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
	<h1>테스트</h1>
	<div>
	<h1>아이디</h1>
		<h3>${member.id}</h3>
	<h1>비번</h1>
		<h3>${member.pw}</h3>
	</div>
	<div>
	<form action="<c:url value="/hobby"/>">
		<label>
			<input type="checkbox" name="hobby" value="축구">축구
		</label>
		<label>
			<input type="checkbox" name="hobby" value="야구">야구
		</label>
		<label>
			<input type="checkbox" name="hobby" value="농구">농구
		</label>
		<label>
			<input type="checkbox" name="hobby" value="테니스">테니스
		</label>
		<label>
			<input type="checkbox" name="hobby" value="음악감상">음악감상
		</label>
		<button>버튼</button>
	</form>
	</div>
</body>
</html>