<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<c:forEach var="list" items="${list}" varStatus="status" >
<input type="hidden" value="${list.commentno }">
${list.commentno}.<div id="cContent${list.commentno}"> ${list.cContent }</div>
 
<button class="cDelete" data-commentno="${list.commentno}" data-contentno="${list.commentno}" data-boardno="${list.boardno}">삭제</button>

<!-- 작성하는 것1111 -->

<button class="cContent" data-commentno="${list.commentno}" data-contentno="${list.commentno}">수정</button>

<button class="confirm" data-commentno="${list.commentno}" data-contentno="${list.commentno}" >확인</button><br>

<!-- 작성하는 것2222 1은1 2는2의 짝꿍 -->
<%-- <button class="cContent" onclick="func(${list.commentno})" >수정</button><br> --%>

</c:forEach>
