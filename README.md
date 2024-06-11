<p align="center">
  <img src="app/src/main/res/mipmap-xxxhdpi/ic_launcher_round.webp" width="150" height="150">
</p>

<div align="center">


### Hook !
##### Link Management Application
<br>
<img src="https://img.shields.io/badge/Android-34A853?style=for-the-badge&logo=Android&logoColor=white"> 
<img src="https://img.shields.io/badge/Kotlin-7F52FF?style=for-the-badge&logo=Kotlin&logoColor=white"> 
<img src="https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=GitHub&logoColor=white"> 
<img src="https://img.shields.io/badge/Figma-F24E1E?style=for-the-badge&logo=Figma&logoColor=white"> 
<br>
<img src="https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=Docker&logoColor=white">  
<img src="https://img.shields.io/badge/NestJS-E0234E?style=for-the-badge&logo=NestJS&logoColor=white"> 
<img src="https://img.shields.io/badge/AWS-232F3E?style=for-the-badge&logo=Amazon AWS&logoColor=white"> 
<img src="https://img.shields.io/badge/Node.js-339933?style=for-the-badge&logo=Node.js&logoColor=white">
<img src="https://img.shields.io/badge/GitHub Actions-2088FF?style=for-the-badge&logo=GitHub Actions&logoColor=white">

</div>

Features
-
- 링크 저장 (Hook)
- 저장시 관련 태그 자동 삽입
- 주제별로 훅 정리 및 관리
- 훅 별 주석 기능 제공

Tech Stacks
-
- MVVM
- Jetpack Compose
- Android App Architecture
- App Modularization
- Material 3

Members
-

|<a href="https://github.com/ktodw98">이동원|<a href="https://github.com/imeugeneco">고유진|<a href="https://github.com/Chaeyoung714">이채영|<a href="https://github.com/pointmina">김민아|<a href="https://github.com/lee-hassan">이예진|<a href="https://github.com/whduddn">조영우|
|:---:|:---:|:---:|:---:|:---:|:---:|
|<img src="https://github.com/pointmina/hook/assets/68779817/1cdbef47-5608-4685-b7de-37779093762c" width="100">|<img src="https://github.com/pointmina/hook/assets/68779817/c6dbac4b-c060-4ad5-8f5b-f7ae2efeb60c" width="100">|<img src="https://github.com/pointmina/hook/assets/68779817/ef5d3d14-4f32-423e-8a0e-da1615a1123d" width="100">|<img src="https://github.com/pointmina/hook/assets/68779817/11f73b42-4f6b-40b5-8bdd-27aeab4bfa4c" width="100">|<img src="https://github.com/pointmina/hook/assets/68779817/8f2e9a54-397a-4b17-931a-3358b71b77b0" width="100">|<img src="https://github.com/pointmina/hook/assets/68779817/7c500406-f577-41af-a094-e0cc1d482433" width="100">|
|PM|Backend|Backend|Frontend|Frontend|Frontend|


# Hook! - Capstone Design Team Project
일해라 핫산!

## 1. 주차별 계획 테이블
|주차|진행 위치|예정된 이벤트|
|:---:|:---:|:---|
|1주차(04/01 ~ 04/07)|||
|2주차(04/08 ~ 04/14)|||
|3주차(04/15 ~ 04/21)|||
|4주차(04/22 ~ 04/28)||중간고사|
|5주차(04/29 ~ 05/05)|||
|6주차(05/06 ~ 05/12)|**HERE**||
|7주차(05/13 ~ 05/19)||**05/16: 중간 발표**|
|8주차(05/20 ~ 05/26)|||
|9주차(05/27 ~ 06/02)|||
|10주차(06/03 ~ 06/09)|||
|11주차(06/10 ~ 06/13)||**06/13: 최종 발표 및 개발 종료**|

## 1.1 작업 기록 상세 로그

## 7주차
### 2024-05-14
- 이 레포지토리 내용 Fork로 다 옮기고 작업은 민아님 브랜치에서 할 준비

