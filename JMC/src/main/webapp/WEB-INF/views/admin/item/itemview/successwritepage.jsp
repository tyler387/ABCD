<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../../main.jsp"/>
<script type="text/javascript">
$(function() {
	
})
</script>


<style type="text/css">

#writeDone{
	width: 1000px;
	margin: 0 auto;
	border:1px solid black;
}

</style>
<br><br>
<div id="writeDone">
<br>
<h1 style="text-align: center">상품 등록 완료</h1>
<br>
<h4 style="text-align: center">상품이 성공적으로 등록되었습니다</h4>
<br>
<%-- 판매 페이지가 완성되면 상품 번호를 클릭하면 판매중인 상품의 페이지로 이동하는 기능 구현예정 --%>
<div style="text-align: center">
<h6>상품 번호: <a style="color:blue;" href="<%=request.getContextPath()%>/store/itemDetail?itemno=${reqisteredItemno}">${reqisteredItemno}</a></h6>
<button onclick="location.href='./write'">상품 등록</button>
<button onclick="location.href='./list'">상품 수정</button>
</div>
</div>
</body>
</html>