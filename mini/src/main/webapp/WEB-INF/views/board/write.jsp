<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    
<!DOCTYPE html PUBLIC>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="resources/js/jquery-3.3.1.min.js"></script>
<title>write</title>
<script>

/* 제이쿼리 에이젝스 실패
window.onload = function(){
	$('#title').focus();
}
$(document).ready(function(){
	$('#bt').on('click', write);
});

function write(){
	var title = $('#title').val();
	var content = $('#content').val();
	
	if(title == null || title == ""){
		alert('제목을 입력하세요');
		$('#title').focus();
		$('#content').select();
		return;
	}
 	if(content == null || content == ""){
		alert('내용을 입력하세요');
		$('#title').select();
		$('#content').focus();
		return;
	}
 	
 	$.ajax({
 		url: 'write',
 		type: 'post',
 		data: $('#write').serialize(),
 		success: function(){
 			location.href="board"
 		},
 		error: function(){
 			alert('실패');
 		}
 	});
}
 */
</script>

</head>
<body>
<h1>write</h1>


<form action="write" method="post" enctype="multipart/form-data">
<table>
	<tr>
		<th>제목</th>
		<td><input type="text" name="title" id="title"></td>
	</tr>
	<tr>
		<th>내용</th>
		<td><textarea name="content" id="content" rows="4" cols="50"></textarea></td>
	</tr>
	<tr>
		<th>파일첨부</th> 
		<td>
			<input type="file" name="upload" size="30">
		</td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" value="글쓰기"></td>
	</tr>
</table>
</form>



</body>
</html>