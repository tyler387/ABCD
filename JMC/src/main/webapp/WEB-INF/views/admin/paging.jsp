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

<div>
<nav>
<ul class="pagination pagination-sm justify-content-center">

<%--===========================Go to First=============================--%>
<%-- 첫 페이지로 이동 --%>
<c:if test="${paging.curPage ne 1}">
	<li class ="page-item"><a class="page-link" href="./list">첫 페이지</a></li>
</c:if>

<%-- 현재 페이지가 1이라면 첫 페이지로 이동하는 기능을 비활성화한다 --%>
<c:if test="${paging.curPage eq 1}">
	<li class="page-item disabled"><a class="page-link">첫 페이지</a></li>
</c:if>
<%--====================================================================--%>

<%--=====================Move to before page list=======================--%>
<%-- 페이지리스트를 이전 페이지 리스트로 이동(이동시엔 페이지 리스트의 첫페이지로 보낸다) --%>
<c:if test="${paging.startPage ne 1}">
	<li  class="page-item"><a class="page-link" href="./list?curPage=${paging.startPage-paging.pageCount}">&laquo;</a></li>
</c:if>
<%-- 현재 페이지리스트의 시작 페이지가 1이라면 기능을 비활성화한다 --%>
<c:if test="${paging.startPage eq 1}">
	<li class="page-item disabled"><a class="page-link">&laquo;</a></li>
</c:if>
<%--====================================================================--%>

<%--=======================Move to before page==========================--%>

<%-- 현재 페이지를 이전 페이지로 이동시킨다--%>
<c:if test="${paging.curPage gt 1}">
	<li class="page-item"><a class="page-link" href="./list?curPage=${paging.curPage-1}">&lt;</a></li>
</c:if>

<%-- 현재 페이지가 1보다 작거나 같다면 기능을 비활성화한다 --%>
<c:if test="${paging.curPage le 1}">
	<li class="page-item disabled"><a class="page-link">&lt;</a></li>
</c:if>
<%--====================================================================--%>


<%--===================Basic Pagination Numbering=======================--%>
<%-- ./list페이지로 이동할때 현재 페이지 정보를 쿼리스트링형태로 전송함 --%>
<c:choose>
	<c:when test="${not empty filterListStatus and filterListStatus }">
		<c:forEach var="i" begin="${paging.startPage}" end="${paging.endPage}">
			<c:if test="${paging.curPage eq i }">
			<li class="page-item active"><a class="page-link" href="./filter?curPage=${i}&filter=${filter.filter}&content=${filter.content}&status=${filter.status}">${i}</a></li>
			</c:if>
			<c:if test="${paging.curPage ne i }">
			<li class="page-item"><a class="page-link" href="./filter?curPage=${i}&filter=${filter.filter}&content=${filter.content}&status=${filter.status}">${i}</a></li>
			</c:if>
		</c:forEach>
	</c:when>
	<c:when test="${empty filterList and filterList ne true}">
		<c:forEach var="i" begin="${paging.startPage}" end="${paging.endPage}">
			<c:if test="${paging.curPage eq i }">
			<li class="page-item active"><a class="page-link" href="./list?curPage=${i}">${i}</a></li>
			</c:if>
			<c:if test="${paging.curPage ne i }">
			<li class="page-item"><a class="page-link" href="./list?curPage=${i}">${i}</a></li>
			</c:if>
		</c:forEach>
	</c:when>
	<c:when test="${not empty filterList and filterList}">
		<c:forEach var="i" begin="${paging.startPage}" end="${paging.endPage}">
			<c:if test="${paging.curPage eq i }">
			<li class="page-item active"><a class="page-link" href="./filter?curPage=${i}&filter=${filter.filter}&content=${filter.content}">${i}</a></li>
			</c:if>
			<c:if test="${paging.curPage ne i }">
			<li class="page-item"><a class="page-link" href="./filter?curPage=${i}&filter=${filter.filter}&content=${filter.content}">${i}</a></li>
			</c:if>
		</c:forEach>
	</c:when>
</c:choose>
<%--====================================================================--%>

<%-- 검사 : ${empty filterList and filterList ne true} --%>
<%-- 검사 : ${not empty filterList and filterList} --%>

<%--=======================Move to after page==========================--%>
<%-- 현재 페이지를 다음 페이지로 이동시킨다--%>
<c:if test="${paging.curPage lt paging.totalPage}">
	<li class="page-item"><a class="page-link" href="./list?curPage=${paging.curPage+1}">&gt;</a></li>
</c:if>

<%-- 현재 페이지가 전체 페이지보다 크거나 같다면 기능을 비활성화한다 --%>
<c:if test="${paging.curPage ge paging.totalPage}">
	<li class="page-item disabled"><a class="page-link">&gt;</a></li>
</c:if>
<%--====================================================================--%>

<%--=====================Move to before page list=======================--%>
<%-- 페이지리스트를 다음 페이지 리스트로 이동(이동시엔 페이지 리스트의 첫페이지로 보낸다) --%>
<c:if test="${paging.endPage ne paging.totalPage}">
	<li class="page-item"><a class="page-link" href="./list?curPage=${paging.startPage+paging.pageCount}">&raquo;</a></li>
</c:if>

<%-- 현재 페이지리스트의 끝 페이지가 끝 페이지와 같다면 기능을 비활성화한다 --%>
<c:if test="${paging.endPage eq paging.totalPage}">
	<li class="page-item disabled"><a class="page-link">&raquo;</a></li>
</c:if>
<%--====================================================================--%>

<%--===========================Go to End=============================--%>
<%-- 끝 페이지로 이동 --%>
<c:if test="${paging.curPage ne paging.totalPage}">
	<li class="page-item"><a class="page-link" href="./list?curPage=${paging.totalPage}">끝 페이지</a></li>
</c:if>

<%-- 현재 페이지가 끝페이지라면 끝 페이지로 이동하는 기능을 비활성화한다 --%>
<c:if test="${paging.curPage eq paging.totalPage}">
	<li class="page-item disabled"><a class="page-link">끝 페이지</a></li>
</c:if>
<%--====================================================================--%>

</ul>
</nav>
</div>
