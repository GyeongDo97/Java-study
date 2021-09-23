<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@page import="Pack01.Person"%>
    <%@ page import="java.util.*, java.text.*"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>사자</h1>
	<h1>${ppp.getName()}</h1>
	<h1>${ppp.getAge()}</h1>
	
	<h1>${name}</h1>
	<h1>${age}</h1>
	
	<h1>${mmm.get(0)}</h1>
	<h1>${mmm.get(1)}</h1>
	<h1>${mmm.get(2)}</h1>
	<%
		Person person = (Person)request.getAttribute("ppp");
	%>
	<%= person.getName() %>
	<%= person.getAge() %>
</body>
</html>