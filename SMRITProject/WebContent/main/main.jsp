<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/include.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" 
	src="http://code.jquery.com/jquery-latest.js" ></script>
<script>
$(function(){
	$("#imgSubmit").click(function(){
		if($("#userId").val()== ""){
			$("#idmsg").html("아이디를 입력하세요.");
			$("#userId").focus();
			return false;
		}
		if($("#userPw").val()== ""){
			$("#pwmsg").html("비밀번호 입력하세요.");
			$("#userPw").focus();
			return false;
		}
		$("#frm").submit();
	});
});
</script>
</head>
<body>
<c:if test="${empty logId }">
<!-- 로그인 안 된 경우 -->
<form action="login/loginPro.main" name="frm" id="frm" method="post">
<table border="1">
<tr><td colspan="3">
자동로그인<input type="checkbox" name="autologin" value="auto">
&nbsp;&nbsp;&nbsp;&nbsp;
아이디 저장 <input type="checkbox" name="idStore" value="store" 
<c:if test = "${!empty isId}"> checked </c:if>  /></td>
</td></tr>
<tr>
<td>아이디</td>
<td><input type="text" name="userId" id="userId" value="${isId}">
	<div id ="idmsg"></div>
</td>
<td rowspan=2><input type="image" src="images/img1.jpg" width="80" height="80" id="imgSubmit">
</td>
<tr>
<td>비밀번호</td>
<td><input type="password" name="userPw" id="userPw">
	<div id="pwmsg"></div>
</td>
</tr>

<tr>
<td colspan="3">
<a href="mem/memberAgree.mem">회원가입</a>&nbsp;
<a href="mem/idCk.mem">아이디 찾기</a>&nbsp;
<a href="">비밀번호 찾기</a>&nbsp;
</td>
</tr>
</table>
</form>
</c:if>
<c:if test="${!empty logId }">
<!-- 로그인 된 경우 -->
<a href="mem/memberDetail.mem">내정보</a>
<a href="login/logOutPro.main">로그아웃</a>
<a href="mem/meberList.mem">회원리스트</a>
<a href="qna/qnaList.qna">공지사항 게시판</a>
<a href="lib/libBoardList.lib">자료 게시판</a>
<a href="ans/ansBoardList.ans"">답변형 게시판</a>
<a href="gd/goodsList.gd">상품목록</a>
<a href="cb/commentList.cb">댓글 게시판</a>
<a href="survey/survey.sv">설문조사</a>
<a href="survey/surveyForm.sv">설문내용 등록</a>
</c:if>
</body>
</html>