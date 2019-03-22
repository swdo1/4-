<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
<title>Home</title>
<script src="resources/js/jquery-3.3.1.min.js"></script>

<script>
$(document).ready(function(){
	$('#loginbt').on('click', openWin);
	$('#leave').on('click', leave);
	
	
});

function openWin(){
	win = window.open('login', 'login', 'width=600, height=200 , left=500 , top=200');
}
function leave(){
	$.ajax({
		url: 'leave',
		type: 'get',
		success: function(){
			alert('성공');
			location.href="";
		},
		error: function(){
			alert('실패');
		}
	});
}

</script>
</head>
<body>

<c:if test="${sessionScope.loginId != null}">
	<p><b>${sessionScope.loginName}님 로그인 중입니다.</b></p>
</c:if>

<h1>[테스트 홈]</h1>
<ul>
<c:if test="${sessionScope.loginId == null}">
	<li><a href="join">join</a></li>
	<li><input type="button" id="loginbt" value="login"></li>
</c:if>
<c:if test="${sessionScope.loginId != null}">
	<li><a href="logout">logout</a></li>
	<li><a href="update">update</a></li>
	<li><input type="button" id="leave" value="탈퇴"></li>
</c:if>
	<li><a href="board">board</a></li>
</ul>






</body>
</html>
