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


</script>

</head>
<body>
<h1>write</h1>


<form action="updateWrite" method="post" enctype="multipart/form-data">
<input type="hidden" name="bnum" value="${vo.bnum}">
<table>
	<tr>
		<th>제목</th>
		<td><input type="text" name="title" id="title" value="${vo.title}"></td>
	</tr>
	<tr>
		<th>내용</th>
		<td><textarea name="content" id="content" rows="4" cols="50">${vo.content}</textarea></td>
	</tr>
	<tr>
		<th>파일첨부</th> 
		<td>
			<input type="file" name="upload" size="30">
				<c:if test="${vo.originalfile != null}">
				현재파일 ${vo.originalfile}
				</c:if>
				<c:if test="${vo.originalfile == null}">
				<p>파일이 존재하지 않습니다.</p>
				</c:if>
		</td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" value="수정"></td>
	</tr>
</table>
</form>



</body>
</html>