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
	$("#btn").click(function(){
		$(opener.document).find("#userId").val($("#userId").val());
		$(opener.document).find("#userIdChk").val($("#num").val());
		window.close();
	});	
});
</script>
</head>
<body>
<form action="userConfirm.mem" method="post" name="frm" >
 <input type="text" name = "userId" value="${userId }" id ="userId"/>
 <div>
 	<c:if test="${empty confirmId }">
 		사용가능한 아이디 입니다.
 		<c:set var="num" value="2"/>
 	</c:if>
 	<c:if test="${!empty confirmId }">
 		사용중인 아이디 입니다.
 		<c:set var="num" value="1"/>
 	</c:if>
 </div>
 <input type="hidden" name = "num" value="${num }" id="num" />
 <input type = "submit" value="아이디확인" /> 
 <input type="button" value="닫기"  id = "btn"/>
</form>
</body>
</html>