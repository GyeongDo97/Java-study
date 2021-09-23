<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="UTF-8"%>
<%@ page import="Pack.Person" %>
<%@ page import="Pack.MySQL" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body align = 'center'>
	
	
	<jsp:useBean id='recv' class='Pack.Person' scope='page'/>
	<!-- 객체가 생성되면 'recv'라는 이름을 가지겟다 -->
	<!-- 객체가 사용의 유형범위는 이 페이지 안에서사용하겟다 -->
	
	<jsp:setProperty name='recv' property='id' />
	<jsp:setProperty name='recv' property='pass'/>
	
	<%
	String head = null;
	String msg = null;
	String checkID = recv.getId();
	String checkPW = recv.getPass();
	System.out.println("받아온 ID:" + checkID);
	System.out.println("받아온 PW:" +checkPW);
	%>
	
	<jsp:useBean id='SQL' class='Pack.MySQL' scope='page'/>
	
	<%
	int num = SQL.readlogin(checkID, checkPW); 
	// 0 = 로그인 오류 발생
	// 1 = ID가 없음
	// 2 = ID는 맞지만 PW가 틀림
	// 3 = ID PW 둘다 맞음
	System.out.println(num);
	switch (num) {
	case 0: {
		head = "로그인실패";
		msg = "로그인 오류 발생";
		break;
	}
	case 1: {
		head = "로그인실패";
		msg = "ID를 확인 부탁드립니다.";
		break;
	}
	case 2: {
		head = "로그인실패";
		msg = "PW를 확인 부탁드립니다.";
		break;
	}
	case 3: {
		head = "로그인성공";
		msg = "로그인 되었습니다!";
		break;
	}
	default:
		head = "로그인실패";
		msg = "로그인 오류 발생";
		break;
	}
	System.out.println(msg);
	%>
	
	<h1><%= head %></h1>
	<div><%= checkID %>님! <%= msg %></div><br/>
	<button style='background-color:#FFC0CB; color:#ffffff; border:0; border-radius:20px; width:100px; height:30px;' onClick=location.href='index.html'>홈으로</button>
	
	

</body>
</html>