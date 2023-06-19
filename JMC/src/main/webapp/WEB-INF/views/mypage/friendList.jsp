<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

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
.friendremove{
	cursor: pointer;
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
      
      <div><h1>친구 목록</h1></div>
       <div style="width:150px;"><hr></div>
         	
        <div id="tablebox">
         
         <div id="FriendList">
<%--  				<input type="hidden" name="userno" id="userno" value="${userno}"> --%>
				<table class="friendTable">
					<tr>
						<th>유저 아이디</th>
						<th>유저 닉네임</th>
						<th>유저 이름</th>
						<th>친구 삭제</th>
					</tr>
				<c:forEach var="list" items="${list}">
					
					<tr>
						<td>${list.USER_ID }</td>
						<td>${list.USER_NICK }</td>
						<td>${list.USER_NAME }</td>
						<td>

							<img src="/resources/image/삭제버튼.png" class="friendremove" data-userno="${list.FRIEND_USERNO}" style="width:30px;height:30px;">
						</td>
					</tr>
				</c:forEach>
				</table>
	 		</div>
         
         </div>
      </div>
    </div>
    
    
<script type="text/javascript">

$(function() {
	
	$("#FriendList").on("click", ".friendremove", function () {
		
		var userno = $(this).attr("data-userno")
		alert("친구삭제 되었습니다.");
		console.log(userno);		
		dataToss2(userno);
		return true;
		
	})
	
})

function dataToss2(userno) {
	console.log("받나요? ", userno)
	$.ajax({
		type:'post',
		url:'/mypage/friendList',
		dataType : 'html', 
		data : {userno: userno} ,
		success: function (data) {
			console.log("AJAX s") 
			console.log("result", data.result) 
			location.href='./friendList';
           },
        error: function () {
			console.log("AJAX e") 
		}
		
	})
	
}



</script>

<c:import url="../layout/footer.jsp" />