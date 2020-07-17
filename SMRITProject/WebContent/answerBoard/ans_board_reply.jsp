<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>#</title>
</head>
<body>
<form action="answerBoardReplyPro.ans" method="post" name="frm" >
<input type="text" name="boardNum" value="${dto.boardNum }"/>
<input type="text" name="boardReRef" value="${dto.boardReRef }"/>
<input type="text" name="boardReLev" value="${dto.boardReLev }"/>
<input type="text" name="boardReSeq" value="${dto.boardReSeq }"/>

<table cellpadding="0" cellspacing="0">
	<tr align="center" valign="middle">
		<td colspan="2">MVC 게시판</td>
	</tr>
	<tr>
		<td style="font-family:돋음; font-size:12" height="16">
			<div align="center">글쓴이 </div>
		</td>
		<td>
			<input type="text" name="boardName"  />
		</td>
	</tr>
	<tr>
		<td style="font-family:돋음; font-size:12" height="16">
			<div align="center">제 목</div>
		</td>
		<td>
			<input type="text" name="boardSubject" size="50" maxlength="100" 
				value="RE: ${dto.boardSubject }"/>

		</td>
	</tr>
	<tr>
		<td style="font-family:돋음; font-size:12">
			<div align="center">내 용</div>
		</td>
		<td>
			<textarea name="boardContent" cols="67" rows="15" />&#10;&#10;=============================================================&#10;${dto.boardContent }</textarea>
		</td>
	</tr>
	<tr>
		<td style="font-family:돋음; font-size:12">
			<div align="center">비밀번호</div>
		</td>
		<td>
			<input type="password" name="boardPass" />
		</td>
	</tr>
	
	<tr bgcolor="cccccc">
		<td colspan="2" style="height:1px;">
		</td>
	</tr>
	<tr><td colspan="2">&nbsp;</td></tr>
	
	<tr align="center" valign="middle">
		<td colspan="5">
		<a href="javascript:frm.submit();">[등록]</a>&nbsp;&nbsp;
		<a href="javascript:history.go(-1)">[뒤로]</a>
		</td>
	</tr>
</table>
</form>
</body>
</html>