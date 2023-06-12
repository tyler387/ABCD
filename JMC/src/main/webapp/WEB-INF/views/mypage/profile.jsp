<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:import url="../layout/header.jsp" />
<c:import url="../layout/mypageAside.jsp" />

</div>
    <div class="right">
     <form action="/mypage/profile" method="post" enctype="multipart/form-data" id="profileForm">
      <input type="hidden" name="userno" id="userno" value="${userno}">  
  
	<div class='profile'>
		<c:if test="${profile.profileStoredName eq null}">
			<img src="<%=request.getContextPath() %>/userProfile/pexels-tobias-bjørkli-1693095.jpgf6f88b97" id="profileimg"> 
	        <input type="file" id="file" name="file">
        </c:if>
        <c:if test="${profile.profileStoredName ne null}">
			<img src="<%=request.getContextPath() %>/userProfile/${profile.profileStoredName}" id="profileimg"> 
	        <input type="file" id="file" name="file">
        </c:if>
     </div>  
    
    <button id="profileInput" >프로필 수정</button>
    <a href="/mypage/main"><button>취소</button></a>
    
      </form>
    </div>
  </div>
    
<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script type="text/javascript">

function profileImageUpload(principalId) {
    $("#profileInput").click();

    $("#profileInput").on("change", (e) => {
        let f = e.target.files[0];

        if (!f.type.match("image.*")) {
            alert("이미지를 등록해야 합니다.");
            return;
        }

        // FormData 객체를 이용하면 form 태그의 필드와 그 값을 나타내는 일련의 key/value 쌍을 담을 수 있음
        let profileForm = $("#profileForm")[0];
        let formData = new FormData(profileForm);

        // 서버에 이미지 전송하기
        $.ajax({
            type: "post",
            url: '/userProfile/${profileStoredName}',
            data: formData,
            contentType: false,    // x-www-form-urlencoded로 파싱되는 것을 방지
            processData: false,    // contentType을 false로 설정할 경우 QueryString이 자동 설정되는 것을 방지
            enctype: "multipart/form-data",
            dataType: "json"
        }).done(resp => {
            // 사진 전송 성공시 이미지 변경
            let reader = new FileReader();
            reader.onload = (e) => {
                $("#profileimg").attr("src", e.target.result);
            }
            reader.readAsDataURL(f); // 이 코드 실행시 reader.onload 실행됨.
        }).fail(error => {
            console.log(error);
        });
    });
}

</script>    
    
<c:import url="../layout/footer.jsp" />