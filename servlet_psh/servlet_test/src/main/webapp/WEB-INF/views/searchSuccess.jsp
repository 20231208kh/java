<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<thead>
		<tr>
			<th>회원번호</th>
			<th>회원아이디</th>
			<th>회원이름</th>
			<th>회원나이</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>${userDTO.user_no}</td>
			<td>${userDTO.user_id}</td>
			<td>${userDTO.user_name}</td>
			<td>${userDTO.user_age}</td>
		</tr>
	</tbody>
</table>
</body>
</html>