<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="tag" uri="/WEB-INF/tld/custom_tag.tld"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table.type08 {
	border-collapse: collapse;
	text-align: left;
	line-height: 1.5;
	border-left: 1px solid #ccc;
	margin: 20px 10px;
}

table.type08 thead th {
	padding: 10px;
	font-weight: bold;
	border-top: 1px solid #ccc;
	border-right: 1px solid #ccc;
	border-bottom: 2px solid #c00;
	background: #dcdcd1;
}

table.type08 tbody th {
	width: 150px;
	padding: 10px;
	font-weight: bold;
	vertical-align: top;
	border-right: 1px solid #ccc;
	border-bottom: 1px solid #ccc;
	background: #ececec;
}

table.type08 td {
	width: 350px;
	padding: 10px;
	vertical-align: top;
	border-right: 1px solid #ccc;
	border-bottom: 1px solid #ccc;
}
</style>
</head>
<body>
	<div class="contentContainer">
		<div class="contentTit">
			<h3>내 후원목록</h3>
		</div>
		<%-- ======== 상세 페이지 이동을 위한 FORM ============ --%>
		<form name="detailForm" id="detailForm">
			<input type="hidden" name="pno" id="pno">
		</form>



		<%-- ================= 리스트 시작 =============== --%>
		<%-- <div id="boardList">
			<table summary="게시판 리스트">
				<colgroup>
					<col width="10%" />
					<col width="62%" />
					<col width="15%" />
					<col width="13%" />
				</colgroup>
				<thead>
					<tr>
						<th>아이디</th>
						<th>프로젝트제목</th>
						<th>후원금액</th>
						<th>후원날짜</th>
					</tr>
				</thead>
				<tbody id="kkk">
					<!-- 데이터 출력 -->

					<c:choose>
						<c:when test="${not empty projectList}">
							<c:forEach var="project" items="${projectList}"
								varStatus="status">
								<tr class="tac" id="tac" data-num="${project.p_no}">
									<td>${project.email}</td>
									<td id="ttt" align="center">${project.s_giftname}</td>
									<td id="ccc" align="right">모음금액 :${project.s_giftprice}원</td>
									<td>${project.s_date}</td>
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
			</table> --%>
			<table class="type08">
				<thead>
					<tr>
						<th scope="cols">아이디</th>
						<th scope="cols">프로젝트제목</th>
						<th scope="cols">후원금액</th>
						<th scope="cols">후원날짜</th>
					</tr>
				</thead>
				<tbody id="kkk">
					<!-- 데이터 출력 -->

					<c:choose>
						<c:when test="${not empty projectList}">
							<c:forEach var="project" items="${projectList}"
								varStatus="status">
								<tr class="tac" id="tac" data-num="${project.pno}">
									<td>${project.email}</td>
									<td id="ttt" align="center">${project.s_giftname}</td>
									<td id="ccc" align="right">모음금액 :${project.s_giftprice}원</td>
									<td>${project.s_date}</td>
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
		<!-- </div> -->
		<%-- ================= 리스트 종료 ================ --%>


	</div>
</body>
</html>