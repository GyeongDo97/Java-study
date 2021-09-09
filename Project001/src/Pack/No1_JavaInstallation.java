/*
다운
- 자바 SDK(자바라이브러리), 개발환경(이클립스)

자바 환경설정
- 시스템 환경 변수 편집
	고급
		환경변수
			시스템 변수
				새로 만들기
					변수 이름 : JAVA_HOME 
					디렉토리 찾아보기(프로그램 파일 - 자바 - jdk-16.0.2)
					변수 값 : C:\Program Files\Java\jdk-16.0.2
				편집
					Path 클릭 후 편집
						새로 만들기
							%JAVA_HOME%\bin
							
자바 깔렸는지 확인
- 자바 깔렸는지 버전확인
	Javac -version
	

자바 실행
	오른쪽 상단에 Open Perspective
		Java
			Open
	초기 상태로 되돌릴때
		메뉴창에 Window 
			Perspective
				Reset Perspective
	Window
		Show View
			Package Explorer
	왼쪽 상단에 File - New
		Java Project (공백 안되고 특수문자 안됨 띄어쓰기 없이)
			Finish 눌렀을떄 뭔가 뜨면 만들지말기
	생성한 폴더에 오른쪽 마우스 New - Class
		Package : Pack (패키지 만들경우 사용)
		Name : Hello (첫자 대문자 습관)
		Public static void main(String[] args) 체크하기
	화면 크기 변경 (Ctrl -, Ctrl +)
*/
