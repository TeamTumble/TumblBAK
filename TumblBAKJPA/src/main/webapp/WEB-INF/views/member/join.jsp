<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />

<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

<script type="text/javascript">
	var idConfirm = 1;
	$(function() {

		/* $('#joinInsert').attr('disabled', true); //SMS버튼 비활성화  */
		// 사용자에게 요구사항에 대한 문자열로 배열 초기화.
		var message = [ "이메일형식으로 입력해주세요", "영문,숫자,특수문자만 가능. 8 ~ 15자 입력해 주세요.",
				"비밀번호와 비밀번호 확인란은 값이 일치해야 합니다.", "이름을 입력하세요",
				"- 포함 입력해 주세요. 예시) 010-0000-0000" ];
		$('.error').each(function(index) {
			$('.error').eq(index).html(message[index]);
		});
		$('#email, #inputCode, #mpw, #mpwCheck').bind("focus", function() {
			var idx = $("#email,#inputCode, #mpw, #mpwCheck").index(this);
			// console.log("대상 : "+ idx );
			$(this).parents(".form-group").find(".error").html(message[idx]);
		});

		

		$("#mail")
				.click(
						function() {

							$
									.ajax({
										url : "userIdConfirm.do",
										type : "post",
										data : "email=" + $("#email").val(),
										error : function() {
											alert('사이트 접속에 문제로 정상 작동하지 못하였습니다.잠시 후 다시 시도해 주세요.');
										},
										success : function(resultData) {
											console.log("resultData : "
													+ resultData);
											if (resultData == "1") {
												$("#email").parents(
														".form-group").find(
														".error").html(
														"현재 사용 중인 아이디입니다.");
											} else if (resultData == "2") {
												$("#email").parents(
														".form-group").find(
														".error").html(
														"사용 가능한 아이디입니다.");
												/* $('#joinInsert').attr(
														'disabled', false); */
												idConfirm = 2;
											}
										}
									});

						});

		/*  $("#pwcheck").click(function() {

			if ($("#m_pw").val() != $("#m_pwCheck").val()) {
				alert("비밀번호와 비밀번호 확인이 일치하지 않습니다");
				$("#m_pwCheck").focus();
				$("#m_pwCheck").val("");
				return false;
			} else {
				alert("비밀번호 일치");
				$('#joinInsert').attr('disabled', false); //SMS버튼 활성화
				return true;
			}

		});  */
		/* $("#joinInsert").click(function() {

			$("#memberForm").attr({
				"method" : "post",
				"action" : "/member/join.do"
			});
			$("#memberForm").submit();

		}); */

		$("#joinCancel").click(function() {

			$("#memberForm").attr({
				"method" : "post",
				"action" : "/member/login.do"
			});
			$("#memberForm").submit();
		});
		
	
	});
