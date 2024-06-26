<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<header>
	<nav class="navbar navbar-expand-sm navbar-light">
		<div class="container-fluid">
			<h1>
				<a class="navbar-brand" href="<c:url value="/"/>">
					<img alt="LOGO" src="<c:url value="/resources/img/StudyMOim.png"/>" class="first-logo">
					<!-- <img alt="LOGO" src="<c:url value="/resources/img/SMOLogo.png"/>" class="second-logo">   -->
				</a>
			</h1>
			<div class="naver-lsft-box">
				<ul class="navbar-left">
					<li class="nav-item">
						<a class="nav-link" href="<c:url value="/group/list" />">스터디/프로젝트</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="<c:url value="/mentor/list" />">멘토링</a>
					</li>
					<li class="nav-item">
						<div class="dropdown-lecture">
							<a class="nav-link dropbtn-lecture" href="<c:url value="/lecture/list" />">강의</a>
							<div class="dropdown-content-lecture">
								<c:forEach items="${menuCateList}" var="cate">
								<div class="dropdown-submenu-lecture">
									<c:url value="/lecture/list" var="lectUrl">
										<c:param name="progCt_num" value="${cate.progCt_num}"/>
										<c:param name="searchType" value="cate"/>
									</c:url>
									<a class="subbtn-lecture" href="${lectUrl}">${cate.progCt_name}</a>
									<div class="submenu-content-lecture">
										<c:forEach items="${menuLangList}" var="lang">
										<c:if test="${cate.progCt_num == lang.progCt_num }">
											<c:url value="/lecture/list" var="lectUrl">
												<c:param name="lang_num" value="${lang.lang_num}"/>
												<c:param name="progCt_num" value="${lang.progCt_num}"/>
												<c:param name="searchType" value="lang"/>
											</c:url>
											<a href="${lectUrl}">${lang.lang_name}</a>
										</c:if>
										</c:forEach>
									</div>
								</div>
								</c:forEach>
							</div>
						</div>
					</li>
				
				</ul>
			</div>
			
			<ul class="navbar-right">
				<c:if test="${user == null}">
					<li class="nav-item"><a class="nav-link"
						href="<c:url value="/login" />">로그인</a></li>
					<li class="nav-item"><a class="nav-link"
						href="<c:url value="/signup" />">회원가입</a></li>
				</c:if>
				<c:if test="${user != null}">
					<li class="nav-item">
						<div class="dropdown">
							<a class="nav-link dropbtn">마이페이지</a>
							<div class="dropdown-content">
								<a href="<c:url value="/mypage/profile?me_id=${user.me_id}"/>">내 정보</a>
								<a href="<c:url value="/mypage/mygroup?me_id=${user.me_id}"/>">그룹/프로젝트</a>
								<a href="<c:url value="/mygroup/list"/>">나의 그룹</a>
								<a href="<c:url value="/lecture/myList"/>">내가 구매한 강의</a>
								<c:if test="${user.me_ma_auth.equals('관리자') == true}">
									<a href="<c:url value="/admin/managemember"/>">멤버 관리</a>
									<a href="<c:url value="/admin/managementor"/>">멘토 관리</a>
									<a href="<c:url value="/admin/report"/>">신고 관리</a>
								</c:if>
							</div>
						</div>
					</li>
					<li class="nav-item">
						<a class="nav-link"href="<c:url value="/logout" />">로그아웃</a>
					</li>
				</c:if>
			</ul>
		</div>
	</nav>
</header>


