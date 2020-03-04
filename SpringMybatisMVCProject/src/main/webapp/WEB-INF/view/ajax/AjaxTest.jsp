<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function testDiv(n){
		if(n ==1){
			op1.style.display = "";
			op2.style.display = "none";
			op3.style.display = "none";
		}else if(n ==2){
			op1.style.display = "none";
			op2.style.display = "";
			op3.style.display = "none";
		}else if(n ==3){
			op1.style.display = "none";
			op2.style.display = "none";
			op3.style.display = "";
		}
	}
</script>
</head>
<body>
		<div class="person_bod" id="op1" >
			<ul class="person_tab">
				<li class="person_tab01"><h3>경력3년이상</h3></li>
				<li class="person_tab02" onclick="testDiv(2);"><h3>석박사급</h3></li>
				<li class="person_tab03" onclick="testDiv(3);"><h3>IT·개발</h3></li>
			</ul>

			<table cellspacing="0" cellpadding="0" border="0" summary="board" class="re_bod">
				<caption></caption>
				<colgroup>
					<col width="18%" />
					<col width="44%" />
					<col width="14%" />
					<col width="12%" />
					<col width="12%" />
				</colgroup>
				<thead>
					<tr>
						<th>ID(성별,연령)</th>
						<th>이력서제목</th>
						<th>학력</th>
						<th>경력</th>
						<th>희망연봉</th>
					</tr>
				</thead>
				<tbody>
					<tr >
						<td class="left">aa11</td>
						<td class="left">bb11</td>
						<td>cc11</td>
						<td>dd11</td>
					</tr>
				</tbody>
			</table>

		</div>
		<div class="person_bod" id="op2" style="display:none">
			<ul class="person_tab">
				<li class="person_tab01" onclick="testDiv(1);"><h3>경력3년이상</h3></li>
				<li class="person_tab02" ><h3>석박사급</h3></li>
				<li class="person_tab03" onclick="testDiv(3);"><h3>IT·개발</h3></li>
			</ul>

			<table cellspacing="0" cellpadding="0" border="0" summary="board" class="re_bod">
				<caption></caption>
				<colgroup>
					<col width="18%" />
					<col width="44%" />
					<col width="14%" />
					<col width="12%" />
					<col width="12%" />
				</colgroup>
				<thead>
					<tr>
						<th>ID(성별,연령)</th>
						<th>이력서제목</th>
						<th>학력</th>
						<th>경력</th>
						<th>희망연봉</th>
					</tr>
				</thead>
				<tbody>
					<tr >
						<td class="left">aa222</td>
						<td class="left">bb222</td>
						<td>cc11</td>
						<td>dd11</td>
					</tr>
				</tbody>
			</table>

		</div>
		<div class="person_bod" id="op3" style="display:none">
			<ul class="person_tab">
				<li class="person_tab01" onclick="testDiv(1);"><h3>경력3년이상</h3></li>
				<li class="person_tab02" onclick="testDiv(2);"><h3>석박사급</h3></li>
				<li class="person_tab03" ><h3>IT·개발</h3></li>
			</ul>

			<table cellspacing="0" cellpadding="0" border="0" summary="board" class="re_bod">
				<caption></caption>
				<colgroup>
					<col width="18%" />
					<col width="44%" />
					<col width="14%" />
					<col width="12%" />
					<col width="12%" />
				</colgroup>
				<thead>
					<tr>
						<th>ID(성별,연령)</th>
						<th>이력서제목</th>
						<th>학력</th>
						<th>경력</th>
						<th>희망연봉</th>
					</tr>
				</thead>
				<tbody>
					<tr >
						<td class="left">aa3333</td>
						<td class="left">bb3333</td>
						<td>cc11</td>
						<td>dd11</td>
					</tr>
				</tbody>
			</table>

		</div>
</body>
</html>