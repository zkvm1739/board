<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>전체리스트</h1>
	<div>
		<form method="post">
			<table>
				<tr>
					<td><select name="sex" onchange="categoryChange(this)">
							<option>성별</option>
							<option value="남성">남성</option>
							<option value="여성">여성</option>
					</select></td>
					<td><select name="clothtype">
							<option>옷종류</option>
							<option>티셔츠</option>
							<option>바지</option>
							<option>슈트</option>
					</select></td>
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
	</table>
</body>
</html>