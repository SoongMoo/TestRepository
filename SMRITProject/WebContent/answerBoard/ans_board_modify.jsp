<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" 
 	src="http://code.jquery.com/jquery-1.8.1.js" ></script>
<script type="text/javascript">
$(function(){
	$("#btn").click(function(){
		if($(this).attr("value") == "삭제"){
			$(this).attr("value","삭제취소");
			$("#fileDel").val("${dto.storeFileName}");
			$("#chnFile").html(
					"<input type='file' name='fileUp' />"
			);
		}else{
			$(this).attr("value","삭제")
			$("#fileDel").val("");
			$("#chnFile").html("");
		}
	});
});	
</script>
<script type="text/javascript">
	function modifyboard(){
		modifyform.submit();
	}
	</script>
</head>
<body>
<form action="answerBoardModifyPro.ans" method="post" name="modifyform" 
	enctype="multipart/form-data">
<input type="hidden" name="boardNum" value="${dto.boardNum }">
<table cellpadding="0" cellspacing="0">
	<tr align="center" valign="middle">
		<td colspan="2">MVC 게시판</td>
	</tr>
	<tr align="left" valign="middle">
		<td colspan="2">글쓴이 : ${dto.boardName }
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
	</tr>	
	<tr>
		<td height="16" style="font-family:돋음; font-size:12">
			<div align="center">제 목</div>
		</td>
		<td>
			<input name="boardSubject" size="50" 
			maxlength="100" value="${dto.boardSubject }">
		</td>
	</tr>
	<tr>
		<td style="font-family:돋음; font-size:12">
			<div align="center">내 용</div>
		</td>
		<td>
			<textarea name="boardContent" cols="67" rows="15">${dto.boardContent }</textarea>
		</td>
	</tr>
	<tr>
			<td>파일</td>
			<td>
				원본 파일명 : ${dto.originalFileName }<br />
				저장된 파일 명 : ${dto.storeFileName}
				<input type="button" id="btn" value="삭제"/>
			</td>	
	</tr>
	<tr>
		<td>변경할 파일</td>
		<td><div id="chnFile"></div></td>
	</tr>
	<tr>
		<td height="16" style="font-family:돋음; font-size:12">
			<div align="center">비밀번호</div>
		</td>
		<td>
			<input name="boardPass" type="password">
		</td>
	</tr>
	
	<tr bgcolor="cccccc">
		<td colspan="2" style="height:1px;">
		</td>
	</tr>
	<tr><td colspan="2">&nbsp;</td></tr>
	
	<tr align="center" valign="middle">
		<td colspan="5">
			<font size=2>
			<a href="javascript:modifyboard()">[수정]</a>&nbsp;&nbsp;
			<a href="javascript:history.go(-1)">[뒤로]</a>&nbsp;&nbsp;
			</font>
		</td>
	</tr>
</table>
<input type="text" name="fileDel" id = "fileDel" />	
</form>
</body>
</html>