## 6주차
### 2024-05-11
- 완료 (새로 반영된 사항)
  - 로그인 화면 - 테스트 전용 접속 버튼 오른쪽 위로 이동 (나중에 버튼 아예 삭제 예정)
  - 홈 화면 - FAB 디자인 변경
  - 상단 앱 툴바 - 스크롤에 따라 동적으로 변화하는 것으로 변경 (협의 없이 진행됨, 패스 안되면 예전 방식으로 복귀)
  - 홈 화면 개별 훅 아이템 박스 - 2줄씩만 보이고 나머지 ...로 줄이기 적용
  - 태그 화면 API 작성 - findMyTag() 완료 (바인딩 정상 확인)
  - 홈 화면 API 추가 작성 - updateMyHook, DeleteMyHook 작성 (findMyHook() 문제로 인해 아직 바인딩 테스트 못함)
 
- 문제 보고
  - findMyHook() 훅 모두보기 - 서버 응답을 보니까 Example 중에 200 - None 만 넘어와서 홈뷰에 아이템이 안 보이는 거였음. 내 컬렉션에서 바로 None 삭제해주면 다시 나올듯. -- 폰에서 삭제했는데 와! 된다 ㅎㅎ
  - 예상보다 제목 80자가 많이 적어서 더미 데이터 기준으로 많이 잘림. 100~ 150자로 확대 조정 필요?

### 오전 3:59 2024-05-09
- 임시 저장 로그
- FAB 한 번 누르면 바로 WriteHookActivity로 가기(수정)
- 로그인 API 테스트 (안됨? 이유를 모르겠음. okhttp 인터셉터로 모든 요청에 Bearer 토큰 넣었는데 안됨?)
- 기존에 잘 되던 createHook도 리퀘스트 잘 갔는데 404 Bad Request 반환됨. - 이거 백엔드에 캡쳐본 넘겨서 물어봐야댐
- 새로운 훅 작성할 때 URL 유효성 검사에 공백 검사 추가함.
- 태그 뷰 병합 시작. 리사이클러뷰 어댑터 map 부분에서 오류가 남? 이유는 몰룸?
- FAB 눌러서 훅 만들고 태그는 태그뷰 버튼으로 하는 게 이상하다는 생각을 함.. FAB 버튼 클릭 -> 다이알로그 없이 메뉴 visible -> 선택 로직이 좋은 거 같은데
- deleteHook()은 만들어놨던거 내일 복사하기
- 로그인 버튼 api 호출로 바꿔놓았는데 왜 이거 토큰 받아오는 뭐가 없는지? api 완성본 올린 거 아니었나? 주소도 없고???
- onBackPressed() 오버라이드 재정의 -- 로그인 페이지에서 뒤로가기라든가 그런 대참사 예방용.
- 두번 눌러서 뒤로가기 귀찮아서 없애버리고 트렌드에 따라서 그냥 바로 종료로 수정.
- 예진쨩 화이팅~!


### 2024.05.07 (05.06~ ")
>+ API 모듈 안정화 업데이트
>   + 보고된 문제 해결: 서버 200 응답, 데이터를 가져왔으나 Response 매칭이 되지 않는 경우
>   + ApiResponse 클래스 수정
>       + sealed class ApiResponse (메인), ApiResponseAdapter 적용

### 2024.05.06 (05.05~ ")
>+ API 모듈 테스트
>   + MVVM 공장 가동: ViewModel - ApiResponseManager - RetroServer 설계
>   + createHook(@POST) 테스트 - 200 응답 확인 완료, WriteHookActivity.kt 구현 완료
>   + findMyHook(@GET) 테스트
>       + 문제 보고: 200 응답 확인, 데이터를 가져왔으나 리스폰스 매칭 되지 않는 문제


## 5주차
### 2024.05.04 (05.03~ ")
>+ 서버 API 연동 준비 작업
>   + postman Mock Server 빌드 (HassanWeb)
>   + 서버 응답 확인 테스트 (목 서버 검증)
>   + get Random Hook API 테스트: 정상 작동 확인 (data binding까지 완료)
>+ 서버 응답 지연 시간 핸들링 (ShimmerFrameLayout 적용): 화면 로딩되는 동안 반짝반짝


## 4주차
### 2024.04.30
>+ 홈 RV 아이템 선택 이벤트 처리
>   + 데이터 Intent, DetailActivity(상세보기)뷰로 이동
>   + 아이템 클릭 기능 확장: onClick 웹뷰 연결 // onLongClick 옵션 다이얼로그 팝업
>+ 훅 작성하기 페이지(WriteHookActivity) 기능 추가
>   + 글자수 제한 기능 추가 (제목 50자, 설명 80자) -- 뷰 화면에서 실시간 확인 가능
>   + 주소 입력창 옆에 클립 아이콘 클릭시 유저 클립보드에서 자동으로 url 복사


