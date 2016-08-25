
jQuery.fn.center = function () {
	this.css("position","absolute");
	this.css("top", Math.max(0, (($(window).height() - $(this).outerHeight()) / 2) + $(window).scrollTop()) + "px");
	this.css("left", Math.max(0, (($(window).width() - $(this).outerWidth()) / 2) + $(window).scrollLeft()) + "px");
	return this;
}
function modalMsage(msg, sec) {
	$('#modalMsg').text(msg);
	$("#modal_btn").click(); //보이게
	$('#myModal').delay(sec).fadeOut(function(){
		$('#btn-default').click();
	});
}

function loginform(){
	$('#modalMsg').html("<form method='post' action='main.jhj'>" +
			"<table><tr>" +
			"<td height='40px'>사번&nbsp; &nbsp;</td><td><input type='text' id='id' name='id'></td>" +
			"<td rowspan='2'><input type='submit' value='로그인' onclick='return login_check();' style='margin-left: 10px; height: 67px; width: 70px;'></td>" +
			"<tr><td height='40px'>비밀번호&nbsp; &nbsp;</td><td><input type='password' id='userpwd' name='userpwd'></td>"+
			"</tr></table></form>");
	$("#modal_btn").click(); //보이게
	
}

function login(){
		  $.ajax({
				type: "POST",
				data: {id:$("#id").val(),userpwd:$("#userpwd").val()},
				url: "main.jhj"
			});
		  $('#btn-default').click();
}

function login_check() {
	if (document.getElementById("id").value == "") {
		alert("아이디를 입력하세요");
		document.getElementById("id").focus();
		return false;
	}
	if(document.getElementById("userpwd").value==""){
		alert("비밀번호를 입력하세요");
		document.getElementById("userpwd").focus();
		return false;
	}
	return true;
}
	  		
window.onload = function() {
	$("#myModal").center();
	$("#modalTitle").html("<b>로그인</b>");
	
}


