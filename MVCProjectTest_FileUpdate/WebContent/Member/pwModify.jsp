<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>pwModify.jsp</title>
</head>
<body>
<c:if test="${empty memId}">
	<script>
		location.href="index.nhn";
	</script>
</c:if>
<form action = "pwModify1.nhn" method="post" name="frm" >
	비밀번호 : <input type="password" name = "pw" id = "pw" /><br />
	${msg }<br />
	<input type="submit" value="확인" />
</form>
</body>
</html>