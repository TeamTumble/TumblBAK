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
	href="/resources/include/css/support.css" />
<script type="text/javascript"
	src="/resources/include/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="/resources/include/js/common.js"></script>
<script type="text/javascript">
	$(function() {
		/* 저장버튼 클릭시 처리 이벤트 */
		$("#supportInsertBtn").click(function() {
			if (!chkSubmit($('#p_title'), "제목을"))
				return;
			else if (!chkSubmit($('#s_giftname'), "내용을"))
				return;
			else {

				$("#f_writeForm").attr({
					"method" : "POST",
					"action" : "/admin/support/supportInsert.do"
				});
				$("#f_writeForm").submit();
			}
		})
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
			<h3>후원관리 글작성</h3>
		</div>
		<div class="contentTB">
			<form id="f_writeForm" name="f_writeForm"
				enctype="multipart/form-data">
				<table id="supportWrite">
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
						<td><input type="text" name="p_title" id="p_title"></td>
					</tr>
					<tr>
						<td class="ac vm">내용</td>
						<td><textarea name="s_giftname" id="s_giftname"></textarea></td>
					</tr>

				</table>
			</form>
		</div>
		<div class="contentBtn">
			<input type="button" value="저장" class="but" id="supportInsertBtn">
			<input type="button" value="목록" class="but" id="supportListBtn">
		</div>
	</div>
</body>
</html>