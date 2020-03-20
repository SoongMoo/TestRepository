<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getParameter("path");
	String urlPath = null;
	if(path == null) path = "1";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
include2.jsp 페이지 내용입니다.<br />
<%if(path.equals("1")){ %>
	<%@ include file="Test/1.jsp" %>
<%}else if(path.equals("2")){ %>
	<%@ include file="Test/2.jsp" %>
<%}else if(path.equals("3")){ %>
	<%@ include file="Test/3.jsp" %>
<%} %>
<br />
include 지시문에 의해 출력된 내용 끝...<br />
</body>
</html>