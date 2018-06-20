<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximumscale=1.0,
minimum-scale=1.0, user-scalable=no" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>Login</title>
<script type="text/javascript">
	function errCodeCheck() {
		var errCode = '<c:out value="${errCode}" />';
		if (errCode != "") {
			// 명확한 자료형 명시를 위해 errCode의 타입을 정수형으로 변환.
			switch (parseInt(errCode)) {
			case 1:
				alert("아이디 또는 비밀번호 일치 하지 않거나 존재하지 않는 \n회원입니다. 다시 로그인해 주세요.");
				break;
			case 3:
				alert("회원탈퇴에 문제가 있어 정상 처리하지 못하였습니다.\n다시 시도해 주세요");
				break;
			case 6:
				alert("5번이상 로그인 시도로 30초동안 로그인 할 수없습니다.\n잠시 후 다시 시도해 주세요");
				break;
			}
		}
	}
	function nullchk() {
		var id = $("#email");
		var pw = $("#mpw");
		if (id.val() == '') {
			alert("아이디를 입력해주세요.");
			return false;
		} else if (pw.val() == '') {
			alert("비밀번호를 입력해주세요.");
			return false;
		} else {
			return true;
		}
	}

	function chkId() {
		var id = $("#email");
		var check = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
		if (!check.test(id.val())) {
			alert("아이디는  이메일 형식으로 입력하세요");
			$("#email").val("");
			$("#email").focus();
			return false;
		} else {
			return true;
		}
	}
	$(function() {

		/* 로그인 버튼 클릭 시 처리 이벤트 */
		$("#loginBtn").click(function() {
			if (!nullchk())
				return;
			else  if (!chkId())
				return;
			else
			$("#loginForm").attr({
				"method" : "POST",
				"action" : "/member/login.do"
			});
			$("#loginForm").submit();

		});
		/* 회원가입 버튼 클릭 시 처리 이벤트 */
		$("#joinBtn").click(function() {
			location.href = "/member/join.do";
		});
	});


</script>

</head>
<body>
<body>
	<div class="contentContainer">
		<div class="well">
			<c:if test="${login.email == null or login.email == ''}">
				<form id="loginForm" class="form-horizontal">
					<div class="form-group">
						<label for="email" class="col-sm-2 control-label"> 아 이 디 </label>
						<div class="col-sm-4">
							<input type="text" id="email" name="email" class="form-control"
								placeholder="ID">
						</div>
						<p class="form-control-static error"></p>
					</div>
					<div class="form-group">
						<label for="userPw" class="col-sm-2 control-label"> 비밀번호 </label>
						<div class="col-sm-4">
							<input type="password" id="mpw" name="mpw" class="form-control"
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
			</c:if>
			<c:if test="${login.email != null and login.email != ''}">
				<fieldset id="loginAfter">
					<legend>
						<strong>[ ${login.email} ]님 반갑습니다 </strong>
					</legend>
					<span id="memberMenu" class="tac"> <a
						href="/member/logout.do">로그아웃</a> &nbsp;&nbsp;&nbsp; <a
						href="/member/modify.do">정보수정(비밀번호 변경)</a>&nbsp;&nbsp;&nbsp; <a
						href="/member/delete.do">회원탈퇴</a>
					</span>
				</fieldset>
			</c:if>
		</div>
	</div>
</body>
</html>