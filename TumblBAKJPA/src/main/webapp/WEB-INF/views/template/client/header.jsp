<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<style type="text/css">
@media screen and (min-width:768px) {
	.navbar-brand-centered {
		position: absolute;
		left: 50%;
		display: block;
		width: 160px;
		text-align: center;
		background-color: #eee;
	}
	.navbar>.container .navbar-brand-centered, .navbar>.container-fluid .navbar-brand-centered
		{
		margin-left: -80px;
	}
}
</style>
<title>Insert title here</title>
</head>
<body>

	<div class="container">

		<div class="navbar-header" >
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
		</div>
		<a class="navbar-brand navbar-brand-centered" href="/">TUMBLBAK</a>
		<div id="navbar" class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-expanded="false">프로젝트
						둘러보기 <span class="caret"></span>
				</a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="/project/projectList.do">모든 프로젝트</a></li>
						<li><a href="/project/projectListNew.do">최신 프로젝트</a></li>
						<li><a href="/project/projectListHot.do">인기 프로젝트</a></li>
						
						<!-- <li><a href="#">인기 프로젝트</a></li>
						<li><a href="#">최신 프로젝트</a></li> -->

						
					</ul></li>
				<li><a href="/project/liner.do">프로젝트 올리기</a></li>
				<c:if test="${sessionScope.login == null }">
					<li><a href="/member/join.do">회원가입</a></li>
				</c:if>



			</ul>
			<ul class="nav navbar-nav navbar-right">
				<c:if test="${sessionScope.login == null }">
					<li><a href="/member/login.do">로그인</a></li>
				</c:if>
				<c:if test="${sessionScope.login != null }">
					<%-- <li><a href="/member/mypage.do">${login.email}님의 마이페이지</a></li> --%>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-expanded="false">${login.email}님
							<span class="caret"></span>
					</a>
						<ul class="dropdown-menu" role="menu">
							
							<li><a href="/member/modify.do">회원정보 수정</a></li>
							<li><a href="/member/supportMember.do">내후원현황</a></li>
							<li><a href="/member/projectMember.do">내 프로젝트</a></li>
							<li><a href="/member/logout.do">로그아웃</a></li>
							<li><a href="/board/boardList.do" >1:1 문의</a></li>
							<li><a href="/member/noticeList.do">공지사항</a></li>
							<li class="divider"></li>
							
						</ul></li>
				</c:if>
			</ul>
		</div>

		<!--/.nav-collapse -->

	</div>


</body>
</html>