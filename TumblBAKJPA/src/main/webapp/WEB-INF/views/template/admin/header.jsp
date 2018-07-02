<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.header-right{
text-align: right;
margin-top: 15px;
}
</style>
</head>
<body>
	<div class="navbar-header">
		
		<a class="navbar-brand" href="/admin/.do"> TumbleBak[관리자 페이지]</a>
		
	</div>
	<div class="header-right">
	<c:if test="${adminLogin.adid == null}">
		<a class="navbar-brand" href="/admin/login.do">☺로그인</a>
	</c:if>
	<c:if test="${adminLogin.adid != null and adminLogin.adid != ''}">
		<a class="navbar-brand" href="/admin/logout.do">☺로그아웃</a>
	</c:if>
	<a class="navbar-brand" href="/">☺메인페이지</a>
	</div>


</body>

</html>