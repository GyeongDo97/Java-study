<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	
	<jsp:setProperty name='recv' property='name' />
	<jsp:setProperty name='recv' property='email'/>
	
	<%
	String msg = null;
	String checkname = recv.getName();
	String checkemail = recv.getEmail();
	System.out.println("받아온 name:" + checkname);
	System.out.println("받아온 email:" +checkemail);
	%>
	
	<jsp:useBean id='SQL' class='Pack.MySQL' scope='page'/>
	
	<%
	String result = SQL.findID(checkname, checkemail); 
	%>
	
	<h1>찾기 결과</h1>
	<hr/>
	<div><%= checkname %><%= result %></div><br/>
	<button style='background-color:#FFC0CB; color:#ffffff; border:0; border-radius:20px; width:100px; height:30px;' onClick=location.href='FindID.jsp'>다시 입력</button>
	<button style='background-color:#FFC0CB; color:#ffffff; border:0; border-radius:20px; width:100px; height:30px;' onClick=location.href='index.html'>홈으로</button>

</body>
</html>