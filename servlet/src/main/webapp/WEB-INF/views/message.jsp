<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript">
		let msg = '${msg}';
		if(msg !=''){
			alert(msg);
		}
		let redirectURL = '${url}';
		if(url !=''){
			location.href = '<c:url value ="\${url}"/>'
		}
	</script>
</body>
</html>