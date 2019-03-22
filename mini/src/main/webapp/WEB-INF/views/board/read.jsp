<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>read</title>
<link rel="stylesheet" type="text/css" href="resources/css/read.css">
<script src="resources/js/jquery-3.3.1.min.js"></script>

<script>
$(document).ready(function(){
	$('#bt1').on('click', insert);
	list();
	
});

function insert(){
	var text = $('#text').val();
	if(text == '') return;
	
	$.ajax({
		url: 'insert',
		type: 'post',
		data: $('#re').serialize(),
		success: function(){
			$('#text').val("");
			$('#text').focus();
			list();
		},
		error: function(){
			alert('로그인하세요');
		}
	});
}

//리플 리스트
function list(){
	var bnum = $('#bnum').val();
	$.ajax({
		url:'list',
		type:'POST',
		data: {bnum: bnum},
		dataType:'json',
		success: output,
		error: function(){
			alert('리플 목록읽기 실패');
		}
	});
}

function output(ob){
	var str = '<table border="1">';
	$.each(ob, function(key, item){
		str += '<tr>';
		str += '<td>' + item.id + '</td>';
		str += '<td>' + item.text + '</td>';
		str += '<td>' + item.inputdate + '</td>';

		str += '</tr>';
		str += '<tr><td colspan="3"><div id="editDiv' + item.rnum + '"></div></td></tr>';
	});
	str += '</table>';
	$('#listDiv').html(str);

}
//리플 삭제

		
		
	
	
	






</script>
<style>
.r{
	width: 500px;
}

.tt{
	border: none;
}


</style>
</head>
<body>
<h1>read</h1>



<table>
<tr>
	<td>${vo.title}</td>
</tr>
<tr>
	<td>${vo.content}</td>
</tr>
<tr>
	<td>
	<c:if test="${sessionScope.loginId == vo.id}">
		<a href="updateWrite?bnum=${bnum}"><input type="button" value="수정"></a>&nbsp;
		<a href="del?bnum=${bnum}"><input type="button" value="삭제"></a>&nbsp;
	</c:if>
		<a href="write"><input type="button" value="글쓰기"></a>&nbsp;
		<a href="board"><input type="button" value="목록"></a>
	</td>
</tr>
</table>


<div id="listDiv"></div>

<table class="tt">
<tr class="tt">
<td class="tt">
<form id="re">
	<input type="hidden" name="bnum" id="bnum" value="${bnum}">
	<input type="hidden" name="id" id="id" value="${sessionScope.loginId}">
	<input class="r" type="text" name="text" id="text">
	<input type="button" id="bt1" value="등록">
</form>
</td>
</tr>		
</table>	
	





</body>
</html>