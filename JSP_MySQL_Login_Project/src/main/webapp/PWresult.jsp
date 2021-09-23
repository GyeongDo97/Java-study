<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="Pack.MySQL" %>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>정보확인 및 비밀번호 변경</title>
</head>

<body align = 'center'>
	<jsp:useBean id="mysql" class="Pack.MySQL" scope="page"/>
	<jsp:useBean id="person" class="Pack.Person" scope="page"/>
	
	<%
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String number = request.getParameter("number");
		
		boolean pass=mysql.readall(id, name, number);
		if(pass){
			out.println("<h1>정보가 일치합니다.</h1><hr/>");
			out.println("<FORM METHOD=Post action='ChangePW.jsp'><br/>");
			out.println("변경할 비밀번호<br/> <input type='text' name='pw'>");
			out.println("<input type='hidden' name='id' value='"+id+"'>");
			out.println("<button style='background-color:#FFC0CB; color:#ffffff; border:0; border-radius:20px; width:100px; height:30px;'>변경</button></div>");
			out.println("</Form><br/>");
		}else{
			out.println("<h1>정보가 일치하지 않습니다.</h1><hr/>");
			out.println("<button style='background-color:#FFC0CB; color:#ffffff; border:0; border-radius:20px; width:100px; height:30px;' onClick=location.href='FindPW.jsp'>다시 입력</button></div>");
		}
	%>
	<input type='hidden' name='id' value=<%=id%>>
	<button style='background-color:#FFC0CB; color:#ffffff; border:0; border-radius:20px; width:100px; height:30px;' onClick=location.href='index.html'>홈으로</button></div>
</body>

</html>