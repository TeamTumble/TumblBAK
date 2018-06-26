<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="tag" uri="/WEB-INF/tld/custom_tag.tld"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<title>회원 정보</title>
<link rel="stylesheet" type="text/css"
	href="/resources/include/css/common.css" />
<link rel="stylesheet" type="text/css"
	href="/resources/include/css/member.css" />
	<script type="text/javascript"
	src="/resources/include/js/jquery-1.12.4.min.js"></script>

<script type="text/javascript" src="/resources/include/js/common.js"></script>
	
<script type="text/javascript">
	$(function() {
		/* 검색 후 검색 대상과 검색 단어 출력 */
		var word = "<c:out value='${data.keyword}' />";
		var value = "";
		if (word != "") {
			$("#keyword").val("<c:out value='${data.keyword}' />");
			$("#search").val("<c:out value='${data.search}' />");
			if ($("#search").val() != 'all') {
				//:contains()는 특정 텍스트를 포함한 요소반환
				if ($("#search").val() == 'email')
					value = "#list tr td.goDetail";
				else if ($("#search").val() == 'mname')
					value = "#list tr td.mname";
				$(value + ":contains('" + word + "')").each(
						function() {
							var regex = new RegExp(word, 'gi');
							$(this).html(
									$(this).text().replace(
											regex,
											"<span class='required'>" + word
													+ "</span>"));
						});
			}
		}
		//검색
		$("#btnSearch").click(function() {
			$("#searchForm").attr({
				"method" : "POST",
				"action" : "/admin/member/memberSearchList.do"
			});
			$("#searchForm").submit();
		});

		/* 한페이지에 보여줄 레코드 수 조회 후 선택한 값 그대로  유지하기 위한 설정*/
		if ("<c:out value='${data.pageSize}' />" != "") {
			$("#pageSize").val("<c:out value='${data.pageSize}' />");
		}
		/* 검색 대상이 변경될 때마다 처리 이벤트 */
		$("#search").change(function() {
			if ($("#search").val() == "all") {
				$("#keyword").val("전체 데이터 조회합니다.");
			} else if ($("#search").val() != "all") {
				$("#keyword").val("");
				$("#keyword").focus();
			}
		});

		/* 한 페이지에 보여줄 레코드 수 변경될 때마다 처리 이벤트 */
		$("#pageSize").change(function() {
			goPage(1);
		});
		/* 검색 버튼 클릭 시 처리 이벤트 */
		$("#searchData").click(function() {
			if ($("#search").val() != "all") {
				if (!chkSubmit($('#keyword'), "검색어를"))
					return;
			}
			goPage(1);
		});
		$(".order").click(function() {
			var order_by = $(this).attr("data-value");
			console.log("선택값 : " + order_by);
			$("#order_by").val(order_by);
			if ($("#order_sc").val() == 'DESC') {
				$("#order_sc").val('ASC');
			} else {
				$("#order_sc").val('DESC');
			}
			goPage(1);
		});

	});
	/* 검색과 한 페이지에 보여줄 레코드 수 처리 및 페이징을 위한 실질적인 처리 함수 */
	function goPage(page) {
		if ($("#search").val() == "all") {
			$("#keyword").val("");
		}
		$("#page").val(page);
		$("#f_search").attr({
			"method" : "get",
			"action" : "/admin/member/memberList.do"
		});
		$("#f_search").submit();
	}
</script>
</head>
<body>
	<div class="contentTit">
		<p style="font-size: 24px;">
			회원관리 리스트 <span style="font-size: 15px;">총 회원 수:</span>
		</p>
	</div>
	<!-- 검색창 -->
	<!-- <div>
		<form class="navbar-form navbar-left" id="searchForm">
			<label>검색조건</label> <select id="search" name="search">
				<option value="all">전체</option>
				<option value="email">아이디</option>
				<option value="m_name">이름</option>
				<option value="m_phone">전화번호</option>
				<option value="m_joindate">가입일</option>
			</select> <input type="text" name="keyword" id="keyword" value="검색어를입력하세요" />
			<button id="btnSearch">검색</button>
		</form>
	</div> -->
	<div id="boardSearch">
		<form id="f_search" name="f_search">
			<input type="hidden" id="page" name="page" value="${data.page}">
			<%-- <input type="hidden" id="order_by" name="order_by"
					value="${data.order_by}" /> <input type="hidden" id="order_sc"
					name="order_sc" value="${data.order_sc}" /> --%>
			<table summary="검색">
				<colgroup>
					<col width="70%"></col>
					<col width="30%"></col>
				</colgroup>
				<tr>
					<td id="btd1"><label>검색조건</label> <select id="search"
						name="search">
							<option value="all">전체</option>
							<option value="email">이메일</option>
							<option value="mname">작성자</option>
					</select> <input type="text" name="keyword" id="keyword" value="검색어를입력하세요" />
						<input type="button" value="검색" id="searchData" /></td>
					<td id="btd2">한페이지에 <select id="pageSize" name="pageSize">
							<option value="1">1줄</option>
							<option value="2">2줄</option>
							<option value="3">3줄</option>
							<option value="5">5줄</option>
							<option value="7">7줄</option>
							<option value="10">10줄</option>
							<option value="30">30줄</option>
					</select>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<!-- 테이블 -->
	<table class="table table-boarderd">
		<%--table-striped--%>


		<thead>
			<tr>
				<th class="tac">회원번호</th>
				<th class="tac">회원아이디</th>
				<th class="tac">회원명</th>
				<th class="tac">회원핸드폰</th>
				<th class="tac">등록일</th>
			</tr>
		</thead>

		<tbody>
			<c:choose>
				<c:when test="${not empty memberList}">
					<c:forEach var="member" items="${memberList}" varStatus="status">
						<tr class="tac" data-idx="${member.idx}">
							<td>${status.count}</td>
							<td><span class="goDetail">${member.email}</span></td>
							<td class="mname">${member.mname}</td>
							<td>${member.m_phone}</td>
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

	<!-- 	============ 페이지 네비게이션 시작 ============
 -->
	<div id="boardPage">
		<tag:paging page="${param.page}" total="${total}"
			list_size="${data.pageSize}" />
	</div>

	<!-- =========== 페이지 네비게이션 종료 ============= -->


</body>
</html>