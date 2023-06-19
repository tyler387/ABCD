<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <style>
        #modal.modal-overlay {
            width: 100%;
            height: 100%;
          
            left: 0;
            top: 0;
            display: none;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            background: rgba(255, 255, 255, 0.25);
            box-shadow: 0 8px 32px 0 rgba(31, 38, 135, 0.37);
            backdrop-filter: blur(1.5px);
            -webkit-backdrop-filter: blur(1.5px);
            border-radius: 10px;
            border: 1px solid rgba(255, 255, 255, 0.18);

			  position: fixed;
			  top: 50%;
			  left: 50%;
			  transform: translate(-50%, -50%);

        }
        #modal .modal-window {
            background: #FFA500;
            box-shadow: 0 8px 32px 0 rgba( 31, 38, 135, 0.37 );
            backdrop-filter: blur( 13.5px );
            -webkit-backdrop-filter: blur( 13.5px );
            border-radius: 10px;
            border: 1px solid rgba( 255, 255, 255, 0.18 );
            width: 320px;
            height: 400px;
            position: relative;
            top: -100px;
            padding: 10px;
        }
        #modal .title {
            padding-left: 10px;
            display: inline;
            text-shadow: 1px 1px 2px gray;
            color: white;
            
        }
        #modal .title h2 {
            display: inline;
        }
        #modal .close-area {
            display: inline;
            float: right;
            padding-right: 10px;
            cursor: pointer;
            text-shadow: 1px 1px 2px gray;
            color: white;
        }
        
        #modal .content {
            margin-top: 20px;
            padding: 0px 10px;
            text-shadow: 1px 1px 2px gray;
            color: white;
        }
        
        #modaldivt{
        	margin-bottom: 15px;
        	
        }
        #modalbutton{
        	margin-top: 20px;
   			margin-left: 230px;
   			border: 2px solid white;
			background-color: rgba(0, 0, 0, 0);
			color: white;
			font-size: 25px;
			border-top-left-radius: 5px;
			border-bottom-left-radius: 5px;
			border-top-right-radius: 5px;
			border-bottom-right-radius: 5px;
			cursor: pointer;
        }
    </style>
</head>
<body>
 <div id="container">
        <button id="btn-modal">상품 문의하기</button>
        <div id="lorem-ipsum"></div>
</div>
<div id="modal" class="modal-overlay">
    <div class="modal-window">
        <div class="title">
            <h2>궁금한 점을 작성하세요.</h2>
        </div>
        <div class="close-area">X</div>
      
        <div class="content"> 
          <div id="modaldivt" style="margin-bottom:5px;">제목</div>
         
          <div id="modaldivc" style="margin-bottom:5px;">내용</div>

          <button id="modalbutton" onclick="confirm">확인</button>
   
        </div>
<!--         </form> -->
    </div>
</div>



<script>
    //특정 버튼을 누르면 모달창이 켜지게 하기
    const modal = document.getElementById("modal")
    const btnModal = document.getElementById("answer")
    btnModal.addEventListener("click", e => {
        modal.style.display = "flex"
    })
    
    //X(클로즈) 버튼에 위 예제와 반대되는 이벤트를 부여합니다.
    const closeBtn = modal.querySelector(".close-area")
	closeBtn.addEventListener("click", e => {
    modal.style.display = "none"
	})
    
    //모달창 바깥 영역을 클릭하면 모달창이 꺼지게 하기
    modal.addEventListener("click", e => {
    const evTarget = e.target
	    if(evTarget.classList.contains("modal-overlay")) {
	        modal.style.display = "none"
	    }
	})
	
	
	//--------------------------------------------------------------


</script>

<script type="text/javascript">

$("#modalbutton").click(function(){
	console.log("모달창 확인 버튼 클릭됨")
	var modalTitle = $("#modalTitle").val()
	var modalContent = $("#modalContent").val()
	console.log(modalTitle)
	console.log(modalContent)
	
	console.log("받았나?",${allItemDetail.itemDetail.itemno})
	
	//-----------------------------------
	 $.ajax({
		         type: "post"
		         , url: "/store/abcabc"
		         , data: {modalTitle : modalTitle
		        	 	, modalContent: modalContent
		        	 	, itemno : ${allItemDetail.itemDetail.itemno}}
		         , dataType: "html"
		         , success: function(){
		        	 
		            console.log("AJAX 성공")
		            location.reload();
		            
		         }
		         , error: function(){
		            console.log("AJAX 실패")   
		         }
		      })
	//----------------------------------------
})
	


</script>