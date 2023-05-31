<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- jQuery 2.2.4 -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>

    <style>
    div {
        width: 100%;
        height: 800px;
        
        border: 1px solid #000;
    }
    div.left {
        width: 20%;
        float: left;
        box-sizing: border-box;
        
    } 
    div.right {
        width: 80%;
        float: right;
        box-sizing: border-box;
        
    }
    h2{
    padding-left : 50px;
    }
    p{
    padding-left : 50px;
    }
    a {
  	text-decoration: none;
  	color: black;
	}
	a:visited {
  	color : black;
	}
    
    </style>
</head>
<body>
<h1>관리자 메인 페이지</h1>
<hr>
<div class="left">

<h2 style = "padding-top : 30px">회원관리</h2>
<p><a href="./board/list?boardOption=notice">회원 정보 수정</a><br></p> 
<p><a href="./board/list?boardOption=event">블랙리스트 관리</a><br><br></p>
<h2>신고관리</h2>
<p><a href="./board/list?boardOption=event">신고글 확인</a><br></p>
<p><a href="./board/list?boardOption=event">신고 계정 확인</a><br><br></p>
<h2>판매관리</h2>
<p><a href="./item/write">상품 등록</a><br></p>
<p><a href="./item/list">상품 삭제/수정</a><br></p>
<p><a href="./itemqna/list">상품 문의</a><br><br></p>
<h2>고객센터관리</h2>
<p><a href="./main/boardCategory?boardOption=notice">공지사항 관리</a><br></p>
<p><a href="./main/boardCategory?boardOption=event">이벤트 관리</a><br></p>
<p><a href="./qna/list">Q & A 관리</a><br><br></p>

</div>
<div class="right">



















</div>
</body>
</html>