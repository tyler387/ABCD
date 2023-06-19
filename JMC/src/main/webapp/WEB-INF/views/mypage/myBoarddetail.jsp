<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="../layout/header.jsp" />
<c:import url="../layout/mypageAside.jsp" />

<style type="text/css">
	table {
  border: 1px #a39485 solid;
  font-size: .9em;
  box-shadow: 0 2px 5px rgba(0,0,0,.25);
  width: 90%;
  border-collapse: collapse;
  border-radius: 5px;
  overflow: hidden;
  margin-left: 15px;
}


th {
  text-align: left;
     background: #371e06;
	 color : #fff;
}
  
  
 td, th {
  padding: 1em .5em;
  vertical-align: middle;
}
  
 td {
  border-bottom: 1px solid rgba(0,0,0,.1);
  background: #fff;
}

td:hover{
	background-color: #a39485;
}

  
 @media all and (max-width: 768px) {
    
  table, thead, tbody, th, td, tr {
    display: block;
  }
  
  th {
    text-align: right;
  }
  
  table {
    position: relative; 
    padding-bottom: 0;
    border: none;
    box-shadow: 0 0 10px rgba(0,0,0,.2);
  }
  
  
  tr {
    display: inline-block;
    vertical-align: top;
  }
  
  th {
    border-bottom: 1px solid #a39485;
  }
  
  td {
    border-bottom: 1px solid #e5e5e5;
  }
  
  
  }
	

</style>

  </div>
      <div class="right">
       <div id="searchFriend">
				<div  style="font-size: 20px; padding-top: 38px; margin-left: 20px; "> My board </div>
       			<div style="width:150px; margin-left: 18px;"><hr></div>
				<table class="friendTable">
					<tr>
						
						<th>작성날짜</th>
						<th>본문</th>
						<th>사진</th>
					</tr>
					
						<c:forEach var="list" items="${list }">
					<tr>
						<td><fmt:formatDate value="${list.WRITE_DATE }" pattern="yyyy/MM/dd HH:mm"/></td>
						<td>${list.CONTENT }</td>
						<td><img src="<%=request.getContextPath() %>/boardFileUpload/${list.STORED_NAME}" style="width:50px; height: 50px;"></td>
					</tr>
					</c:forEach>
				</table>
	 		</div>
      </div>
    </div>

<c:import url="../layout/footer.jsp" />