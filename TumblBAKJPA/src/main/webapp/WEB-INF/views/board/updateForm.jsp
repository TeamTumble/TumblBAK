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
	href="/resources/include/css/board.css" />
<script type="text/javascript"
	src="/resources/include/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="/resources/include/js/common.js"></script>
<script type="text/javascript">
	$(function() { /* 수정 버튼 클릭 시 처리 이벤트 */
		$("#boardUpdateBtn").click(function() {
			$("#f_writeForm").attr({
				"method" : "POST",
				"action" : "/board/boardUpdate.do"
			});
			$("#f_writeForm").submit();

		});
		/* 목록 버튼 클릭 시 처리 이벤트 */
		$("#boardListBtn").click(function() {
			location.href = "/board/boardList.do";

		});
	});
</script>
</head>
<body>
	<div class="contentContainer">
		<div class="contentTit">
			<h3>게시판 글수정</h3>
		</div>
		<div class="contentTB">
			<form id="f_writeForm" name="f_writeForm"
				enctype="multipart/form-data">
				<input type="hidden" id="qnum" name="qnum"
					value="${updateData.qnum}" /> <input type="hidden" name="b_file"
					id="b_file" value="${updateData.b_file}" /> <input type="hidden"
					name="page" id="page" value="${param.page}" /> <input
					type="hidden" name="pageSize" id="pageSize"
					value="${param.pageSize}" /><input type="hidden" name="q_date"
					id="q_date" value="${updateData.q_date}" /><input type="hidden"
					name="email" id="email" value="${updateData.email}" />
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
							<td>${updateData.qnum}</td>
							<td class="ac">작성일</td>
							<td>${updateData.q_date}</td>
						</tr>
						<tr>
							<td class="ac">작성자</td>
							<td colspan="3">${updateData.email}</td>
						</tr>
						<tr>
							<td class="ac">글제목</td>
							<td colspan="3"><input type="text" name="qtitle"
								id="qtitle" value="${updateData.qtitle}" /></td>
						</tr>
						<tr>
							<td class="ac vm">내용</td>
							<td colspan="3"><textarea name="q_content" id="q_content">${updateData.q_content} </textarea></td>
						</tr>
						<tr>
							<td class="ac">첨부파일</td>
							<td colspan="3"><input type="file" name="file" id="file">
								<span id="imgView">기존 이미지파일명: ${updateData.b_file}<span
									id="imgArea"> </span></span></td>
						</tr>
				</table>
			</form>
		</div>
		<div class="contentBtn">
			<input type="button" value="수정" id="boardUpdateBtn"> <input
				type="button" value="목록" id="boardListBtn">
		</div>
	</div>
</body>
</html>