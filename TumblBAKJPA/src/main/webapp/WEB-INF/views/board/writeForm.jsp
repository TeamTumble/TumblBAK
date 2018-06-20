<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기 화면</title>
<link rel="stylesheet" type="text/css"
	href="/resources/include/css/common.css" />
<link rel="stylesheet" type="text/css"
	href="/resources/include/css/board.css" />
<script type="text/javascript"
	src="/resources/include/js/jquery-1.12.4.min.js"></script>
<!-- <script type="text/javascript" src="/resources/include/js/common.js"></script> -->
<script type="text/javascript">
	$(function() {
		/* 저장버튼 클릭시 처리 이벤트 */
		$("#boardInsertBtn").click(function() {
			//입력값 체크

			$("#f_writeForm").attr({
				"method" : "POST",
				"action" : "/board/boardInsert.do"
			});
			$("#f_writeForm").submit();

		})
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
			<h3>1:1 문의하기</h3>
		</div>
		<div class="contentTB">
			<form id="f_writeForm" name="f_writeForm"
				enctype="multipart/form-data">
				<table id="boardWrite">
					<colgroup>
						<col width="17%" />
						<col width="83%" />
					</colgroup>
					<tr hidden="">
						<td><input type="hidden" name="idx" id="idx"
							value="${member.idx}" /> <input type="hidden" name="email"
							id="email" value="${member.email}" /></td>
					</tr>
					<tr>
						<td class="ac">작성자</td>
						<td>${member.email}</td>
					</tr>
					<tr>
						<td class="ac">글제목</td>
						<td><input type="text" name="q_title" id="q_title"></td>
					</tr>
					<tr>
						<td class="ac vm">내용</td>
						<td><textarea name="q_content" id="q_content"></textarea></td>
					</tr>
					<tr>
						<td class="ac">첨부파일</td>
						<td><input type="file" name="file" id="file"></td>
					</tr>
				</table>
			</form>
		</div>
		<div class="contentBtn">
			<input type="button" value="문의하기" class="but" id="boardInsertBtn">
			<input type="button" value="목록" class="but" id="boardListBtn">
		</div>
	</div>
</body>
</html>