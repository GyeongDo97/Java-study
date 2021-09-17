<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://unpkg.com/mvp.css">
</head>
<body">
	<form action="candidate" method="post" style=" margin: auto;">
		<input type="hidden" name="voterName"  value="${voterInfo.getName() }">
		<input type="hidden" name="voterJumin" value="${voterInfo.getJumin() }">
		<p>
			홍길동 <input type="radio" name="name" value="홍길동">
		<p>
			이순신 <input type="radio" name="name" value="이순신">
		<p>
			유관순 <input type="radio" name="name" value="유관순"><br> 
				<input type="submit" value="투표하기" style=" cursor: pointer">
	<a href="http://localhost:8080/VoteProject03/index.jsp">HOME</a>
	</form>
</body>
</html>