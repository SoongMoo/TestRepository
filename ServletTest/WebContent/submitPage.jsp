<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
submitPage.jsp : <%= request.getAttribute("req") %><br />
submitPage.jsp : <%= request.getParameter("num") %><br />
submitPage.jsp : <%= session.getAttribute("ses") %><br />
submitPage.jsp : <%= application.getAttribute("app") %><br />
</body>
</html>