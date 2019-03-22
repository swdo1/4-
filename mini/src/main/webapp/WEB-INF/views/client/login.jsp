<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
<script src="resources/js/jquery-3.3.1.min.js"></script>
<script>
window.onload = function(){
	$('#id').focus();
}
$(document).ready(function(){
	$('#bt').on('click', login);
	
	
});

function login(){
	var id = $('#id').val();
	var password = $('#password').val();
	
	$.ajax({
		url: 'login',
		type: 'post',
		data: {id: id, password: password},
		dataType: 'text',		
		success: function(result){
			if(result == "1"){						
				//alert('로그인 성공');	
				window.close();
				opener.location.reload();	//새로고침
			}
			else{
				$('#fail').text('로그인 실패');
				$('#password').val('');
				$('#id').select();
				$('#password').focus();
			}			
		},
		error: function(){
			alert('실패');
		}
	});
}


</script>

<style>

.l{
	margin: auto;
	text-align: center;
	
	width: 80%;
	border-collapse: collapse;
}

}
h1{
	text-align: center;
}

.a,.b{
	width: 200px;
}
</style>

</head>
<body>
<h1 class="l">[ LOGIN ]</h1>
<div class="l">
<input class="a" type="text" name="id" id="id" placeholder="userid" ><br>
<input class="a" type="password" name="password" id="password" placeholder="password">
<br>
<input class="b" type="button" id="bt" value="login">

<div id="fail" style="color: blue"></div>

</div>


</body>
</html>