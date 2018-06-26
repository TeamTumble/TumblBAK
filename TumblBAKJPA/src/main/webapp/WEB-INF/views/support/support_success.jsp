<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximumscale=1.0,
minimum-scale=1.0, user-scalable=no" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta http-equiv="refresh" content="10; url=/project/projectList.do">
<title>후원 신청 완료</title>
<!-- 모바일 웹 페이지 설정 -->
<link rel="shortcut icon" href="/resources/images/common/icon.png" />
<link rel="apple-touch-icon" href="/resources/images/common/icon.png" />

<!-- CSS -->
<link rel="stylesheet" type="text/css"
	href="/resources/include/css/common.css" />
<link rel="stylesheet" type="text/css"
	href="/resources/include/css/board.css" />

<!-- SCRIPT -->
<script type="text/javascript"
	src="/resources/include/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="/resources/include/js/common.js"></script>
<script type="text/javascript">
	$(function() {
		/* 메인으로 가기  버튼 클릭 시 처리 이벤트 */
		$("#mainBtn").click(function() {
			location.href = "/project/projectList.do";
		});
	});
</script>

</head>
<body>
	<div class="contentContainer">
		<div class="well">
			<div class="tac">
				<h1>축하합니다.</h1>
				<br />
				<p>${detail.email}님</p>
				<p>${detail.s_giftname}</p>
				<p style="color: red;">후원금액:${detail.s_giftprice}원</p>
				<h2>후원 축하합니다</h2>

			</div>

			<div class="button">
				<input type="button" class="" id="mainBtn" value="후원완료">
			</div>
		</div>
	</div>
</body>
</html>