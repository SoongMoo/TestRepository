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
		$("#frm").submit();
	});
	$("#memDel").click(function(){
		
		location.href="memPw.nhn";
	})
});
</script>
</head>
<body>
<form name ="frm" id ="frm" method = "post" action ="memberInfoModifyPro.mem">
<input type="hidden" name="memChk" value="${memChk }" />
<input type="hidden" name="id" value="${dto.userId }" />
<table border = 1  width = 600 align = "center" cellpadding = 3 >
	<tr><td colspan=2> 회원정보 수정 </td></tr>
	<tr><td >아이디</td>
		<td >${dto.userId }</td></tr>
	<tr><td>사용자 ID</td><td></td></tr>
	<tr><td >기본정보 입력</td>
		<td >&nbsp;</td></tr>
	<tr><td>사용자 이름</td>
		<td>${dto.userName }</td>
	</tr>
	<tr><td> 생년월일 및 성별</td>
		<td><fmt:formatDate value="${dto.userBirth }" type="date" 
		pattern="yyyy-MM-dd"/>
		/
			<c:if test="${dto.userGender == 'M'}">남자</c:if> 
			<c:if test="${dto.userGender == 'F'}">여자</c:if> 
		</td>
	</tr>
	<tr><td>사용자 비밀번호</td>
	    <td><input type="password" id ="userPw" name ="userPw" 
	        value = ""/></td></tr>
	<tr><td>사용자 이메일</td>
	    <td><input type ="text" id ="email" name ="userEmail" 
	        value = "${dto.userEmail }"/></td></tr>
	<tr><td>사용자 주소</td>
	    <td>
	    <input type ="text" id ="addr" name ="userAddr" 
	        value = "${dto.userAddr }"/>
	    </td>
	</tr>
	<tr><td>연락처 1</td>
	    <td>
	    <input type ="text" id ="memberPh1" name ="userPh1" 
	        value = "${dto.userPh1 }"/>
	    </td>
	</tr>
	<tr><td>연락처 2</td>
	    <td>
	    <input type ="text" id ="memberPh2" name ="userPh2" 
	        value = "${dto.userPh2 }"/>
	    </td>
	</tr>
	<tr>
		<td colspan=2>
		<input type="button" name="modify" id ="modify" 
				value="수   정" >
		<input type="button" value="취  소" 
			onclick = "javascript:history.back();" />
		<!-- onclick = "javascript:location.href='index.nhn';" -->
		</td>
	</tr>
</table>

</form>
</body>
</html>