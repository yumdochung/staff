<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
h3 {
	margin-bottom: 15px
}

fieldset {
	border: none
}

.tb {
	width: 850px;
	border-collapse: collapse;
	border-spacing: 0;
	border-top: 2px solid #ddd;
	border-bottom: 2px solid #ddd;
	font-size: 15px;
	font-family: dotum;
}

.tb th {
	height: 30px;
	border-bottom: 1px solid #ddd;
	color: #3f93c7;
	background-color: #e6e6e6
}

.tb input{
	width:150px;
	font-size: 15pt;
	border: 1px solid #ccc;
}
.tb textarea {
	font-size: 15pt;
	width: 698px;
	border: 1px solid #ccc;
}
.tb button {
	font-size: 20pt;
 	padding: 15px;
}
</style>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script src="js/project.js"></script>
<script type="text/javaScript">
$(document).ready(function(){
	  $('#button1').click(function(){ //button1을 클릭했을 경우
		  $.ajax({
				type: "POST",
				url: "pjtCtrl.jhj?command=project_staff",
				data: {sno:$("#sno").val(),
					prjtno:$("#prjtno").val(),
					writer:$("#writer").val(),
					rolecd:$("#rolecd").val()
					},
				  success: function(mm){
					 $("#staff").append($(mm));
					 }	  
			});
	  		$('#sno').val("");
	  		$('#sname').val("");
	  		$('#deptcd').val("");
	  		$('#rolecd').val("");
	  });
});
</script>
</head>
<body>
<jsp:include page="../main/top.jsp"></jsp:include>
<div style="width: 850px; margin: 0 auto;">
<h2>프로젝트 사원 추가</h2>
<table class="tb">
<tr>
<th>사번</th>
<td><input type="text" name="sno" id="sno" readonly="readonly">
<input type="hidden" name="prjtno" id="prjtno" value="${prjt.prjtno }">
<input type="hidden" name="writer" id="writer" value="${prjt.writer }">
</td>
<th>사원명</th>
<td><input type="text" name="sname" id="sname" readonly="readonly"></td>
<th>부서명</th>
<td><input type="text" name="deptcd" id="deptcd" readonly="readonly">
</td>
<th>역할</th>
<td><select name="rolecd" id="rolecd">
<option value="">선택하세요</option>
<option value="00">DEV</option>
<option value="01">PL</option>
<option value="10">PM</option>
<option value="11">PMO</option>
<option value="21">SALES</option>
</select></td>
</tr>
</table>
<input type="button" value="검색" onclick="Project();">
<input type="button" value="완료" onclick="location.href='pjtCtrl.jhj?command=project_list'" style="float: right;margin-top: 10px; margin-right: 10px">
<input type="button" id="button1" value="추가" style="float: right; margin-top: 10px; margin-right: 10px">
<table class="tb">
<tr>
<th>사번</th>
<th>사원명</th>
<th>부서명</th>
<th>역할</th>
</tr>
<tbody id="staff"></tbody>
</table>


<div class="container" style="width:450px; z-index:10011;">
			  <!-- Modal -->
			  <div class="modal fade" id="myModal" role="dialog" style="width:450px">
			    <div class="modal-dialog" id="myModal_in" style="width:450px; margin-top:200px">
			    
			      <!-- Modal content-->
			      <div class="modal-content">
			        <div class="modal-header">
			          <button type="button" class="close" data-dismiss="modal">&times;</button>
			          <h4 class="modal-title" id="modalTitle">&nbsp;</h4>
			        </div>
			        <div class="modal-body" align="center">
			          <p id="modalMsg">&nbsp;</p>
			        </div>
			        <div class="modal-footer">
			        	<button type="button" id="btn-default" class="btn btn-default" data-dismiss="modal" onclick="">완료</button>
			        	<button type="button" id="btn-default" class="btn btn-default" data-dismiss="modal">닫기</button>
			        </div>
			      </div>
			    </div>
			  </div>
			</div>
			<button type="button" style="visibility:hidden" id="modal_btn" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Open Modal</button>

</div>
</body>
</html>