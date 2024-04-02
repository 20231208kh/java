<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="<c:url value="/signup"/>" method="post">
	<h1>회원가입</h1>
	<div class="form-group">
		<label for="id">아이디</label>
		<input type="text" class="form-control" id="id" name="me_id">
		<label id="id-error" class="error text-danger" for="id"></label>
		<label id="id-error2" class="error text-danger"></label>
	</div>
	<div class="form-group">
		<label for="pw">비번</label>
		<input type="password" class="form-control" id="pw" name="me_pw">
		<label id="pw-error" class="error text-danger" for="pw"></label>
	</div>
	<div class="form-group">
		<label for="pw2">비번확인</label>
		<input type="password" class="form-control" id="pw2" name="me_pw2">
		<label id="pw2-error" class="error text-danger" for="pw2"></label>
	</div>
	<div class="form-group">
		<label for="email">이메일</label>
		<input type="text" class="form-control" id="email" name="me_email">
		<label id="email-error" class="error text-danger" for="email"></label>
	</div>
	<button class="btn btn-outline-success col-12">회원가입</button>
</form>
</body>
</html>