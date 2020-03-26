<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
		location.href="memberModify.nhn"
	});
	$("#memDel").click(function(){
		location.href="memberDel.nhn"
	});
	
});
</script>
</head>
<body>
<c:if test="${empty memId}">
	<script>
		location.href="index.nhn";
	</script>
</c:if>
이름 : ${member.userName }<br />
아이디 : ${member.userId }<br />
이메일  : ${member.userEmail }<br />
생년월일  : ${member.userBirth }<br />
성별 : <c:choose >
	  	<c:when test="${member.userGender == 'M'}">
	  		남자
	  	</c:when>
	  	<c:when test="${member.userGender == 'F'}">
	  		여자
	  	</c:when>
	  </c:choose> <br />
연락처 1 : ${member.userPh1 }<br />
연락처 2 : ${member.userPh2 }<br />
등록일 : ${member.userRegist }<br />
주소  : ${member.userAddr }<br />
<input type="button" name="modify" id ="modify" value="수   정" >
<input type="button" value="취  소" 
				onclick = "javascript:history.back();" />
<input type="button" value="탈퇴" id ="memDel"/>
</body>
</html>