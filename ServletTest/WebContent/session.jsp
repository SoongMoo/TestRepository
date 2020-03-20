<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	if(session.isNew()){
		out.print("New <br />");
	}else{
		out.print("Old <br />");
		out.print(session.getCreationTime()+"<br />");
		out.print(session.getLastAccessedTime()+"<br />");
		out.print(session.getMaxInactiveInterval()+"<br />");
		out.print(session.getId()+"<br />");
	}
%>
</body>
</html>