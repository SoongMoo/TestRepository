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
<script type="text/javascript">
$(function(){
	$("#modify").click(function(){
		location.href="memberPw.mem"
	});
	$("#memDel").click(function(){
		location.href="memberUserDel.mem"
	});
	$("#pwModify").click(function(){
		location.href="memberPwForm.mem"
	});
});
</script>
</head>
<body>
이름 : ${dto.userName }<br />
아이디 : ${dto.userId }<br />
이메일  : ${dto.userEmail }<br />
생년월일  : ${dto.userBirth }<br />
성별 : <c:choose >
	  	<c:when test="${dto.userGender == 'M'}">
	  		  		남자
	  	</c:when>
	  	<c:when test="${dto.userGender == 'F'}">
	  		여자
	  	</c:when>
	  </c:choose> <br />
연락처 1 : ${dto.userPh1 }<br />
연락처 2 : ${dto.userPh2 }<br />
등록일 : ${dto.userRegist }<br />
주소  : ${dto.userAddr }<br />
<input type="button" name="modify" id ="modify" value="수   정" >
<input type="button" name="pwModify" id ="pwModify" value="비밀번호" >
<input type="button" value="취  소" 
				onclick = "javascript:history.back();" />
<input type="button" value="탈퇴" id ="memDel"/>
</body>
</html>