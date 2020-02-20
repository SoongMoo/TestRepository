<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
		location.href="../memberModify?id=${memberCommand.userId }";
	});
	$("#memDel").click(function(){
		location.href="../memberInfoDel?id=${memberCommand.userId }"
	});
});
</script>
</head>
<body>

이름 : ${memberCommand.userName }<br />
아이디 : ${memberCommand.userId }<br />
이메일  : ${memberCommand.userEmail }<br />
생년월일  : <fmt:formatDate value="${memberCommand.userBirth }" type="date" pattern="yyyy-MM-dd"/> <br />
성별 : <c:if test="${memberCommand.userGender == 'M'}">
		남자
	  </c:if>
	  <c:if test="${memberCommand.userGender == 'F'}">
		여자
	  </c:if>
	 <br />
연락처 1 : ${memberCommand.userPh1 }<br />
연락처 2 : ${memberCommand.userPh2 }<br />
등록일 : ${memberCommand.userRegist }<br />
주소  : ${memberCommand.userAddr }<br />
<input type="button" name="modify" id ="modify" value="수   정" >
<input type="button" value="취  소" 
				onclick = "javascript:history.back();" />
<input type="button" value="회원삭제" id ="memDel"/>
</body>
</html>