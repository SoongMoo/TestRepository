<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function modifyboard(){
		frm.submit();
	}
</script>
</head>
<body>
<div>${msg }</div>
<form action="answerBoardModify.ab" method="post" name="frm">
<input type="hidden" name="boardNum" value="${board.boardNum }" />
<table border="1" cellpadding="0" cellspacing="0" >
	<tr align="center" valign="middle" >
		<td style="font-size:12" height="16">글쓴이 </td>
		<td style="font-size:12">
			<input type="text" name = "boardName" value="${board.boardName }">  
		</td>
	</tr>
	<tr align="center" valign="middle">
		<td style="font-size:12" height="16">제목 </td>
		<td style="font-size:12" >
			<input type="text" name = "boardSubject" 
						value="${board.boardSubject }"> 
		</td>
	</tr>
	<tr align="center" valign="middle">
		<td style="font-size:12" height="16" >내용 </td>
		<td style="font-size:12">
			<textarea rows="15" cols="50" 
						name="boardContent">${board.boardContent }</textarea> 
		</td>
	</tr>
	<tr align="center" valign="middle">
		<td style="font-size:12" height="16" >비밀번호</td>
		<td style="font-size:12">
			<input type="password" name = "boardPass" />
		</td>
	</tr>
	<tr align="center" valign="middle">
		<td colspan="2">
			<font size=2>
			<a href="javascript:modifyboard()">[수정]</a>&nbsp;&nbsp;
			<a href="javascript:history.go(-1)">[뒤로]</a>&nbsp;&nbsp;
			</font>
		</td>
	</tr>
</table>
</form>
</body>
</html>