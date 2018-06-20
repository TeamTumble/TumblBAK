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
<title>후원하기</title>
<!-- CSS -->
<link rel="stylesheet" type="text/css"
	href="/resources/include/css/common.css" />
<link rel="stylesheet" type="text/css"
	href="/resources/include/css/board.css" />

<!-- SCRIPT -->
<!-- 다음 우편번호 스크립트 -->
<!-- SCRIPT -->

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>

<script type="text/javascript">
	function lookupAddress() {
		new daum.Postcode(
				{
					oncomplete : function(data) {
						// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

						// 각 주소의 노출 규칙에 따라 주소를 조합한다.
						// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
						var fullAddr = ''; // 최종 주소 변수
						var extraAddr = ''; // 조합형 주소 변수

						// 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
						if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
							fullAddr = data.roadAddress;

						} else { // 사용자가 지번 주소를 선택했을 경우(J)
							fullAddr = data.jibunAddress;
						}

						// 사용자가 선택한 주소가 도로명 타입일때 조합한다.
						if (data.userSelectedType === 'R') {
							//법정동명이 있을 경우 추가한다.
							if (data.bname !== '') {
								extraAddr += data.bname;
							}
							// 건물명이 있을 경우 추가한다.
							if (data.buildingName !== '') {
								extraAddr += (extraAddr !== '' ? ', '
										+ data.buildingName : data.buildingName);
							}
							// 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
							fullAddr += (extraAddr !== '' ? ' (' + extraAddr
									+ ')' : '');
						}

						// 우편번호와 주소 정보를 해당 필드에 넣는다.
						document.getElementById('s_zipcode').value = data.zonecode; //5자리 새우편번호 사용
						document.getElementById('s_address').value = fullAddr;

						// 커서를 상세주소 필드로 이동한다.
						document.getElementById('s_address').focus();
					}
				}).open();
	}

	//매소드 포함이기 때문에 
	//제이쿼리로 재 정의
	function cal() {
		$(function() {

			//4차 성공
			oldprice = $("#p_giftprice").val();
			quantity = $("#s_giftquantity").val();
			newprice = oldprice * quantity;
			$("#s_giftprice").val(newprice);
			newprice = parseInt(document.getElementById('s_giftprice').value)
			addprice = parseInt(document.getElementById('s_addprice').value)
			totalprice = newprice + addprice;
			$("#s_price").val(totalprice);
		});

	}

	$(function() {

		console.log("${detail.email}");
		console.log("${detail.pno}");

		//초기 선물 값에 금액표기용
		oldprice = $("#p_giftprice").val();
		quantity = $("#s_giftquantity").val();
		newprice = oldprice * quantity;
		$("#s_giftprice").val(newprice);
		addprice = parseInt(document.getElementById('s_addprice').value)
		totalprice = newprice + addprice;
		$("#s_price").val(totalprice);

		// 버튼 액션 파트
		/* 후원하기 버튼 클릭 시 처리 이벤트  리스트로 보냄*/
		$("#cancelBtn").click(function() {
			location.href = "/project/projectList.do";
		});

		/* 후원신청 버튼 클릭 시 처리 이벤트 */
		/* 등록 실행 버튼*/
		$("#supportBtn").click(function() {
			//입력값 체크
			if ($("#s_paymentcheck").is(":checked") == false) {
				alert("약관 동의는 필수입니다.");
				$("# s_paymentcheck ").focus();
				return
			}
			{
				$("#s_createForm").attr({
					"method" : "POST",
					"action" : "/support/supportInsert.do"
				});
				$("#s_createForm").submit();
			}
		})

	});
