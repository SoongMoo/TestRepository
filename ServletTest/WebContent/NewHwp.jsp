<%@ page language="java" contentType="application/hwp; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	response.setHeader("Content-Disposition", 
			"attachment;filename=member.hwp");
	response.setHeader("Content-Description", 
			"JSP Generated Data");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
	<tr><td>이름</td><td>번호</td></tr>
	<tr><td>이숭무</td><td>1</td></tr>
	<tr><td>이상범</td><td>2</td></tr>
</table>
</body>
</html>