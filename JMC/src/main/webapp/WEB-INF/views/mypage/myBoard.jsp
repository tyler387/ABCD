<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
      <div><h1>작성 게시물</h1></div>
       <div style="width:150px;"><hr></div>
        <div id="myboard">
				<input type="hidden" name="userno" id="userno" value="${userno}">
				<table class="boardTable">
					<tr>
						<th>사진</th>
					
					</tr>
				<c:forEach var="list" items="${list }">
					
					<tr>
					
				<td><a href="./myBoarddetail?boardno=${list.BOARDNO }"><img src="<%=request.getContextPath() %>/boardFileUpload/${list.STORED_NAME}"></a></td>
					
					</tr>
				</c:forEach>
				</table>
	 		</div>
      </div>
    </div>

<c:import url="../layout/footer.jsp" />