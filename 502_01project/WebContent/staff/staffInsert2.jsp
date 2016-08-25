<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<style>
h2 { margin: 20px 0}
.tab-content {padding: 10px 0;}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
 h3 {margin-bottom:15px}
 fieldset {border:none}
 legend {display:none}
 img {border:none}
 .join_tbl {width:850px; border-collapse:collapse; border-spacing:0; border-top:2px solid #ddd; border-bottom:2px solid #ddd; font-size:15px; font-family:dotum; margin-bottom:30px; margin-top: 30px;}
 .join_tbl th { text-align:left; padding:5px 10px; border-bottom:1px solid #ddd; color:#3f93c7;background-color:#e6e6e6}
 .join_tbl td {padding:5px 15px; border-bottom:1px solid #ddd}
 .join_tbl td .inputText {width:180px; border:1px solid #ccc}
 .join_tbl td .juso {width:220px; border:1px solid #ccc}
 .join_tbl td .hp {width:30px; border:1px solid #ccc}
 .join_tbl td .select {width:100px; border:1px solid #ccc}
 .join_tbl td .btn {border:1px solid #ccc; padding:3px 5px; font-size:11px; font-family:dotum; margin-left: 3px; border-radius: 5px;}
 .join_tbl td span {color:#888}
 .join_tbl textarea {width:95%; height:80px; border:1px solid #ccc; padding:10px}
 .btn {text-align:center}
 </style>
<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script type="text/javaScript">
$(document).ready(function(){
	  $('#button1').click(function(){ //button1을 클릭했을 경우
		  $.ajax({
				type: "POST",
				url: "staff.jhj?command=staff_lic",
				data: {licnm:$("#licnm").val(),
					issue:$("#issue").val(),
					issuedt:$("#issuedt").val(),
					licpic:$("#licpic").val()
					},
				  success: function(mm){
					 $("#lic").append($(mm).html(mm));
					 }	  
			});
	  		$('#licnm').val("");
	  		$('#issue').val("");
	  		$('#issuedt').val("");
	  		$('#licpic').val("");
	  });
	  $('#button2').click(function(){ //button2를 클릭했을 경우
		  $.ajax({
				type: "POST",
				url: "staff.jhj?command=staff_car",
				data: {prjtnm:$("#prjtnm").val(),
					prjtskill:$("#prjtskill").val(),
					startdt:$("#startdt").val(),
					enddt:$("#enddt").val(),
					ordernm:$("#ordernm").val(),
					rolecd:$("#rolecd").val()
					},
				  success: function(mm){
					 $("#car").append($(mm).html(mm));
					 }	  
			});
		    $("#prjtnm").val("");
			$("#prjtskill").val("");
			$("#startdt").val("");
			$("#enddt").val("");
			$("#ordernm").val("");
			$("#rolecd").val("");
	  });
	  $('#button3').click(function(){ //button3을 클릭했을 경우
		  $.ajax({
				type: "POST",
				url: "staff.jhj?command=staff_aca",
				data: {scd:$("#scd").val(),
					scname:$("#scname").val(),
					subjectnm:$("#subjectnm").val(),
					entrancedt:$("#entrancedt").val(),
					graduatedt:$("#graduatedt").val(),
					graduateyn:$("#graduateyn").val(),
					spic:$("#spic").val()
					},
				  success: function(mm){
					 $("#aca").append($(mm).html(mm));
					 }	  
			});
		  	$("#scd").val("");
			$("#scname").val("");
			$("#subjectnm").val("");
			$("#entrancedt").val("");
			$("#graduatedt").val("");
			$("#graduateyn").val("");
			$("#spic").val();
	  });
	});
</script>
</head>
<body>
	<a href="staff.jhj?command=staff_list"> 완료 </a>

<div style="width: 850px; margin: 0 auto; margin-top: 20px">
 <ul class="nav nav-tabs">
      <li class="active"><a href="#home" data-toggle="tab">자격증 정보</a></li>
      <li><a href="#tab1" data-toggle="tab">경력 사항</a></li>
      <li><a href="#tab2" data-toggle="tab">학력 사항</a></li>
    </ul>
   
  <div class="tab-content">
    <div class="tab-pane active" id="home">
      <fieldset>
 <legend>자격증사항 입력</legend>
 <table class="join_tbl">
<colgroup>
 <col width="20%" />
 <col width="30%" />
 <col width="20%" />
 <col width="30%" />
 </colgroup>
 <tr>
 <th>자격증명
 </th>
 <td><input type="text" class="inputText" name="licnm" id="licnm">
 </td>
 
 <th>발급처</th>
 <td><input type="text" class="inputText" name="issue" id="issue"></td>
 </tr>
  <tr>
 <th>발급일</th>
 <td><input type="text" name="issuedt" class="inputText" id="issuedt"></td>

 <th>자격증 스캔파일</th>
 <td><input type="file" id="licpic" name="licpic" class="inputText" style="display: none;">
 <input type="button" value="찾아보기" class="btn" onclick="document.licpic.click();"></td>
 </tr>
 </table>
 <input type="button" id="button1" value="추가하기">
 <fieldset id=lic></fieldset>
</fieldset>
</div>


<div class="tab-pane" id="tab1">
<fieldset>
 <legend>경력사항 입력</legend>
  <table class="join_tbl">
<colgroup>
 <col width="20%" />
 <col width="30%" />
 <col width="20%" />
 <col width="30%" />
 </colgroup>
 <tr>
 <th>프로젝트명</th>
 <td><input type="text" class="inputText" name="prjtnm" id="prjtnm"></td>
 <th>소요기술</th>
 <td><input type="text" class="inputText" name="prjtskill" id="prjtskill"></td>
 </tr>
  <tr>
 <th>시작일</th>
 <td><input type="text" class="inputText" name="startdt" id="startdt"></td>
 <th>종료일</th>
 <td><input type="text" class="inputText" id="enddt" name="enddt"></td>
 </tr>
  <tr>
 <th>발주처</th>
 <td><input type="text" class="inputText" name="ordernm" id="ordernm"></td>
 <th>역할</th>
 <td><select class="select" name="rolecd" id="rolecd">
 <option value="">선택하세요</option>
 <option value="00">DEV</option><option value="01">PL</option>
 <option value="10">PM</option><option value="11">PMO</option>
 <option value="21">SALES</option>
 </select></td>
 </tr>
 </table>
 <input type="button" id="button2" value="추가하기">
 <fieldset id=car></fieldset>
 </fieldset>
    </div>

    <div class="tab-pane" id="tab2">
<fieldset>
 <legend>학력사항 입력</legend>
 <table class="join_tbl">
 <colgroup>
 <col width="20%" />
 <col width="30%" />
 <col width="20%" />
 <col width="30%" />
 </colgroup>
 <tr>
 <th>학력</th>
 <td><select class="select" name="scd" id="scd">
 <option value="">선택하세요</option>
 <option value="00">초등</option><option value="01">중등</option>
 <option value="11">고등</option><option value="20">전문</option>
 <option value="21">대학</option><option value="30">석사</option>
 <option value="31">박사</option>
 </select></td>
 <th colspan="2"></th>
 </tr>
 <tr>
 <th>학교명</th>
 <td><input type="text" class="inputText" name="scname" id="scname"></td>
 <th>학과명</th>
 <td><input type="text" class="inputText" name="subjectnm" id="subjectnm"></td>
 </tr>
  <tr>
 <th>입학일</th>
 <td><input type="text" class="inputText" id="entrancedt" name="entrancedt"></td>
 <th>졸업일</th>
 <td><input type="text" class="inputText" id="graduatedt" name="graduatedt"></td>
 </tr>
  <tr>
 <th>졸업여부</th>
 <td><select class="select" name="graduateyn" id="graduateyn">
 <option value="">선택하세요</option>
 <option value="0">졸업</option><option value="1">졸업예정</option>
 <option value="2">중퇴</option>
 </select></td>
 <th>졸업증명 스캔파일</th>
 <td><input type="file" name="spic" id="spic" class="inputText" style="display: none;">
 <input type="button" value="찾아보기" class="btn" onclick="document.reg_frm.spic.click();"></td>
 </tr>
 </table>
 <input type="button" id="button3" value="추가하기">
 <fieldset id=aca></fieldset>
</fieldset>
</div>
</div>
</div>
</body>
</html>