<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>글상세 보기</title>
<link rel="stylesheet" type="text/css" href="/resources/include/css/common.css" />
<link rel="stylesheet" type="text/css" href="/resources/include/css/qna.css" />
<script type="text/javascript" src="/resources/include/js/jquery-1.12.4.min.js"></script>
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
			var qnum = $(this).parents("tr").attr("data-num");
			$("#qnum").val(qnum);
			console.log("글번호 : " + qnum);
			//상세 페이지로 이동하기 위해 form추가 (id : detailForm)
			$("#f_data").attr({
				"method" : "get",
				"action" : "/qna/updateForm.do"
			});
			$("#f_data").submit();
			
		});
		/* 삭제 버튼 클릭 시 처리 이벤트 */
		$("#qnaDeleteBtn").click(function() {
			/* $("#pwdChk").show();
			$("#msg").text("작성시 입력한 비밀번호를 입력해 주세요.").css("color", "#000099"); */
			butChk = 2;
		});

		/* 비밀번호 확인 버튼 클릭 시 처리 이벤트 */
		$("#pwdBtn").click(function() {
			qnaPwdConfirm();
		});
		/* 목록 버튼 클릭 시 처리 이벤트 */
		$("#qnaListBtn").click(function() {
			location.href = "/qna/qnaList.do";
		});
	});
</script>
</head>
<body>
	<div class="contentContainer">
		<div class="contentTit">
			<h3>1:1문의사항 상세페이지</h3>
		</div>
		<form name="f_data" id="f_data" >
			<input type="hidden" name="qnum" value="${detail.qnum}" />
			<input type="hidden" name="qnum" id="qnum">
			<input type="hidden" name="page" value="${data.page}"> 
			<input type="hidden" name="pageSize" value="${data.pageSize}">
		</form>
		<%-- ========= 비밀번호 확인 버튼 및 버튼 추가 시작 ====== --%>
		<table id="qnaPwdBut">
			<tr>
				<td id="btd2">
					<input type="button" value="삭제" id="qnaDeleteBtn"> 
					<input type="button" value="목록" id="qnaListBtn"></td>
			</tr>
		</table>
		<%-- =========== 비밀번호 확인 버튼 및 버튼 추가 종료 ====== --%>
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
						<td>${detail.email}</td>
						<td class="ac">작성일</td>
						<td>${detail.q_date}</td>
					</tr>
					<tr>
						<td class="ac">제목</td>
						<td colspan="3">${detail.qtitle}</td>
					</tr>
					<tr>
						<td class="ac vm">내용</td>
						<td colspan="3">${detail.q_content}</td>
					</tr>
				</tbody>
			</table>
		</div>
		<%-- =============== 상세 정보 보여주기 종료 ============ --%>
		<jsp:include page="reply.jsp"></jsp:include>
	</div>
</body>
</html>