<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.io.*" %>
<%
	String path = request.getRealPath("/");
	BufferedReader br = null;// 데이터를 임시로 저장해두기 위한 공간
	PrintWriter pr = null;
	String count = null;
	int num = 0;
	br = new BufferedReader(new FileReader(path + "/count.txt"));
	count = br.readLine().trim();
	br.close();
	if(session.isNew()){
		num = Integer.parseInt(count) +1;
		pr = new PrintWriter(new FileWriter(path + "/count.txt"));
		pr.print(num);
		pr.close();
	}else{
		num = Integer.parseInt(count);
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%= num %>명
</body>
</html>