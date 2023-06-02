<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<span class="button" id="test3">
댓글 <span id="cocountSpan" style="font-size:1em">${map.COCOUNT }</span>▽ 
<span style="font-size:1em">댓글 쓰기&#128394;</span>
</span>


<span class="like">
<img id="heartw" src="/resources/image/heartw.png" alt='이미지' width="25px" height="25px" />
<img id="heartr" src="/resources/image/heartr.png" alt='이미지' width="25px" height="25px" />
<span style="font-size:1em">${map.LIKECOUNT }</span>
</span>