<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://www.w3schools.com/lib/w3-theme-blue.css">
<title>프로젝트 수정</title>
<!-- CSS -->
<link rel="stylesheet" type="text/css"
	href="/resources/include/css/common.css" />
<link rel="stylesheet" type="text/css"
	href="/resources/include/css/board.css" />

<!-- SCRIPT -->
<script type="text/javascript"
	src="/resources/include/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="/resources/include/js/common.js"></script>
<script src="//cdn.ckeditor.com/4.8.0/standard/ckeditor.js"></script>

<!-- FUNCTION -->
<script type="text/javascript">
	/* 날짜 폼 함수*/
	Date.prototype.format = function(f) {
		if (!this.valueOf())
			return " ";

		var weekName = [ "일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일" ];
		var d = this;

		return f.replace(/(yyyy|yy|MM|dd|E|hh|mm|ss|a\/p)/gi, function($1) {
			switch ($1) {
			case "yyyy":
				return d.getFullYear();
			case "yy":
				return (d.getFullYear() % 1000).zf(2);
			case "MM":
				return (d.getMonth() + 1).zf(2);
			case "dd":
				return d.getDate().zf(2);
			case "E":
				return weekName[d.getDay()];
			case "HH":
				return d.getHours().zf(2);
			case "hh":
				return ((h = d.getHours() % 12) ? h : 12).zf(2);
			case "mm":
				return d.getMinutes().zf(2);
			case "ss":
				return d.getSeconds().zf(2);
			case "a/p":
				return d.getHours() < 12 ? "오전" : "오후";
			default:
				return $1;
			}
		});
	};

	String.prototype.string = function(len) {
		var s = '', i = 0;
		while (i++ < len) {
			s += this;
		}
		return s;
	};
	String.prototype.zf = function(len) {
		return "0".string(len - this.length) + this;
	};
	Number.prototype.zf = function(len) {
		return this.toString().zf(len);
	};

	/* 날짜 변환 기능*/
	function newdate(p_createForm) {

		/*3차방법*/
		plusDate = $("#p_fundingdate").val();
		var now = new Date();
		var newdate = new Date();
		var newtimems = newdate.getTime() + (plusDate * 24 * 60 * 60 * 1000);
		newdate.setTime(newtimems);

		$("#p_enddate").val(newdate.toString());
		$("#p_enddate_input").val(newdate.toLocaleDateString());
		/*예산 지급일 */
		newdate.setTime(newtimems + (7 * 24 * 60 * 60 * 1000));
		$("#p_paydate").val(newdate.toString());
		$("#p_paydate_input").val(newdate.toLocaleDateString());

	}
	/* 금액 , 표시 및 공제 계산*/
	function newprices() {
		var original;
		var newprice;
		$("#p_price").val($("#p_price_input").val());
		original = $("#p_price_input").val();
		newprice = original / 10;
		newprice = newprice / 2;
		newprice = original - newprice;
		numchk1(newprice, 1);
		numchk1(original, 2);
	}

	function numchk1(num, numba) {
		var sign = "";
		if (isNaN(num)) {
			alert("숫자만 입력할 수 있습니다.");
			return 0;
		}
		if (num == 0) {
			return num;
		}

		if (num < 0) {
			num = num * (-1);
			sign = "-";
		} else {
			num = num * 1;
		}
		num = new String(num)
		var temp = "";
		var pos = 3;
		num_len = num.length;
		while (num_len > 0) {
			num_len = num_len - pos;
			if (num_len < 0) {
				pos = num_len + pos;
				num_len = 0;
			}
			temp = "," + num.substr(num_len, pos) + temp;
		}
		if (numba == 1)
			$("#real_price").val(sign + temp.substr(1));
		else
			$("#p_price_input").val(sign + temp.substr(1));
	}

	$(function() {

		var original;
		var newprice;
		$("#p_price").val($("#p_price_input").val());
		original = $("#p_price_input").val();
		newprice = original / 10;
		newprice = newprice / 2;
		newprice = original - newprice;
		$("#real_price").val(newprice);

		/* 버튼 기능 */
		/*수정 취소 버튼 - 리스트로 이동*/
		$("#updateCancelBtn").click(function() {
			location.href = "/project/projectList.do";
		});

		/* 등록 실행 버튼*/
		$("#projectUpdateBtn").click(function() {
			//입력값 체크
			if (!chkSubmit($('#p_title'), "제목을"))
				return;
			else if (!chkSubmit($('#pm_name'), "이름을"))
				return;
			else if (!chkSubmit($('#p_story'), "작성할 내용을"))
				return;
			else {

				if ($('#p_file').val() != "") {
					if (!chkFile($('#p_file')))
						return;
				}
				if ($('#pm_file').val() != "") {
					if (!chkFile($('#pm_file')))
						return;
				}
				if ($('#ps_file').val() != "") {
					if (!chkFile($('#ps_file')))
						return;
				}

				$("#p_updateForm").attr({
					"method" : "POST",
					"action" : "/project/projectUpdate.do"
				});
				$("#p_updateForm").submit();
			}
		})
	});
