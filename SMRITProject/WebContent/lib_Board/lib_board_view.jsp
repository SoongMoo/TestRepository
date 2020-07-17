<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/include.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table cellpadding="0" cellspacing="0">
	<tr align="center" valign="middle">
		<td colspan="5">QNA 게시판</td>
	</tr>
	
	<tr>
		<td height="16">제 목&nbsp;&nbsp;</td>
		<td >${list[0].boardSubject }</td>
	</tr>
	<tr bgcolor="cccccc">
		<td colspan="2" style="height:1px;">
		</td>
	</tr>
	<tr>
		<td >내 용</td>
		<td >
			<table border=0 width=490 height=250 >
				<tr>
					<td valign=top>
					${fn:replace(list[0].boardContent,cn,br)}
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td>파일</td>
		<td>
		<a href="../lib_Board/upload/${list[0].storeFileName }">
		${list[0].originalFileName }</a>
		&nbsp;&nbsp; / &nbsp;&nbsp;${list[0].fileSize }Byte
		</td>		
	</tr>
	<tr bgcolor="cccccc">
		<td colspan="2" style="height:1px;"></td>
	</tr>
	<tr><td colspan="2">&nbsp;</td></tr>
	
	<tr align="center" valign="middle">
		<td colspan="5">
			<font size=2>
			<a href="libBoardModify.lib?num=${list[0].boardNum }">
			[수정]
			</a>&nbsp;&nbsp;
			<a href="libBoardDel.lib?num=${list[0].boardNum }">
			[삭제]
			</a>&nbsp;&nbsp;
			<a href="libBoardList.lib">[목록]</a>&nbsp;&nbsp;
			</font>
		</td>
	</tr>
</table>
</body>
</html>