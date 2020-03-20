<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String num = request.getParameter("num");
	String urlPath = null;
	if(num.equals("1")){
		urlPath = "test/1.jsp";
	}else if(num.equals("2")){
		urlPath = "test/2.jsp";
	}else if(num.equals("3")){
		urlPath = "test/3.jsp";
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	includer.jsp에서 출력하는 내용: <%= "Hello World!" %><br />
	<jsp:include page="sub.jsp" ></jsp:include><br />
	액션 태그 수행 이후에 출력하는 내용.<br />
	<jsp:include page="<%=urlPath %>" ></jsp:include><br />
	urlPath가 포함되었습니다.
</body>
</html>