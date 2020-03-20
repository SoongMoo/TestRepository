<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String code = request.getParameter("code");
	String viewPageUrl = null;
	switch(code){
		case "1": viewPageUrl = "test/1.jsp";break;
		case "2": viewPageUrl = "test/2.jsp";break;
		case "3": viewPageUrl = "test/3.jsp";break;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:forward page="<%= viewPageUrl %>" />
</body>
</html>