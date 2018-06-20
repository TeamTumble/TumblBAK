<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description"
	content="SlidesJS is a simple slideshow plugin for jQuery. Packed with a useful set of features to help novice and advanced developers alike create elegant and user-friendly slideshows.">
<meta name="author" content="Nathan Searles">

<!-- SlidesJS Required (if responsive): Sets the page width to the device width. -->
<meta name="viewport" content="width=device-width">
<!-- End SlidesJS Required -->

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<!-- CSS for slidesjs.com example -->
<link rel="stylesheet" type="text/css"
	href="/resources/include/css/common.css" />
<link rel="stylesheet" type="text/css"
	href="/resources/include/css/board2.css" />
<!-- <link rel="stylesheet" href="/resources/include/css/example.css">
<link rel="stylesheet"
	href="/resources/include/css/font-awesome.min.css"> -->
<link rel="icon" href="/resources/images/common/icon.png">

<title><tiles:getAsString name="title" /></title>


<!-- Bootstrap core CSS -->
<link href="/resources/include/dist/css/bootstrap.min.css"
	rel="stylesheet">


<!-- Custom styles for this template -->
<link href="/resources/include/dist/css/sticky-footer-navbar.css"
	rel="stylesheet">


<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]>
<script src="/resources/include/dist/assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<script
	src="/resources/include/dist/assets/js/ie-emulation-modes-warning.js"></script>


<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
 <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
 <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
 <![endif]-->
<script type="text/javascript"
	src="/resources/include/js/jquery-1.12.4.min.js"></script>

<link rel="stylesheet" type="text/css"
	href="/resources/include/css/common.css" />
<link rel="stylesheet" type="text/css"
	href="/resources/include/css/board2.css" />
<link rel="stylesheet" type="text/css"
	href="/resources/include/css/lightbox.css" />
<script type="text/javascript"
	src="/resources/include/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="/resources/include/js/common.js"></script>

<style type="text/css">
body {
	-webkit-font-smoothing: antialiased;
	font: normal 15px/1.5 "Helvetica Neue", Helvetica, Arial, sans-serif;
	color: #232525;
	padding-top: 0px;
}

#slides {
	display: none
}

#slides .slidesjs-navigation {
	margin: 3px;
}

#slides .slidesjs-previous {
	margin-right: 5px;
	float: left;
}

#slides .slidesjs-next {
	margin-right: 5px;
	float: left;
}

.slidesjs-pagination {
	margin: 0px 0 0;
	float: right;
	list-style: none;
}

.slidesjs-pagination li {
	float: left;
	margin: 0 1px;
}

.slidesjs-pagination li a {
	display: block;
	width: 13px;
	height: 0;
	padding-top: 13px;
	background-image: url(resources/img/pagination.png);
	background-position: 0 0;
	float: left;
	overflow: hidden;
}

.slidesjs-pagination li a.active, .slidesjs-pagination li a:hover.active
	{
	background-position: 0 -13px
}

.slidesjs-pagination li a:hover {
	background-position: 0 -26px
}

#slides a:link, #slides a:visited {
	color: #333
}

#slides a:hover, #slides a:active {
	color: #9e2020
}

h6 {
	color: green;
}
</style>
<script type="text/javascript">
	$(function() {
		/* 제목 클릭시 상세 페이지 이동을 위한 처리 이벤트 */
		$(".goDetail").click(function() {
			var pno = $(this).parents("div").attr("data-num");
			$("#pno").val(pno);
			console.log("글번호 : " + pno);

			//상세 페이지로 이동하기 위해 form추가 (id : detailForm)
			$("#detailForm").attr({
				"method" : "get",
				"action" : "/project/projectDetail.do"
			});
			$("#detailForm").submit();
		});
	});
