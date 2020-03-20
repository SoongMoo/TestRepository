<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	int i = 10;
	out.print(i);
	if(i == 10){}
	//for(int i1 : i){}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="ii" value="10" /><br />
<c:out value="${ii}"></c:out><br />
${ii}<br />
<c:remove var="ii"/>
${ii }.... <be />

<c:set var="ii" value="98" /><br />
<c:if test="${ii>90 }">
	A학점입니다.
</c:if>
<c:if test="${ii<=89 && ii >= 80 }">
	B학점입니다.
</c:if>
<c:if test="${6+3==9}">
<h3>6 + 3 은 9이다.</h3>
</c:if>
<% request.setAttribute("req", 10); %>
<c:choose>
	<c:when test="${req==10 }">
		10입니다.
	</c:when>
	<c:when test="${req==20 }">
		20입니다.
	</c:when>
	<c:otherwise>
		10도 20도 아닙니다.
	</c:otherwise>
</c:choose>

<c:forEach var="test" begin="1" end="10" step="2">
	${test }  
</c:forEach>
<%
	String [] str = 
		{"a","b","c","d","e","f","g","h","i","j","k","l","m","n"};
	request.setAttribute("str1", str);
%>
${str }은 안됨
<c:forEach var="test1" items="${str1 }">
	${test1 }
</c:forEach>
<%
	String str2 = "a,b,c,d,e,f,g,h,i,j,k,l,m,n";
	request.setAttribute("str2", str2);
%>
<c:forTokens var="test2" items="${str2 }" delims=",">
	${test2 }
</c:forTokens>
</body>
</html>