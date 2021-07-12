<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 작성</title>
</head>
<body>

	<div id="nav">
		<%@ include file="../include/nav.jsp"%>
	</div>
	
	<form method="post">
		<label>제목</label>
		<input type="text" name="title" /><br/> 
		<c:if test="${member!=null }">
		<label>작성자</label>
		<input type="text" name="writer" value="${member.userName}"/><br/>
		</c:if> 
		<label>내용</label>
		<textarea cols="50" rows="5" name="content"></textarea>
		<br/>
		<button type="submit">작성</button>
	</form>

	<form action="upload" method="post" enctype="multipart/form-data">
		<label>파일 : </label> 
		<input multiple="multiple" type="file"	name="file1">
		<input type="submit" value="upload">
	</form>

</body>
</html>