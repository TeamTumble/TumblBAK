<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로젝트 리스트 (게시판 형)</title>
<link rel="stylesheet" type="text/css"
	href="/resources/include/css/common.css" />
<link rel="stylesheet" type="text/css"
	href="/resources/include/css/board2.css" />
<!-- <link rel="stylesheet" type="text/css"
	href="/resources/include/css/lightbox.css" /> -->
<script type="text/javascript"
	src="/resources/include/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="/resources/include/js/common.js"></script>

<script type="text/javascript">
	$(function() {
		/* 글쓰기 버튼 클릭 시 처리 이벤트 */
		$("#projectCreateBtn").click(function() {
			location.href = "/project/projectCreate.do";
		});

		/* 제목 클릭시 상세 페이지 이동을 위한 처리 이벤트 */
		$(".goDetail").click(function() {
			var p_no = $(this).parents("tr").attr("data-num");
			$("#p_no").val(p_no);
			console.log("글번호 : " + p_no);
			//상세 페이지로 이동하기 위해 form추가 (id : detailForm)
			$("#detailForm").attr({
				"method" : "get",
				"action" : "/project/projectDetail.do"
			});
			$("#detailForm").submit();
		});

		$("#p_type").change(function() {
			if($("#search").val() == "all") {
				
				
			}
			$("#page").val(page);
			$("#f_search").attr({
				"method" : "get",
				"action" : "/project/projectList.do"
			});
			$("#f_search").submit();
		});

		/* $("#projectImage").attr({
			src : "uploadStorage/project/${project.p_image}",
			width : "120px",
			height : "110px"
		});
		 */
	});

	function goPage(page) {
		
	}
</script>

</head>
<body>
	<div>
		<%-- ======== 상세 페이지 이동을 위한 FORM ============ --%>
		<form name="detailForm" id="detailForm">
			<input type="hidden" name="p_no" id="p_no"> <input
				type="hidden" name="page" value="${data.page}"> <input
				type="hidden" name="pageSize" value="${data.pageSize}">
		</form>

		<%-- <div id="boardSearch">
			<form id="f_search" name="f_search">
				<input type="hidden" id="page" name="page" value="${data.page}">
				<input type="hidden" id="order_by" name="order_by"
					value="${data.order_by}" /> <input type="hidden" id="order_sc"
					name="order_sc" value="${data.order_sc}" />
				<table summary="검색">
					<colgroup>
						<col width="70%"></col>
						<col width="30%"></col>
					</colgroup>
					<tr>
						<td id="btd1"><select id="p_type" name="p_type"  >
								<option value="all" >전체</option>
								<option value="crafts">공예</option>
								<option value="culture">문화</option>
								<option value="art">미술</option>
								<option value="book">출판</option>
						</select> 
						<td id="btd2">한페이지에 <select id="pageSize" name="pageSize">
								<option value="1">1줄</option>
								<option value="2">2줄</option>
								<option value="3">3줄</option>
								<option value="5">5줄</option>
								<option value="7">7줄</option>
								<option value="10">10줄</option>
						</select>
						</td>
					</tr>
				</table>
			</form>
		</div> --%>

		<!-- <div>
			<div>
				<div>
					<div>
						<h1>모든 프로젝트</h1>
					</div>
				</div>
				<div>
					<div>
						<div>
							<select id="p_type" name="p_type">
								<option value="crafts">공예</option>
								<option value="culture">문화</option>
								<option value="art">미술</option>
								<option value="book">출판</option>
							</select>
						</div>
						<span><input type="checkbox" value="true" data-reactid="49" />
							react-text: 50 펀딩 마감된 프로젝트 보기/react-text</span>
					</div>
				</div>
			</div>
		</div> -->

		<%-- ================= 리스트 시작 =============== --%>
		<div id="boardList">
			<table summary="게시판 리스트">
				<colgroup>
					<col width="10%" />
					<col width="62%" />
					<col width="15%" />
					<col width="13%" />
				</colgroup>
				<tbody id="kkk">
					<!-- 데이터 출력 -->
					<c:choose>
						<c:when test="${not empty projectList_Art}">
							<c:forEach var="project" items="${projectList_Art}"
								varStatus="status">

								<tr class="tac" id="tac" data-num="${project.p_no}">

									<td class="goDetail tal"><img
										src="/uploadStorage/project/${project.p_image}" width="350px"
										height="250px"></td>
									<td id="ttt" align="center">${project.ptitle}</td>
									<td id="ccc" align="right">모음금액 :${project.p_collection}원</td>
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
		<%-- ================= 리스트 종료 ================ --%>

	</div>

	<%-- <div class="contentContainer">

		갤러리 리스트 영역
		<div class="panel-group" id="accordion" role="tablist"
			aria-multiselectable="true"></div>

	</div> --%>
</body>

</html>