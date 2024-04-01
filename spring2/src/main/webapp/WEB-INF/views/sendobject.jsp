<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<c:url value="/send/object"/>" method="post">
	<div>
		<label for="id">아이디</label>
		<input type="text" name ="list[0].id">
	</div>
	<div>
		<label for="pw">비번</label>
		<input type="password" name ="list[0].pw">
	</div>
	<div>
		<label for="id">아이디</label>
		<input type="text" name ="list[1].id">
	</div>
	<div>
		<label for="pw">비번</label>
		<input type="password" name ="list[1].pw">
	</div>
	<div>
		<label for="id">아이디</label>
		<input type="text" name ="list[2].id">
	</div>
	<div>
		<label for="pw">비번</label>
		<input type="password" name ="list[2].pw">
	</div>
	<button>버튼</button>
	</form>


</body>
</html>