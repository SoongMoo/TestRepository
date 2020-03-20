<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setAttribute("req", "request");
	session.setAttribute("ses", "session");
	application.setAttribute("app", "application");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%= request.getAttribute("req") %><br />
<%= session.getAttribute("ses") %><br />
<%= application.getAttribute("app") %><br />
</body>
</html>