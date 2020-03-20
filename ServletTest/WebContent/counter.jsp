<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Integer count = (Integer)application.getAttribute("count");
	Integer newCount = null;
	if(count == null){
		application.setAttribute("count",1); // Object
		newCount = 1;
	}else{
		if(session.isNew()){
			newCount = count + 1;
			application.setAttribute("count",newCount);
		}		
	}
	
%>
방문자수 : <%= (Integer)application.getAttribute("count") %>명
</body>
</html>