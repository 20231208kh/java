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
		if(redirectURL !=''){
			location.href = '<c:url value ="/\${redirectURL}"/>';
		}else{
			location.href = '<c:url value ="/"/>';
		}
	</script>
</body>
</html>