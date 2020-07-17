<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action = "idCkPro.mem" name="frm" method = "post">
	<table border = 1>
		<tr><td>아이디 찾기</td></tr>
		<tr><td>이메일을 입력하세요</td></tr>
		<tr><td><input type = "email" name = "userEmail" id = "userEmail"/></td></tr>
		<tr><td>전화번호를 입력하세요</td></tr>
		<tr><td><input type = "text" name = "userPh1" id = "userPh1" placeholder = "010-0000-0000,010-000-0000"/>
		</td></tr>
	</table>
		<button type ="submit" >다음으로</button>
	</form>
</body>
</html>