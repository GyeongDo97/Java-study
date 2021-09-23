<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
</head>
<body align = 'center'>
<%
String CheckValue;

if(request.getParameter("CheckValue") != null) {
	CheckValue = request.getParameter("CheckValue");
} else {
	CheckValue = "none";
}

//CheckValue 로 판별하면 된다
// none은 아직 체크하지 않은 상태
// checked 는 체크완료된 상태
// denied 는 거부된 상태(중복이 있다)
//체크확인인지 아닌지 문구 띄워주는부분
String Check_color;
String Check_text;
String Submit_able;
if(CheckValue.equals("checked")){
	Check_color = "blue";
	Check_text = "*사용 가능한 아이디";
	Submit_able = " ";
} else if (CheckValue.equals("denied")){
	Check_color = "red";
	Check_text = "*중복된 아이디";
	Submit_able = "disabled";
} else {
	Check_color = "red";
	Check_text = " ";
	Submit_able = "disabled";
}

String id;
if(request.getParameter("id") != null) {
	id = request.getParameter("id");
} else {
	id = "";
}
%>

	<h1> 회원가입</h1>
	<hr/>
	
	
	<form action="IDCheck.jsp" method="post">

 			<table  width='300px' cellpadding='3' cellspacing='5' align='center'>
 				<tr>
 					<td colspan = '2'>아이디</td>
 				</tr>
  			<tr>
 					<td> <input type="text" name="id" placeholder="아이디 입력" value="<%=id%>"></td>
 					<td><button style='background-color:#FFC0CB; color:#ffffff; border:0; border-radius:20px; width:100px; height:30px;'>중복확인</button></td>
 				</tr> 
 				<tr>
 					<td> <a style="color: <%=Check_color%>;"><%=Check_text%></a></td>
 					<td> <input type="hidden" name="CheckValue" value="<%=CheckValue%>"></td> 
 				</tr>
 			</table>
 			
 	</form>


 	<form name="login" action="Check.jsp" method="post">
 	 	<table width='300px' cellpadding='3' cellspacing='1' align='center'>
 	 		<tr>
 	 			<td><input type="hidden" name="id" size='1' value="<%=id%>">비밀번호</td>
 	 		</tr>
 	 		<tr>
 	 			<td><input type="password" name="pass" placeholder="비밀번호 입력"></td>
 	 		</tr>
 	 		<tr>
 	 			<td>이름</td>
 	 		</tr>
 	 			<tr>
 	 				<td><input type="text" name="name" placeholder="이름 입력"></td>
 	 			</tr>
 	 			<tr>
 	 				<td>이메일</td>
 	 			</tr>
 	 			<tr>
 					<td><input type="email" name="email" placeholder="이메일 입력"></td>
 	 			</tr>
 	 			<tr>
 	 				<td>휴대전화</td>
 	 			</tr>
 	 			<tr>
 	 				<td><input type="text" name="num" placeholder="010-****-****"></td>
 	 			</tr>
 	 			<tr>
 	 				<td>생년월일(8자리)</td>
 	 			</tr>
 	 			<tr>
 	 				<td><input type="text" name="date" placeholder="19941234"></td>
 	 			</tr>
 				<tr>
 	 				<td> <button style='background-color:#FFC0CB; color:#ffffff; border:0; border-radius:20px; width:100px; height:30px;' <%=Submit_able%>>가입완료</button></td>
 	 			</tr>
 	 
 	 </table>
 	 </form>

</body>
</html>