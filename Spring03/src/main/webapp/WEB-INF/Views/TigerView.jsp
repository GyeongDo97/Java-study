<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*, java.text.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 	<h1>호랑이</h1>
	<h1>${name}</h1>
	<h1>${age}</h1>
 --%>	
 <!-- model로 던졌을떄 parameter로 따로 저장하지않고 위와 같이 사용하여 쓸 수 있다. -->
	<!-- 4대 제어문을 사용할 경우에는 자바코드를 사용하여도 되지만 
	쓰겠다고 생각이들어 하게되면 JSTL문법을 사용하는 것을 선호 -->
	<%
	//여기서는 request.gerparameter를 사용할 수 없다
	String name = (String)request.getAttribute("name");
	//getAttrinbute의 경우 리턴 타입이 오브젝트 타입이기때문에 String으로 변환해줘야한다.
	//사용시 받아오는 데이터 타입 확인하기
	String age = (String)request.getAttribute("age");
	%>
	
	<%=name %>
	<%=age %>
</body>
</html>