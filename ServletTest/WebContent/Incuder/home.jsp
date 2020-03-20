<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	
	int i =10;
	String page1 = request.getParameter("page2");
	if(page1 == null) page1 = "mainHome";
	String viewPage = page1 + ".jsp";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
valTest.jsp에서 출력 : <%@ include file="valTest.jsp" %>
<table>
	<tr><td colspan = 2>
			<jsp:include page="include/topMenu.jsp" />
		</td></tr>
	<tr><td><jsp:include page="include/leftMenu.jsp" /></td>
		<td><jsp:include page="<%= viewPage %>" /></td></tr>
	<tr>
		<td colspan = 2>
			<jsp:include page="include/footer.jsp" />
		</td>
	</tr>
</table>
</body>
</html>