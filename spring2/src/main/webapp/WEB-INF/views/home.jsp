<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	${hi}  
</h1>

<form action="<c:url value="/login"/>" method="post">
	<div>
		<label for="id">아이디</label>
		<input type="text" name ="id">
	</div>
	<div>
		<label for="pw">비번</label>
		<input type="password" name ="pw">
	</div>
	<button type="submit">버튼</button>
</form>
<br>
<a href="<c:url value="/name?name=홍길동"/>">전송하기</a>

<br>
<a href="<c:url value="/send/object"/>">객체 여러개를 서버에 전송하기</a>

<br>

<a href="<c:url value="/send/path/123"/>">경로에 데이터를 추가해서 전송하기</a>

<br>

<a href="<c:url value="/ajax"/>">ajax 예제</a>

</body>
</html>
