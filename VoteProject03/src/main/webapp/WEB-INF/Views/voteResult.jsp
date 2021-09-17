<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://unpkg.com/mvp.css">
</head>
<body style="text-align: center;">
<h2>투표현황</h2>
	<table>
		<tr>
			<th>이름</th>
			<th>투표수</th>	
		</tr>
		<c:forEach var="i" items="${ mmm }">	
		<tr>
			<td>${i.name}</td>
			<td>${i.count}</td>					
		</tr>
		</c:forEach>	
	</table>
	<br>
	<br>

<h2>투표자 체크</h2>	
	<table>
		<tr>
			<th>이름</th>
			<th>투표체크</th>	
		</tr>
		<c:forEach var="i" items="${ voteList }">	
		<tr>
			<td>${i.name}</td>
			<td>${i.check == 0 ? '안했음' : '했음'}</td>					
		</tr>
		</c:forEach>	
	</table>
	<br>
	<a href="http://localhost:8080/VoteProject03/index.jsp">HOME</a>
</body>
</html>