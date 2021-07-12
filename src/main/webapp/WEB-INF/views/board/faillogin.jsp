<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
 <title>로그인</title> 
</head>
<body>
 <p>아이디나 비밀번호가 다릅니다.</p>
 <form role="form" method="post" autocomplete="off">
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
<p><a href="/">처음으로</a>
</body>
</html>