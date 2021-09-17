<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<title>메인 페이지</title>
<link rel="stylesheet" href="https://unpkg.com/mvp.css">
</head>
<body>
<h1 style="text-align: center">대통령 선거</h1>
	<form action="loginCheck" method="post" style="margin: auto">
		<div>
			<input type="text" name="name" value="" required="required"><br>
			<input type="text" name="jumin" value="" required="required"><br>
			<input type="submit" value="투표하러가기" style=" cursor: pointer">
		</div>
	</form>
</body>