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
	href="/resources/include/css/notice.css" />
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
			var n_no = $(this).parents("tr").attr("data-num");
			$("#n_no").val(n_no);
			console.log("글번호 : " + n_no);
			//상세 페이지로 이동하기 위해 form추가 (id : detailForm)
			$("#f_data").attr({
				"method" : "get",
				"action" : "/admin/notice/updateForm.do"
			});
			$("#f_data").submit();
			
		});
		/* 삭제 버튼 클릭 시 처리 이벤트 */
		$("#noticeDeleteBtn").click(function() {
			/* $("#pwdChk").show();
			$("#msg").text("작성시 입력한 비밀번호를 입력해 주세요.").css("color", "#000099"); */
			$("#f_data").attr({
				"method" : "get",
				"action" : "/admin/notice/noticeDelete.do"
			});
			$("#f_data").submit();

		});

		/* 목록 버튼 클릭 시 처리 이벤트 */
		$("#noticeListBtn").click(function() {
			location.href = "/admin/notice/noticeList.do";
		});
	});
</script>
</head>
<body>
	<div class="contentContainer">
		<div class="contentTit">
			<h3>공지사항 상세페이지</h3>
		</div>
		<form name="f_data" id="f_data" >
			<input type="hidden" name="n_no" value="${detail.n_no}" />
			<input type="hidden" name="n_no" id="n_no"> <input type="hidden" name="page" value="${data.page}"> 
			<input type="hidden" name="pageSize" value="${data.pageSize}">
		</form>
		<%-- ========= 버튼 추가 시작 ====== --%>
		<table id="noticePwdBut">
			<tr>
				<td id="btd2">
					<input type="button" value="수정" id="updateFormBtn"> 
					<input type="button" value="삭제" id="noticeDeleteBtn"> 
					<input type="button" value="목록" id="noticeListBtn"></td>
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
						<td class="ac">작성일</td>
						<td>${detail.n_date}</td>
					</tr>
					<tr>
						<td class="ac">제목</td>
						<td colspan="3">${detail.n_title}</td>
					</tr>
					<tr>
						<td class="ac vm">내용</td>
						<td colspan="3">${detail.n_content}</td>
					</tr>
				</tbody>
			</table>
		</div>
		<%-- =============== 상세 정보 보여주기 종료 ============ --%>
	</div>
</body>
</html>