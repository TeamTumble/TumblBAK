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
	href="/resources/include/css/notice.css" />
<script type="text/javascript"
	src="/resources/include/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="/resources/include/js/common.js"></script>
<script type="text/javascript">
	$(function() {
		/* 저장버튼 클릭시 처리 이벤트 */
		$("#noticeInsertBtn").click(function() {
			if (!chkSubmit($('#ntitle'), "제목을"))
				return;
			else if (!chkSubmit($('#ncontent'), "내용을"))
				return;
			else {

				$("#f_writeForm").attr({
					"method" : "POST",
					"action" : "/admin/notice/noticeInsert.do"
				});
				$("#f_writeForm").submit();
			}
		})
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
			<h3>공지사항 글작성</h3>
		</div>
		<div class="contentTB">
			<form id="f_writeForm" name="f_writeForm"
				enctype="multipart/form-data">
				<table id="noticeWrite">
					<colgroup>
						<col width="17%" />
						<col width="83%" />
					</colgroup>
					<tr>
						<td class="ac">작성자</td>
						<td>관리자</td>
					</tr>
					<tr>
						<td class="ac">글제목</td>
						<td><input type="text" name="ntitle" id="ntitle"></td>
					</tr>
					<tr>
						<td class="ac vm">내용</td>
						<td><textarea name="ncontent" id="ncontent"></textarea></td>
					</tr>

				</table>
			</form>
		</div>
		<div class="contentBtn">
			<input type="button" value="저장" class="but" id="noticeInsertBtn">
			<input type="button" value="목록" class="but" id="noticeListBtn">
		</div>
	</div>
</body>
</html>