<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table width=50% border="1" cellpadding="0" cellspacing="0" >
<tr align="center" valign="middle">
	<td colspan =4 >회원리스트</td>
	<td align=right >회원수 : ${count } </td>
</tr>
<tr align="center" valign="middle">
	<td align="center">회원아이디</td>
	<td align="center">회원이름</td>
	<td align="center">회원연락처</td>
	<td align="center">이메일</td>
	<td align="center">등록일</td>
</tr>
<c:forEach items="${memberList }" var="member" >
<tr align="center" valign="middle">
	<td align="center">
		<a href ="memberInfo.nhn?id=${member.userId }">${member.userId }</a>
	</td>
	<td align="center">${member.userName }</td>
	<td align="center">${member.userPh1 }</td>
	<td align="center">${member.userEmail }</td>
	<td align="center">
		<fmt:formatDate value="${member.userRegist }" type="date" pattern="yyyy-MM-dd"/> 
	</td>
</tr>
</c:forEach>

</table>
<a href="../register/agree" >회원등록</a>
</body>
</html>