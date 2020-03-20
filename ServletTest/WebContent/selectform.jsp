<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%= request.getParameter("edu") %><br />
	<% String [] like = request.getParameterValues("like"); %>
	<%
		for(String s : like)	{
			out.print(s+"<br />");
		}
	%>
</body>
</html>