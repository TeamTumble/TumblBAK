<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximumscale=1.0,
minimum-scale=1.0, user-scalable=no" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>Update Member!</title>
<!-- 모바일 웹 페이지 설정 -->
<link rel="shortcut icon" href="/resources/image/icon.png" />
<link rel="apple-touch-icon" href="/resources/image/icon.png" />
<!-- 모바일 웹 페이지 설정 끝 -->
<!--[if lt IE 9]>
<script src="/resources/include/js/html5shiv.js"></script>
<![endif]-->
<script type="text/javascript"
	src="/resources/include/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#modify").click(function() {

			$("#memberForm").attr({
				"method" : "post",
				"action" : "/member/modify.do"
			});
			$("#memberForm").submit();

		});
		$("#modifyReset").click(function() {
			$("#memberForm").each(function() {
				this.reset();
			});
		});
		$("#modifyCancel").click(function() {
			location.href = "/member/login.do";
		});
	});
	function passwordCheck() {
		if ($("#mpw").val() != $("#userPwCheck").val()) {
			alert("패스워드 입력이 일치하지 않습니다");
			$("#mpw").val("");
			$("#userPwCheck").val("");
			$("#mpw").focus();
			return false;
		}
		return true;
	}
</script>
</head>
<body>
	<div class="contentContainer">
		<div class="well">
			<form id="memberForm" class="form-horizontal">
				<input type="hidden" name="idx" id="idx" value="${member.idx}" />
				<div class="form-group form-group-sm">
					<label for="userId" class="col-sm-2 control-label">사용자 ID</label>
					<div class="col-sm-3">${member.email}</div>
				</div>
				<div class="form-group form-group-sm">
					<label for="oldUserPw" class="col-sm-2 control-label">기존 비밀
						번호 </label>
					<div class="col-sm-3">
						<input type="password" id="oldm_pw" name="oldm_pw" maxlength="15"
							class="form-control" placeholder="기존 비밀번호 입력">
					</div>
					<div class="col-sm-5">
						<p class="form-control-static error"></p>
					</div>
				</div>
				<div class="form-group form-group-sm">
					<label for="userPw" class="col-sm-2 control-label">변경할 비밀
						번호 </label>
					<div class="col-sm-3">
						<input type="password" id="mpw" name="mpw" maxlength="15"
							class="form-control" placeholder="변경할 비밀번호 입력">
					</div>
					<div class="col-sm-5">
						<p class="form-control-static error"></p>
					</div>
				</div>
				<div class="form-group form-group-sm">
					<label for="userPwCheck" class="col-sm-2 control-label">변경할
						비밀번호 확인</label>
					<div class="col-sm-3">
						<input type="password" id="userPwCheck" name="userPwCheck"
							maxlength="15" class="form-control" placeholder="변경할 비밀번호 입력
확인">
					</div>
					<div class="col-sm-5">
						<p class="form-control-static error"></p>
					</div>
				</div>
				<div class="form-group form-group-sm">
					<label for="phone" class="col-sm-2 control-label">핸드폰 번호 </label>
					<div class="col-sm-3">
						<input type="text" id="m_phone" name="m_phone" maxlength="15"
							class="form-control" value="${member.m_phone}">
					</div>
					<div class="col-sm-5">
						<p class="form-control-static error"></p>
					</div>
				</div>
				<div class="form-group form-group-sm">
					<label for="userName" class="col-sm-2 control-label">회원이름</label>
					<div class="col-sm-3">${member.m_name}</div>
				</div>

				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-6">
						<input type="button" value="확인" id="modify"
							class="btn btn-default" /> <input type="button" value="재작성"
							id="modifyReset" class="btn btn-default" /> <input type="button"
							value="취소" id="modifyCancel" class="btn btn-default" />
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>