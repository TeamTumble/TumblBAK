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
<!-- <script type="text/javascript">
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
</script> -->
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<script>
	// 차트를 사용하기 위한 준비입니다.
	google.charts.load('current', {
		packages : [ 'corechart' ]
	});
	google.charts.setOnLoadCallback(drawChart);

	function drawChart() {

		// 차트 데이터 설정
		var data = google.visualization.arrayToDataTable([ [ '항목', '후원금액' ], // 항목 정의
		[ '개', 4 ], // 항목, 값 (값은 숫자로 입력하면 그래프로 생성됨)
		[ '메뚜기', 6 ], [ '문어', 8 ], [ '오징어', 10 ], [ '운영자', 2 ] ]);

		// 그래프 옵션
		var options = {
			title : '총 후원 금액', // 제목
			width : 600, // 가로 px
			height : 400, // 세로 px
			bar : {
				groupWidth : '80%' // 그래프 너비 설정 %
			},
			legend : {
				position : 'none' // 항목 표시 여부 (현재 설정은 안함)
			}
		};

		var chart = new google.visualization.ColumnChart(document
				.getElementById('chart_div'));
		chart.draw(data, options);
	}
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
				<!-- <div id="chart_div"></div> -->
				<ul class="projectList">
					<li>
						<div class="table-responsive">
							<label>최근 승인된 프로젝트</label>
							<table summary="게시판 리스트" class="table table-bordered">
								<colgroup>
									<col width="10%" />
									<col width="62%" />
									<col width="15%" />
									<col width="13%" />
								</colgroup>
								<thead>
									<tr id="tableHead3">
										<th data-value="pno" class="order" style="text-align: center;">분류</th>
										<th style="text-align: center;">프로젝트 명</th>
										<th style="text-align: center;">창작자명</th>
										<th class="borcle" style="text-align: center;">프로젝트 상태</th>
									</tr>
								</thead>
								<tbody id="list">
									<!-- 데이터 출력 -->
									<c:choose>
										<c:when test="${not empty projectList}">
											<c:forEach var="project" items="${projectList}"
												varStatus="status">
												<tr class="tac" data-num="${project.pno}">
													<td>${project.p_type}</td>
													<td class="goDetail">${project.ptitle}</td>
													<td class="name">${project.pmname}</td>
													<td>${project.pcase}</td>
												</tr>
											</c:forEach>
										</c:when>
										<c:otherwise>
											<tr>
												<td colspan="4" class="tac">등록된 게시 물이 존재하지 않습니다.</td>
											</tr>
										</c:otherwise>
									</c:choose>
								</tbody>
							</table>
						</div>
					</li>
					<li>
						<div class="table-responsive">
							<label>승인대기중인 프로젝트</label>
							<table summary="게시판 리스트" class="table table-bordered">
								<colgroup>
									<col width="10%" />
									<col width="62%" />
									<col width="15%" />
									<col width="13%" />
								</colgroup>
								<thead>
									<tr id="tableHead3">
										<th data-value="pno" class="order" style="text-align: center;">분류</th>
										<th style="text-align: center;">프로젝트 명</th>
										<th style="text-align: center;">창작자명</th>
										<th class="borcle" style="text-align: center;">프로젝트 상태</th>
									</tr>
								</thead>
								<tbody id="list">
									<!-- 데이터 출력 -->
									<c:choose>
										<c:when test="${not empty projectList}">
											<c:forEach var="project" items="${projectList_wait}"
												varStatus="status">
												<tr class="tac" data-num="${project.pno}">
													<td>${project.p_type}</td>
													<td class="goDetail">${project.ptitle}</td>
													<td class="name">${project.pmname}</td>
													<td>${project.pcase}</td>
												</tr>
											</c:forEach>
										</c:when>
										<c:otherwise>
											<tr>
												<td colspan="4" class="tac">등록된 게시 물이 존재하지 않습니다.</td>
											</tr>
										</c:otherwise>
									</c:choose>
								</tbody>
							</table>
						</div>
					</li>
				</ul>
				<!-- 아랫줄 -->
				<ul class="projectList">
					<li>
						<div class="table-responsive">
							<label>최근 후원현황</label>
							<table summary="게시판 리스트" class="table table-bordered">
								<colgroup align="center">
									<col width="6%" />
									<col width="10%" />
									<col width="54%" />
									<col width="17%" />
									<col width="13%" />
								</colgroup>
								<thead>
									<tr id="tableHead3">
										<th data-value="sno" class="order" style="text-align: center;">번호</th>
										<th data-value="sno" class="order" align="center"
											style="text-align: center;">후원자</th>
										<th align="center" style="text-align: center;">후원 프로젝트
											리워드 명</th>
										<th data-value="s_date" class="order" align="center"
											style="text-align: center;">후원금액</th>
										<th class="borcle" style="text-align: center;">후원날짜</th>
									</tr>
								</thead>
								<tbody id="list">
									<!-- 데이터 출력 -->
									<c:choose>
										<c:when test="${not empty supportList}">
											<c:forEach var="support" items="${supportList}"
												varStatus="status">
												<tr class="tac" data-num="${support.sno}">
													<td>${support.sno}</td>
													<td class="sname">${support.sname}</td>
													<td class="goDetail">${support.s_giftname}</td>
													<td>${support.s_giftprice}원</td>
													<td>${support.s_date}</td>
												</tr>
											</c:forEach>
										</c:when>
										<c:otherwise>
											<tr>
												<td colspan="4" class="tac">등록된 후원 내역이 존재하지 않습니다.</td>
											</tr>
										</c:otherwise>
									</c:choose>
								</tbody>
							</table>
						</div>
					</li>
					<li>
						<div class="table-responsive">
							<label>회원가입 현황</label>
							<table class="table table-bordered">
								<%--table-striped--%>


								<thead>
									<tr id="tableHead3">
										<th class="tac">회원번호</th>
										<th class="tac">회원아이디</th>
										<th class="tac">회원명</th>
										<th class="tac">등록일</th>
									</tr>
								</thead>

								<tbody>
									<c:choose>
										<c:when test="${not empty memberList}">
											<c:forEach var="member" items="${memberList}"
												varStatus="status">
												<tr class="tac" data-idx="${member.idx}">
													<td>${member.idx}</td>
													<td><span class="goDetail">${member.email}</span></td>
													<td class="mname">${member.mname}</td>
													<td>${member.m_joindate}</td>
												</tr>
											</c:forEach>
										</c:when>

										<c:otherwise>
											<tr>
												<td colspan="6" align="center">현재 회원이 존재하지 않습니다.</td>
											</tr>
										</c:otherwise>
									</c:choose>
								</tbody>
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