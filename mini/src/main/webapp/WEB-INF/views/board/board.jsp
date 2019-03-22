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
<link rel="stylesheet" type="text/css" href="resources/css/board.css">
<title>board</title>
<script>
// 페이지 지정과 검색을 동시에 하기
function form(page){
	var f = document.getElementById('search');	//검색 form
	var p = document.getElementById('page');	//페이지
	p.value = page;
	f.submit();
}

</script>


<style>
.bb{
	text-align: center;
	border: none;
}
table{
	border: none;
}
th{
	background-color: lightgrey;
}

h1{
	text-align: center;
}

</style>




</head>
<body>
<h1>[ BOARD ]</h1>

<table>
<tr>
	<th>글번호</th>
	<th>제목</th>
	<th>작성자</th>
	<th>조회수</th>
	<th>작성일</th>
</tr>
<c:forEach var="value" items="${list}">
<tr>
	<td>${value.bnum}</td>
	<td><a href="read?bnum=${value.bnum}">${value.title}</a></td>
	<td>${value.id}</td>
	<td>${value.hits}</td>
	<td>${value.inputdate}</td>
</tr>
</c:forEach>

<tr class="bb">
	<td colspan="5" class="bb">
		<a href="javascript:form(${navi.currentPage - navi.pagePerGroup})">◁◁</a> &nbsp;&nbsp;
		<a href="javascript:form(${navi.currentPage - 1})">◀</a> &nbsp;&nbsp;
		
		<c:forEach var="counter" begin="${navi.startPageGroup}" end="${navi.endPageGroup}">
			<c:if test="${counter == navi.currentPage}"><b></c:if>
				<a href="javascript:form(${counter})">${counter}</a>&nbsp;
			<c:if test="${counter == navi.currentPage}"></b></c:if>
		</c:forEach>
		&nbsp;&nbsp;
		<a href="javascript:form(${navi.currentPage + 1})">▶</a>&nbsp;&nbsp;
		<a href="javascript:form(${navi.currentPage + navi.pagePerGroup})">▷▷</a> &nbsp;&nbsp;
	</td>
</tr>
<tr class="bb">
	<td class="bb" colspan="5">
		<a href="write"><input class="bb" type="button" value="글쓰기"></a>
	</td>
</tr>
<tr class="bb">
	<td class="bb" colspan="5">
		<form action="board" method="get" id="search">
			<input type="hidden" name="page" id="page" value="1">
			<select name="type">
				<option value="title">제목</option>
				<option value="id">작성자</option>
			</select>
			<input type="text" name="searchText" value="${searchText}">
			<input class="bb" type="button" id="bt" value="검색" onclick="form(1)">
		</form>
	</td>
</tr>


</table>





</body>
</html>