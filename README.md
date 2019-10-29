# rssuport_test

1. 개발환경: macOS, java8
2. 개발툴: STS
3. 프레임워크: Spring Boot
4. DB: H2

실행방법: 
1. STS 또는 이클립스에서 'maven import'로 프로젝트 임포트를 한다.
2. "Run > Run As > Spring Boot App" 메뉴를 실행하여 프로그램을 실행할 수 있다.
3. 브라우저에서 "http://localhost:8001" 로 접속할 수 있다.

테스트 계정:
* 초기 데이터로 계정과 테스트를 위한 게시판 데이터를 업로드하게 되어 있다.
* 계정의 username/password 는 다음과 같다.
  * test1/test1
  * test2/test2
  * test3/test3
  * test4/test4
  * test5/test5

기능:
1. 로그인/로그아웃
2. 게시판 조회
3. 게시글 등록/수정/삭제

게시글은 등록한 사용자만 수정/삭제가 가능하게 되어 있다.