</script>

</head>
<body>
	<div class="contentContainer" >
			<div class="contentTit">
				<h2 style="text-shadow: 0.5px 0.5px 0 #444">프로젝트 수정하기</h2>
			</div>
				<!-- 프로젝트 작성 버튼 부분 -->
									<div class="projectCreatBtn w3-margin-bottom" align="right" >
			<input type="button" value="수정하기" class="btn btn-primary" id="projectUpdateBtn">
			<input type="button" value="취소" class="btn btn-default" id="updateCancelBtn">
		</div>
									</div>

			<div class="form-group" style="height: 100%">
				<form id="p_updateForm" name="p_updateForm"
					enctype="multipart/form-data">
					<div>
						<input type="hidden" name="email" id="email"
							value="${dtail.email}" /> <input type="hidden" name="p_no"
							id="p_no" value="${updateData.p_no}" /> <input type="hidden"
							name="p_image" id="p_image" value="${updateData.p_image}" /> <input
							type="hidden" name="pm_image" id="pm_image"
							value="${updateData.pm_image}" /> <input type="hidden"
							name="p_storyimage" id="p_storyimage"
							value="${updateData.p_storyimage}" />
					</div>
					<div class="panel-group" id="accordion" role="tablist"
						aria-multiselectable="true">
						<div class="panel panel-default">
							<div class="panel-heading" role="tab" id="headingOne">
								<h4 class="panel-title">
									<a data-toggle="collapse" data-parent="#accordion"
										href="#collapseOne" aria-expanded="ture"
										aria-controls="collapseOne">프로젝트 개요</a>
								</h4>
							</div>
							<div id="collapseOne" class="panel-collapse collapse in"
								role="tabpanel" aria-labelledby="headingOne">
								<div class="panel-body w3-theme-light">

									<div>
										<div
											class="w3-padding-16 w3-panel w3-border w3-hover-border-black">
											<label class="w3-margin-left"> 프로젝트 제목</label><br> <input
												type="text" class=" w3-animate-input w3-margin-left"
												style="width: 40%" name="p_title" id="p_title" value="${updateData.p_title}"><br>
										</div>

										<div
											class="w3-padding-16 w3-panel w3-border w3-hover-border-black">
											<label class="w3-margin-left">프로젝트 대표이미지</label><br> <input
												type="file" class="w3-margin-left" name="p_file" id="p_file">기존이미지 파일명: ${updateData.p_image}
										</div>


										<div
											class="w3-padding-16 w3-panel w3-border w3-hover-border-black">
											<label class="w3-margin-left">프로젝트 카테고리</label><br> <select
												class="w3-margin-left" id="p_type" name="p_type">
												<option value="${updateData.p_type}" >이전 선택(${updateData.p_type})</option>
												<option value="crafts">공예</option>
												<option value="culture">문화</option>
												<option value="art">미술</option>
												<option value="book">출판</option>
											</select>
										</div>

										<div
											class="w3-padding-16 w3-panel w3-border w3-hover-border-black">
											<label class="w3-margin-left ">프로젝트 요약</label><br> <input
												type="text" class=" w3-animate-input w3-margin-left"
												style="width: 40%" name="p_summary" id="p_summary" value="${updateData.p_summary}">
										</div>
									</div>

								</div>
							</div>
						</div>


						<div class="panel panel-default">
							<div class="panel-heading" role="tab" id="headingTwo">
								<h4 class="panel-title">
									<a class="collapsed" data-toggle="collapse"
										data-parent="#accordion" href="#collapseTwo"
										aria-expanded="ture" aria-controls="collapseTwo">진행자 정보</a>
								</h4>
							</div>
							<div id="collapseTwo" class="panel-collapse collapse"
								role="tabpanel" aria-labelledby="headingTwo">
								<div class="panel-body w3-theme-light">
									<div
										class="w3-padding-16 w3-panel w3-border w3-hover-border-black">
										<label class="w3-margin-left">프로필 이미지</label><br> <input
											type="file" class="w3-margin-left" name="pm_file"
											id="pm_file">기존	이미지 파일명: ${updateData.pm_image}
									</div>

									<div
										class="w3-padding-16 w3-panel w3-border w3-hover-border-black">
										<label class="w3-margin-left">진행자 이름</label><br> <input
											type="text" class="w3-margin-left w3-center"
											style="width: 15%" name="pm_name" id="pm_name"
											value="${updateData.pm_name}">
									</div>

									<div
										class="w3-padding-16 w3-panel w3-border w3-hover-border-black">
										<label class="w3-margin-left">진행자 활동지역</label><br> <input
											type="text" class="w3-margin-left w3-center"
											style="width: 15%" name="pm_area" id="pm_area" value="${updateData.pm_area}">
									</div>

									<div
										class="w3-padding-16 w3-panel w3-border w3-hover-border-black">
										<label class="w3-margin-left">진행자 소개</label><br>
										<textarea class="form-control w3-margin-left" rows="2"
											name="pm_intro" id="pm_intro">${updateData.pm_intro}</textarea>
									</div>

								</div>
							</div>
						</div>

						<div class="panel panel-default">
							<div class="panel-heading" role="tab" id="headingThree">
								<h4 class="panel-title">
									<a class="collapsed" data-toggle="collapse"
										data-parent="#accordion" href="#collapseThree"
										aria-expanded="false" aria-controls="collapseThree">펀딩 및
										리워드</a>
								</h4>
							</div>
							<div id="collapseThree" class="panel-collapse collapse"
								role="tabpanel" aria-labelledby="headingThree">
								<div class="panel-body w3-theme-light">
									<h4>펀딩 목표 설정</h4>
									<div
										class="w3-padding-16 w3-panel w3-border w3-hover-border-black">
										<label class="w3-margin-left">목표금액</label><br>
										<p class="text-info w3-margin-left">
											이번 프로젝트를 통해 모으고자 하는 펀딩 목표 금액이 얼마인가요?<br> 마감일 자정까지 목표 금액을
											100% 이상 달성하셔야만 모인 후원금이 결제 됩니다.<br> 막판에 후원을 취소하는 후원자들도 있는
											점을 감안해 10% 이상 초과 달성을 목표로 하시는게 안전합니다.<br> (목표 금액은 제작비, 선물
											배송비, 진행자의 인건비, 예비 비용 등을 고려하시기 바랍니다.)<br>
										</p>
										<input type="text" class="w3-margin-left" name="p_price_input"
											id="p_price_input" style="text-align: right"
											onchange="newprices()"  value="${updateData.p_price}">원 <br>
										<p class="w3-margin-left">
											수수료(플렛폼수수료(5%)) 공제 후 금액은 { <input type="text"
												name="real_price" id="real_price" style="text-align: right"
												onkeyup="real_price()" readonly style="border: 0;">
											}원입니다. <input type="hidden" name="p_price" id="p_price">
									</div>

									<div
										class="w3-padding-16 w3-panel w3-border w3-hover-border-black">
										<label class="w3-margin-left">프로젝트 마감일</label><br>
										<p class="text-info w3-margin-left">
											펀딩이 끝나는 마감일을 정해주세요<br> 펀딩 마감일은 오늘로부터 60일 이내의 날짜 중에 고르실 수
											있습니다.<br> 이미 선물을 만드셨다면, 선물 실행일 중에 마감일 보다 이른 날짜가 있지는 않은지
											꼭 확인해 주세요.<br>
										</p>
										<p class="w3-margin-left">
											오늘로부터<input type="number" class="w3-margin-left w3-center"
												style="width: 10%" name="p_fundingdate" id="p_fundingdate"
												onchange="newdate(this.form)" value="${updateData.p_fundingdate}">일 뒤인 <input
												type="text" class="w3-margin-left w3-center"
												style="width: 15%" name="p_enddate_input"
												id="p_enddate_input" readonly value=" ${updateData.p_enddate_input}">에 펀딩을 마감합니다.
											<input type="hidden" name="p_enddate" id="p_enddate" value=" ${updateData.p_enddate}">
									</div>

									<div
										class="w3-padding-16 w3-panel w3-border w3-hover-border-black">
										<label class="w3-margin-left">예상 정산일</label><br>
										<p class="w3-margin-left">
											모금에 성공할 경우 지급 확정일은 <input type="text"
												class="w3-margin-left w3-center" style="width: 15%"
												name="p_paydate_input" id="p_paydate_input" value="${updateData.p_paydate_input}" readonly>입니다.
											<input type="hidden" name="p_paydate" id="p_paydate" value="${updateData.p_paydate}">
									</div>

									<h4>
										<STRONG>리워드 설정</STRONG>
									</h4>

									<div
										class="w3-padding-16 w3-panel w3-border w3-hover-border-black">
										<p class="w3-margin-left">선물 추가하기</p>
										<p class="text-info w3-margin-left">후원자 분들에게 드릴 선물 내용을
											입력해주세요.</p>
										<label class="w3-margin-left">선물 명</label><br> <input
											type="text" class="w3-margin-left"
											class="w3-margin-left w3-center" style="width: 20%"
											name="p_giftname" id="p_giftname" value="${updateData.p_giftname}">
									</div>

									<div
										class="w3-padding-16 w3-panel w3-border w3-hover-border-black">
										<label class="w3-margin-left">선물 개수</label><br> <input
											type="text" class="w3-margin-left w3-center"
											style="width: 15%" name=p_giftquantity id="p_giftquantity" value="${updateData.p_giftquantity}">개
									</div>

									<div
										class="w3-padding-16 w3-panel w3-border w3-hover-border-black">
										<label class="w3-margin-left">선물 가격</label><br> <input
											type="text" class="w3-margin-left w3-center"
											style="width: 15%" name="p_giftprice" id="p_giftprice" value="${updateData.p_giftprice}">원
									</div>

									<div
										class="w3-padding-16 w3-panel w3-border w3-hover-border-black">
										<label class="w3-margin-left">선물 설명</label><br> <input
											type="text" class="w3-margin-left" name="p_giftexplanation"
											id="p_giftexplanation" value="${updateData.p_giftexplanation}">
									</div>

									<div
										class="w3-padding-16 w3-panel w3-border w3-hover-border-black">
										<label class="w3-margin-left">선물 전달일</label><br>
										<p class="w3-margin-left">
											리워드 전달일은 <input type="date" name="p_giftdate" id="p_giftdate"
												width="15" style="text-align: right" value="${updateData.p_giftdate}">입니다.
									</div>

									<div
										class="w3-padding-16 w3-panel w3-border w3-hover-border-black">
										<label class="w3-margin-left">교환 및 환불</label><br>
										<p class="text-info w3-margin-left">
											마감일 다음날 결제가 일괄 진행되며 결제된 금액은 자동으로 진행자에게 전달되므로, 그 후의 환불 및 교환
											요청은 전적으로 진행자가 약속하는 정책을 따릅니다. 이 프로젝트에 꼭 맞는 환불 및 교환 정책을 신중하게
											작성해주세요.
											<textarea class="form-control" rows="2" name="p_refund"
												id="p_refund">${updateData.p_refund}</textarea>
									</div>

								</div>
							</div>
						</div>

						<div class="panel panel-default">
							<div class="panel-heading" role="tab" id="headingFour">
								<h4 class="panel-title">
									<a class="collapsed" data-toggle="collapse"
										data-parent="#accordion" href="#collapseFour"
										aria-expanded="false" aria-controls="collapseFour">스토리 텔링</a>
								</h4>
							</div>
							<div id="collapseFour" class="panel-collapse collapse"
								role="tabpanel" aria-labelledby="headingFour">
								<div class="panel-body w3-theme-light">
									<h4>
										<STRONG>프로젝트 스토리</STRONG>
									</h4>
									<textarea
										class="w3-padding-16 w3-panel w3-border w3-hover-border-black"
										name="p_story" id="p_story" rows="10" cols="80"> ${updateData.p_story} </textarea>
									<script>
										// Replace the <textarea id="editor1"> with a CKEditor
										// instance, using default configuration.
										CKEDITOR.replace('p_story');
									</script>
									<input type="file" name="ps_file" id="ps_file">기존이미지 파일명: ${updateData.p_storyimage}</input>
								</div>
							</div>
						</div>

						<div class="panel panel-default">
							<div class="panel-heading" role="tab" id="headingFive">
								<h4 class="panel-title">
									<a class="collapsed" data-toggle="collapse"
										data-parent="#accordion" href="#collapseFive"
										aria-expanded="false" aria-controls="collapseFive"> 계좌설정</a>
								</h4>
							</div>
							<div id="collapseFive" class="panel-collapse collapse"
								role="tabpanel" aria-labelledby="headingFive">
								<div class="panel-body w3-theme-light">

									<h4>
										<strong>연락처 인증</strong>
									</h4>

									<div
										class="w3-padding-16 w3-panel w3-border w3-hover-border-black">
										<label class="w3-margin-left">이메일 주소</label><br> <input
											type="email" class="w3-margin-left" name="pm_email"
											id="pm_email" value="${updateData.pm_email}">
									</div>

									<div
										class="w3-padding-16 w3-panel w3-border w3-hover-border-black">
										<label class="w3-margin-left">휴대폰 번호</label><br> <input
											type="text" class="w3-margin-left" style="width: 23%" name="pm_phone"
											id="pm_phone" value="${updateData.pm_phone}">
									</div>

									<h4>
										<strong>입금계좌</strong>
									</h4>

									<div
										class="w3-padding-16 w3-panel w3-border w3-hover-border-black">
										<label class="w3-margin-left">거래 은행</label><br> <select
											class="w3-margin-left" id="pm_bank" name="pm_bank">
											<option value="${updateData.pm_bank}">이전선택(${updateData.pm_bank})</option>
											<option value="wuri">우리</option>
											<option value="kb">국민</option>
											<option value="shinhan">신한</option>
											<option value="web">외환</option>
											<option value="ibk">기업</option>
										</select>
									</div>

									<div
										class="w3-padding-16 w3-panel w3-border w3-hover-border-black">
										<label class="w3-margin-left">예금주명</label><br> <input
											type="text" class="w3-margin-left" style="width: 15%" name="pm_acountname"
											id="pm_acountname" value="${updateData.pm_acountname}">
									</div>

									<div
										class="w3-padding-16 w3-panel w3-border w3-hover-border-black">
										<label class="w3-margin-left">계좌번호</label><br> <input
											type="text" class="w3-margin-left" style="width: 23%" name="pm_acount"
											id="pm_acount" value="${updateData.pm_acount}">
									</div>

									<div
										class="w3-padding-16 w3-panel w3-border w3-hover-border-black">
										<label class="w3-margin-left">생년월일</label><br> <input
											type="text" class="w3-margin-left" style="width: 23%" name="pm_birthday"
											id="pm_birthday" value="${updateData.pm_birthday}">
									</div>
								</div>
							</div>
						</div>
						<!-- 계정 등록 수정 끝  -->
					</div>
					<!-- createForm 끝 -->
				</form>
				<!-- 아코디언 그룹 끝 -->
			</div>
		<!-- 전체 컨테이너 끝 -->
		</div>
</body>
</html>