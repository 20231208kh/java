<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
</head>
<body>
<div class="container">
	<h1>게시글 등록</h1>
	<form action="<c:url value="/post/insert"/>" method="post" enctype="multipart/form-data">
		<div class="form-group">
			<label for="bo_title">게시판</label>
			<select name="bo_co_num" class="form-control">
				<c:forEach items="${coList}" var="community">
					<option value="${community.co_num}">${community.co_name}</option>
				</c:forEach>
			</select>
		</div>
		<div class="form-group">
			<label for="title">제목:</label>
			<input type="text" class="form-control" id="title" name="bo_title" required>
		</div>
		<div class="form-group">
			<label for="content">내용:</label>
			<textarea class="form-control" id="content" name="bo_content" required rows="10"></textarea>
		</div>
		<button type="submit" class="btn btn-outline-success col-12">게시글 등록</button>
	</form>
</div>
</body>
</html>