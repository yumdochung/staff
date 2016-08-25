<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script src="js/staff.js"></script>
<style type="text/css">
h3 {
	margin-bottom: 15px
}

fieldset {
	border: none
}

legend {
	display: none
}

img {
	border: none
}

.join_tbl {
	width: 850px;
	border-collapse: collapse;
	border-spacing: 0;
	border-top: 2px solid #ddd;
	border-bottom: 2px solid #ddd;
	font-size: 15px;
	font-family: dotum;
	margin-bottom: 30px;
	margin-top: 30px;
}

.join_tbl th {
	text-align: left;
	padding: 5px 10px;
	border-bottom: 1px solid #ddd;
	color: #3f93c7;
	background-color: #e6e6e6
}

.join_tbl td {
	padding: 5px 15px;
	border-bottom: 1px solid #ddd
}

.join_tbl td .inputText {
	width: 100px;
	border: 1px solid #ccc
}

.join_tbl td .juso {
	width: 220px;
	border: 1px solid #ccc
}

.join_tbl td .hp {
	width: 40px;
	border: 1px solid #ccc
}

.join_tbl td .select {
	width: 100px;
	border: 1px solid #ccc
}

.join_tbl td .btn {
	border: 1px solid #ccc;
	padding: 3px 5px;
	font-size: 11px;
	font-family: dotum;
	margin-left: 3px;
	border-radius: 5px;
}

.join_tbl td span {
	color: #888
}

.join_tbl textarea {
	width: 95%;
	height: 80px;
	border: 1px solid #ccc;
	padding: 10px
}

.btn {
	text-align: center
}
#print{
	font-size: 8pt;
}
</style>
</head>
<body>
	<jsp:include page="../main/top.jsp"></jsp:include>
	<div style="width: 850px; margin: 0 auto;">
		<h2>사원 기본정보 등록</h2>
		<form method="post" action="staff.jhj?command=staff_insert" name="reg_frm" enctype="multipart/form-data">
				<table class="join_tbl">
					<colgroup>
						<col width="20%" />
						<col width="20%" />
						<col width="60%" />
					</colgroup>
					<tr>
						<td rowspan="7" style="background-color: #e6e6e6; border-bottom: 0px">
						<div style="background-color: #ffffff; width: 130px; height: 160px">
					
					
					
					
						</div>
					
					
					
					
					
							<img id="img_preview" style="width: 130px;height: 160px">
						<input type="file" name="pictureUrl" id="file"	style="display: none;" onchange="readURL(this)"/>
						<input type="button" value="사진등록" class="btn" onclick="document.all.file.click();">&nbsp;&nbsp;
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						<input type="button" value="삭&nbsp;제" class="btn">
						</td>
						<th>이름</th>
						<td><input type="text" id="sname" name="sname"
							class="inputText"></td>
					</tr>
					<tr>
						<th>주민번호</th>
						<td><input type="text" maxlength="6" name="jumin1" id="jumin1"
							class="inputText"> - <input type="password" maxlength="7"
							name="jumin2" id="jumin2" class="inputText"></td>
					</tr>
					<tr>
						<th>성별</th>
						<td><input type="radio" name="gendercd" id="gendercd" value="1">남&nbsp;&nbsp;&nbsp;<input
							type="radio" name="gendercd" id="gendercd" value="2">여</td>
					</tr>
					<tr>
						<th>이메일</th>
						<td><input type="text" id="email1" name="email1" class="inputText">@<input
							type="text" name="email2" id="email2" class="inputText"> <select
							class="select" name="email3" id="email3" onchange="select_email();">
								<option>선택하세요</option>
								<option value="naver.com">naver.com</option>
								<option value="nate.com">nate.com</option>
								<option value="hanmail.net">hanmail.net</option>
								<option value="gmail.com">gmail.com</option>
								<option value="msn.com">msn.com</option>
								<option value="">직접입력</option>
						</select></td>
					</tr>
					<tr>
						<th>전화번호</th>
						<td><input type="text" class="hp" name="hp1" maxlength="3">-<input
							type="text" class="hp" name="hp2" maxlength="4">-<input type="text"
							class="hp" name="hp3" maxlength="4"></td>
					</tr>
					<tr>
						<th>부서</th>
						<td><select class="select" name="deptcd">
								<option value="">선택하세요</option>
								<option value="0001">관리부</option>
								<option value="1001">개발부</option>
								<option value="2001">영업부</option>
								<option value="3001">인사부</option>
						</select></td>
					</tr>
					<tr>
						<th>직급</th>
						<td><select class="select" name="jobcd">
								<option value="">선택하세요</option>
								<option value="0000">사원</option>
								<option value="0001">주임</option>
								<option value="0002">대리</option>
								<option value="1001">과장</option>
								<option value="1002">차장</option>
								<option value="1003">부장</option>
								<option value="2001">상무</option>
								<option value="3001">대표</option>
						</select></td>
					</tr>
					<tr>
						<td rowspan="5" style="background-color: #e6e6e6;"></td>
						<th>우편번호</th>
						<td><input type="text" name="zipcode" class="inputText" readonly="readonly">
						<input type="button" value="우편번호 검색" class="btn" onclick="Zipcode();"></td>
					</tr>
					<tr>
						<th>주소</th>
						<td><input type="text" class="juso" id="addr1" name="addr1" readonly="readonly"></td>
					</tr>
					<tr>

						<th>상세주소</th>
						<td><input type="text" class="juso" name="addr2"></td>
					</tr>
					<tr>
						<th>급여</th>
						<td><input type="text" class="inputText" name="sal"></td>
					</tr>
					<tr>
						<th>업무 가능 기술</th>
						<td><textarea name="skill"></textarea></td>
					</tr>
				</table>
				<input type="submit" value="등록" style="margin-left: 250px" onclick="return check_ok();" >
				<input type="button" value="취소" onclick="history.go(-1);" style="margin-left: 10px">
		</form>
			</div>
			<jsp:include page="../main/footer.jsp"></jsp:include>
			<jsp:include page="../main/modal.jsp"></jsp:include>
</body>
</html>