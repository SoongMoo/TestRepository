<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	request.setAttribute("date", new java.util.Date());
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<fmt:setLocale value="ko_kr"/><!-- en_US, ja_jp -->
<fmt:formatNumber value="50000" type="currency" /><br>
<fmt:formatNumber value="50000" pattern="USD #,###,###"/><br>
<fmt:formatNumber value="50000" pattern="#,###,###-" type="currency"/><br>
<fmt:formatNumber value="0.15" type="percent"/><br>
<hr />
<fmt:formatDate value="${date }" type="date"/><br />
<fmt:formatDate value="${date }" type="time"/><br />
<fmt:formatDate value="${date }" type="both"/><br />
<hr />
<fmt:formatDate value="${date }" type="date" dateStyle="short"/><br />
<fmt:formatDate value="${date }" type="date" dateStyle="long"/><br />
<fmt:formatDate value="${date }" type="time" timeStyle="short"/><br />
<fmt:formatDate value="${date }" type="time" timeStyle="long"/><br />
<fmt:formatDate value="${date }" type="both" dateStyle="short" 
	timeStyle="long" /><br />
</body>
</html>