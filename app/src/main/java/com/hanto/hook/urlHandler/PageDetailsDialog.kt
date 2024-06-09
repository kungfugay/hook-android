package com.hanto.hook.urlHandler

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.Window
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.hanto.hook.R
import com.hanto.hook.api.ApiServiceManager
import com.hanto.hook.api.ErrorResponse
import com.hanto.hook.api.SuccessResponse
import com.hanto.hook.databinding.ActivityUrlHandlingBinding
import com.hanto.hook.viewmodel.MainViewModel
import com.hanto.hook.viewmodel.ViewModelFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class PageDetailsDialog(val activity: AppCompatActivity, val title: String, val url: String) : Dialog(activity, R.style.DialogTheme) {
    private val multiChoiceList = linkedMapOf<String, Boolean>()
    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityUrlHandlingBinding

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window?.setBackgroundDrawableResource(android.R.color.transparent)

        binding = ActivityUrlHandlingBinding.inflate(activity.layoutInflater)
        val view = binding.root
        setContentView(view)

        val apiServiceManager = ApiServiceManager()
        val viewModelFactory = ViewModelFactory(apiServiceManager)
        viewModel = ViewModelProvider(activity, viewModelFactory).get(MainViewModel::class.java)

        viewModel.loadFindMyTags()
        viewModel.tagData.observe(activity) { tagData ->
            tagData?.let {
                for (tag in tagData.tag) {
                    tag.displayName?.let { displayName ->
                        multiChoiceList[displayName] = false
                    }
                }
            }
        }

        with(binding) {
            tvBookmark.text = " 훅 저장하기"
            editTextUrl.setText(url)
            editTextTitle.setText(title)
            editTextDescription.setText("")

            checkboxExpand.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    tvTag.visibility = android.view.View.VISIBLE
                } else {
                    tvTag.visibility = android.view.View.GONE
                }
            }

            tvTag.setOnClickListener {
                showTagSelectionDialog(tvTag)
            }

            btnCancel.setOnClickListener {
                dismiss()
                (context as? Activity)?.finishAndRemoveTask()
            }

            val buttonCreate: TextView? = findViewById(R.id.btn_create)
            buttonCreate?.setOnClickListener {
                val inputUrl = editTextUrl.text.toString()
                val inputTitle = editTextTitle.text.toString()
                val inputTags = ArrayList(tvTag.text.split("  ")
                    .map { it.trim().replace("#", "") })
                val inputDescription = editTextDescription.text.toString()
                println("생성버튼클릭")
                (context as? AppCompatActivity)?.finish()

                GlobalScope.launch(Dispatchers.Main) {
                    val apiServiceManager = ApiServiceManager()
                    val response = apiServiceManager.managerCreateHook(inputTitle, inputDescription, inputUrl, inputTags)
                    if (response is SuccessResponse) {
                        println("생성 성공: ${response.result?.message}")
                    } else if (response is ErrorResponse) {
                        println("생성 실패: ${response.message}")
                    }

                    dismiss()
                    (context as? Activity)?.finishAndRemoveTask()
                }
                dismiss()
            }
        }
    }

    private fun showTagSelectionDialog(editTextTag: TextView) {
        val tags = multiChoiceList.keys.toTypedArray()
        val checkedItems = BooleanArray(tags.size) { i -> multiChoiceList[tags[i]] == true }

        val builder = AlertDialog.Builder(context)
        builder.setTitle("태그 선택")

        builder.setMultiChoiceItems(
            tags,
            checkedItems
        ) { _, which, isChecked ->
            multiChoiceList[tags[which]] = isChecked
        }

        builder.setPositiveButton("OK") { dialog, _ ->
            val selectedTags = mutableListOf<String>()
            for ((tag, selected) in multiChoiceList) {
                if (selected) {
                    selectedTags.add("#$tag")
                }
            }
            editTextTag.text = selectedTags.joinToString("  ")
            dialog.dismiss()
        }

        builder.setNegativeButton("Cancel") { dialog, _ ->
            dialog.dismiss()
        }

        builder.setNeutralButton("Add") { _, _ ->
            val editText = EditText(context)
            editText.hint = "태그 입력"
            val dialogBuilder = AlertDialog.Builder(context)
                .setTitle("태그 추가")
                .setView(editText)
                .setPositiveButton("추가") { _, _ ->
                    val newTag = editText.text.toString().trim()
                    if (newTag.isNotEmpty()) {
                        GlobalScope.launch(Dispatchers.Main) {
                            val response = viewModel.loadCreateTag(newTag)

                            multiChoiceList[newTag] = true
                            showTagSelectionDialog(editTextTag)

                        }
                    } else {
                        Toast.makeText(context, "태그를 입력하세요.", Toast.LENGTH_SHORT).show()
                        showTagSelectionDialog(editTextTag)
                    }
                }
                .setNegativeButton("취소") { _, _ ->
                    showTagSelectionDialog(editTextTag)
                }
            val addDialog = dialogBuilder.create()
            addDialog.show()
        }

        val dialog = builder.create()
        dialog.show()
    }
}