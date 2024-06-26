<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- mygroup.css -->
<link rel="stylesheet" href="<c:url value="/resources/css/mygroup.css"/>">

</head>
<body>
<div class="container">
	<c:choose>
		<c:when test="${group == null }">
			<div class="not-authorized text-align-center">
				<div>접근 권한이 없는 페이지 입니다.</div>
				<a href="<c:url value="/"/>">홈으로 가기</a>
			</div>
		</c:when>
		
		<c:otherwise>
			<div class="container-info-bar">
				<div class="float-left group-title">${group.go_name}</div>
				<div class="float-left">지원자 관리페이지</div>
			</div>
			<div class="applicant-query">
				<input type="radio" id="all" name="type" value="all" checked>
				<label for="all">전체</label>
				<input type="radio" id="not-passed" value="not-passed" name="type">
				<label for="not-passed">미처리 신청만</label>
				<input type="radio" id="canceled" value="canceled" name="type">
				<label for="canceled">거절된 신청만</label>
			</div>
			<div class="applicant-list-bg">
				
			</div>
			
			<!-- 페이지네이션 -->
			<div class="box-pagination">
				<ul class="pagination justify-content-center">
					<!-- 페이지네이션 출력됨 -->
				</ul>
			</div>
		</c:otherwise>
	</c:choose>
</div>

<!-- 그룹 지원자 불러오기 -->
<script type="text/javascript">
let cri = {
	page : 1,
	search : ${group.go_num},
	type : 0
}

getApplyList(cri)

function getApplyList(cri){
	$.ajax({
		async : true, //비동기 : true(비동기), false(동기)
		url : "<c:url value="/group/manage/applicant/list"/>", 
		type : 'post', 
		data : JSON.stringify(cri), 
		//서버로 보낼 데이터 타입
		contentType : "application/json; charset=utf-8",
		//서버에서 보낸 데이터의 타입
		dataType :"json", 
		success : function (data){
				displayApplicantList(data.list) // 지원자 리스트 표시
				displayGroupPagination(data.pm) // 페이지네이션 표시
			}, 
			error : function(a, b, c){
				
		}
	});
	
}

function displayApplicantList(list){
	let str = '';

	if(list.length == 0){
		$(".applicant-list-bg").html(`<div style="text-align: center">조회 내역이 없습니다.</div>`)
		return;
	}
	
	for(apply of list){
		
		str +=
			`
			<tr>
				<td class="nickname">
					<c:url var = 'url1' value = '/mypage/profile'/>
					<a href="${url1}?me_id=\${apply.goap_me_id}">\${apply.nickname}</a>
				</td>
				<td><div class="id">\${apply.goap_me_id}<div></td>
				<td class="text-center content">
					<c:url var = 'url2' value = '/group/apply/detail'/>
					<a href="${url2}?num=\${apply.goap_num}">\${apply.goap_content}</a>
				</td class="content">
			`;
			
			if(apply.goap_state == -1){
				str+=`
						<td class="apply-manage-btn-group">
							거절됨
						<td>
					</tr>
				`
				
			}else if(apply.goap_state == 1){
				str+=`
					<td class="apply-manage-btn-group">
						승낙됨
					<td>
				</tr>
			`
			}else{
				str+=`
					<td class="apply-manage-btn-group">
						<a class="apply-confirm-btn" data-num="\${apply.goap_num}">수락</a>
						<a class="apply-deny-btn" data-num="\${apply.goap_num}">거절</a>
					<td>
				</tr>
			`
			}
		}
	
		let table = `
			<table>
				<thead class="applicant-list-th">
					<tr>
						<th class="nickname">닉네임</th>
						<th class="id">아이디</th>
						<th class="content">지원 내용</th>
						<th></th>
					</tr>
				</thead>
				<tbody class="applicant-list">
					\${str}
				</tbody>
			</table>
		`;
		
		$(".applicant-list-bg").html(table);
}

//페이지네이션
function displayGroupPagination(pm){
	let str = '';
	
	if(pm.prev){
		str +=
			`<li class="page-item">
				<a class="page-link" href="javascript:void(0)" data-page="\${pm.startPage - 1}" data-type="\${pm.cri.type}">이전</a>
		    </li>`;
	}
	
	for(let i = pm.startPage; i<=pm.endPage; i++){
		let active = pm.cri.page == i ? 'active':'';
		str +=
			`
			 <li class="page-item \${active}">
			 	<a class="page-link" href="javascript:void(0)" data-page="\${i}" data-type="\${pm.cri.type}">\${i}</a>
		    </li>				
			`;
	}
	
	if(pm.next){
		str +=
			`
			<li class="page-item">
				<a class="page-link" href="javascript:void(0)" data-page="\${pm.endPage + 1}" data-type="\${pm.cri.type}">다음</a>
		    </li>				
			`;
	}
	$('.box-pagination>ul').html(str);
}


// 클릭이벤트
$(document).on('click', '.box-pagination .page-link', function(){
	cri.page = $(this).data('page');
	getApplyList(cri);
})


<!-- 지원자 리스트 hover 설정 -->
$(document).on("mouseover",".applicant-list tr", function(){
	$(this).css("background-color", "#C9C9C9")
	$(this).children('.apply-manage-btn-group').css("visibility", "visible")
})

$(document).on("mouseout",".applicant-list tr", function(){
	$(this).css("background-color", "transparent")
	$(this).children('.apply-manage-btn-group').css("visibility", "hidden")
})
</script>

<!-- 지원자 리스트 query 설정 변경 -->
<script type="text/javascript">
$("[name=type]").click(function(){
	cri.type = $(this).attr('value');
	getApplyList(cri);
})
</script>

<!-- 지원 수락 -->
<script type="text/javascript">
	$(document).on('click', '.apply-confirm-btn', function(){
		if(!${group.go_update}){
			alert('그룹이 얼려진 상태입니다. 리더가 그룹 얼리기를 해제한 후 이용할 수 있습니다.')
			return;
		}
		
		let num = $(this).data('num')
		$.ajax({
			async : true, //비동기 : true(비동기), false(동기)
			url : "<c:url value="/group/manage/applicant/insert"/>", 
			type : 'post', 
			data : {
				num : ${group.go_num},
				apNum : num
			}, 
			dataType :"json", 
			success : function (data){
					if(data.data == 'ok'){
						alert('지원자를 그룹에 추가했습니다.')
						getApplyList(cri);
					}else{
						alert('지원자를 그룹에 추가하지 못했습니다. 새로고침 후 다시 이용해주세요.')
					}
				}, 
				error : function(a, b, c){
					
			}
		});
	})
</script>

<!-- 지원 거절 -->
<script type="text/javascript">
	$(document).on('click', '.apply-deny-btn', function(){
		if(!${group.go_update}){
			alert('그룹이 얼려진 상태입니다. 리더가 그룹 얼리기를 해제한 후 이용할 수 있습니다.')
			return;
		}
		
		let num = $(this).data('num')
		$.ajax({
			async : true, //비동기 : true(비동기), false(동기)
			url : "<c:url value="/group/manage/applicant/cancel"/>", 
			type : 'post', 
			data : {
				num : ${group.go_num},
				apNum : num
			}, 
			dataType :"json", 
			success : function (data){
					if(data.data == 'ok'){
						alert('지원을 거절했습니다.')
						getApplyList(cri);
					}else{
						alert('지원을 거절하지 못했습니다. 새로고침 후 다시 이용해주세요.')
					}
				}, 
				error : function(a, b, c){
					
			}
		});
	})
</script>
</body>
</html>