</script>
<script type="text/javascript">
	// 비밀번호와 비밀번호 확인 일치 여부 확인
	function passwordCheck() {
		if ($("#mpw").val() != $("#mpwCheck").val()) {
			alert("비밀번호와 비밀번호 확인이 일치하지 않습니다");
			$("#mpwCheck").focus();
			$("#mpwCheck").val("");
			return false;
		} else {
			return true;
		}
	}

	function chkPwd() {
		var pw = $("#mpw");
		var check = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,15}$/;
		if (!check.test(pw.val())) {
			alert("비밀번호는 영문,숫자,특수문자 혼합 8~15자리로 구성되어야합니다.");
			$("#mpw").val("");
			$("#mpw").focus();
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
	function chkphone() {
		var phone = $("#m_phone");
		var check = /^(?=.*[0-9]).{10,11}$/;
		if (!check.test(phone.val())) {
			alert("핸드폰번호 형식이 올바르지 않습니다.");
			$("#m_phone").val("");
			$("#m_phone").focus();
			return false;
		} else {
			return true;
		}
	}
	function nullchk() {
		var id = $("#email");
		var pw = $("#mpw");
		var pwchk = $("#mpwCheck");
		var name = $("#mname");
		var phone = $("#m_phone");
		if (id.val() == '') {
			alert("아이디를 입력해주세요.");
			return false;
		} else if (pw.val() == '') {
			alert("비밀번호를 입력해주세요.");
			return false;
		} else if (pwchk.val() == '') {
			alert("비밀번호 확인를 입력해주세요.");
			return false;
		} else if (name.val() == '') {
			alert("이름을 입력해주세요.");
			return false;
		} else if (phone.val() == '') {
			alert("핸드폰번호를 입력해주세요.");
			return false;
		} else {
			return true;
		}
	}

	$(function() {

		$("#joinInsert").click(function() {
			if (!nullchk())
				return;
			else if (!chkPwd())
				return;
			else if (!passwordCheck())
				return;
			else if (!chkphone())
				return;
			else if (!chkId())
				return;
			else
				$("#memberForm").attr({
					"method" : "post",
					"action" : "/member/join.do"
				});
			$("#memberForm").submit();
		});

		$("#cancleBtn").click(function() {
			location.href = "/";
		});
	});
</script>
<title>Join Member!</title>
</head>
<body>
	

	<div class="contentContainer">
		<div class="well">
			<form id="memberForm" class="form-horizontal">

				<div class="form-group form-group-sm">
					<label for="userId" class="col-sm-2 control-label">이메일</label>
					<div class="col-sm-3">
						<input type="text" id="email" name="email" class="form-control" />
					</div>
					<div class="col-sm-2">
						<!-- <input type="button" id="idck" value="아이디 중복체크"
							class="form-control btn-primary" /> -->
						<input type="button" id="mail" value="중복체크"
							class="form-control btn-primary" />
					</div>
					<div class="col-sm-5">
						<p class="error"></p>
					</div>
				</div>
				<div class="form-group form-group-sm">
					<label for="userPw" class="col-sm-2 control-label">비밀 번호</label>
					<div class="col-sm-3">
						<input type="password" id="mpw" name="mpw" maxlength="15"
							class="form-control" placeholder="Password">
					</div>
					<div class="col-sm-5">
						<p class="form-control-static error"></p>
					</div>
				</div>
				<div class="form-group form-group-sm">
					<label for="userPwCheck" class="col-sm-2 control-label">비밀번호
						확인 </label>
					<div class="col-sm-3">
						<input type="password" id="mpwCheck" name="mpwCheck"
							maxlength="15" class="form-control"
							placeholder="Password Confirm">
					</div>
					<!-- <div class="col-sm-2">
						<input type="button" id="pwcheck" value="비밀확인"
							class="form-control btn-primary" />
					</div> -->
					<div class="col-sm-5">
						<p class="form-control-static error"></p>
					</div>
				</div>
				<div class="form-group form-group-sm">
					<label for="userName" class="col-sm-2 control-label">회원이름</label>
					<div class="col-sm-3">
						<input type="text" id="mname" name="mname" maxlength="10"
							class="form-control" placeholder="NAME">
					</div>
					<div class="col-sm-5">
						<p class="form-control-static error"></p>
					</div>
				</div>
				<div class="form-group form-group-sm">
					<label for="phone" class="col-sm-2 control-label">핸드폰 번호 </label>
					<div class="col-sm-3">
						<input type="text" id="m_phone" name="m_phone" maxlength="15"
							class="form-control" placeholder="Phone Number">
					</div>
					<div class="col-sm-5">
						<p class="form-control-static error"></p>
					</div>
				</div>
				<div class="form-group" id="ccc">
					<div class="col-sm-offset-2 col-sm-6">
						<input type="button" value="확인" id="joinInsert"
							class="btn btn-default" /> <input type="button" value="취소"
							id="joinCancel" class="btn btn-default" />
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
