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
	href="https://www.w3schools.com/lib/w3-theme-black.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css">

<title>프로젝트 시작하기</title>
<script type="text/javascript">
	$(function() {

		/*라이너 실행 버튼*/
		$("#stbt").click(function() {
			location.href = "/project/projectCreate.do";
				
		});
		$("#stbt2").click(function() {
			location.href = "/project/projectCreate.do";
				
		});

	});
</script>
</head>
<body style="width: 100%">

	<!-- Header -->
	<header class="w3-container w3-theme w3-padding" id="myHeader">
		<div class="w3-center">
			<h4>마음 속 프로젝트 아이디어</h4>
			<h1 class="w3-xxxlarge w3-animate-bottom">텀블박에서 현실로!!</h1>
			<div class="w3-padding-32">
				<button class="w3-btn w3-xlarge w3-dark-grey w3-hover-light-grey"
					style="font-weight: 900;" name="stbt" id="stbt">지금 시작하기</button>
			</div>
		</div>
	</header>

	<div class="w3-container" style="text-align: center; width: 100%">
		<hr>

		<div class="w3-center w3-large">
			<h2>쉽게 시작할 수 있습니다.</h2>
			<label style="width: 80%">‘크라우드펀딩’은 어려울지 몰라도 텀블박은 어렵지 않습니다.
				수익을 내서 현금을 돌려주거나 소유권을 나누는 등의 복잡한 과정도 필요하지 않습니다. 펀딩으로 모은 금액을 통해 만들어낸
				선물(제품)을 후원자들과 약속하고 공유하면 됩니다.</label>
		</div>

		<div class="w3-row-padding w3-center w3-margin-top">
			<div class="w3-third">
				<div class="w3-card w3-container" style="min-height: 350px">
					<h3>프로젝트 올리기</h3>
					<br> <i class="fa fa-desktop w3-margin-bottom w3-text-theme"
						style="font-size: 120px"></i>
					<p>창작 아이디어를 소개하는</p>
					<p>프로젝트 페이지를 작성합니다.</p>
					<p>후원자들에게 금액대별 특별한</p>
					<p>선물들을 약속합니다.</p>
				</div>
			</div>

			<div class="w3-third">
				<div class="w3-card w3-container" style="min-height: 350px">
					<h3>펀딩 진행하기</h3>
					<br> <i
						class="fa fa-refresh w3-spin w3-margin-bottom w3-text-theme"
						style="font-size: 120px"></i>
					<p>정해진 기간 동안 후원자를 모으기</p>
					<p>위해 열심히 홍보합니다. 목표</p>
					<p>금액을 달성해야만 후원금이</p>
					<p>전달됩니다.</p>
				</div>
			</div>

			<div class="w3-third">
				<div class="w3-card w3-container" style="min-height: 350px">
					<h3>만들고 보답하기</h3>
					<br> <i class="fa fa-diamond w3-margin-bottom w3-text-theme"
						style="font-size: 120px"></i>
					<p>전달받은 후원금으로 창작에</p>
					<p>돌입합니다. 틈틈히 진척사항을</p>
					<p>알리고, 약속한 선물을 전달하면</p>
					<p>프로젝트가 끝납니다</p>
				</div>
			</div>
		</div>
		<hr>


		<!--  두번쨰 사이트  -->

		<div class="w3-center w3-large"
			style="margin-bottom: 10px; margin-top: 30px">
			<h2>누구에게나 열려있습니다.</h2>
		</div>

		<div class="w3-row-padding w3-center w3-margin-top">
			<div class="w3-third">
				<div class="w3-card w3-container" align="center"
					style="min-height: 450px">
					<h3 style="margin-top: 15px; margin-bottom: 5px">창작자</h3>
					<hr style="border: solid 2px red; width: 70%; margin-top: 2px;">
					<p style="text-align: justify; width: 85%">평소에 몰두했던 작업이나 구상만 하던
						창작 아이디어를 본격적인 단계로 발전시킬 기회로 삼아보세요.</p>
					<br>

					<p style="text-align: justify;; width: 85%">시작하는 창작자에게 텀블벅은
						지원금, 공모전 등의 방식들보다 훨씬 자율적이고 독립적으로 나와 내 작업을 알릴 수 있는 새로운 길입니다. 이미
						콘텐츠와 팬층을 확보한 작가라면 신선한 기획을 통해 팬들을 만나는 새로운 창구를 열어보는 건 어떨까요?</p>
					<br>
				</div>
			</div>

			<div class="w3-third">
				<div class="w3-card w3-container" align="center"
					style="min-height: 450px">
					<h3 style="margin-top: 15px; margin-bottom: 5px">브랜드</h3>
					<hr style="border: solid 2px blue; width: 70%; margin-top: 2px;">
					<p style="text-align: justify; width: 85%">초기 비용이나 재고 부담 없이 새로운
						제품이나 서비스를 론칭하고 코어 팬 베이스를 확보하세요.</p>
					<br>

					<p style="text-align: justify;; width: 85%">브랜드에 이목을 집중시키는 스토리를
						통해 마케팅 효과를 극대화할 수 있습니다. 트렌디하면서도 개인의 취향과 가치가 강조되는 새로운 참여형 소비 창구로
						각광받는 텀블벅에서 모인 후원자들의 신뢰는 일반 이커머스에서보다 훨씬 깊고 오래 가는 팬 베이스가 되어줄 것입니다</p>
					<br>
				</div>
			</div>

			<div class="w3-third">
				<div class="w3-card w3-container" align="center"
					style="min-height: 450px;">
					<h3 style="margin-top: 15px; margin-bottom: 5px">캠페인</h3>
					<hr style="border: solid 2px teal; width: 70%; margin-top: 2px;">
					<p style="text-align: justify; width: 85%">임팩트 있는 캠페인을 통해 사회적
						이슈를 지속가능한 참여와 후원으로 전환시켜보세요.</p>
					<br>

					<p style="text-align: justify;; width: 85%">언론이나 소셜미디어에서 떠오르는
						이슈들을 구체적인 행동으로 전환시키는 데에 텀블벅 프로젝트가 제격입니다. 새롭고 젊은 정치참여·사회운동 방식으로
						주목받는 텀블벅 펀딩으로 더 많은 지지자를 얻고, 사회적 목소리를 증폭시켜보세요.</p>
					<br>
				</div>
			</div>
		</div>


		<!-- 세번째 사이트 -->
		<div align="center">
			<div class="w3-center w3-large"
				style="margin-bottom: 10px; margin-top: 30px; width: 96%">
				<h2>창조적인 도전을 아는 사람들이 만듭니다.</h2>
				<p align="center" class="w3-medium" style="text-align: justify;">6년
					전 대학생 두 명이 창작 활동을 위해 직접 서비스를 시작한 이래 텀블벅의 목표는 늘 하나였습니다. 누구나 쉽고 빠르고
					똑똑하게 아이디어를 실현할 수 있도록 창조적인 시도를 위한 기반을 만드는 것. 텀블벅 창작자와 후원자들은 독창적인 시도와
					다양성이 존중받는 생태계를 함께 만들어가고 있습니다.</p>
			</div>
		</div>

		<div class="w3-row-padding w3-center w3-margin-top">
			<div class="w3-third">
				<div class="w3-card w3-container" align="center"
					style="min-height: 250px">
					<h3 style="margin-top: 15px; margin-bottom: 5px">낮은 수수료, 빠른정산</h3>
					<br>
					<p style="text-align: justify; width: 85%">펀딩에 성공한 경우에만 5%의
						수수료를 받습니다. 직관적인 프로젝트 작성 도구를 이용해 미리 발생할 수수료와 정산 일정을 계산해 볼 수 있어 첫
						프로젝트도 쉽게 계획할 수 있습니다.</p>
					<br>
				</div>
			</div>

			<div class="w3-third">
				<div class="w3-card w3-container" align="center"
					style="min-height: 250px">
					<h3 style="margin-top: 15px; margin-bottom: 5px">성공을 돕는 리소스</h3>
					<br>
					<p style="text-align: justify; width: 85%">펀딩 시작 전, 각 분야의 생태를 잘
						아는 에디터가 프로젝트를 검토하고 피드백을 드립니다. 프로젝트 생성 가이드에는 각 단계별 성공을 위한 꼼꼼한 도움말이
						준비되어 있습니다.</p>
					<br>
				</div>
			</div>

			<div class="w3-third">
				<div class="w3-card w3-container" align="center"
					style="min-height: 250px;">
					<h3 style="margin-top: 15px; margin-bottom: 5px">확산이 빠른 커뮤니티</h3>
					<br>
					<p style="text-align: justify; width: 85%">후원의 상당 부분이 40만 텀블벅
						커뮤니티와 확장된 소셜네트워크에서 유입됩니다. 데이터에 기초해 스마트한 홍보와 진행을 할 수 있도록 노하우를 지원해
						드리겠습니다.</p>
					<br>
				</div>
			</div>
		</div>
		<br>
		<button class="w3-btn w3-xlarge w3-dark-grey w3-hover-light-grey"
			style="font-weight: 900;" name="stbt2" id="stbt2">지금 시작하기</button>
		<br> <br> <br>
		<hr>
	</div>




</body>
</html>