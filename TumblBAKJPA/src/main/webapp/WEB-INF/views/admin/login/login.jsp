<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>Login</title>



<script type="text/javascript"
	src="/resources/include/js/jquery-1.12.4.min.js"></script>
</head>

<body>
	<div class="contentContainer">
		<div class="well">
			
				<form id="loginForm" class="form-horizontal">
					<div class="form-group">
						<label for="email" class="col-sm-2 control-label"> 아 이 디 </label>
						<div class="col-sm-4">
							<input type="text" id="adid" name="adid" class="form-control"
								placeholder="ID">
						</div>
						<p class="form-control-static error"></p>
					</div>
					<div class="form-group">
						<label for="userPw" class="col-sm-2 control-label"> 비밀번호 </label>
						<div class="col-sm-4">
							<input type="password" id="adpw" name="adpw" class="form-control"
								placeholder="Password">
						</div>
						<p class="form-control-static error"></p>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-6">
							<input type="button" value="로그인" id="loginBtn"
								class="btn btn-default" /> <input type="button" value="회원가입"
								id="joinBtn" class="btn btn-default" />
						</div>
					</div>
				</form>
			
			
				
			
		</div>
	</div>
	<script type="text/javascript">
	$(function() {
		/* 로그인 버튼 클릭 시 처리 이벤트 */
		$("#loginBtn").click(function() {
			alert("로그인");

			$("#loginForm").attr({
				"method" : "POST",
				"action" : "/admin/login.do"
			});
			$("#loginForm").submit();

		});
		/* 회원가입 버튼 클릭 시 처리 이벤트 */
		$("#joinBtn").click(function() {
			location.href = "/admin/member/join.do";
		});
	});
</script>
</body>
</html>