</script>
</head>
<body>
	<form name="detailForm" id="detailForm">
		<input type="hidden" name="pno" id="pno"> <input
			type="hidden" name="page" value="${data.page}"> <input
			type="hidden" name="pageSize" value="${data.pageSize}">
	</form>
	<!-- Fixed navbar -->
	<nav class="navbar navbar-default navbar-fixed-top">
		<tiles:insertAttribute name="header" />
	</nav>

	<!-- Begin page content -->
	<div class="container">

		<div class="page-header">
			<!-- <div class="jumbotron"> -->
			<div id="slides">
				<img src="/resources/img/example-slide-1.jpg"
					alt="Photo by: Missy S Link: http://www.flickr.com/photos/listenmissy/5087404401/">
				<img src="/resources/img/example-slide-2.jpg"
					alt="Photo by: Daniel Parks Link: http://www.flickr.com/photos/parksdh/5227623068/">
				<img src="/resources/img/example-slide-3.jpg"
					alt="Photo by: Mike Ranweiler Link: http://www.flickr.com/photos/27874907@N04/4833059991/">
				<img src="/resources/img/example-slide-4.jpg"
					alt="Photo by: Stuart SeegerLink: http://www.flickr.com/photos/stuseeger/97577796/">
				<a href="#" class="slidesjs-previous slidesjs-navigation"><i
					class="icon-chevron-left icon-large"></i></a> <a href="#"
					class="slidesjs-next slidesjs-navigation"><i
					class="icon-chevron-right icon-large"></i></a>
			</div>
			<!-- </div> -->
			<!-- <img src="/resources/images/common/lala.png" /> -->
		</div>












		<div class="row">
			<div>
				<h4
					style="padding: 12px; color: black; font-weight: bold; font-size: 2.3rem; cursor: pointer">최신
					프로젝트</h4>
			</div>
			<div class="w3-row-padding w3-margin-top">
				<c:choose>
					<c:when test="${not empty projectList_New}">
						<c:forEach var="project" items="${projectList_New}"
							varStatus="status">

							<div class="w3-third" data-num="${project.pno}">
								<div class="w3-card goDetail tal">
									<img src="/uploadStorage/projectvo/thumbnail/${project.p_image}"
										style="width: 100%" class="">
									<div class="w3-container">
										<h6>${project.p_title}</h6>
									</div>
								</div>
							</div>

						</c:forEach>

					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="4" class="tac">등록된 게시 물이 존재하지 않습니다.</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</div>
			<br> <br> <br>
			<div>
				<h4
					style="padding: 12px; color: black; font-weight: bold; font-size: 2.3rem; cursor: pointer">인기
					프로젝트</h4>
			</div>
			<div class="w3-row-padding w3-margin-top">
				<c:choose>
					<c:when test="${not empty projectList_Hot}">
						<c:forEach var="project" items="${projectList_Hot}"
							varStatus="status">

							<div class="w3-third" data-num="${project.pno}">
								<div class="w3-card goDetail tal">
									<img src="/uploadStorage/projectvo/${project.p_image}"
										style="width: 100%">
									<div class="w3-container">
										<h6>${project.p_title}</h6>
									</div>
								</div>
							</div>

						</c:forEach>

					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="4" class="tac">등록된 게시 물이 존재하지 않습니다.</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</div>


			<!--/.col-xs-6.col-lg-4-->

			<!--/.col-xs-6.col-lg-4-->
		</div>
		<!--/row-->
	</div>
	<!--/.container-->


	<%-- <footer class="footer">
		<tiles:insertAttribute name="footer" />
	</footer> --%>


	<!-- Bootstrap core JavaScript
 ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script> -->
	<script src="/resources/include/dist/js/bootstrap.min.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script
		src="/resources/include/dist/assets/js/ie10-viewport-bug-workaround.js"></script>
	<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
	<!-- End SlidesJS Required -->

	<!-- SlidesJS Required: Link to jquery.slides.js -->
	<script src="/resources/include/js/jquery.slides.min.js"></script>
	<!-- End SlidesJS Required -->

	<!-- SlidesJS Required: Initialize SlidesJS with a jQuery doc ready -->
	<script>
		$(function() {
			$('#slides').slidesjs({
				width : 1140,
				height : 400,
				navigation : false
			});
		});
	</script>
</body>
</html>