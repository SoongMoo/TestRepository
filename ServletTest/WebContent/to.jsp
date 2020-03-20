<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>to.jsp의 제목</title>
</head>
<body>
날짜 : <%= new java.util.Date() %><br />
<a href="submitPage.jsp">다음 페이지로</a><br />
to.jsp : <%= request.getAttribute("req") %><br />
to.jsp : <%= request.getParameter("num") %><br />
to.jsp : <%= session.getAttribute("ses") %><br />
to.jsp : <%= application.getAttribute("app") %><br />
<hr />
title: <%= request.getParameter("title") %><br />
subject : <%= request.getParameter("subject") %><br />
content : <%= request.getParameter("content") %><br />
</body>
</html>