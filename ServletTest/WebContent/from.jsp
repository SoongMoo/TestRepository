<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setAttribute("req", "123456");
	session.setAttribute("ses", "ses123456");
	application.setAttribute("app", "app123456");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>form.jsp의 제목</title>
</head>
<body>
이 페이지는 from.jsp페이지입니다.
<%= request.getAttribute("req") %>
<%  request.setCharacterEncoding("UTF-8"); %>
<jsp:forward page="to.jsp" >
	<jsp:param name="title" value="jsp"/>
	<jsp:param name="subject" value="forward"/>
	<jsp:param name="content" value="전달되네요."/>
</jsp:forward>
</body>
</html>