<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${empty authInfo}">
<form:form action="login" name="frm" id="frm" method="post" 
	commandName="loginCommand">
<table border =1>
	<tr><td colspan=3>
			자동로그인<form:checkbox path="autoLogin" />
		</td>
	</tr>
	<tr><td>아이디 입력</td>
		<td>
		<form:input id="id1" path="id1" />
		<form:errors path="id1" />
		</td>
		<td><form:checkbox path="idStore"  />아이디 저장
		</td>
	</tr>
	<tr><td>비밀번호</td>
		<td>
			<form:password id="pw" path="pw" />
			<form:errors path="pw" />
		</td>
		<td><input type="submit" id="btn" value="로그인" /></td>
	</tr>
	<tr><td colspan=3>
		<a href="#">아이디 찾기</a>|<a href="#">비밀번호 찾기</a>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="register/agree">회원가입</a>
	</td></tr>
</table>
</form:form>
</c:if>
<!-- 로그인 되었을 때 -->
<c:if test="${!empty authInfo}">
<a href ="memberDetail">내 정보</a>
<a href ="logout" >로그아웃</a>
<a href ="member/list">회원리스트</a>
<a href ="board">공지사항 게시판</a>
<a href ="library">일반 자료실</a>
<a href ="answerBoard">답변형 게시판</a>
<a href ="commentBoard">댓글 게시판</a>
<a href ="goodsList">상품목록</a>
<a href="mailForm">메일전송</a>
</c:if>
</body>
</html>