### 2024.04.29
>+ 홈 RV에 서버 데이터 @GET 기본 테스트
>    + github repository의 dummy.json 파싱
>+ MVVM 패턴 적용 시작

## 3주차
>- ~~카카오 로그인 REST API 개발~~ (*로그인 API 도입 예정)
>- 서버 데이터 연동 준비 작업 (구현 방식 설계)
>- 클린 아키텍쳐 적용 준비 작업 (MVVM 레퍼런스 조사)

## 2주차
>- 레이아웃 새로 작성 (HomeFragment, HookDetailActivity)
>- HomeFragment RV 준비 작업
>- 서버 데이터 연동 준비 작업 (메타 레퍼런스 조사)

## 1주차
>- ~~폴더 페이지 구현~~ (*프로젝트 변경, 폐기)
>- ~~폴더 작성 다이알로그 진행중~~ (*프로젝트 변경, 폐기)
>- ~~카카오 소셜 로그인 구현 (KAKAO SDK 사용)~~ (*로그인 API 도입 예정, 폐기 예정)
>- **카카오 유저 프로필 데이터(닉네임, 메일 주소) -> 마이페이지(SettingActivity) 연동 완료** (*유저 API 사용 예정, 변경 필요)

<br>

## 3. 메모 & TODO
* 중요한 사항 MEMO
  + 로그인 api 나오면 로그인 로직 바꾸기
  <br>
 
* 미뤄둔 TODO
  * (메이저) 의존성 주입 Koin -> api 패키지를 app 모듈에서 분리, api 모듈로 관리하기
  * (메이저) ItemHandler 클래스 만들기: Fragment/Activity에서 모든 메소드를 처리하려고 하니 인간이 피로하고 기계도 피로하다. 단, 테스트 검증이 되었을 때만 메소드를 따로 빼서 관리해야할듯.
  * (메이저) 인터넷 연결 안정성 보장 문제(네트워크 연결이 안되어 있을 때 어떻게 처리할건지? 강제종료 되지 않도록 오프라인 우선으로 처리해야함)
    * (문제) 회원가입이 되어있고, 예전에 로그인을 해서 앱을 사용했던 사용자라면 어떻게 처리할건지?
    * (참고) 네트워크 연결 상태 확인을 GlobalApplication에서 하면 안된다고 한다. Context를 얻는 이점 때문에 Activity/Fragment에서 네트워크가 필요한 상황에서 확인하는 게 좋다고 한다.
    * (참고)메세지 예시: "인터넷에 연결되어 있지 않습니다", "네트워크 연결 상태를 확인한 뒤 다시 시도해주세요"
  + (마이너) 정렬 기준 확인하기: (필요) 백엔드 협의 (정렬해서 보내주는 걸로 아는데 정렬 기준을 클라이언트에서 바꿔달라고 요청보낼 수 있는지)
  + (마이너) 하드코딩 처리하기: (필요) buildconfig로 숨겨야하는 거 todo로 정리하고 처리하기, style로 적용할 수 있는 거는 다 바꾸기
  + (마이너) Toast 메시지 줄이기: (필요) Snackbar로 UNDO 작업이 꼭 필요한 것 빼고는 웬만해서 (뷰)바인딩으로 alert 메세지 처리하기
  + (마이너) 함수 이름 혼동 문제: (제안) 레퍼지토리 - 뷰모델은 get으로 뷰모델-뷰는 fetch로 fun 이름 바꾸기
  <br>
  
* 개인적인 MEMO
  - 버전 관리 규칙: 기본적인 개발&테스트는 여기에서 하고, "Fatal 오류가 안 나면" 내 Fork 브랜치에 병합, master 머지 요청은 마이너 버그가 무시할 만한 정도일 때
  - 개발할 때 규칙: 우선순위에 올라온 일부터 먼저 처리하고, 레이아웃 디자인은 가능한한 나중에, 이름지을때 무조건 카멜로만 짓고, 맨앞에는 뷰이름 약어, hook 남용하지 말기

<br>

## 4. 기술 스택
나중에 업로드 예정

<br>

## 5. 참고 자료
나중에 업로드 예정







