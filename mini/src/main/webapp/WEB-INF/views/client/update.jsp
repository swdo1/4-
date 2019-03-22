<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>update</title>
<script src="resources/js/jquery-3.3.1.min.js"></script>
<script>
$(document).ready(function(){
	$('#bt').on('click', update);
});

function update(){
	var pw1 = $('#password1').val();
	var pw2 = $('#password2').val();
	var name = $('#name').val();
	var email = $('#email').val();
	var idnu = $('#idnu').val();
	var ad = $('#address').val();
	
	if(name == null || name == ''){
		alert('잘못입력');
		return;
	}

	if(pw1 != pw2){
		alert('비밀번호 불일치');
		return;
	}

	$.ajax({
		url: 'update',
		type: 'post',
		data: $('#update').serialize(),
		success: function(){
			location.href="./";
		},
		error: function(){
			alert('실패');
		}
		
		
		
	});
}

</script>
</head>
<body>
<b>${vo.id}</b>
<form id="update">
	<input type="text" name="password" id="password1"><br>
	<input type="text" id="password2">
	<span id="pwCheck" style="color: red"></span>
	<br>
	<input type="text" name="email" id="email" value="${vo.email}"><br>
	<input type="text" name="name" id="name" value="${vo.name}"><br>
	<input type="text" name="phone" id="phone" value="${vo.phone}"><br>
	<input type="text" name="address" id="address" value="${vo.address}"><br>
<b>${vo.birth}</b>
	<br>
	<input type="button" id="bt" value="저장">
</form>




</body>
</html>