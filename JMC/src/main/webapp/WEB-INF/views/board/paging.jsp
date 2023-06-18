<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--     var curPage = <c:out value="${paging.curPage}"></c:out>; --%>
<%--    var totalCount = <c:out value="${paging.totalCount}"></c:out>; --%>
<%--     var totalPage = <c:out value="${paging.totalPage}"></c:out>; --%>
<%--     var listCount = <c:out value="${paging.listCount}"></c:out>; --%>
<%--     var pageCount = <c:out value="${paging.pageCount}"></c:out>; --%>
<%--     var startPage = <c:out value="${paging.startPage}"></c:out>; --%>
<%--     var endPage = <c:out value="${paging.endPage}"></c:out>; --%>
<%--     var startno = <c:out value="${paging.startno}"></c:out>; --%>
<%--     var endno = <c:out value="${paging.endno}"></c:out>; --%>
<%--     console.log("ssdasd", <c:out value="${paging.totalCount}"></c:out>); --%>
<%--    console.log("ssdasd", <c:out value="${paging.curPage}"></c:out>); --%>


<style type="text/css">
.pagination span{
   text-decoration: none;
   color: black;   
}

<%-- 사용불가 표현 CSS --%>
.disabled{
   color: gray;
   	display: inline-block;
}

ul{
	text-align: center;


}

li{
display: inline-block;
}


</style>

<div>


<input type="hidden" value="${paging.totalCount}" id="totalCount">
<input type="hidden" value="${paging.totalPage}" id="totalPage">

<nav>
<ul class="pagination pagination-sm justify-content-center" style="width: 670px;">
<%--===========================Go to First=============================--%>
<%-- 첫 페이지로 이동 --%>
<c:if test="${paging.curPage ne 1}">
   <li class ="page-item first"><span class="page-link">첫 페이지</span></li>
</c:if>

<%-- 현재 페이지가 1이라면 첫 페이지로 이동하는 기능을 비활성화한다 --%>
<c:if test="${paging.curPage eq 1}">
   <li class="disabled page-item  first"><span class="page-link">첫 페이지</span></li>
</c:if>
<%--====================================================================--%>

<%--=====================Move to before page list=======================--%>
<%-- 페이지리스트를 이전 페이지 리스트로 이동(이동시엔 페이지 리스트의 첫페이지로 보낸다) --%>
<c:if test="${paging.startPage ne 1}">
   <li class="page-item beforelist"><span class="page-link">&laquo;</span></li>
</c:if>
<%-- 현재 페이지리스트의 시작 페이지가 1이라면 기능을 비활성화한다 --%>
<c:if test="${paging.startPage eq 1}">
   <li class="disabled page-item  beforelist"><span class="page-link">&laquo;</span></li>
</c:if>
<%--====================================================================--%>

<%--=======================Move to before page==========================--%>

<%-- 현재 페이지를 이전 페이지로 이동시킨다--%>
<c:if test="${paging.curPage gt 1}">
   <li class="page-item before"><span class="page-link">&lt;</span></li>
</c:if>
  
<%-- 현재 페이지가 1보다 작거나 같다면 기능을 비활성화한다 --%>
<c:if test="${paging.curPage le 1}">
   <li class="disabled page-item  before"><span class="page-link">&lt;</span></li>
</c:if>
<%--====================================================================--%>


<%--===================Basic Pagination Numbering=======================--%>
<%-- ./list페이지로 이동할때 현재 페이지 정보를 쿼리스트링형태로 전송함 --%>
<c:forEach var="i" begin="${paging.startPage}" end="${paging.endPage}">
   <c:if test="${paging.curPage eq i }">
      <li class="page-item active usable gotoPage"><span class="page-link number">${i}</span></li>
   </c:if>
   <c:if test="${paging.curPage ne i }">
      <li class="page-item usable gotoPage"><span class="page-link number">${i }</span></li>
   </c:if>   
</c:forEach>
<%--====================================================================--%>

<%--=======================Move to after page==========================--%>
<%-- 현재 페이지를 다음 페이지로 이동시킨다--%>
<c:if test="${paging.curPage lt paging.totalPage}">
   <li  class="page-item next"><span class="page-link" >&gt;</span></li>
</c:if>

<%-- 현재 페이지가 전체 페이지보다 크거나 같다면 기능을 비활성화한다 --%>
<c:if test="${paging.curPage ge paging.totalPage}">
   <li class="disabled page-item  next"><span class="page-link">&gt;</span></li>
</c:if>
<%--====================================================================--%>

<%--=====================Move to before page list=======================--%>
<%-- 페이지리스트를 다음 페이지 리스트로 이동(이동시엔 페이지 리스트의 첫페이지로 보낸다) --%>
<c:if test="${paging.endPage ne paging.totalPage}">
   <li class="page-item nextlist"><span class="page-link" >&raquo;</span></li>
</c:if>

<%-- 현재 페이지리스트의 끝 페이지가 끝 페이지와 같다면 기능을 비활성화한다 --%>
<c:if test="${paging.endPage eq paging.totalPage}">
   <li class="disabled page-item  nextlist"><span class="page-link">&raquo;</span></li>
</c:if>
<%--====================================================================--%>

<%--===========================Go to End=============================--%>
<%-- 끝 페이지로 이동 --%>
<c:if test="${paging.curPage ne paging.totalPage}">
   <li class="page-item end"><span class="page-link">끝 페이지</span></li>
</c:if>

<%-- 현재 페이지가 끝페이지라면 끝 페이지로 이동하는 기능을 비활성화한다 --%>
<c:if test="${paging.curPage eq paging.totalPage}">
   <li class="disabled page-item  end"><span class="page-link">끝 페이지</span></li>
</c:if>
<%--====================================================================--%>

</ul>
</nav>
</div>