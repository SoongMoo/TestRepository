<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" 
	src="http://code.jquery.com/jquery-latest.js" ></script>
<script type="text/javascript">
$(function(){
	$("#frm").submit(function(){
		if($("#boardPass").val() == ""){
			$("#msg").html("비밀번호를 입력하세요");
			$("#boardPass").focus();
			return false;
		}
	});
});
</script>
</head>
<body>
<div>${deleteMsg }</div>
<form action="answerBoardDeletePro.ab" method="post" name="frm">
<input type ="hidden" name="boardNum"  value="${param.num }" />
비밀번호 : <input type="password" name = "boardPass"  id = "boardPass"/>
<div id="msg"></div>
<input type="submit" value = "게시글 삭제" />
</form>
</body>
</html>