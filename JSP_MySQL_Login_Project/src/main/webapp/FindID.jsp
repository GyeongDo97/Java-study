<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>ID찾기</title>
</head>

<body align='center'>
	<h1>ID찾기</h1>
	<hr/>
	
	<FORM METHOD=Post action="IDresult.jsp">
		<table  cellpadding='5' cellspacing='5' align='center'>

			<tr>
				<td >이름</td>
				<td><input type='text' name='name'></td>
				<td rowspan="2"><button style='background-color: #FFC0CB; color: #ffffff; border: 0; border-radius: 20px; width: 100px; height: 30px;'>찾기</button></td>
			</tr>

			<tr>
				<td>E-mail</td>
				<td><input type='text' name='email'></td>
			</tr>
		</table>
	</FORM>


</body>
</html>