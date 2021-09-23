<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="Pack.MySQL" %>
<%@ page import="Pack.Person" %>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>아이디중복확인</title>
</head>

<body align='center'>

	<jsp:useBean id="mysql" class="Pack.MySQL" scope="page"/>
	<jsp:useBean id="person" class="Pack.Person" scope="page"/>
	<jsp:setProperty property="*" name="mysql"/>
	
	<% 
		String id=null;
		String result=null;
		
		id = request.getParameter("id");
		result=mysql.readID(id);
		switch(result){
			case "checked":{
				out.print("<h1>사용할 수 있는 아이디입니다.</h1>");
				break;
			}
			case "denied":{
				out.print("<h1 style='color:red;'>사용할 수 없는 아이디입니다.</h1>");
				break;
			}
		}
	%>
	<hr/>
	<FORM METHOD=POST action="Join.jsp">
		<INPUT TYPE="hidden" NAME="CheckValue" VALUE=<%=result%>>
		<INPUT TYPE="hidden" NAME="id" VALUE=<%=id%>>
		<button style='background-color:#FFC0CB; color:#ffffff; border:0; border-radius:20px; width:100px; height:30px;' onClick=location.href='Join.jsp'>확인</button>
	</FORM>
	
</body>

</html>