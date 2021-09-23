<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<title>메인 페이지</title>
</head>
<body>
	<%=new Date()%>
	<% response.setContentType("text/html; charset=UTF-8");%>
	<% request.setCharacterEncoding("UTF-8");%>
	<h2>Hello World</h2>
	<a href="t1">링크1</a>
	<!-- 링크를 클릭하게되면 t1이라는 이름을 가진 컨트롤러를 찾는다 -->
	<a href="t2">링크2</a>
	<a href="t3">링크3</a>
	<a href="t4?name=코끼리">링크4</a>
	<a href="t5?name=코끼리&age=20">링크5</a>
	<a href="t6?name=독수리&age=30">링크6</a>
	<a href="t7">링크7</a>
	<a href="t8?name=대나무&age=40">링크8</a>
	<a href="t9?name=강아지&age=50">링크9</a>
	<a href="t10">링크10</a>
	<a href="t11">링크11</a>
	<form action="t12">
		<label>이름:</label> <input type="text" name="name" value="호랑이"><br>
		<label>나이:</label> <input type="text" name="age" value="20"><br>
		<input type="submit" value="Submit">
	</form>
	<br />
</body>