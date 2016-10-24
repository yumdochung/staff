$(function (){
	$("#delete_notice").click(function(){
		if(confirm("삭제하시겠습니까 ?")){
			location.href='notice?command=noticeDelete&num='+num;
		}
	})
	
	$("#button1").click(function(){
		if(user == ''){
			alert("로그인 해주세요.");
			location.href='/staff?command=staff_login_form';
			return false;
		}else if($("#replyin").val() == ""){
			alert("댓글을 입력 해주세요.");
			$("#replyin").focus();
			return false;
		}else{
			$.ajax({
				url : '/notice?command=noticeReplyInsert',
				type : 'POST',
				dataType : 'json',
				data : $("#frm").serialize(),
				success : function(data){
				}
			});
			history.go(0);
		}
	})
	$("#reply_delete").click(function(){
		if(confirm("삭제하시겠습니까 ?")){
			$.ajax({
				url : '/notice?command=noticeReplyDelete',
				type : 'POST',
				dataType : 'json',
				data : $("#re_del").serialize(),
				success : function(data){
				}
			});
			history.go(0);
		}
	})
	$("#reply_update").click(function(){
		
		$("#re_del").html('<input type="hidden" name="num" value="'+$(this).data("num")+'">'
				+'<textarea id="replyin" name="content" style="width: 800px;height: 40px;border: 1px solid #ccc;">'+$(this).data("content")+'</textarea>' 
				+'<input type="button" id="button2" onclick="replyUpdate();" value="수정" style="width: 100px;height: 46px;float: right;cursor: pointer;">')
	})
	
})

function replyUpdate(){
	$.ajax({
		url : '/notice?command=noticeReplyUpdate',
		type : 'POST',
		dataType : 'json',
		data : $("#re_del").serialize(),
		success : function(data){
		}
	});
	history.go(0);
}