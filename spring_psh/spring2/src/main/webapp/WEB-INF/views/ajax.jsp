<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="//code.jquery.com/jquery-3.7.1.js"></script>
</head>
<body>

<button class="btn" type="button"> json - json </button>
<br>
<button class="btn2" type="button">object - json </button>
<br>
<div>
	<label for="name">이름</label>
	<input type="text" class="name">
</div>
<div>
	<label for="age">나이</label>
	<input type="number" class="age">
</div>
<button class="btn3" type="button">예제테스트</button>
<script type="text/javascript">
$('.btn').click(function(){
	let obj = {
		id: "abc",
		pw : "def"
	}
	
	$.ajax({
		async : true,
		url : '<c:url value="/ajax/json/json"/>',
		type : 'post',
		data : JSON.stringify(obj),
		contentType : "application/json; charset=utf-8",
		dataType : "json",
		success : function(data){
			console.log(data.member.id);
			console.log(data.member.pw);
			console.log(data.name);
		},error : function(a,b,c){
			
		}
	})
})

$('.btn2').click(function(){
	
	let obj ={
			
	}

	$.ajax({
		async : true ,
		url : '<c:url value="/ajax/object/json"/>', 
		type : 'get', 
		data : obj,
		dataType : "json", 
		success : function (data){
			console.log(data)
		}, 
		error : function(jqXHR, textStatus, errorThrown){
	
		}
	});

})

$('.btn3').click(function(){
	let name = $('.name').val();
	let age = $('.age').val();
	
	let obj = {
			name,
			age
	}
	$.ajax({
		async : true,
		url : '<c:url value="/ajax/test"/>',
		type : 'post',
		data : obj,
		dataType : "json",
		success : function(data){
			console.log(data.result);
			alert(data.result);
		},error : function(jqXHR, textStatus, errorThrown){
	
		}
	})
})
</script>
</body>
</html>