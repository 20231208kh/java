<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"/>
<div class="container">
	<c:choose>
		<c:when test="${board != null }">
			<h1>게시글 상세</h1>
			<div class="mb-3 mt-3">
				<label class="form-label">게시판</label>
				<input type="text" class="form-control" readonly="readonly" value="${board.community.co_name}">
			</div>
			<div class="mb-3 mt-3">
				<label class="form-label">제목</label>
				<input type="text" class="form-control" readonly="readonly" value="${board.bo_title}">
			</div>
			<div class="mb-3 mt-3">
				<label class="form-label">작성자</label>
				<input type="text" class="form-control" readonly="readonly" value="${board.bo_me_id}">
			</div>
			<div class="mb-3 mt-3">
				<label for="title" class="form-label">조회수</label>
				<input type="text" class="form-control" readonly="readonly" value="${board.bo_view}">
			</div>
			<div class="mb-3 mt-3 clearfix">
				<button type="button" class="btn btn-outline-success btn-up float-start col-6" data-state="1">추천</button>
				<button type="button" class="btn btn-outline-success btn-down float-end col-6" data-state="-1">비추천</button>
			</div>
			<div class="mb-3 mt-3">
				<label for="content" class="form-label">내용</label>
				<div class="form-control" style="min-height: 400px">${board.bo_content }</div>
			</div>
			<c:if test="${fileList != null && fileList.size() != 0 }">
				<div class="mb-3 mt-3">
					<label class="form-label">첨부파일</label>
					<c:forEach items="${fileList}" var="file">
						<a href="<c:url value="/download?filename=${file.fi_name}"/>" download="${file.fi_ori_name}" class="form-control">${file.fi_ori_name}</a>
					</c:forEach>
				</div>
			</c:if>
		</c:when>
		<c:otherwise>
			<h1>없는 게시글이거나 삭제된 게시글입니다.</h1>
		</c:otherwise>
	</c:choose>
	<div class="mb-3 mt-3 comment-box">
				<h3>댓글</h3>
				<div class="comment-list">
			  		<div class="input-group mb-3">
						<div class="col-3">abc123</div>
						<div class="col-9">댓글 내용</div>
					</div>	
			  	</div>
				<div class="comment-pagination">
					<ul class="pagination justify-content-center">
			  				
			  		</ul>
				</div>
	</div>
	<a href="<c:url value="/board/list"/>" class="btn btn-outline-primary">목록으로</a>
	<c:if test="${user.me_id == board.bo_me_id }">
		<a href="<c:url value="/board/delete?num=${board.bo_num }"/>" class="btn btn-outline-danger">삭제</a>
		<a href="<c:url value="/board/update?num=${board.bo_num }"/>" class="btn btn-outline-danger">수정</a>
	</c:if>
</div>

<script src="//code.jquery.com/jquery-3.4.1.js"></script>
<script type="text/javascript">
	$(".btn-up,.btn-down").click(function(){
		
		if('${user.me_id}' == ''){
			if(confirm("로그인이 필요한 서비스입니다. 로그인 페이지로 이동하겠습니까?")){
				location.href = '<c:url value="/login"/>'
			}else{
				return;
			}
		}
		
		let state = $(this).data('state');
		let boNum = '${board.bo_num}';
		$.ajax({
			url : '<c:url value="/recommend"/>',
			method : 'get',
			async : true, //동기/비동기 선택, true : 비동기, false : 동기
			data : {
				"state" : state,
				"boNum" : boNum
			},
			success : function(data){
				initBtn(".btn-up","btn-outline-success","btn-success");
				initBtn(".btn-down","btn-outline-success","btn-success");
				switch(data){
				case "1":
					alert("추천 되었습니다.");
					initBtn(".btn-up","btn-success","btn-outline-success");
					break;
				case "0":
					alert(`\${state == 1 ? '' : '비'}추천이 취소 되었습니다.`);
					break;
				case "-1":
					alert("비추천 되었습니다.");
					initBtn(".btn-down","btn-success","btn-outline-success");
					break;
				}
			},
			error : function (a, b, c) {
				console.error("예외 발생");
			}
		});//ajax end
		
	});//click end
	
	function initBtn(selector, addClassName, removeClassName){
		$(selector).addClass(addClassName);
		$(selector).removeClass(removeClassName);
	}
	
	<c:if test="${recommend != null}">
		<c:if test="${recommend.re_state == 1}">
			initBtn(".btn-up","btn-success","btn-outline-success");
		</c:if>
		<c:if test="${recommend.re_state == -1}">
			initBtn(".btn-down","btn-success","btn-outline-success");
		</c:if>
	</c:if>
</script>
<script type="text/javascript">
	let cri = {
			page : 1,
			boNum : '${board.bo_num}'
	}
	displayCommentAndPagination(cri);
	function displayCommentAndPagination(cri){
		$.ajax({
			url : '<c:url value="/comment/list"/>',
			method : 'get',
			data : cri,
			success : function(data){
				displayComment(data.list);
				displayCommentPagination(data.pm);
			},
			error : function(xhr,status,error){
				
			}
		})
	}
	
	function displayComment(commentList){
		let str = "";
		for(comment of commentList){
			let btns = '';
			if('${user.me_id}'==comment.cm_me_id){
				btns += 
				`<div class="btn-comment-group">
					<button class="btn btn-outline-warning btn-comment-update" data-num ="\${comment.cm_num}">수정</button>
					<button class="btn btn-outline-danger btn-comment-delete" data-num ="\${comment.cm_num}">삭제</button>
				</div>
				`
			}
			str +=
				`
				<div class="input-group mb-3">
					<div class="col-2">\${comment.cm_me_id}</div>
					<div class="col-6">\${comment.cm_content}</div>
					\${btns}
				</div>
				`
		}
		$(".comment-list").html(str);
	}
	
	function displayCommentPagination(pm){
		pm = JSON.parse(pm);
		let pmStr = "";
		//이전 버튼 활성화 여부
		if(pm.prev){
			pmStr += `
			<li class="page-item">
				<a class="page-link" href="javascript:void(0);" data-page="\${pm.startPage-1}">이전</a>
			</li>
			`;
		}
		//숫자 페이지
		for(i = pm.startPage; i<= pm.endPage; i++){
			let active = pm.cri.page == i ? "active" :"";
			pmStr += `
			<li class="page-item \${active}">
				<a class="page-link" href="javascript:void(0);" data-page="\${i}">\${i}</a>
			</li>
			`
		}
		//다음 버튼 활성화 여부
		if(pm.next){
			pmStr += `
			<li class="page-item">
				<a class="page-link" href="javascript:void(0);" data-page="\${pm.endPage+1}">다음</a>
			</li>
			`;
		}
		$(".comment-pagination>ul").html(pmStr);
	}
	
	$(document).on("click",".comment-pagination .page-link", function(){
		cri.page = $(this).data("page");
		displayCommentAndPagination(cri);
	})
	
</script>
</body>
</html>