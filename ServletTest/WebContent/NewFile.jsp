<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%= request.getContextPath()%><br />
<%= request.getRequestURI().substring(
		request.getContextPath().length())
%><br />
<%= request.getHeader("User-Agent")%><br />
<%
	String mobilePhone 
			= "iphone,ipod,android,blackberry,windows ce,"
	        + "nokia,webos,opera mini,sonyericsson,opera mobi,"
	        + "iemobile,windows phone";
    String [] mobilePhones = mobilePhone.split(",");
    String userAgent = 
    		request.getHeader("User-Agent").toLowerCase();
    boolean isMobile = false;
    for(String s : mobilePhones)
    {
    	if(userAgent.indexOf(s) != -1){
    		isMobile = true;
    		break;
    	}
    }
    if(isMobile){
    	response.sendRedirect("http://m.naver.com");
    	out.print("<br />모바일 접속입니다.");
    }else{
    	response.sendRedirect("http://www.naver.com");
    	out.print("<br />pc접속입니다.");
    }
 %>
</body>
</html>






