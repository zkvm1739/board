<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	게시판 !
</h1>
<form role="form" method="post" autocomplete="off" action="board/login">
 <p>
  <label for="userId">아이디</label>
  <input type="text" id="userId" name="userId" />
 </p>
 <p>
  <label for="userPass">패스워드</label>
  <input type="password" id="userPass" name="userPass" />
 </p>
 <p><button type="submit" id="login">로그인</button></p>
 </form>
<p><a href="/board/register">회원가입</a></p>
<p><a href="/cloth/cloth">옷</a>
<p><a href="/practice">연습</a>
<!-- <p><a href="/board/list">게시물 목록</a></p>
<p><a href="/board/write">게시물 작성</a></p> -->
</body>
</html>