</script>
</head>
<body>
	<div class="contentContainer" align="center" style="height: 1150px">
		<!-- 후원하기 타이틀 -->
		<div class="contentTit"></div>
		<!-- 후원하기 타이틀끝  -->
		<form id="s_createForm" name="s_createForm">

			<!-- 리워드 선택하기 틀-->
			<div>
				<p align="left"
					style="width: 80%; text-shadow: 0.5px 0.5px 0 #444; font-size: x-large;; margin-bottom: 5px">리워드
					선택</p>
				<!-- 리워드 선택 및 수량 체크 부분 -->
				<div class="w3-theme-l3 w3-round-large" style="width: 80%">
					<table class="table" style="width: 95%;">
						<tr hidden="">
							<td><input type="hidden" name="email" id="email"
								value="${login.email}" /> <input type="hidden" name="pno"
								id="pno" value="${detail.pno}" /> <input type="hidden"
								name="p_title" id="p_title" value="${detail.p_title}"> <input
								type="hidden" class="s_supporter" id="s_supporter"
								name="s_supporter" value="1"><input type="hidden"
								name="s_no" id="s_no" value="${detail.s_no}" /></td>

						</tr>
						<colgroup>
							<col width="10%" />
							<col width="20%" />
							<col width="20%" />
							<col width="15%" />
							<col width="35%" />
						</colgroup>
						<tbody>
							<tr align="center" style="padding-top: 20px; font-size: large;">
								<td>번호</td>
								<td>선물명</td>
								<td>선물가격</td>
								<td>수량</td>
								<td>합계</td>
							</tr>
							<tr align="center" style="font-size: large;">
								<td>1.</td>
								<td style="font-size: medium; font-weight: bold;">${detail.p_giftname}<input
									type="hidden" value="${detail.p_giftname}" class="s_giftname"
									id="s_giftname" name="s_giftname" readonly></td>
								<td style="font-size: medium; font-weight: bold;">${detail.p_giftprice}원<input
									type="hidden" value="${detail.p_giftprice}" class="p_giftprice"
									id="p_giftprice" name="p_giftprice" readonly></td>
								<td style="font-size: medium; font-weight: bold;"><input
									type="number" value="1" class="s_giftquantity"
									id="s_giftquantity" name="s_giftquantity" onchange="cal();"
									style="text-align: center; width: 40%">개</td>
								<td style="font-size: medium; font-weight: bold;" align="right"><input
									type="text" class="s_giftprice" id="s_giftprice"
									name="s_giftprice" style="text-align: right; width: 80%"
									readonly>원</td>
							</tr>
							<tr>

								<td colspan="4"
									style="border-bottom: 1px solid black; border-top: 1px solid black; text-align: center;"><p
										style="font-size: medium; font-weight: bold; margin-top: 5px; margin-bottom: 5px;">선물
										선택 외 추가적인 금액을 후원합니다.</td>
								<td align="right"
									style="border-bottom: 1px solid black; border-top: 1px solid black;">
									<input type="text" value="0" class="s_addprice" id="s_addprice"
									name="s_addprice"
									style="text-align: right; width: 80%; margin-top: 6px; margin-bottom: 5px"
									onkeyup="cal();">원
								</td>
							</tr>
							<tr>
								<td colspan="4"
									style="padding-bottom: 20px; padding-top: 10px; margin-top: 10px; font-size: medium; font-weight: bold; text-align: center;">총
									합 계</td>
								<td align="right"><input type="text" class="s_price"
									id="s_price" name="s_price"
									style="text-align: right; font-size: medium; width: 80%"
									readonly>원</td>
							</tr>
						</tbody>
					</table>
				</div>

			</div>
			<!-- 리워드 선택하기 틀 끝-->


			<h4 align="left"
				style="width: 80%; margin-top: 20px; text-shadow: 0.5px 0.5px 0 #444; font-size: x-large; margin-bottom: 5px">배송지
				입력</h4>

			<!-- 베송지 입력 틀-->
			<div class="panel-body w3-theme-l3 w3-round-large"
				style="width: 80%;" align="left">

				<div>
					<p style="text-shadow: 0.2px 0.2px 0 #444; margin-bottom: 5px">우편
						번호</p>
					<input type="text" class="s_zipcode" id="s_zipcode"
						placeholder="검색" name="s_zipcode"
						style="width: 20%; margin-bottom: 10px; text-align: center; border-color: grey; border-radius: 4px;"
						readonly><input type="button" onclick="lookupAddress()"
						value="우편번호 찾기"><br>
				</div>
				<div>
					<p style="margin-bottom: 5px">주소 입력</p>
					<input type="text" placeholder="내용입력" class="s_address"
						id="s_address" name="s_address"
						style="width: 100%; margin-bottom: 10px; text-align: center; border-color: grey; border-radius: 4px;">
				</div>

				<!-- 받는 사람 -->
				<div>
					<p style="margin-bottom: 5px">받으시는 분</p>
					<input type="text" class="s_name" id="s_name" name="s_name"
						style="width: 20%; margin-bottom: 10px; text-align: center; border-color: grey; border-radius: 4px;"
						placeholder="이름을 넣어주세요">
				</div>
				<div>
					<p style="margin-bottom: 5px">이메일</p>
					<input type="email" class="s_email" id="s_email" name="s_email"
						style="width: 35%; margin-bottom: 10px; text-align: center; border-color: grey; border-radius: 4px;"
						placeholder="이메일주소">
				</div>
				<div>
					<p style="margin-bottom: 5px">휴대전화</p>
					<input type="text" class="s_phone" id="s_phone" name="s_phone"
						style="width: 35%; text-align: center; border-color: grey; border-radius: 4px;"
						placeholder="'-'을 제외한 숫자">
				</div>
			</div>
			<!-- 배송지 입력 틀 끝-->

			<h3 align="left" style="margin-top: 20px; width: 80%">
				<strong>결제 안내</strong>
			</h3>
			<!-- 결제 안내 틀 -->
			<div align="center"
				style="width: 80%; border: 1px solid; padding: 20px">

				<!-- 관리자 안내  -->
				<div>
					<div>
						<div>
							<p align="center" style="font-size: large;">
								<strong>저희 텀블박에서는 무통장 입금으로 결제가 진행이 됩니다.<br> 프로젝트의
									은행과 계좌를 드리오니 프로젝트 일정에 맞게 입금 부탁드립니다.
								</strong>
						</div>
						<div>
							<p align="left"
								style="font-size: larger; border: 2px solid; padding-left: 130px;; width: 60%">
								<strong>거래 은행: 국민은행 <br> 계좌 번호: 017002-04-312107
								</strong>
						</div>
						<div style="width: 70%" align="left">
							<ul type="disc">
								<li style="color: red">(주의) 프로젝트 일정 기간 외 입금을 하실 경우 입금에 제한이
									있을 수 있습니다.</li>
								<li style="color: red">(주의) 프로젝트 달성 후 입금완료 후 교환 환불은 창작자와
									협의를 하셔야 합니다.</li>
								<li>프로젝트가 목표금액을 모두 달성할 경우 결제가 진행됩니다.</li>
								<li>프로젝트에 후원을 원하시는 분께서는 위 사항에 동의 후 후원를 신청바랍니다.</li>
							</ul>
						</div>
						<div align="center"
							class="w3-panel w3-border w3-hover-border-black"
							style="width: 20%; margin: 6px; padding: 2px">
							<label for="s_paymentcheck"
								style="cursor: pointer; font-size: large;"> 위 사항에 동의 </label> <input
								type="checkbox" class="s_paymentcheck" id="s_paymentcheck"
								name="s_paymentcheck" style="border: 1px solid;">
						</div>

					</div>
				</div>
			</div>
			<!-- 결제 안내 틀 끝-->
		</form>

		<!-- 후원하기 및 취소 버튼 -->
		<div class="button" align="right" style="width: 80%; margin-top: 10px">
			<!-- 취소 -->
			<input type="button" style="size: auto; font-size: large;" value="취소"
				id="cancelBtn">
			<!-- 후원하기 -->
			<input type="button" style="size: auto; font-size: large;"
				value="후원 신청" id="supportBtn">
		</div>

	</div>
</body>
</html>