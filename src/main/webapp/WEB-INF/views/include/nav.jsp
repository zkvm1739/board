<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<ul>
<h1>게시판 !</h1>

<li>
 <a href="/board/listPageSearch?num=1">글 목록 (페이징) + 검색 </a> 
</li> 
<!-- <li>
 <a href="/board/listPage?num=1">글 목록 (페이징) </a> 
</li>  -->
<!--  <li>
  <a href="/board/list">글 목록</a> 
 </li> -->
 <li>
  <a href="/board/write">글 작성</a> 
 </li> 
 
 <c:if test="${member!=null }">
 	<div>
 		<p>${member.userName }님 환영합니다.</p>
 	</div>
 </c:if>
 
 
 
 
</ul>