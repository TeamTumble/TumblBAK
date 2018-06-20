<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로젝트 등록</title>
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
	/* 날짜 변환 기능*/
	function newdate(p_createForm) {
		/* 1차 방법*/
		/* 	var st_date = new Date($("#p_startdate").val());
			var plus_date= $("#p_fundingdate").val();
			var dayOfMonth = st_date.getDate();
			var end_date;
			end_date.setDate(dayOfMonth + plus_date);
			("#p_enddate").val(end_date);
		 */

		/* 2차 방법*/
		/* 	my_date = new Date();
			var ISOData = my_date.toISOString();
			var ISODate = ISOData.split("T",1);
			
			document.write(ISODate); //결과는 2017-3-6 
			
			 var currDate = new Date(); // 현재 날짜 생성
			 currDate=dateToYYYYMMDD(currDate);

			var strDate1 = currDate; // 2017-3-6 형식으로  받기
			var arr1 = strDate1.split('-');
			var dat1 = new Date(arr1[0], arr1[1], arr1[2]);
			var plusDate = $("#p_fundingdate").val(); // 문자열  숫자로
			
			var month = my_date.getMonth();
			var day = my_date.getDate()+"plusDate";
			var year = my_date.getFullYear();	
			var plusDate = $("#p_fundingdate").val();
			
			my_date = new Date(year,month,day);
			
			my_date.setDate(my_date.getDate());
			
			$("#p_enddate").val(my_date);
			
		 */

		/*3차방법*/
		plusDate = $("#p_fundingdate").val();
		var now = new Date();
		var newdate = new Date();
		var newtimems = newdate.getTime() + (plusDate * 24 * 60 * 60 * 1000);
		newdate.setTime(newtimems);
		document.p_createForm.p_enddate.value = newdate.toString();
		document.p_createForm.p_enddate_input.value = newdate
				.toLocaleDateString();
		/*예산 지급일 */
		newdate.setTime(newtimems + (7 * 24 * 60 * 60 * 1000));
		document.p_createForm.p_paydate.value = newdate.toLocaleDateString();
		document.p_createForm.p_paydate_input.value = newdate
				.toLocaleDateString();

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

	/* function numberWithCommas(x) {
	    return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
	} */

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

	/* 버튼 기능 */
	$(function() {

		/*가이드 실행 버튼*/
		$("#projectGuideBtn").click(function() {
			location.href = "/project/projectGuide.do";
		});

		/* 등록 실행 버튼*/
		$("#projectInsertBtn").click(function() {
			//입력값 체크
			if (!chkSubmit($('#p_title'), "제목을"))
				return;
			else if (!chkSubmit($('#pm_name'), "이름을"))
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

				$("#p_createForm").attr({
					"method" : "POST",
					"action" : "/project/projectInsert.do"
				});
				$("#p_createForm").submit();
			}
		})
	});
</script>


