<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<c:import url="../layout/header.jsp" />
<c:import url="../layout/mypageAside.jsp" />


<style type="text/css">
.inputbox{
	display: inline-block;
}

.selectbox{
	display: inline-block;	
}
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

.friendAdd{
	cursor: pointer;
}

.searchInput {
    display: inline-block;
    height: 32px;
    vertical-align: middle;
    border: 1px solid orange;
    width: 200px;
    color: #371e06;
    font-family: '양진체';
}

.selectbtn{
	border: 1px solid orange;
    background-color: orange;
    border-radius: 7px;
    color: #fff;
    width: 60px;
    height: 32px;
    font-size: 20px;
    cursor: pointer;
    margin-top: 40px;
    font-family: '양진체';
}

.selectbox{
	margin-left: 15px;
}

.selectbox2{
	 display: inline-block;
    height: 32px;
    vertical-align: middle;
    border: 1px solid orange;
    width: 120px;
    color: #371e06;
    font-family: '양진체';
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
      
      
      <div class="anotherbox">
         	<div><h1>친구 찾기</h1></div>
        		<div style="width:150px;"><hr></div>
         	</div>
        
       <form name="friendFind" autocomplete="off" action="/mypage/search" method="get" class="searchbox"> 
<!--        <form name="friendFind" autocomplete="off"> -->
         <div class="selectbox">
        	<select name="type" class="selectbox2">
        		<option value="all">아이디+닉네임</option>
        		<option value="user_id">아이디</option>
        		<option value="user_nick">닉네임</option>
        	</select>
     
	        <div class="inputbox">
	        	<input type="text" name="keyword" class="searchInput" >
	        </div>
        
	      
	        <button class="selectbtn">검색</button>
	        
	     </div>  
	     </form>   
	     <form action="/mypage/friendfind" method="post">
         <input type="hidden" id="userno" name="userno" value="${userno}">
         <div id="tablebox">
         <div id="searchFriend">
			<table class="labelbox1">
				<tr>
					<th>유저 아이디</th>
					<th>유저 닉네임</th>
					<th>유저 이름</th>
					<th>친구 등록</th> 
				</tr>
			
			<c:forEach var="list" items="${list }">
			<tr>
				<td>${list.userId }</td>
				<td>${list.userNick }</td>
				<td>${list.userName }</td>
				<td>
					<img src="/resources/image/optionAddIcon.png" class="friendAdd" data-userno="${list.userno}" style="width:30px;height:30px;">
				</td>
			</tr>
			</c:forEach>
			</table>
		 </div>
         
         </div>
        </form>
         
      </div>
    </div>

<script type="text/javascript">

$(function() {
	
	$("#searchFriend").on("click", ".friendAdd", function () {
		
		var userno = $(this).attr("data-userno")
		
		alert("친구추가 되었습니다.");
		console.log(userno);
		
		dataToss(userno);
	})
	
})

function dataToss(userno) {
	console.log("받나요? ", userno)
	$.ajax({
		type:'post',
		url:'/mypage/friendfind',
		dataType : 'json', 
		data : {userno: userno} ,
		success: function (data) {
			console.log("AJAX s") 
			console.log("result", data.result) 
			if(data.result){
				$(this).unwrap()
			}
           },
        error: function () {
			console.log("AJAX e") 
		}
		
	})
	
}



</script>

<c:import url="../layout/footer.jsp" />