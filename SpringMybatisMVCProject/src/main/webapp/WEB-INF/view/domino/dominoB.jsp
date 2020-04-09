<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	$(function(){
		$("#bsel").change(function() {
			$.ajax({
				type:"POST",
				url : "cDomino",
				data : {"a1" : $("#asel").val() ,"b1" : $("#bsel").val()},
				datatype : "html",
				success : function(data1){
					$("#cDTO").html(data1);
				}
			});
		});
	});
</script>
</head>
<body>
${fn:substring(ho,0, fn:length(ho)-2) } 
${fn:substring(ho, fn:length(ho)-2, fn:length(ho)) }
<h2>Second Domino</h2>
		<select id="bsel" name="bNum">
			<option value="">--------선택하세요--------</option>
			<c:forEach var="bDTO" items="${bb}">
			<option value="${bDTO.b1}">${bDTO.b2}</option>
			</c:forEach>
		</select>
</body>
</html>