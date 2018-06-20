<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<script type="text/javascript" src="/resources/include/js/master.js"></script>

<title>Insert title here</title>
</head>
<body id="page-top" class="index">
	<!-- Navigation -->
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header page-scroll">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand page-scroll" href="#page-top">텀텀</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-right">
					<li class="hidden"><a href="#page-top"></a></li>
					<li data-analytics="fundingGoal"><a
						class="page-scroll navbar-toggle-item"
						href="#funding-goal-deadline">목표 설정</a></li>
					<li data-analytics="title"><a
						class="page-scroll navbar-toggle-item" href="#title">좋은 제목</a></li>
					<li data-analytics="story"><a
						class="page-scroll navbar-toggle-item" href="#write-story">스토리</a></li>
					<li data-analytics="reward"><a
						class="page-scroll navbar-toggle-item" href="#reward">선물 구성</a></li>
					<li data-analytics="credibility"><a
						class="page-scroll navbar-toggle-item" href="#credibility">신뢰성</a></li>
					<li data-analytics="promotion"><a
						class="page-scroll navbar-toggle-item" href="#pr">홍보</a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>


	<!--main-header-->
	<div class="main-no-gutter">
		<div class="header">
			<div class="header-inner">
				<div class="header-title">
					<h1 class="header-heading wow fadeInDown" data-wow-delay=".1s"
						data-wow-duration="1s">텀블하기</h1>
				</div>
			</div>
		</div>

		<div class="header-project">

			<div class="header-project-inner">


				<div class="header-project-text">
					<hr class="hr-header"></hr>
					<h3 class="header-project-text-headline wow fadeInDown"
						data-wow-delay=".5s">
						텀블벅을 처음 시작하는 <span class="br-inline-mobile-block"></span>창작자 가이드
					</h3>

					<h4 class="header-project-text-subheadline wow fadeInUp"
						data-wow-delay=".7s">
						성공률이 높은 목표 금액을 산출하는 방법부터 펀딩 막바지 뒷심을 끌어올리는 방법까지.<br>텀블벅하기 필수
						노하우를 소개합니다.
					</h4>

					<a href="#funding-goal-deadline" class="page-scroll">
						<div class="scroll-down">
							<span> <i class="fa fa-2x fa-angle-down"></i>
							</span>
						</div>
					</a>
				</div>


			</div>
		</div>
	</div>

	<!--2.funding-goal-deadline-->
	<div id="funding-goal-deadline" class="section-padding-70">
		<div class="container">
			<div class="row">
				<div
					class="col-lg-6 col-md-6 section-padding-50 padding-left-right-15">
					<div class="row wow fadeIn" data-wow-delay=".1s">
						<div class="col-md-8 col-md-offset-2 text-center">
							<div class="title-logo">
								<img class="title-logo-img" src="" alt="">
							</div>
							<div class="section-title">
								<h2 class="section-heading">목표 금액 설정하기</h2>

								<hr class="hr-center">

								<h3 class="section-subheading">
									평균적으로 모금액의 <strong>약 40%</strong>가 <strong>창작자의 주변</strong>에서
									모입니다. 예를 들어 창작자의 지인이나 팬층에서 약 400만원 정도 모금이 예상된다면 목표 금액 1,000만원은
									도전해 볼 만한 금액입니다.
								</h3>
							</div>
						</div>
					</div>
					<div class="row wow pulse" data-wow-delay=".3s">
						<img src="" class="img-responsive" alt="">
					</div>
				</div>

				<div
					class="col-lg-6 col-md-6 section-padding-50 padding-left-right-15">
					<div class="row wow fadeIn" data-wow-delay=".6s">
						<div class="col-md-8 col-md-offset-2 text-center">
							<div class="title-logo">
								<img class="title-logo-img" src="" alt="">
							</div>
							<div class="section-title">
								<h2 class="section-heading">모금 기간 설정하기</h2>

								<hr class="hr-center">

								<h3 class="section-subheading">
									성공한 프로젝트의 평균적인 모금 기간은 <strong>30일</strong>입니다. 기간을 타이트하게 잡으면
									'시간이 얼마 남지 않았으니 빨리 후원해야지' 하는 긴장감이 형성되어 성공률을 높이는데 도움이 됩니다.
								</h3>
							</div>
						</div>
					</div>
					<div class="row wow pulse" data-wow-delay=".8s">
						<img src="" class="img-responsive" alt="">
					</div>
				</div>
			</div>
		</div>
	</div>


	<!-- 3.title-->
	<div id="title" class="bg-light-gray section-padding-120">
		<div class="container">
			<div class="row wow fadeIn" data-wow-delay=".1s">
				<div class="col-md-8 col-md-offset-2 text-center">
					<div class="title-logo">
						<img class="title-logo-img" src="" alt="">
					</div>
					<div class="section-title">
						<h2 class="section-heading">좋은 제목 만들기</h2>

						<hr class="hr-center">

						<h3 class="section-subheading">
							제목은 무엇을 만드는지가 분명하게 드러나도록 쓰는 것이 중요합니다.<span
								class="block-mobile-inline"></span> SNS를 통해 퍼져나갈 때를 고려하여 가급적이면
							짧은 제목이 좋답니다.
						</h3>
					</div>
				</div>
			</div>

		</div>
	</div>


	<!-- 4.write-story-->
	<div id="write-story" class="section-padding-120">
		<div class="container">
			<div class="row wow fadeIn" data-wow-delay=".1s">
				<div class="col-md-8 col-md-offset-2 text-center">
					<div class="title-logo">
						<img class="title-logo-img" src="" alt="">
					</div>
					<div class="section-title marginbot-50-bottom">
						<h2 class="section-heading">스토리 작성하기</h2>

						<hr class="hr-center">

						<h3 class="section-subheading">개인 블로그 한 페이지에 프로젝트 소개글을 쓴다고
							상상해 보세요. 너무 어렵게 생각할 필요가 없습니다. 아래 네 가지 항목에 맞는 내용들을 후원자에게 직접 말을
							건네듯이 작성해 보세요.</h3>
					</div>
				</div>
			</div>

			<div class="row wow fadeIn" data-wow-delay=".2s">
				<div class="col-md-10 col-md-offset-1">
					<div class="panel panel-default">
						<div class="row">
							<div class="col-sm-4 text-center">
								<a href="#storyModal1" data-toggle="modal"> <img
									class="story-hover" src="" alt="">
								</a>
							</div>
							<div class="col-sm-8">
								<div class="panel-caption">
									<h4>무엇을 만드는지 먼저 소개하기</h4>
									<p>초반에 무엇을 만들려고 하는지 간단명료하게 소개해 주세요. 이 프로젝트를 좋아할 만한 사람들이
										페이지를 끝까지 읽어볼 수 있도록 가능한 한 빨리 프로젝트의 핵심을 알려주는 것이 좋습니다.</p>
								</div>

								<div class="section-button-example">
									<a href="#storyModal1" data-toggle="modal"
										class="btn btn-example btn-md">좋은 예시 참고하기<i
										class="fa fa-angle-right button-icon scroll-right"></i></a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="row wow fadeIn" data-wow-delay=".2s">
				<div class="col-md-10 col-md-offset-1">
					<div class="panel panel-default">
						<div class="row">
							<div class="col-sm-4 text-center">
								<a href="#storyModal2" data-toggle="modal"> <img
									class="story-hover" src="" alt="">
								</a>
							</div>
							<div class="col-sm-8">
								<div class="panel-caption">
									<h4>창작자 소개하기</h4>
									<p>이 스토리는 친구 뿐만 아니라 전혀 모르는 방문객들도 볼 수 있습니다. 이번 프로젝트와 관련 있는
										경험이나 결과물을 중심으로 자신을 소개해 주세요.</p>
								</div>
								<div class="section-button-example">
									<a href="#storyModal2" data-toggle="modal"
										class="btn btn-example btn-md">좋은 예시 참고하기<i
										class="fa fa-angle-right button-icon scroll-right"></i>
									</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="row wow fadeIn" data-wow-delay=".2s">
				<div class="col-md-10 col-md-offset-1">
					<div class="panel panel-default">
						<div class="row">
							<div class="col-sm-4 text-center">
								<a href="#storyModal3" data-toggle="modal"> <img
									class="story-hover" src="" alt="">
								</a>
							</div>
							<div class="col-sm-8">
								<div class="panel-caption">
									<h4>프로젝트를 시작하게 된 계기</h4>
									<p>계기는 거창할 필요가 없습니다. 창작자가 프로젝트를 시작하게 된 개인적이고 소소한 이야기들이 오히려
										잠재 후원자들의 마음을 열기 쉽습니다.</p>
								</div>

								<div class="section-button-example">
									<a href="#storyModal3" data-toggle="modal"
										class="btn btn-example btn-md">좋은 예시 참고하기<i
										class="fa fa-angle-right button-icon scroll-right"></i></a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="row wow fadeIn" data-wow-delay=".2s">
				<div class="col-md-10 col-md-offset-1">
					<div class="panel panel-default">
						<div class="row">
							<div class="col-sm-4 text-center">
								<a href="#storyModal4" data-toggle="modal"> <img
									class="story-hover" src="" alt="">
								</a>
							</div>
							<div class="col-sm-8">
								<div class="panel-caption">
									<h4>이미지를 적극적으로 활용하기</h4>
									<p>때로는 긴 텍스트보다 적절한 이미지가 더 효과적일 수 있습니다. 결과물에 대한 프로토타입이나 작업
										과정이 담긴 이미지 그리고 후원자가 받을 수 있는 선물의 샘플 이미지를 보여주세요.</p>
								</div>

								<div class="section-button-example">
									<a href="#storyModal4" data-toggle="modal"
										class="btn btn-example btn-md">좋은 예시 참고하기<i
										class="fa fa-angle-right button-icon scroll-right"></i></a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


	<!-- story Modal 1 -->
	<div class="modal fade bs-example-modal-lg" id="storyModal1"
		tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel"
		aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<!--     modal header-->
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true" class="closex">&times;</span>
					</button>
					<h3 class="modal-title text-center">
						LEBB의 <small>멜트프레소 </small> 제품디자인 프로젝트
					</h3>
					<hr class="hr-modal">
				</div>
				<!--      modal-body-->
				<div class="modal-body story-modal-1">
					<div class="container-fluid">
						<div class="row">
							<div class="col-md-4 text-center">
								<img src="" alt="" class="img-responsive img-rounded">
							</div>
							<div class="col-md-8">
								<h4 class="modal-subtitle">MELTPRESSO</h4>
								<p class="modal-text">
									커피메이커를 닮은 <small>MELTPRESSO</small> 는 할로겐램프의 열로 캔들을 녹이는 캔들 워머
									(Candle-warmer) 기능을 품은 조명입니다. <br> <small>MELT</small> 캔들을
									녹이다 + <small>ESPRESSO</small> 커피메이커 형태에서 착안한 <br> <small>MELTPRESSO</small>
									라는 이름은 제품의 기능과 형태적 특징을 조합해 만들어 졌습니다.
								</p>
								<a href="https://tumblbug.com/meltpresso" target="_blank"
									class="btn-link modal-example">이 프로젝트 더 보기 <i
									class="fa fa-angle-right button-icon scroll-right"></i></a>

							</div>
						</div>
					</div>
				</div>

				<hr class="hr-modal">

			</div>
		</div>
	</div>

	<!-- story Modal 2 -->
	<div class="modal fade bs-example-modal-lg" id="storyModal2"
		tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel"
		aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<!--     modal header-->
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true" class="closex">&times;</span>
					</button>
					<h3 class="modal-title text-center">
						김정윤의 <small>CLUTCH</small> 미술 전시 프로젝트
					</h3>
					<hr class="hr-modal">
				</div>
				<!--      modal-body-->
				<div class="modal-body story-modal-2">
					<div class="container-fluid">
						<div class="row">
							<div class="col-md-4 text-center">
								<img src="" alt="" class="img-rounded">
							</div>
							<div class="col-md-8 modal-margin-top-30">
								<p class="modal-text">
									안녕하세요! 일러스트레이터 <strong>김정윤 </strong> 입니다. <br>수채화나 붓펜을 이용한
									수작업 부터 디지털 드로잉, GIF 애니메이션 제작 등 다양한 작업을 진행하고 있어요. 어릴적 우연히 보게 된
									슬램덩크에 큰 영향을 받았습니다. 그 때부터 농구와 만화를 좋아하게 되었어요. 건국대 애니메이션과를 졸업하고
									자연스레 개인작업을 시작했고요, 현재까지 크고 작은 전시와 <small>코카콜라,</small> 의류브랜드 <small>펠틱스</small>
									등과의 여러 콜라보 작업을 진행해왔습니다.
								</p>
								<a href="https://tumblbug.com/vagab" target="_blank"
									class="btn-link modal-example">이 프로젝트 더 보기<i
									class="fa fa-angle-right button-icon scroll-right"></i></a>

							</div>
						</div>
					</div>
				</div>

				<hr class="hr-modal">

			</div>
		</div>
	</div>


	<!-- story Modal 3 -->
	<div class="modal fade bs-example-modal-lg" id="storyModal3"
		tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel"
		aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<!--     modal header-->
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true" class="closex">&times;</span>
					</button>
					<h3 class="modal-title text-center">
						애쉬크로프트의 <small>홀든 콜필드 안경 디자인</small> 프로젝트
					</h3>
					<hr class="hr-modal">
				</div>
				<!--      modal-body-->
				<div class="modal-body story-modal-3">
					<div class="container-fluid">
						<div class="row">
							<div class="col-md-8 col-md-offset-2 text-center">
								<img src="" alt="" class="img-responsive img-rounded">
							</div>
							<div class="col-md-8 col-md-offset-2 modal-margin-top-30">
								<p class="modal-text">한 안경디자이너는 저시력 친구의 안경테 바깥으로 튀어나온 렌즈 해결을
									모색하다가 아름다운 디자인의 안경을 제작하게 되었습니다.</p>
								<a href="https://tumblbug.com/ashcroft" target="_blank"
									class="btn-link modal-example">이 프로젝트 더 보기<i
									class="fa fa-angle-right button-icon scroll-right"></i></a>
							</div>
						</div>
					</div>
				</div>

				<hr class="hr-modal">

			</div>
		</div>
	</div>

	<!-- story Modal 4 -->
	<div class="modal fade bs-example-modal-lg" id="storyModal4"
		tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel"
		aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<!--     modal header-->
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true" class="closex">&times;</span>
					</button>
					<h3 class="modal-title text-center">이미지가 돋보이는 프로젝트들</h3>
					<hr class="hr-modal">
				</div>

				<!--      modal-body-->
				<div class="modal-body story-modal-4">
					<div class="container-fluid">
						<div class="row modal-padding-top-10">
							<div class="col-md-4">
								<img src="" alt="" class="img-rounded story-modal-4-image">
							</div>
							<div class="col-md-8 marginbot-50">
								<p class="modal-text">
									<strong>'트리 오브 라이프 - 여정의 시작' 프로젝트의 트레일러 영상</strong> <br>
									게임이 어떻게 진행되는지 후원자가 머리 속에 그려볼 수 있도록 해주세요.
								</p>
								<a href="https://www.tumblbug.com/treeoflife" target="_blank"
									class="btn-link modal-example">트레일러 영상 보기<i
									class="fa fa-angle-right button-icon scroll-right"></i></a>
							</div>
						</div>

						<div class="row modal-padding-top-10">
							<div class="col-md-4">
								<img src="" alt="" class="img-rounded story-modal-4-image">
							</div>
							<div class="col-md-8 marginbot-50">
								<p class="modal-text">
									<strong>'내 방 안 정령 미뇽' 제품 프로젝트의 시제품 이미지</strong> <br> 후원자가
									무엇을 선물로 받을 수 있는지 확실히 알 수 있게 해주세요.
								</p>
								<a href="https://tumblbug.com/mignon" target="_blank"
									class="btn-link modal-example">이 프로젝트 더 보기 <i
									class="fa fa-angle-right button-icon scroll-right"></i></a>
							</div>
						</div>

						<div class="row modal-padding-top-10">
							<div class="col-md-4">
								<img src="" alt="" class="img-rounded story-modal-4-image">
							</div>
							<div class="col-md-8 marginbot-50">
								<p class="modal-text">
									<strong>'보급형 올솔리드 기타' 프로젝트의 제작 과정 이미지 </strong> <br> 후원자에게
									제작 과정을 보여주는 것도 좋아요.
								</p>
								<a href="https://tumblbug.com/jguitar" target="_blank"
									class="btn-link modal-example">이 프로젝트 더 보기<i
									class="fa fa-angle-right button-icon scroll-right"></i></a>
							</div>
						</div>
					</div>
				</div>
				<hr class="hr-modal">
			</div>
		</div>
	</div>
	</div>

	<!-- 5.reward -->
	<div id="reward" class="bg-light-gray section-padding-120">
		<div class="container">
			<div class="row wow fadeIn" data-wow-delay=".1s">
				<div class="col-md-8 col-md-offset-2 text-center">
					<div class="title-logo">
						<img class="title-logo-img" src="" alt="">
					</div>
					<div class="title-section marginbot-50-bottom">
						<h2 class="section-heading">선물 구성하기</h2>

						<hr class="hr-center">

						<h3 class="section-subheading">미지의 후원자를 상정하면 무슨 선물을 드려야 할지
							막막합니다. 친구들이나 팬들이 어떤 선물을 좋아할지 생각해 보세요. 크라우드 펀딩은 창작자의 네트워크에서 시작되기
							때문에 주변 사람들이 재미나 감동을 느낄 요소를 만드는 것이 중요합니다.</h3>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-md-12">
					<div class="reward-contents marginbot-50-bottom">
						<div class="row">
							<div class="reward-graph-section">

								<div class="graph">
									<img src="" class="hidden-xs img-responsive wow fadeIn"
										data-wow-delay=".2s"> <img src=""
										class="visible-xs-block img-responsive wow fadeIn"
										data-wow-delay=".2s">
								</div>
								<div class="graph-caption wow fadeIn" data-wow-delay=".4s">
									<h4>인기금액대를 놓치지 마세요</h4>
									<p>
										통계적으로 후원자들이 가장 많이 선택하는 선물은 <strong>1만원에서 1만 8천원 사이 </strong>입니다.
										시중의 음반, 서적, DVD 등이 모두 이 구간에 형성되어 있기 때문입니다. 1만원대에 핵심적인 선물을
										배치한다면 많은 후원을 기대할 수 있습니다. 이 다수의 소액대 후원자들이 SNS 등을 통해 프로젝트를 공유하면
										<strong>홍보 효과</strong>까지 얻을 수 있습니다.
									</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
				<hr>
			</div>


			<div class="row wow fadeIn" data-wow-delay=".1s">
				<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
					<div class="reward-high-caption">
						<h4>고액대에 매력적인 선물을 만들어 보세요</h4>
						<p>
							놀랍게도 고액대 후원이 적지 않습니다. 고액대 후원자가 밀어주면 목표 금액에 성큼 가까워집니다. 일반 쇼핑몰에서
							돈으로는 살 수 없는 재미를 고액대 선물로 만들어 보세요. 프로젝트에 <strong>후원자의 흔적을
								반영</strong>하거나 텀블벅에서만 가질 수 있는 <strong>한정판</strong>은 고액대 후원자에게 인기가 좋습니다.
						</p>
					</div>
				</div>
			</div>

			<div class="row wow fadeIn" data-wow-delay=".2s">
				<div
					class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1 col-sm-12 col-xs-12 marginbot-50">
					<div class="media reward-media">
						<div class="media-left">
							<a href="https://tumblbug.com/kswxkhw" target="_blank"
								class="btn-link"> <img
								class="media-object reward-example-object  wow pulse"
								data-wow-iteration="infinite" data-wow-duration="1.2s" src=""
								alt="">
							</a>
						</div>
						<div class="media-body">
							<p class="muted">
								<a href="https://tumblbug.com/kswxkhw" target="_blank"
									class="btn btn-link btn-reward"><i
									class="fa fa-angle-left scroll-right"></i></a>좋아하는 뮤지션 앨범 크레딧에서 <strong>자신의
									이름</strong>을 발견하는 특별한 기분을 선물해 보세요.
							</p>
						</div>
					</div>
					<div class="media reward-media">
						<div class="media-left">
							<a href="https://tumblbug.com/ans" target="_blank"
								class="btn-link"> <img
								class="media-object reward-example-object  wow pulse"
								data-wow-iteration="infinite" data-wow-duration="1.2s" src=""
								alt="">
							</a>
						</div>
						<div class="media-body">
							<p class="muted">
								<a href="https://tumblbug.com/ans" target="_blank"
									class="btn btn-link btn-reward"><i
									class="fa fa-angle-left scroll-right"></i></a>좋아하는 게임에 <strong>자신을
									닮은 캐릭터</strong>가 등장하는 재미를 선물해 보는 것도 좋겠죠.
							</p>
						</div>
					</div>
					<div class="media reward-media">
						<div class="media-left">
							<a href="https://tumblbug.com/catchcats" target="_blank"
								class="btn-link"> <img
								class="media-object reward-example-object  wow pulse"
								data-wow-iteration="infinite" data-wow-duration="1.2s" src=""
								alt="">
							</a>
						</div>
						<div class="media-body">
							<p class="muted">
								<a href="https://tumblbug.com/catchcats" target="_blank"
									class="btn btn-link btn-reward"><i
									class="fa fa-angle-left scroll-right"></i></a>세상에서 딱 하나 뿐인 <strong>커스텀
									디자인 선물</strong>은 어떤가요.
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- 6.credibility -->
	<div id="credibility" class="section-padding-120">
		<div class="container">
			<div class="row wow fadeIn" data-wow-delay=".1s">
				<div
					class="col-md-8 col-md-offset-2 text-center marginbot-50-bottom">
					<div class="title-logo">
						<img class="title-logo-img" src="" alt="">
					</div>
					<div class="section-title">
						<h2 class="section-heading">신뢰성 높이기</h2>

						<hr class="hr-center">


						<h3 class="section-subheading">
							후원자는 창작자가 믿을만하다고 판단이 될 때 밀어주기를 클릭합니다.<span
								class="block-mobile-inline"></span>후원자에게 신뢰감을 줄 수 있는 방법들을 소개합니다.
						</h3>
					</div>
				</div>
			</div>

			<div class="row wow fadeIn" data-wow-delay=".2s"
				data-wow-duration="1.5s">
				<div class="col-lg-4 col-md-4 text-center">
					<div class="credible-caption">
						<img src="" class="img-circle credible-img">
						<h4>창작자의 얼굴 사진을 사용하세요</h4>
						<p>창작자를 투명하게 드러내는 가장 쉽고 간단한 방법은 창작자 프로필에 얼굴 사진을 사용하는 것입니다. 팀
							단위로 프로젝트를 진행한다면 대표 멤버의 얼굴 사진을 사용하면 됩니다.</p>
					</div>

				</div>
				<div class="col-lg-4 col-md-4 text-center">
					<div class="credible-caption">
						<img src="" class="img-circle credible-img">
						<h4>프로젝트 소개영상을 만들어 보세요</h4>
						<p>창작자가 직접 프로젝트를 소개하는 영상은 방문객이 쉽고 빠르게 프로젝트를 파악할 수 있도록 돕습니다.</p>
						<div class="section-button-example">
							<a href="https://tumblbug.com/catchcats" target="_blank"
								class="btn btn-md btn-example">좋은 프로젝트 참고하기<i
								class="fa fa-angle-right button-icon scroll-right"></i>
							</a>
						</div>
					</div>
				</div>
				<div class="col-lg-4 col-md-4 text-center">
					<div class="credible-caption">
						<img src="" class="img-circle credible-img">
						<h4>구체적인 교환/환불 정책을 생각해 보세요</h4>
						<p>선물 실행에 대해 구체적으로 대비한다면 후원자들이 신뢰와 안전을 느낄 수 있습니다.</p>
						<div class="section-button-example">
							<a href="https://tumblbug.com/madebymary/policy" target="_blank"
								class="btn btn-md btn-example">좋은 프로젝트 참고하기<i
								class="fa fa-angle-right button-icon scroll-right"></i>
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- 7.pr -->
	<div id="pr" class="bg-light-gray section-padding-120">
		<div class="container">

			<div class="row wow fadeIn" data-wow-delay=".1s">
				<div
					class="col-md-8 col-md-offset-2 text-center marginbot-50-bottom">
					<div class="title-logo">
						<img class="title-logo-img" src="" alt="">
					</div>
					<div class="section-title">
						<h2 class="section-heading">프로젝트 알리기</h2>

						<hr class="hr-center">
					</div>
				</div>
			</div>

			<div class="row wow fadeIn" data-wow-delay=".2s"
				data-wow-duration="1.5s">
				<div class="col-lg-4 col-md-4 text-center">
					<div class="credible-caption">
						<img src="">
						<h4>주변에 가장 먼저 런칭 소식을!</h4>
						<p>런칭하자마자 가장 먼저 본인의 커뮤니티에 런칭 소식을 알려주세요. 초반에 커뮤니티에서 집중적으로 밀어주면
							후원율이 높아지고 그 수치가 신뢰성을 반영하여 새로운 방문객들도 관심을 가지게 됩니다.</p>
					</div>
				</div>
				<div class="col-lg-4 col-md-4 text-center">
					<div class="credible-caption">
						<img src="">
						<h4>SNS를 활용해 보세요</h4>
						<p>평소에 지인이나 팬들과 소통하던 SNS 플랫폼이 있다면 프로젝트를 홍보하는데 적극 활용해주세요. 단순히
							후원을 요청하는 것보다는 프로젝트의 매력을 드러내는 것이 좋습니다. 이때 적절한 이미지를 사용하면 더 큰 호응을
							일으킬 수 있답니다.</p>
					</div>
				</div>
				<div class="col-lg-4 col-md-4 text-center">
					<div class="credible-caption">
						<img src="">
						<h4>뒷심 끌어올리기</h4>
						<p>커뮤니티 기능을 통해 제작 과정을 공유하거나 작업 연장선 상에 있는 작은 이벤트를 기획해 보세요.
							프로젝트를 좋아할 만한 외부 커뮤니티에 프로젝트를 알리는 것도 좋은 방법입니다.</p>
						<div class="section-button-example">
							<a href="https://tumblbug.com/dwkr/community" target="_blank"
								class="btn btn-md btn-example">좋은 커뮤니티 참고하기<i
								class="fa fa-angle-right button-icon scroll-right"></i>
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!--do-tumblbug-->
	<div class="do-tumblbug">
		<div class="container">
			<div class="row">
				<div class="col-lg-6 col-md-6 col-md-offset-1 do-tumblbug-textbox">
					<h3 class="do-tumblbug-text wow fadeIn" data-wow-delay=".1s">
						이제, <span class="block-mobile-inline"></span><strong>작은
							메모에서 시작된 상상을 현실로</strong> <span class="block-mobile-inline"></span>만들 일만
						남았습니다.
					</h3>
					<div class="section-button marginbot-30 wow bounce"
						data-wow-delay=".3s">
						<a href="http://localhost:8080/project/projectCreate.do"
							target="_blank" class="btn btn-primary btn-lg js-button-action">프로젝트
							올리기<i class="fa fa-angle-right button-icon scroll-right"></i>
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>



	<!--footer-->
	<div class="footer bg-darkest-gray section-padding-25">
		<div class="container">
			<div class="row">
				<div
					class="col-lg-8 col-lg-offset-2 col-md-8 col-md-offset-2 col-sm-12">
					<span class="footer-copyright pull-left">2017 &copy; <a
						href="https://tumblbug.com/" target="_blank"
						class="btn-link-footer tumblbug-main">tumbl</a></span>
					<div class="pull-right">
						<a href="https://www.facebook.com/tumblbug" target="_blank"
							class="btn-link-footer social"><i class="fa fa-facebook"></i></a>
						<a href="https://twitter.com/tumblbug" target="_blank"
							class="btn-link-footer social"><i class="fa fa-twitter"></i></a>
						<a href="https://www.instagram.com/tumblbug/" target="_blank"
							class="btn-link-footer social"><i class="fa fa-instagram"></i></a>
					</div>
				</div>
			</div>
		</div>




	</div>
</body>
</html>