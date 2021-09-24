<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<title>메인 페이지</title>
</head>
<body>
	<%=new Date()%>
	<form action="hello" method="post" style="margin: auto">
		<div>
			<input type="text" name="name" value="" required="required"><br>
			<input type="text" name="age" value="" required="required"><br>
			<input type="submit" value="확인" style=" cursor: pointer">
		</div>
	</form>
</body>