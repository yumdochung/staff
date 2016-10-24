


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
function Project(){
	$("#modalTitle").html("<b>사원 정보 조회</b>");
	$('#modalMsg').html("<input type='text' id='skill' name='skill'>"
			+"<input type='button' value='검색' onclick='pro();'>"
			+"<div style='max-height:250px; overflow:auto;'><table width='380px'><tr><th align='center' width='65px'>사원명</th><th align='center'>부서</th><th align='center'>직급</th><th align='center'>스킬</th></tr><tbody id='print'></tbody></table></div>");
	$("#modal_btn").click(); //보이게
	
}

function pro(){ //button1을 클릭했을 경우
		  $.ajax({
				type: "POST",
				data: {skill:$("#skill").val()},
				url: "pjtCtrl.jhj?command=staff_search",
				  success: function(mm){
					 $("#print").html(mm);
					 }	  
			});
	  		$('#skill').val("");
}

function staff_select(sno,sname,deptname){
	document.getElementById("sno").value=sno;
	document.getElementById("sname").value=sname;
	document.getElementById("deptcd").value=deptname;
	$('#btn-default').click();
}
	  		
	  		
window.onload = function() {
	$("#myModal").center();
	$("#modalTitle").html("<b>사원 정보 조회</b>");
	
}


