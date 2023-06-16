<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="../layout/header.jsp" />
<c:import url="../layout/mypageAside.jsp" />

<script type="text/javascript">


</script>
<style type="text/css">
.right{
	padding : 0!important;
}
th{
	width : 15%;
}
td{
	text-align: center;
}
#agreeY,#agreeN{	
	display : inline-block;
	width : 70px;
	padding : 10px;
}
tbody{
	height: 100%;
}
tr{
	height : 100px;	
	border-bottom : 1px solid black;
}
#agreeY{
	background-color: #371e06;
	color : white;
}
#agreeN{
	background-color: #f1f0f0;
	color : black;
}

.pagination li{
    margin: 0 0 0 0;
    padding: 0 0 0 0;
    border : 0;
    float: left;


}
.pagination{
	padding: 0;
}
#paging{
	width: 100%;
	height : 100px;
	display: flex;
	justify-content: center;
}
table{
	width:90%;
	border-collapse: collapse;
    height: 0;
}
#apaging{

	padding: 5px 10px 5px 10px;
	font-size : 20px;
	margin-right : 5px;
}
#tablesize{
    height: 700px;
    display: flex;
    justify-content: center;
}
</style>


  </div>
      <div class="right">
      
<c:import url="./meetingTable.jsp"></c:import>
      </div>
    </div>


<c:import url="../layout/footer.jsp" />