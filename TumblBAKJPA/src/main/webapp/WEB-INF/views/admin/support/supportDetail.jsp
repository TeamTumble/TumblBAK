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
	href="/resources/include/css/support.css" />
<script type="text/javascript"
	src="/resources/include/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="/resources/include/js/common.js"></script>
<script type="text/javascript">
	var butChk = 0;
	// 수정버튼과 삭제버튼을 구별하기 위한 변수
	$(function() {
		$("#pwdChk").hide();

		/* 수정 버튼 클릭 시 처리 이벤트 */
		$("#updateFormBtn").click(function() {
			/* $("#pwdChk").show();
			$("#msg").text("작성시 입력한 비밀번호를 입력해 주세요.").css("color", "#000099"); */
			var s_no = $(this).parents("tr").attr("data-num");
			$("#s_no").val(s_no);
			console.log("글번호 : " + s_no);
			//상세 페이지로 이동하기 위해 form추가 (id : detailForm)
			$("#f_data").attr({
				"method" : "get",
				"action" : "/admin/support/updateForm.do"
			});
			$("#f_data").submit();
			
		});
		/* 삭제 버튼 클릭 시 처리 이벤트 */
		$("#supportDeleteBtn").click(function() {
			/* $("#pwdChk").show();
			$("#msg").text("작성시 입력한 비밀번호를 입력해 주세요.").css("color", "#000099"); */
			$("#f_data").attr({
				"method" : "get",
				"action" : "/admin/support/supportDelete.do"
			});
			$("#f_data").submit();

		});

		/* 목록 버튼 클릭 시 처리 이벤트 */
		$("#supportListBtn").click(function() {
			location.href = "/admin/support/supportList.do";
		});
	});
</script>
</head>
<body>
	<div class="contentContainer">
		<div class="contentTit">
			<h3>후원관리 상세페이지</h3>
		</div>
		<form name="f_data" id="f_data" >
			<input type="hidden" name="s_no" value="${detail.s_no}" />
			<input type="hidden" name="s_no" id="s_no"> <input type="hidden" name="page" value="${data.page}"> 
			<input type="hidden" name="pageSize" value="${data.pageSize}">
		</form>
		<%-- ========= 버튼 추가 시작 ====== --%>
		<table id="supportPwdBut">
			<tr>
				<td id="btd2">
					<input type="button" value="수정" id="updateFormBtn"> 
					<input type="button" value="삭제" id="supportDeleteBtn"> 
					<input type="button" value="목록" id="supportListBtn"></td>
			</tr>
		</table>
		<%-- =========== 버튼 추가 종료 ====== --%>
		<%-- =============== 상세 정보 보여주기 시작 ============ --%>
		<div class="contentTB">
			<table>
				<colgroup>
					<col width="17%" />
					<col width="33%" />
					<col width="17%" />
					<col width="33%" />
				</colgroup>
				<tbody>
					<tr>
						<td class="ac">작성자</td>
						<td>관리자</td>
						<td class="ac">후원 일</td>
						<td>${detail.s_date}</td>
					</tr>
					<tr>
						<td class="ac">프로젝트 명</td>
						<td colspan="3">${detail.p_title}</td>
					</tr>
					<tr>
						<td class="ac vm">리워드 명</td>
						<td colspan="3">${detail.s_giftname}</td>
					</tr>
				</tbody>
			</table>
		</div>
		<%-- =============== 상세 정보 보여주기 종료 ============ --%>
	</div>
</body>
</html>