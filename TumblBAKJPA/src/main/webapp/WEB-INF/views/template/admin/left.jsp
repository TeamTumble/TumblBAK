<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function loginChk(path) {
    if (!$("#loginSession").val()) {
       alert("로그인 해주세요");
       location.href = "/admin/login.do";
    } else {
       location.href = path;
    }
 }
</script>
</head>
<body>
	<div class="container">
		<ul class="nav nav-sidebar">
			<li class="active"><a href="#">[관리자 페이지 목록] 
			<span class="sr-only">(current)</span></a></li>
			<li><a href="/admin/.do">Home</a></li>
			<li><a href="#" onclick="loginChk('/admin/member/memberList.do'); return false;">회원 관리</a></li>
			<li><a href="#" onclick="loginChk('/admin/project/projectList.do'); return false;">프로젝트 관리</a></li>
			<li><a href="#" onclick="loginChk('/admin/support/supportList.do'); return false;">후원 관리</a></li>
			<li><a href="#" onclick="loginChk('/admin/notice/noticeList.do'); return false;">공지사항</a></li>
			<li><a href="#" onclick="loginChk('/admin/qna/qnaList.do'); return false;">1:1문의사항</a></li>
			<!-- <li><a href="/chart/PieChart">통계 관리</a></li> -->
		</ul>
	</div>
	<div><input type="hidden" id="loginSession" value="${adminLogin}"></div>
</body>
</html>