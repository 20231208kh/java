<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<style>
/* 페이지네이션 */
.page-item.active .page-link{
	background-color: #8fa78f;
    border-color: #8fa78f;
	
}
.page-link {
  color: #8fa78f;
  }

</style>

<h1>강의 리스트</h1>

<form action="<c:url value="/lecture/list"/>" method="get">
	<div class="input-group mb-3">
		<input type="hidden" name="type" value="all">
		<input type="text" name="search" class="form-control" placeholder="전체검색창" value="${pm.cri.search}">
		<button class="btn btn-outline-success search-btn">검색</button>
	</div>
</form>

<table class="table table-hover">
	<thead>
		<tr>
			<th>강의 제목</th>
			<th>강의 등록멘토</th>
			<th>강의 가격</th>
			<th>강의 게시일</th>
			<th>강의 업데이트일</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list}" var="lecture">
			<tr>
				<td>
					<c:url value="/lecture/detail" var="url">
						<c:param name="page" value="${pm.cri.page}"/>
						<c:param name="type" value="${pm.cri.type}"/>
						<c:param name="search" value="${pm.cri.search}"/>
						<c:param name="lectNum" value="${lecture.lect_num}"/>
					</c:url>
					<a href="${url}">${lecture.lect_name}</a>
				</td>
				<td>
					<c:url value="/lecture/list" var="url">
						<c:param name="type" value="writer"/>
						<c:param name="search" value="${lecture.lect_mentIf_me_id}"/>
						<c:param name="searchType" value="all"/>
					</c:url>
					<a href="${url}">${lecture.lect_me_nickname}</a>
				</td>
				<td>${lecture.lect_price}</td>
				<td>${lecture.lect_posting}</td>
				<td>${lecture.lect_update}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<ul class="pagination justify-content-center">
	<c:if test="${pm.prev}">
		<c:url value="/lecture/list" var="url">
			<c:param name="page" value="${pm.startPage - 1}"/>
			<c:param name="type" value="${pm.cri.type}"/>
			<c:param name="search" value="${pm.cri.search}"/>
			<c:param name="progCt_num" value="${search.progCt_num}"/>
			<c:param name="lang_num" value="${search.lang_num}"/>
			<c:param name="searchType" value="${search.searchType}"/>
		</c:url>
		<li class="page-item">
			<a class="page-link" href="${url}">이전</a>
		</li>
	</c:if>
	<c:forEach begin="${pm.startPage }" end="${pm.endPage}" var="i">
		<c:url value="/lecture/list" var="url">
			<c:param name="page" value="${i}"/>
			<c:param name="type" value="${pm.cri.type}"/>
			<c:param name="search" value="${pm.cri.search}"/>
			<c:param name="progCt_num" value="${search.progCt_num}"/>
			<c:param name="lang_num" value="${search.lang_num}"/>
			<c:param name="searchType" value="${search.searchType}"/>
		</c:url>
		<li class="page-item <c:if test="${pm.cri.page == i}">active</c:if>">
			<a class="page-link" href="${url}">${i}</a>
		</li>
	</c:forEach>
	<c:if test="${pm.next}">
		<c:url value="/lecture/list" var="url">
			<c:param name="page" value="${pm.endPage + 1}"/>
			<c:param name="type" value="${pm.cri.type}"/>
			<c:param name="search" value="${pm.cri.search}"/>
			<c:param name="progCt_num" value="${search.progCt_num}"/>
			<c:param name="lang_num" value="${search.lang_num}"/>
			<c:param name="searchType" value="${search.searchType}"/>
		</c:url>
		<li class="page-item">
			<a class="page-link" href="${url}">다음</a>
		</li>
	</c:if>
</ul>

<c:if test="${user.me_ma_auth == '멘토'}">
	<a class="btn btn-outline-success lecture-insert-btn" href="<c:url value="/lecture/insert"/>">강의 등록하기</a>
</c:if>