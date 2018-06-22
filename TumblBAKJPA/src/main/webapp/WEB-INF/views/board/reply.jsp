<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

<title>댓글</title>

<link rel="stylesheet" type="text/css"
	href="/resources/include/css/reply.css" />

<!-- jQuery Framework 참조하기 -->
<script type="text/javascript"
	src="/resources/include/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="/resources/include/js/common.js"></script>
<script type="text/javascript">
	$(function() {
		/* 기본 덧글 목록 불러오기 */
		var qnum = "<c:out value='${detail.qnum}' />";
		listAll(qnum);

		/* 덧글 내용 저장 이벤트 */
		$("#replyInsert").click(function() {
			// 작성자 이름에 대한 입력여부 검사
			if (!chkData("#r_name", "이름을")) {
				return;
			} else if (!chkData("#r_content", "내용을")) {
				return;
			} else {
				var insertUrl = "/replies/replyInsert.do";

				/* 글 저장을 위한 Post 방식의 Ajax 연동 처리 */
				$.ajax({
					url : insertUrl, // 전송 url
					type : "post", // 전송 시 method 방식
					headers : {
						"Content-Type" : "application/json",
						"X-HTTP-Method-Override" : "POST"
					},
					dataType : "text",
					data : JSON.stringify({
						qnum : qnum,
						r_name : $("#r_name").val(),
						r_content : $("#r_content").val()
					}),
					error : function() {
						alert('시스템 오류 입니다. 관리자에게 문의 하세요');
					},
					success : function(resultData) {
						if (resultData == "SUCCESS") {
							alert("댓글 등록이 완료되었습니다.");
							dataReset();
							listAll(qnum);
						}
					}
				});
			}
		});

		/* 수정버튼 클릭시 수정폼 출력 */
		$(document)
				.on(
						"click",
						".update_form",
						function() {
							$(".reset_btn").click();
							var currLi = $(this).parents("li");

							var conText = currLi.children().eq(1).html();
							// console.log("conText: " + conText);

							currLi.find("input[type='button']").hide();

							var conArea = currLi.children().eq(1);
							conArea.html("");

							var data = "<textarea name='content' id='content'>"
									+ conText + "</textarea>";
							data += "<input type='button' class='update_btn' value='수정완료'>";
							data += "<input type='button' class ='reset_btn' value='수정취소'>";

							conArea.html(data);
						});

		/* 초기화 버튼 */
		$(document).on("click", ".reset_btn", function() {
			btnKind = "";
			var conText = $(this).parents("li").find("textarea").html();
			$(this).parents("li").find("input[type='button']").show();

			var conArea = $(this).parents("li").children().eq(1);
			conArea.html(conText);
		});

		/* 글 수정을 위한 Ajax연동 처리 */
		$(document).on("click", ".update_btn", function() {
			var rnum = $(this).parents("li").attr("data-num");
			var r_content = $("#content").val();
			if (!chkData("#content", "댓글 내용을")) {
				return;
			} else {
				$.ajax({
					url : '/replies/' + rnum + ".do",
					type : 'put',
					headers : {
						"Content-Type" : "application/json",
						"X-HTTP-Method-Override" : "PUT"
					},
					data : JSON.stringify({
						r_content : r_content
					}),
					dataType : 'text',
					success : function(result) {
						console.log("result:" + result);

						if (result == 'SUCCESS') {
							alert("수정 되었습니다.");
							listAll(qnum);
						}
					}
				});

			}
		});

		/* 글 삭제를 위한 Ajax 연동 처리 */
		$(document).on("click", ".delete_btn", function() {
			$(".reset_btn").click();
			var currLi = $(this).parents("li");
			replyNum = currLi.attr("data-num");
			if (confirm("선택하신 댓글을 삭제하시겠습니까?")) {
				$.ajax({
					type : 'delete',
					url : '/replies/' + replyNum + ".do",
					headers : {
						"Content-Type" : "application/json",
						"X-HTTP-Method_Override" : "DELETE"
					},
					dataType : 'text',
					success : function(result) {
						console.log("result : " + result);

						if (result == 'SUCCESS') {
							alert("삭제 되었습니다.");
							listAll(qnum);
						}
					}
				});
			} else {
				pwdConfirm = 0;
			}
		});

		/* 비밀번호 취소 버튼 클릭 시 처리 이벤트 */
		$(document).on("click", ".pwdResetBut", function() {
			// $(this).parents("li").removeClass("glayLayer");
			// $(this).parent().parent().removeClass("overLayer");
			$(this).parent().parent().html("");
		});

		$(document).on("focus", ".passwd", function() {
			$(this).val("");
			var span = $(this).parents("form").find("span");
			span.removeClass("msg_error");
			span.addClass("msg_default");
			span.html(message);
		});

	});

	// 리스트 요청 함수
	function listAll(qnum) {
		$("#comment_list").html("");
		var url = "/replies/all/" + qnum + ".do";
		$.getJSON(url, function(data) {
			console.log(data.length);

			$(data).each(function() {
				var rnum = this.rnum;
				var r_name = this.r_name;
				var r_content = this.r_content;
				var r_date = this.r_date;
				addNewItem(rnum, r_name, r_content, r_date);
			});
		}).fail(function() {
			alert("덧글 목록을 불러오는데 실패하였습니다. 잠시후에 다시 시도해 주세요.");
		});
	}

	/* 새로운 글을 화면에 추가하기 위한 함수 */
	function addNewItem(rnum, r_name, r_content, r_date) {
		// 새로운 글이 추가될 li태그 객체
		var new_li = $("<li>");
		new_li.attr("data-num", rnum);
		new_li.addClass("comment_item");

		// 작성자 정보가 지정될 <p>태그
		var writer_p = $("<p>");
		writer_p.addClass("writer");

		// 작성자 정보의 이름
		var name_span = $("<span>");
		name_span.addClass("name");
		name_span.html(r_name + "님");

		// 작성일시
		var date_span = $("<span>");
		date_span.html(" / " + r_date + " ");

		

		// 내용
		var content_p = $("<p>");
		content_p.addClass("con");
		content_p.html(r_content);

		// 조립하기
		writer_p.append(name_span).append(date_span)
		new_li.append(writer_p).append(content_p);
		$("#comment_list").append(new_li);
	}

	function dataReset() {
		$("#r_content").val("");
	}
</script>
</head>
<body>
	<div id="replyContainer">
		<h1></h1>
		<div id="comment_write">
			<form id="comment_form">
				<div>
					<label>작성자</label> <label>${detail.email }</label><input type="hidden"
						name="r_name" id="r_name" value="${detail.email }"> <input
						type="button" id="replyInsert" value="저장하기" >
				</div>
				<div>
					<label for="r_content">덧글내용</label>
					<textarea name="r_content" id="r_content"></textarea>
				</div>
			</form>
		</div>
		<ul id="comment_list">
			<!-- 여기에 동적 생성 요소가 들어가게 됩니다. -->
		</ul>
	</div>
</body>
</html>