<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="/resources/include/css/common.css" />
<link rel="stylesheet" type="text/css"
	href="/resources/include/css/contentLayout.css" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title><tiles:getAsString name="title" /></title>
<link rel="icon" href="/resources/images/common/icon.png">

<!-- Bootstrap core CSS -->
<link href="/resources/include/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Custom styles for this template -->
<link href="/resources/include/dist/css/dashboard.css" rel="stylesheet">

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
<link rel="stylesheet" type="text/css"
	href="/resources/include/css/admin.css" />
<script type="text/javascript"
	src="/resources/include/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
	function errCodeCheck() {
		var errCode = '<c:out value="${errCode}" />';
		if (errCode != "") {
			// 명확한 자료형 명시를 위해 errCode의 타입을 정수형으로 변환.
			switch (parseInt(errCode)) {
			case 1:
				alert("아이디 또는 비밀번호 일치 하지 않거나 존재하지 않는 \n회원입니다. 다시 로그인해 주세요.");
				break;
			}
		}
	}
	$(function() {
		/* 로그인 버튼 클릭 시 처리 이벤트 */
		$("#loginBtn").click(function() {
			$("#loginForm").attr({
				"method" : "POST",
				"action" : "/admin/login.do"
			});
			$("#loginForm").submit();
		});
	});
</script>
<style type="text/css">
.login-div {
	margin-left: 30%;
	margin-top: 200px;
}
</style>
</head>
<body>

	<nav class="navbar navbar-inverse navbar-fixed-top">
		<tiles:insertAttribute name="header" />
	</nav>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<tiles:insertAttribute name="left" />
			</div>


			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

				<tiles:insertAttribute name="main" />
				<ul class="projectList">
					<li>
						<div class="table-responsive">
							<label>오늘 승인요청 프로젝트</label>
							<table class="table table-bordered">
								<tr id="tableHead1">
									<td><b>분류</b></td>
									<td><b>프로젝트명</b></td>
									<td><b>창작자명</b></td>
								</tr>
								<tr>
									<td>공예</td>
									<td>모찌냥의 습격</td>
									<td>응끼</td>
								</tr>
								<tr>
									<td>출판</td>
									<td>직관적으로 펼쳐보는'컬러인쇄 가이드'</td>
									<td>컬러에이드</td>
								</tr>
								<tr>
									<td>문화</td>
									<td>연극'상어의 춤'</td>
									<td>상어가족</td>
								</tr>
								<tr>
									<td>미술</td>
									<td>1인 맞춤 봄꽃 초상화 '겨울지나 봄'</td>
									<td>지후</td>
								</tr>
							</table>
						</div>
					</li>
					<li>
						<div class="table-responsive">
							<label>마감예정 프로젝트</label>
							<table class="table table-bordered">
								<tr id="tableHead3">
									<td><b>분류</b></td>
									<td><b>프로젝트명</b></td>
									<td><b>창작자명</b></td>
									<td><b>등록일자</b></td>
								</tr>
								<tr>
									<td>공예</td>
									<td>[아동학대예방프로젝트]'꽃으로도 때리지 말라'뱃지</td>
									<td>민들레꽃</td>
									<td>2018-02-08</td>
								</tr>
								<tr>
									<td>출판</td>
									<td>세상을 바꾸는 가장 작은 잼,잼통한 사람들의'착한과채잼'</td>
									<td>위쿡x잼통한사람들</td>
									<td>2018-02-04</td>
								</tr>
								<!-- <tr>
										<td>문화</td>
										<td>테일즈위버 젤리삐 인형</td>
										<td>보네비</td>
										<td>2018-02-03</td>
									</tr>
									<tr>
										<td>미술</td>
										<td>듀랑고로 떠나는 열차에서 만난"콤피 인형"</td>
										<td>고양고양</td>
										<td>2018-02-01</td>
									</tr> -->
							</table>
						</div>
					</li>
				</ul>
				<!-- 아랫줄 -->
				<ul class="projectList">
					<li>
						<div class="table-responsive">
							<label>금일 후원현황</label>
							<table class="table table-bordered">
								<tr id="tableHead2">
									<td><b>분류</b></td>
									<td><b>프로젝트명</b></td>
									<td><b>후원자명</b></td>
									<td><b>후원일자</b></td>
								</tr>
								<tr>
									<td>공예</td>
									<td>열심히 일한 당신 떠나라!</td>
									<td>알로하</td>
									<td>2018-02-11</td>
								</tr>
								<tr>
									<td>출판</td>
									<td>세상을 바꾸는 가장 작은 잼,잼통한 사람들의'착한 과채잼'</td>
									<td>위쿡x잼통한 사람들</td>
									<td>2018-02-11</td>
								</tr>
								<tr>
									<td>문화</td>
									<td>심쿵하면서 실용적인 디자인의 토트백</td>
									<td>보네비</td>
									<td>2018-02-10</td>
								</tr>
								<tr>
									<td>미술</td>
									<td>듀랑고로 떠나는 열차에서 만난"콤피 인형"</td>
									<td>고양고양</td>
									<td>2018-02-09</td>
								</tr>
							</table>
						</div>
					</li>
					<li>
						<div class="table-responsive">
							<label>금일 회원가입 현황</label>
							<table class="table table-bordered">
								<tr id="tableHead4">
									<td><b>회원 아이디</b></td>
									<td><b>가입자명</b></td>
								</tr>
								<tr>
									<td>dmsrl268@naver.com</td>
									<td>응끼</td>
								</tr>
								<tr>
									<td>alwls111@gmail.com</td>
									<td>미지닝</td>
								</tr>
								<tr>
									<td>rndkqk12@gmail.com</td>
									<td>구아바</td>
								</tr>
								<tr>
									<td>skan9411@gmail.com</td>
									<td>수저공방</td>
								</tr>
								<tr>
									<td>elel5567@gmail.com</td>
									<td>디디스튜디오</td>
								</tr>
							</table>
						</div>
					</li>
				</ul>
			</div>


		</div>
	</div>


	<!-- Bootstrap core JavaScript
 ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="/resources/include/dist/js/bootstrap.min.js"></script>
	<script src="/resources/include/dist/assets/js/docs.min.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script
		src="/resources/include/dist/assets/js/ie10-viewport-bug-workaround.js"></script>



</body>
</html>