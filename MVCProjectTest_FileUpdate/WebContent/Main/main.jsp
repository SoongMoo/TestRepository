<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" 
	src="http://code.jquery.com/jquery-latest.js" ></script>
<script type="text/javascript">
$(function(){
	$("#id1").focus();
	$("#btn").click(function(){
		if($("#id1").val() == ""){
			$("#idmsg").html("아이디를 입력하세요.");
			$("#id1").focus();
			return false;
		}
		if($("#pw").val() == ""){
			$("#pwmsg").html("비밀번호를 입력하세요.");
			$("#pw").focus();
			return false;
		}
		$("#frm").submit();
	});
});

</script>
</head>
<body>
<!-- 로그인 되지 않았을 때 -->
<c:if test="${empty memId}">
<form id="frm" name="frm" action="loginPro.nhn" method="post">
<table border =1>
<tr><td colspan=3>
		자동로그인<input type="checkbox" 
			name="autoLogin" value="auto"/>
	</td></tr>
<tr><td>아이디</td>
    <td><input type ="text" id="id1" name="id1" value="${cookieId }" />
    	<div id ="idmsg">${failId }</div>
    </td>
	<td><input type="checkbox" name="idStore" 
		 value="store" <c:if test="${isId }">checked</c:if> />아이디체크</td>
</tr>
<tr><td>비밀번호</td>
	<td><input type="password" id="pw" name="pw" />
		<div id = "pwmsg">${failPw }</div>
	</td>
	<td><input type="button" id="btn" value="로그인" /></td>
</tr>
<tr><td colspan=2>
		<a href="#">아이디 찾기</a>|<a href="#">비밀번호 찾기</a>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="memberRegist.nhn">회원가입</a>
    </td>
</tr>
</table>
</form>
</c:if>
<!-- 로그인 되었을 때 -->
<c:if test="${!empty memId}">
<a href="memberDetail.nhn">내 정보</a>
<a href="logout.nhn" >로그아웃</a>
<a href ="memberList.nhn">회원리스트</a>
<a href ="#">공지사항 게시판</a>
<a href ="answerBoard.ab">답변형 게시판</a>
<a href ="goodsList.gd">상품목록</a>
</c:if>
</body>
</html>