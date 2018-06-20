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
<link rel="stylesheet" type="text/css"
	href="/resources/include/css/common.css" />
<link rel="stylesheet" type="text/css"
	href="/resources/include/css/board2.css" />
<script type="text/javascript">
	$(function() {
		/* 글쓰기 버튼 클릭 시 처리 이벤트 */
		$("#projectCreateBtn").click(function() {
			location.href = "/project/projectCreate.do";
		});

		/* 제목 클릭시 상세 페이지 이동을 위한 처리 이벤트 */
		$(".goDetail").click(function() {
			var pno = $(this).parents("tr").attr("data-num");
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
	<div class="contentContainer">
		<div class="contentTit">
			<h3>내 프로젝트</h3>
		</div>
		<%-- ======== 상세 페이지 이동을 위한 FORM ============ --%>
		<form name="detailForm" id="detailForm">
			<input type="hidden" name="pno" id="pno">
		</form>
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
						<c:when test="${not empty projectList}">
							<c:forEach var="project" items="${projectList}"
								varStatus="status">
								<tr class="tac " id="tac" data-num="${project.pno}">
									
									<td><img src="/uploadStorage/projectvo/${project.p_image}"
										width="350px" height="250px"></td>
									<td class="goDetail tal" id="ttt" align="center">${project.p_title}</td>
									<td id="ccc" align="right">모음금액 :${project.pcollection}원</td>
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
</body>
</html>