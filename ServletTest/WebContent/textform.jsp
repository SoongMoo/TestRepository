<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	당신이 입력한 정보입니다.<br/>
<%-- 	<b>ID</b> : <%= request.getParameter("id") %><br/>
	<b>Password</b> : <%= request.getParameter("pw")%><br/> 
	<b>자기소개</b><br/
	<%= request.getParameter("desc") %> <br/> --%>
	<%
		String[] interest = request.getParameterValues("cp");
	%>
	<%
		for(String s : interest){
			out.print(s+"<br />");
		}
	%>
</body>
</html>