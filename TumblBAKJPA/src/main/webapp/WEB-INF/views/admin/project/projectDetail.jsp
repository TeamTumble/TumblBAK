<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>글상세 보기</title>
<link rel="stylesheet" type="text/css"
	href="/resources/include/css/common.css" />
<link rel="stylesheet" type="text/css"
	href="/resources/include/css/project.css" />
<script type="text/javascript"
	src="/resources/include/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="/resources/include/js/common.js"></script>
<script type="text/javascript">
	var butChk = 0;
	// 수정버튼과 삭제버튼을 구별하기 위한 변수
	$(function() {
		var p_remarks = "${detail.p_remarks}";
		var p_case = "${detail.p_case}";

		if (p_case == '승인대기') {
			$("#p_case").val("승인대기").prop("selected", true);
		} else if (p_case == '승인') {
			$("#p_case").val("승인").prop("selected", true);
		} else if (p_case == '비승인') {
			$("#p_case").val("비승인").prop("selected", true);
		}

		if (p_remarks == '프로젝트에 대한 설명이 불충분 합니다.') {
			$("#p_remarks").val("프로젝트에 대한 설명이 불충분 합니다.").prop("selected", true);
		} else if (p_remarks == '유해 컨텐츠를 포함하고 있습니다.') {
			$("#p_remarks").val("유해 컨텐츠를 포함하고 있습니다.").prop("selected", true);
		} else if (p_remarks == '제3자의 권리를 침해 할 수 있는 요소가 있습니다.') {
			$("#p_remarks").val("제3자의 권리를 침해 할 수 있는 요소가 있습니다.").prop("selected", true);
		} else if (p_remarks == '지적재산권 침해 요소를 포함하고 있습니다.') {
			$("#p_remarks").val("지적재산권 침해 요소를 포함하고 있습니다.").prop("selected", true);
		} else if (p_remarks == '현행법에 위반되는 내용을 포함하고 있습니다.') {
			$("#p_remarks").val("현행법에 위반되는 내용을 포함하고 있습니다.").prop("selected", true);
		}

		/* 수정 버튼 클릭 시 처리 이벤트 */
		$("#updateBtn").click(function() {
			alert("저장 되었습니다.");
			$("#f_data").attr({
				"method" : "post",
				"action" : "/admin/project/projectDetail.do"
			});
			$("#f_data").submit();
		});
		/* 삭제 버튼 클릭 시 처리 이벤트 */

		/* 목록 버튼 클릭 시 처리 이벤트 */
		$("#projectListBtn").click(function() {
			location.href = "/admin/project/projectList.do";
		});
		/* 프로젝트 링크 버튼 클릭 시 처리 이벤트 */
		$("#projectLinkBtn").click(function() {
			var p_no = $(this).parents("tr").attr("data-no");
			$("#p_no").val(p_no);
			console.log("글번호 : " + p_no);
			//상세 페이지로 이동하기 위해 form추가 (id : detailForm)
			$("#f_data").attr({
				"method" : "get",
				"action" : "/project/projectDetail.do"
			});
			$("#f_data").submit();
		});
		var pm_email = "${detail.pm_email}";
		var p_no = "${detail.p_no}";
		$("#mailSendBtn")
				.click(
						function() {
							if ($("#p_case").val() == '승인대기') {
								alert("승인 여부를 선택해주세요");
							} else {
								$
										.ajax({
											url : "projectMail.do",
											type : "post",
											data : "pm_email=" + pm_email
													+ "&p_remarks="
													+ $("#p_remarks").val()
													+ "&p_case="
													+ $("#p_case").val()
													+ "&p_no=" + p_no,
											error : function() {
												alert('사이트 접속에 문제로 정상 작동하지 못하였습니다.잠시 후 다시 시도해 주세요.');
											},
											success : function(resultData) {
												alert("이메일이 성공적으로 보내졌습니다.");
											}
										});
							}
						});
	});
</script>
</head>
<body>
	<div class="contentContainer">
		<div class="contentTit">
			<h3>프로젝트 검사</h3>
		</div>

		<%-- ========= 버튼 추가 시작 ====== --%>
		<table id="projectPwdBut">
			<tr>
				<td id="btd2"><input type="button" value="저장" id="updateBtn">
					<input type="button" value="프로젝트 링크" id="projectLinkBtn"> <input
					type="button" value="메일보내기" id="mailSendBtn"> <input
					type="button" value="목록" id="projectListBtn"></td>
			</tr>
		</table>
		<%-- =========== 버튼 추가 종료 ====== --%>
		<%-- =============== 상세 정보 보여주기 시작 ============ --%>
		<div class="contentTB">
			<form id="f_data">
				<table>
					<colgroup>
						<col width="17%" />
						<col width="33%" />
						<col width="17%" />
						<col width="33%" />
					</colgroup>
					<tbody>

						<tr data-num="${detail.p_no}">
							<td class="ac">제목</td>
							<td colspan="3">${detail.p_title}</td>
						</tr>
						<tr>
							<td class="ac">진행자명</td>
							<td>${detail.pm_name}</td>
							<td class="ac">이메일</td>
							<td>${detail.pm_email}</td>
						</tr>
						<tr>
							<td class="ac">작성자</td>
							<td>관리자</td>
							<td class="ac">프로젝트 상태</td>
							<td><select name="p_case" id="p_case">
									<option value="승인대기">승인대기</option>
									<option value="승인">승인</option>
									<option value="비승인">비승인</option>
							</select></td>
						</tr>
						<tr>
							<td class="ac vm">비고</td>
							<td colspan="3"><select name="p_remarks" id="p_remarks">
									<option value="프로젝트에 대한 설명이 불충분 합니다.">프로젝트에 대한 설명이 불충분
										합니다.</option>
									<option value="유해 컨텐츠를 포함하고 있습니다.">유해 컨텐츠를 포함하고 있습니다.</option>
									<option value="제3자의 권리를 침해 할 수 있는 요소가 있습니다.">제3자의 권리를
										침해 할 수 있는 요소가 있습니다.</option>
									<option value="지적재산권 침해 요소를 포함하고 있습니다.">지적재산권 침해 요소를
										포함하고 있습니다.</option>
									<option value="현행법에 위반되는 내용을 포함하고 있습니다.">현행법에 위반되는 내용을
										포함하고 있습니다.</option>
							</select></td>
						</tr>
					</tbody>
				</table>

				<input type="hidden" name="p_no"  value="${detail.p_no}" />
			</form>
		</div>
		<%-- =============== 상세 정보 보여주기 종료 ============ --%>
	</div>
</body>
</html>