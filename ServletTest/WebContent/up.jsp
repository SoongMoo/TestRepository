<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.oreilly.servlet.MultipartRequest,
	com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page import = "java.io.*" %>
<%
/* 	InputStream ins = request.getInputStream();
  	int data = -1;
  	while ( (data = ins.read()) != -1 ) {
    	out.print((char)data);
  	} */
%>
<%= request.getRealPath("/upload")%><br />

<%  // 파일이 저장될 경로
 	String path =  request.getRealPath("/upload");
	int sizeLimit =  5 * 1024 * 1024; 
	MultipartRequest multi = new MultipartRequest(
			request,path, sizeLimit, "UTF-8", 
			new DefaultFileRenamePolicy());	
%>
    <!-- String -->
<%= multi.getParameter("userName") %><br />
<%= multi.getFilesystemName("upfile") %><br />
<%= multi.getOriginalFileName("upfile") %><br />
<% //파일객체 생성
	File file = multi.getFile("upfile");  
	long fileSize = file.length();
	out.print(fileSize);
%><br />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="upload/<%= multi.getFilesystemName("upfile") %>" >
<%= multi.getOriginalFileName("upfile") %>
</a>
</body>
</html>