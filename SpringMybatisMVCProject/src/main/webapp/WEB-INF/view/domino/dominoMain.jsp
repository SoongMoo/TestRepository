<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
var cc = "<h2>Third Domino</h2>";
    cc += "<select ><option >--------선택하세요--------</option></select>";
$(function(){
	$("#asel").change(function() {
		$.ajax({
			type:"POST",
			url : "bDomino",
			data : "num=" + $("#asel").val(),
			datatype : "html",
			success : function(data1){
				$("#bDTO").html(data1);
				$("#cDTO").html(cc);
			}
		});
	});
});
</script>
</head>
<body>
<h2>첫번째 Domino</h2>
<select id="asel" name="aNum" >
	<option value="">--------선택하세요--------</option>
	<c:forEach items="${aa }" var="adto">
		<option value="${adto.a1 }">${adto.a2 }</option>
	</c:forEach>
</select>
<div id="bDTO">
<h2>Second Domino</h2>
		<select  >
			<option value="">--------선택하세요--------</option>
		</select>
		<div id = "cDTO"></div>
</div>

<div id="cDTO">
<h2>Third Domino</h2>
<select >
	<option >--------선택하세요--------</option>
</select>
</div>
</body>
</html>

