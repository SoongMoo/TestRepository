<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board_write.jsp</title>
</head>
<script type="text/javascript" 
 src="http://code.jquery.com/jquery-latest.js" ></script>
<script type="text/javascript">
	function addboard(){
		$("#frm").submit();
	}
</script>

<body>
<form action="answerBoardWritePro.ab" method="post" 
		name="frm" id="frm">
<table cellpadding="0" cellspacing="0" > 
	<tr align="center" valign="middle">
		<td colspan="2">답변형 게시판</td>
	</tr>
	<tr>
		<td style="font-size:12" height="16" >
			<div align="center">글쓴이</div>
		</td>
		<td>
			<input name="boardName" type="text" size="10" 
				maxlength="10" />
		</td>
	</tr>
	<tr>
		<td style="font-size:12" height="16" >
			<div align="center">비밀번호</div>
		</td>
		<td>
			<input name="boardPass" type="password" size="10" 
				maxlength="10" />
		</td>
	</tr>
	<tr>
		<td style="font-size:12" height="16" >
			<div align="center">제목</div>
		</td>
		<td>
			<input name="boardSubject" type="text" size="10" 
				maxlength="10" />
		</td>
	</tr>
		<tr>
		<td style="font-family:돋음; font-size:12">
			<div align="center">내 용</div>
		</td>
		<td>
			<textarea name="boardContent" cols="67" rows="15"></textarea>
		</td>
	</tr>
	<tr>
		<td colspan=2>
			<a href="javascript:addboard();">[등록]</a>&nbsp;&nbsp;
			
			<a href="javascript:history.go(-1)">[뒤로]</a>
		</td>
	</tr>
</table>
</form>
</body>
</html>