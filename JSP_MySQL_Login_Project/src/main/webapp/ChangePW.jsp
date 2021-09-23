<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="Pack.MySQL" %>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>비밀번호 변경</title>
</head>

<body align = 'center'>
	<jsp:useBean id="mysql" class="Pack.MySQL" scope="page"/>
	<jsp:setProperty property="*" name="mysql"/>
	
	<% 
	String id=request.getParameter("id"); 
	String pw=request.getParameter("pw"); 
	System.out.println(id+' '+pw);
	%>
	<h1>변경되었습니다.</h1><br/>
    <button style='background-color:#FFC0CB; color:#ffffff; border:0; border-radius:20px; width:100px; height:30px;' onClick=location.href='index.html'>홈으로</button>
	
	<% mysql.update(id, pw); %>
	
	
</body>

</html>