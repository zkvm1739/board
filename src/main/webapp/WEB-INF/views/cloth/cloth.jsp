<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>재고 수량</title>
</head>
<body>
	<h1> 전체리스트 </h1>
	<script>
			function categoryChange(e) {
				var clothtype_a = ["티셔츠", "바지", "슈트"];
				var clothtype_b = ["티셔츠", "바지", "원피스"];
				var target = document.getElementById("clothtype");
			
				if(e.value == "남성") var d = clothtype_a;
				else if(e.value == "여성") var d = clothtype_b;
			
				target.options.length = 0;
			
				for (x in d) {
					var opt = document.createElement("option");
					opt.value = d[x];
					opt.innerHTML = d[x];
					target.appendChild(opt);
				}
			}
			
			function getItem(){
				var sex = document.getElementById("sex").value;
				var clothtype = document.getElementById("clothtype").value;
			}
		</script>
	<div>
		<form method="post">
		<table>
		<tr>
		<td><select name="sex" onchange="categoryChange(this)">
			<option>성별</option>
			<option value="남성"<c:if test="${sex eq '남성'}">selected</c:if>>남성</option>
			<option value="여성"<c:if test="${sex eq '여성'}">selected</c:if>>여성</option>
		</select>
		</td>
		<td>
		<select id="clothtype" name="clothtype">
			<option>옷종류</option>
		</select>
		</td>
		<td>
		<button type="submit" onclick="getItem()">조회</button>
		</td>
		</tr>
		</table>
		</form>
	</div>
		
		
	<table>
		<thead>
			<tr>
				<td>상품코드</td>
				<td>상품명</td>
				<td>제조사명</td>
				<td>단위명</td>
				<td>재고수량</td>
				<td>재고여부</td>
				<td>사용여부</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${sex}" var="sex">
				<tr>
					<td>${sex.clothcode}</td>
					<td>${sex.clothname}</td>
					<td>${sex.brand}</td>
					<td>${sex.clotheach}</td>
					<td>${sex.clothcount}</td>
					<td><c:if test="${sex.clothcount ne '0'}"><input type="checkbox" 
						id="stock"  checked disabled></c:if>
						<c:if test="${sex.clothcount eq '0'}"><input type="checkbox" 
						id="stock" onclick="return false"></c:if></td>
					<td><c:if test="${sex.clothcount ne '0'}"><input type="checkbox" 
						id="useable"  checked disabled></c:if>
						<c:if test="${sex.clothcount eq '0'}"><input type="checkbox" 
						id="useable" onclick="return false"></c:if></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	
</body>
</html>