</head>
<body>
	<div class="contentContainer">

		<div class="contentTit">
			<h3>프로젝트 등록하기</h3>
		</div>

		<div class="contentTB">
			<form id="p_createForm" name="p_createForm"
				enctype="multipart/form-data">
				<table id="projectCreate" style="border: 1px solid #ccc">
					<colgroup>
						<col width="80%" />
						<col width="20%" />
					</colgroup>
					<!-- 프로젝트 작성 개요 부분 -->
					<tr hidden="">
						<td><input type="hidden" name="email" id="email"
							value="${member.email}" /> <input type="hidden"
							name="p_collection" id="p_collection" value="0"> <input
							type="hidden" name="p_supporter" id="p_supporter" value="0">
						</td>
					</tr>
					<tr>
						<td class="ac">프로젝트 개요</td>
						<td><input type="button" value="가이드 보기" class="but"
							id="projectGuideBtn"></td>
					</tr>
					<tr>
						<td class="ac">프로젝트 제목</td>
					</tr>
					<tr>
						<td><input type="text" name="p_title" id="p_title"></td>
					</tr>

					<tr>
						<td class="ac">프로젝트 대표 이미지</td>
					</tr>
					<tr>
						<td><input type="file" name="p_file" id="p_file"></td>
					</tr>

					<tr>
						<td class="ac">프로젝트 카테고리</td>
					</tr>
					<tr>
						<td><select id="p_type" name="p_type">
								<option>분야 선택</option>
								<option value="crafts">공예</option>
								<option value="culture">문화</option>
								<option value="art">미술</option>
								<option value="book">출판</option>
						</select></td>
					</tr>

					<tr>
						<td class="ac">프로젝트 요약</td>
					</tr>
					<tr>
						<td><input type="text" name="p_summary" id="p_summary"></td>
					</tr>

					<!-- 프로젝트 작성 프로필 부분 -->

					<tr>
						<td class="ac">진행자 정보</td>
					</tr>
					<tr>
						<td class="ac">프로필 이미지</td>
					</tr>
					<tr>
						<td><input type="file" name="pm_file" id="pm_file"></td>
					</tr>

					<tr>
						<td class="ac">진행자 이름</td>
					</tr>
					<tr>
						<td><input type="text" name="pm_name" id="pm_name"
							value="${member.m_name}"></td>
					</tr>

					<tr>
						<td class="ac">진행자 활동지역</td>
					</tr>
					<tr>
						<td><input type="text" name="pm_area" id="pm_area"></td>
					</tr>

					<tr>
						<td class="ac">진행자 소개</td>
					</tr>
					<tr>
						<td><textarea name="pm_intro" id="pm_intro"></textarea></td>
					</tr>


					<!-- 프로젝트 작성 선물등록 부분  -->
					<tr>
						<td class="ac">펀딩 및 리워드</td>
					</tr>
					<tr>
						<td class="ac">펀딩 목표 설정</td>
					</tr>
					<tr>
						<td class="ac">목표금액</td>
					</tr>
					<tr>
						<td><p>
								이번 프로젝트를 통해 모으고자 하는 펀딩 목표 금액이 얼마인가요?<br> 마감일 자정까지 목표 금액을
								100% 이상 달성하셔야만 모인 후원금이 결제 됩니다.<br> 막판에 후원을 취소하는 후원자들도 있는 점을
								감안해 10% 이상 초과 달성을 목표로 하시는게 안전합니다.<br> 목표 금액은 제작비, 선물 배송비,
								진행자의 인건비, 예비 비용 등을 고려하시기 바랍니다.<br></td>
					</tr>
					<tr>
						<td><input type="text" name="p_price_input"
							id="p_price_input" style="text-align: right"
							onchange="newprices()">원 <br>수수료(플렛폼수수료(5%)) 공제 후
							금액은 { <input type="text" name="real_price" id="real_price"
							style="text-align: right" onkeyup="real_price()" readonly
							style="border: 0;"> }원입니다. <input type="hidden"
							name="p_price" id="p_price">
					</tr>


					<tr>
						<td class="ac">프로젝트 마감일</td>
					</tr>
					<tr>
						<td>펀딩이 끝나는 마감일을 정해주세요<br> 펀딩 마감일은 오늘로부터 60일 이내의 날짜 중에
							고르실 수 있습니다.<br> 이미 선물을 만드셨다면, 선물 실행일 중에 마감일 보다 이른 날짜가 있지는
							않은지 꼭 확인해 주세요.<br>
						</td>
					</tr>
					<tr>
						<td>오늘로부터<input type="number" name="p_fundingdate"
							id="p_fundingdate" onchange="newdate(this.form)">일 뒤인 <input
							type="text" name="p_enddate_input" id="p_enddate_input" readonly
							value="">에 펀딩을 마감합니다. <input type="hidden"
							name="p_enddate" id="p_enddate">
						</td>
					</tr>

					<tr>
						<td class="ac">예상 정산일</td>
					</tr>
					<tr>
						<td>지급 확정일은 7일 뒤인<input type="text" name="p_paydate_input"
							id="p_paydate_input" width="15" readonly>입니다. <input
							type="hidden" name="p_paydate" id="p_paydate">
						</td>
					</tr>


					<tr>
						<td class="ac">리워드 설정</td>
					</tr>
					<tr>
						<td class="ac">선물 추가하기<br>
							<p>후원자 분들에게 드릴 선물 내용을 입력해주세요.</p></td>
					</tr>

					<tr>
						<td class="ac">선물 명</td>
					</tr>
					<tr>
						<td><input type="text" name="p_giftname" id="p_giftname"></td>
					</tr>

					<tr>
						<td class="ac">선물 개수</td>
					</tr>
					<tr>
						<td><input type="text" name=p_giftquantity
							id="p_giftquantity"></td>
					</tr>

					<tr>
						<td class="ac">선물 가격</td>
					</tr>
					<tr>
						<td><input type="text" name=p_giftprice id="p_giftprice"></td>
					</tr>

					<tr>
						<td class="ac">선물 설명</td>
					</tr>
					<tr>
						<td><input type="text" name="p_giftexplanation"
							id="p_giftexplanation"></td>
					</tr>

					<tr>
						<td class="ac">선물 전달일</td>
					</tr>

					<tr>
						<td>리워드 전달일은 <input type="date" name="p_giftdate"
							id="p_giftdate" width="15" style="text-align: right">입니다.
						</td>
					</tr>

					<tr>
						<td class="ac">교환및환불</td>
					</tr>
					<tr>
						<td><textarea name="p_refund" id="p_refund"></textarea></td>
					</tr>



					<!-- 프로젝트 작성 스토리텔링 부분 -->
					<tr>
						<td class="ac">스토리 텔링</td>
					</tr>
					<tr>
						<td class="ac">프로젝트 스토리</td>
					</tr>
					<tr>
						<td><textarea name="p_story" id="p_story" rows="10" cols="80">  </textarea>
							<script>
								// Replace the <textarea id="editor1"> with a CKEditor
								// instance, using default configuration.
								CKEDITOR.replace('p_story');
							</script></td>
					</tr>
					<tr>
						<td><input type="file" name="ps_file" id="ps_file"></input></td>
					</tr>


					<!-- 프로젝트 작성 계정 설정 부분 -->
					<tr>
						<td class="ac">계좌설정</td>
					</tr>
					<tr>
						<td class="ac">연락처 인증</td>
					</tr>
					<tr>
						<td class="ac">이메일 주소</td>
					</tr>
					<tr>
						<td><input type="text" name="pm_email" id="pm_email"></td>
					</tr>

					<tr>
						<td class="ac">휴대폰 번호</td>
					</tr>
					<tr>
						<td><input type="text" name="pm_phone" id="pm_phone"></td>
					</tr>

					<tr>
						<td class="ac">입금 계좌</td>
					</tr>
					<tr>
						<td class="ac">거래 은행</td>
					</tr>
					<tr>
						<td><select id="pm_bank" name="pm_bank">
								<option>은행 선택</option>
								<option value="wuri">우리</option>
								<option value="kb">국민</option>
								<option value="shinhan">신한</option>
								<option value="web">외환</option>
								<option value="ibk">기업</option>
						</select></td>
					</tr>

					<tr>
						<td class="ac">예금주명</td>
					</tr>
					<tr>
						<td><input type="text" name="pm_acountname"
							id="pm_acountname"></td>
					</tr>

					<tr>
						<td class="ac">계좌번호</td>
					</tr>
					<tr>
						<td><input type="text" name="pm_acount" id="pm_acount"></td>
					</tr>

					<tr>
						<td class="ac">생년월일</td>
					</tr>
					<tr>
						<td><input type="text" name="pm_birthday" id="pm_birthday"></td>
					</tr>

				</table>
			</form>
		</div>

		<!-- 프로젝트 작성 버튼 부분 -->
		<div class="projectCreatBtn">
			<input type="button" value="수정하기" class="but" id="projectUpdateBtn">
			<input type="button" value="취소" class="but" id="MainListBtn">
			<input type="button" value="등록완료 검토요청" class="but"
				id="projectInsertBtn">
		</div>
	</div>

</body>
</html>