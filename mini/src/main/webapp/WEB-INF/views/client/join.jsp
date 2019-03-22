<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>join</title>
<link rel="stylesheet" type="text/css" href="resources/css/join.css">
<script src="resources/js/jquery-3.3.1.min.js"></script>
<style>

body , h1{
	margin: auto;
	width: 500px;
}
table, th, td {
  border: 1px solid #bcbcbc;
}
table {
	width: 50%;
	height: 200px;
	margin: auto;
	padding-left: 100px;
	padding-right: 100px;
}
</style>
<script>
window.onload = function(){
	$('#id').focus();
}
$(document).ready(function(){
	$('#bt').on('click', join);
	$('#password2').on('keyup', pwCheck);
	$('#id').on('keyup', idCheck);
//	$('#id').keyup(idCheck);
	
	
});

function join(){
	var id = $('#id').val();
	var pw1 = $('#password1').val();
	var pw2 = $('#password2').val();
	var name = $('#name').val();
	var email = $('#email').val();
	var idnu = $('#idnu').val();
	var ad = $('#address').val();

	if(id == null || id == ''){
		alert('잘못입력');
		return;
	}
	if(pw1 == null || pw1 == ''){
		alert('잘못입력');
		return;
	}
	if(name == null || name == ''){
		alert('잘못입력');
		return;
	}
	if(pw1 != pw2){
		alert('비밀번호 불일치');
		return;
	}

	$.ajax({
		url:'join',
		type:'post',
		data:$('#join').serialize(),
		success: function(){
			alert('저장');
			location.href="./"
		},
		error: function(){
			alert('실패');
		}
	});		
}

function pwCheck() {
	var password1 = $("#password1").val();
	var password2 = $("#password2").val();


	if(password1 == password2) {		
	   $('#pwCheck').css('color', 'blue');        
	   $('#pwCheck').text('일치');        
	}
	else {
		$('#pwCheck').css('color', 'red'); 
	    $('#pwCheck').text('불일치');  
	}
    
}

function idCheck(){
	var id = $('#id').val();
	
	$.ajax({
		url: 'idCheck',
		type: 'post',
		data: {id: id},
		dataType: 'text',
		success: function(result){
			//alert(result);
			var str = '<span ';
			if(result == 'false'){
				str += 'style="color: blue"> 사용가능합니다</span>'
				$('#idCheck').html(str);
			}else {
				str += 'style="color: red"> 존재하는 아이디입니다</span>'
				$('#idCheck').html(str);
			}
	
		},
		error: function(e){
			alert(JSON.stringify(e));
		}
	});
}

</script>


</head>
<body>

<h1>[ JOIN ]</h1>

<form id="join">
	<input type="text" name="id" id="id" placeholder="id">
	<span id="idCheck" style="color:red"></span>
	<br>
	<input type="text" name="password" id="password1" placeholder="password"><br>
	<input type="password" id="password2" placeholder="password check">
	<span id="pwCheck"></span>
	<br>
	<input type="text" name="email" id="email" placeholder="email"><br>
	<input type="text" name="name" id="name" placeholder="name"><br>
	<input type="text" name="phone" id="phone" placeholder="phone"><br>
	<input type="text" name="address" id="address" placeholder="address"><br>
	<input type="radio" name="gender" id="gender1" value="male" checked>고객
	<input type="radio" name="gender" id="gender2" value="female">관리자
	<input type="text" name="birth" id="birth" placeholder="birth">
	<br>
	<input type="button" id="bt" value="저장">
</form>

</body>
</html>