<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>��ü����Ʈ</h1>
	<div>
		<form method="post">
			<table>
				<tr>
					<td><select name="sex" onchange="categoryChange(this)">
							<option>����</option>
							<option value="����">����</option>
							<option value="����">����</option>
					</select></td>
					<td><select name="clothtype">
							<option>������</option>
							<option>Ƽ����</option>
							<option>����</option>
							<option>��Ʈ</option>
					</select></td>
					<td>
						<button type="submit" onclick="getItem()">��ȸ</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<table>
		<thead>
			<tr>
				<td>��ǰ�ڵ�</td>
				<td>��ǰ��</td>
				<td>�������</td>
				<td>������</td>
				<td>������</td>
				<td>�����</td>
				<td>��뿩��</td>
			</tr>
		</thead>
	</table>
</body>
</html>