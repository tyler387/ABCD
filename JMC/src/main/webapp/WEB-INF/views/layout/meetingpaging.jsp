<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style type="text/css">
.pagination a{
	text-decoration: none;
	color: black;	
}

<%-- 사용불가 표현 CSS --%>
.disabled{
	color: gray;
}

</style>

<div class="page">
<ul class="pagination">

<%--===========================Go to First=============================--%>
<%-- 첫 페이지로 이동 --%>

<%-- 현재 페이지가 1이라면 첫 페이지로 이동하는 기능을 비활성화한다 --%>
<%--====================================================================--%>

<%--=====================Move to before page list=======================--%>
<%-- 페이지리스트를 이전 페이지 리스트로 이동(이동시엔 페이지 리스트의 첫페이지로 보낸다) --%>
<%-- 현재 페이지리스트의 시작 페이지가 1이라면 기능을 비활성화한다 --%>
<%--====================================================================--%>

<%--=======================Move to before page==========================--%>

<%-- 현재 페이지를 이전 페이지로 이동시킨다--%>

<%-- 현재 페이지가 1보다 작거나 같다면 기능을 비활성화한다 --%>
<%--====================================================================--%>


<%--===================Basic Pagination Numbering=======================--%>
<%-- ./list페이지로 이동할때 현재 페이지 정보를 쿼리스트링형태로 전송함 --%>
<c:forEach var="i" begin="${paging.startPage}" end="${paging.endPage}">
	<c:if test="${paging.curPage eq i }">
	<li><a href="./meeting?curPage=${i}" id="apaging" style="font-weight: 700;">${i}</a></li>
	</c:if>	
	<c:if test="${paging.curPage ne i }">
	<li><a href="./meeting?curPage=${i}" id="apaging">${i}</a></li>
	</c:if>	
</c:forEach>
<%--====================================================================--%>

<%--=======================Move to after page==========================--%>
<%-- 현재 페이지를 다음 페이지로 이동시킨다--%>

<%-- 현재 페이지가 전체 페이지보다 크거나 같다면 기능을 비활성화한다 --%>
<%--====================================================================--%>

<%--=====================Move to before page list=======================--%>
<%-- 페이지리스트를 다음 페이지 리스트로 이동(이동시엔 페이지 리스트의 첫페이지로 보낸다) --%>

<%-- 현재 페이지리스트의 끝 페이지가 끝 페이지와 같다면 기능을 비활성화한다 --%>
<%--====================================================================--%>

<%--===========================Go to End=============================--%>
<%-- 끝 페이지로 이동 --%>

<%-- 현재 페이지가 끝페이지라면 끝 페이지로 이동하는 기능을 비활성화한다 --%>
<%--====================================================================--%>

</ul>
</div>
