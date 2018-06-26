<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>글수정 화면</title>
<link rel="stylesheet" type="text/css"
	href="/resources/include/css/common.css" />
<link rel="stylesheet" type="text/css"
	href="/resources/include/css/notice.css" />
<script type="text/javascript"
	src="/resources/include/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="/resources/include/js/common.js"></script>
<script type="text/javascript">
	$(function() { /* 수정 버튼 클릭 시 처리 이벤트 */
		$("#UpdateFormBtn").click(function() {
			//입력값 체크 

			$("#f_writeForm").attr({
				"method" : "POST",
				"action" : "/admin/notice/noticeUpdate.do"
			});
			$("#f_writeForm").submit();

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
			<h3>공지사항 수정</h3>
		</div>
		<div class="contentTB">
			<form id="f_writeForm" name="f_writeForm" enctype="multipart/form-data">
				<input type="hidden" id="nno" name="nno" value="${updateData.nno}" />
				<%-- <input type="hidden" name="page" id="page" value="${param.page}" />
				<input type="hidden" name="pageSize" id="pageSize" value="${param.pageSize}" /> --%>
				<table>
					<colgroup>
						<col width="17%" />
						<col width="33%" />
						<col width="17%" />
						<col width="33%" />
					</colgroup>
					<tbody>
						<tr>
							<td class="ac">글번호</td>
							<td>${updateData.nno}</td>
							<td class="ac">작성일</td>
							<td>${updateData.ndate}</td>
						</tr>
						<tr>
							<td class="ac">작성자</td>
							<td colspan="3">관리자</td>
						</tr>
						<tr>
							<td class="ac">글제목</td>
							<td colspan="3"><input type="text" name="ntitle"
								id="ntitle" value="${updateData.ntitle}" /></td>
						</tr>
						<tr>
							<td class="ac vm">내용</td>
							<td colspan="3"><textarea name="ncontent" id="ncontent">${updateData.ncontent} </textarea></td>
						</tr>
				</table>
			</form>
		</div>
		<div class="contentBtn">
			<input type="button" value="수정" id="UpdateFormBtn"> <input
				type="button" value="목록" id="noticeListBtn">
		</div>
	</div>
</body>
</html>