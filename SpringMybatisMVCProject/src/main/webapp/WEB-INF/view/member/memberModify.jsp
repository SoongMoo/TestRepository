<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
	$("#memPw").click(function(){
		location.href="changePassword?userId=${memberCommand.userId}";
	});
});
</script>
</head>
<body>
<form:form name ="frm" id ="frm" method = "post" action ="memberModifyPro"
	commandName="memberCommand">
	<form:hidden path="userId"/>
	
	<input type="hidden" name="userBirth" 
	    value ="<fmt:formatDate 
	              value='${memberCommand.userBirth}' 
		          type='date' pattern='yyyyMMdd' />" />

<table border = 1  width = 600 align = "center" cellpadding = 3 >
	<tr><td colspan=2> 회원정보 수정 </td></tr>
	<tr><td >아이디와 비번</td>
		<td >&nbsp;</td></tr>
	<tr><td>사용자 ID</td><td>${memberCommand.userId }</td></tr>
	<tr><td>비밀번호</td>
		<td><form:password id="pw" path ="userPw" />
		<form:errors path="userPw"/>
		  <div></div>
		  </td>
	</tr>
	<tr><td >기본정보 입력</td>
		<td >&nbsp;</td></tr>
	<tr><td>사용자 이름</td>
		<td></td>
	</tr>
	<form:hidden path="userBirth"/>
	<form:hidden path="userGender"/>
	<tr><td> 생년월일 및 성별</td>
		<td><fmt:formatDate 
	              value='${memberCommand.userBirth}' 
		          type='date' pattern='yyyy-MM-dd' />
		           / ${memberCommand.userGender}</td>
	</tr>
	<tr><td>사용자 이메일</td>
	    <td><form:input id ="email" path ="userEmail" />
	    <form:errors path="userEmail"/></td></tr>
	<tr><td>사용자 주소</td>
	    <td>
	    <form:input id ="addr" path ="userAddr" />
	    <form:errors path="userAddr"/>
	    </td>
	</tr>
	<tr><td>연락처 1</td>
	    <td>
	    <form:input id ="memberPh1" path ="userPh1" />
	    <form:errors path="userPh1"/>
	    </td>
	</tr>
	<tr><td>연락처 2</td>
	    <td>
	    <form:input id ="memberPh2" path ="userPh2" />
	    </td>
	</tr>
	<tr>
		<td colspan=2>
		<input type="submit" name="modify" id ="modify" 
				value="수   정" >
		<input type="button" value="취  소" 
			onclick = "javascript:history.back();" />
		<!-- onclick = "javascript:location.href='main.jsp';" -->
		<input type="button" value="비밀번호 변경" id ="memPw"/>
		</td>
	</tr>
</table>

</form:form>
</body>
</html>