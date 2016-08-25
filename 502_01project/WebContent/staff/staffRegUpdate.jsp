<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="css/bootstrap.min.css" rel="stylesheet">
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
	border: none;
	width: 130px;
	height: 160px;
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

.join_tbl td .zipcode {
	width: 45px;
	border: 1px solid #ccc
}

.join_tbl td .juso {
	width: 220px;
	border: 1px solid #ccc
}

.join_tbl td .hp {
	width: 30px;
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
</style>

</head>

<c:choose>
	<c:when test="${admin == 1000}">
<body>
<jsp:include page="../main/top.jsp"></jsp:include>
	<div style="width: 850px; margin: 0 auto;">
	<h2>사원 수정</h2>
		<form method="post" action="staff.jhj?command=staff_update" name="reg_frm" enctype="multipart/form-data">
				<table class="join_tbl">
					<colgroup>
						<col width="20%" />
						<col width="20%" />
						<col width="60%" />
					</colgroup>
					<tr>
						<td rowspan="7"
							style="background-color: #e6e6e6; border-bottom: 0px">
							<div
								style="background-color: #ffffff; width: 130px; height: 160px">
								<img  id="img_preview" src="img/${staffInfo.pictureUrl}">
								<input type="hidden" name="oldPictureUrl" value="${staffInfo.pictureUrl}">
							</div>
							<br> <input type="file" name="pictureUrl" id="file"
							style="display: none;" value="${staffInfo.pictureUrl}" onchange="readURL(this)" onclick="Zipcode();"/> 
							<input type="button" value="사진수정" class="btn" onclick="document.all.file.click();">&nbsp;&nbsp;
							<input type="button" value="삭&nbsp;제" class="btn">
						</td>
						<th>사번</th>
						<td><input type="text" class="inputText" name="sno"
							 value="${staffInfo.sNo }" readonly></td>
					</tr>
					<tr>
						<th>이름</th>
						<td><input type="text" name="sname" class="inputText"
							value="${staffInfo.sName }"></td>
					</tr>
					<tr>
						<th>주민번호</th>
						<td><input type="text" maxlength="6" name="jumin1" size="10"
							class="inputText" value="${staffInfo.jumin1 }"> - <input
							type="password" maxlength="7" name="jumin2" size="10"
							class="inputText" value="${staffInfo.jumin2 }"></td>
					</tr>
					<tr>
						<th>성별</th>
						<td>
						<c:choose>
						<c:when test="${staffInfo.genderCd==1 }">
						<input type="radio" name="gendercd" value="1" checked>남&nbsp;&nbsp;&nbsp;
						<input type="radio" name="gendercd" value="2">여
						</c:when>
						<c:otherwise>
						<input type="radio" name="gendercd" value="1">남&nbsp;&nbsp;&nbsp;
						<input type="radio" name="gendercd" value="2" checked>여
						</c:otherwise>
						</c:choose>
						</td>
						
					</tr>
					<tr>
						<th>이메일</th>
						<td><input type="text" name="email1" class="inputText"
							value="${staffInfo.mail1 }">@<input type="text"
							name="email2" class="inputText" value="${staffInfo.mail2 }">
							<select	class="select" name="email3" id="email3" onchange="select_email();">
								<option>선택하세요</option>
								<option value="naver.com">naver.com</option>
								<option value="nate.com">nate.com</option>
								<option value="hanmail.net">hanmail.net</option>
								<option value="gmail.com">과장</option>
								<option value="msn.com">msn.com</option>
								<option value="">직접입력</option>
						</select></td>
					</tr>
					<tr>
						<th>전화번호</th>
						<td><input type="text" class="hp" name="hp1"
							value="${staffInfo.hp1 }">-<input type="text" class="hp"
							name="hp2" value="${staffInfo.hp2 }">-<input type="text"
							class="hp" name="hp3" value="${staffInfo.hp3 }"></td>
					</tr>
					<tr>
						<th>부서</th>
						<td>
						<select class="select" name="deptcd">
								<option value="">선택하세요</option>
								<c:choose>
								<c:when test="${staffInfo.deptName=='관리부'}">
								<option value="0001" selected>관리부</option>
								<option value="1001">개발부</option>
								<option value="2001">영업부</option>
								<option value="3001">인사부</option>
								</c:when>
								<c:when test="${staffInfo.deptName=='개발부'}">
								<option value="0001">관리부</option>
								<option value="1001" selected>개발부</option>
								<option value="2001">영업부</option>
								<option value="3001">인사부</option>
								</c:when>
								<c:when test="${staffInfo.deptName=='영업부'}">
								<option value="0001">관리부</option>
								<option value="1001">개발부</option>
								<option value="2001" selected>영업부</option>
								<option value="3001">인사부</option>
								</c:when>
								<c:otherwise>
								<option value="0001">관리부</option>
								<option value="1001">개발부</option>
								<option value="2001">영업부</option>
								<option value="3001" selected>인사부</option>
								</c:otherwise>
								</c:choose>
						</select>
						</td>
					</tr>
					<tr>
						<td rowspan="9" style="background-color: #e6e6e6;"></td>
						<th>직급</th>
						<td><select class="select" name="jobcd">
								<option value="">선택하세요</option>
								<c:choose>
								<c:when test="${staffInfo.jobName=='사원'}">
								<option value="0000" selected>사원</option>
								<option value="0001">주임</option>
								<option value="0002">대리</option>
								<option value="1001">과장</option>
								<option value="1002">차장</option>
								<option value="1003">부장</option>
								<option value="2001">상무</option>
								<option value="3001">대표</option>
								</c:when>
								<c:when test="${staffInfo.jobName=='주임'}">
								<option value="0000">사원</option>
								<option value="0001" selected>주임</option>
								<option value="0002">대리</option>
								<option value="1001">과장</option>
								<option value="1002">차장</option>
								<option value="1003">부장</option>
								<option value="2001">상무</option>
								<option value="3001">대표</option>
								</c:when>
								<c:when test="${staffInfo.jobName=='대리'}">
								<option value="0000">사원</option>
								<option value="0001">주임</option>
								<option value="0002" selected>대리</option>
								<option value="1001">과장</option>
								<option value="1002">차장</option>
								<option value="1003">부장</option>
								<option value="2001">상무</option>
								<option value="3001">대표</option>
								</c:when>
								<c:when test="${staffInfo.jobName=='과장'}">
								<option value="0000">사원</option>
								<option value="0001">주임</option>
								<option value="0002">대리</option>
								<option value="1001" selected>과장</option>
								<option value="1002">차장</option>
								<option value="1003">부장</option>
								<option value="2001">상무</option>
								<option value="3001">대표</option>
								</c:when>
								<c:when test="${staffInfo.jobName=='차장'}">
								<option value="0000">사원</option>
								<option value="0001">주임</option>
								<option value="0002">대리</option>
								<option value="1001">과장</option>
								<option value="1002" selected>차장</option>
								<option value="1003">부장</option>
								<option value="2001">상무</option>
								<option value="3001">대표</option>
								</c:when>
								<c:when test="${staffInfo.jobName=='부장'}">
								<option value="0000">사원</option>
								<option value="0001">주임</option>
								<option value="0002">대리</option>
								<option value="1001">과장</option>
								<option value="1002">차장</option>
								<option value="1003" selected>부장</option>
								<option value="2001">상무</option>
								<option value="3001">대표</option>
								</c:when>
								<c:when test="${staffInfo.jobName=='상무'}">
								<option value="0000">사원</option>
								<option value="0001">주임</option>
								<option value="0002">대리</option>
								<option value="1001">과장</option>
								<option value="1002">차장</option>
								<option value="1003">부장</option>
								<option value="2001" selected>상무</option>
								<option value="3001">대표</option>
								</c:when>
								<c:otherwise>
								<option value="0000">사원</option>
								<option value="0001">주임</option>
								<option value="0002">대리</option>
								<option value="1001">과장</option>
								<option value="1002">차장</option>
								<option value="1003">부장</option>
								<option value="2001">상무</option>
								<option value="3001" selected>대표</option>
								</c:otherwise>
								</c:choose>
						</select></td>
					</tr>
					<tr>
						<th>입사일</th>
						<td><input type="text" class="inputText" name="joindt"
							value="${staffInfo.joinDt }"></td>
					</tr>
					<tr>
						<th>퇴사일</th>
						<td><input type="text" class="inputText" name="retiredt"
							value="${staffInfo.retireDt }"></td>
					</tr>
					<tr>
						<th>우편번호</th>
						<td><input type="text" name="zipcode" class="inputText"
							value="${staffInfo.zipCode }"><input type="button"
							value="우편번호 검색" class="btn"></td>
					</tr>
					<tr>
						<th>주소</th>
						<td><input type="text" class="juso" name="addr1"
							value="${staffInfo.addr1 }"></td>
					</tr>
					<tr>
						<th>상세주소</th>
						<td><input type="text" class="juso" name="addr2"
							value="${staffInfo.addr2 }"></td>
					</tr>
					<tr>
						<th>급여</th>
						<td><input type="text" class="inputText" name="sal"
							 value="${staffInfo.sal }"></td>
					</tr>
					<tr>
						<th>비고</th>
						<td><textarea name="skill">${staffInfo.skill }</textarea></td>
					</tr>
					<tr>
						<th>등록일</th>
						<td><input type="text" class="inputText" name="regdt"
							 value="${staffInfo.regDt }" readonly></td>
					</tr>
				</table>
				<input type="submit" value="수정" style="margin-left: 250px"><input
					type="button" value="취소" onclick="history.go(-1);"
					style="margin-left: 10px"> <br>
				<br>
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
						<c:forEach var="staff" items="${stafflic }">
						<table class="join_tbl">
							<colgroup>
								<col width="20%" />
								<col width="30%" />
								<col width="20%" />
								<col width="30%" />
							</colgroup>
							<tr>
								<th>자격증명 
									<input type="hidden" name="lic_seq" value="${staff.lic_seq }">
								</th>
								<td> ${staff.licnm }
									<input type="hidden" name="licnm" value="${staff.licnm }">
								</td>

								<th>발급처</th>
								<td> ${staff.issue }
									<input type="hidden" name="issue" value="${staff.issue }">
								</td>
							</tr>
							<tr>
								<th>발급일</th>
								<td> ${staff.issuedt }
									<input type="hidden" name="issuedt" value="${staff.issuedt }">
								</td>

								<th>자격증 스캔파일</th>
								<td> ${staff.licpic }
								 	<!-- <input	type="button" value="찾아보기" class="btn" onclick="document.licpic.click();"> -->
								 	<input type="hidden" name="licpic" value="${staff.licpic }">
								 </td>
							</tr>
						</table>
						<fieldset id=lic></fieldset>
						 </c:forEach>
					</fieldset>
				</div>


				<div class="tab-pane" id="tab1">
					<fieldset>
						<legend>경력사항 입력</legend>
						<c:forEach var="staff" items="${staffcar }">
						<table class="join_tbl">
							<colgroup>
								<col width="20%" />
								<col width="30%" />
								<col width="20%" />
								<col width="30%" />
							</colgroup>
							<tr>
								<th>프로젝트명  
									<input type="hidden" name="car_seq" value="${staff.car_seq }">
								</th>
								<td> ${staff.prjtnm }
									<input type="hidden" name="prjtnm" value="${staff.prjtnm }">
								</td>
								<th>소요기술</th>
								<td> ${staff.prjtskill }
									<input type="hidden" name="prjtskill" value="${staff.prjtskill }">
								</td>
							</tr>
							<tr>
								<th>시작일</th>
								<td> ${staff.startdt }
									<input type="hidden" name="startdt" value="${staff.startdt }">
								</td>
								<th>종료일</th>
								<td> ${staff.enddt }
									<input type="hidden" name="enddt" value="${staff.enddt }">
								</td>
							</tr>
							<tr>
								<th>발주처</th>
								<td> ${staff.ordernm }
									<input type="hidden" name="ordernm" value="${staff.ordernm }">
								</td>
								<th>역할</th>
								<td> ${staff.rolecd }
								<input type="hidden" name="rolecd" value="${staff.rolecd }">
								</td>
							</tr>
						</table>
						<fieldset id=car></fieldset>
						</c:forEach>
					</fieldset>
				</div>
				<div class="tab-pane" id="tab2">
					<fieldset>
						<legend>학력사항 입력</legend>
						<c:forEach var="staff" items="${staffaca }">
						<table class="join_tbl">
							<colgroup>
								<col width="20%" />
								<col width="30%" />
								<col width="20%" />
								<col width="30%" />
							</colgroup>
							<tr>
								<th>학력
									<input type="hidden" name="aca_seq" value="${staff.aca_seq }">
								</th>
								<td> ${staff.scd }
									<input type="hidden" name="scd" value="${staff.scd }">
								</td>
								<th colspan="2"></th>
							</tr>
							<tr>
								<th>학교명</th>
								<td> ${staff.scname }
									<input type="hidden" name="scname" id="scname">
								</td>
								<th>학과명</th>
								<td> ${staff.subjectnm }
									<input type="hidden" name="subjectnm" id="subjectnm" value="${staff.subjectnm }">
								</td>
							</tr>
							<tr>
								<th>입학일</th>
								<td> ${staff.entrancedt }
									<input type="hidden" id="entrancedt" name="entrancedt" value="${staff.entrancedt }">
								</td>
								<th>졸업일</th>
								<td> ${staff.graduatedt }
									<input type="hidden" id="graduatedt" name="graduatedt" value="${staff.graduatedt }">
								</td>
							</tr>
							<tr>
								<th>졸업여부</th>
								<td> ${staff.graduateyn }
									<input type="hidden" id="graduateyn" name="graduateyn" value="${staff.graduateyn }">
								</td>
								<th>졸업증명 스캔파일</th>
								<td> ${staff.spic }
									<input type="hidden" id="spic" name="spic" value="${staff.spic }">
								</td>
							</tr>
						</table>
						<fieldset id=aca></fieldset>
						</c:forEach>
					</fieldset>
				</div>
			</div>
		</div>
		</form>
	</div>
	<jsp:include page="../main/footer.jsp"></jsp:include>
</body>
</c:when>
<c:otherwise>
<body>

	<div class="container">
		<form method="post" action="staff.jhj?command=staff_update" name="reg_frm" enctype="multipart/form-data">
				<table class="join_tbl">
					<colgroup>
						<col width="20%" />
						<col width="20%" />
						<col width="60%" />
					</colgroup>
					<tr>
						<td rowspan="7"
							style="background-color: #e6e6e6; border-bottom: 0px">
							<div
								style="background-color: #ffffff; width: 130px; height: 160px">
								<img src="img/${staffInfo.pictureUrl}">
							</div>
							<br> <input type="file" name="pictureUrl" id="file"
							style="display: none;" /> <input type="button" value="사진수정"
							class="btn" onclick="document.all.file.click();">&nbsp;&nbsp;
							<input type="button" value="삭&nbsp;제" class="btn">
						</td>
						<th>사번</th>
						<td><input type="text" class="inputText" name="sno"
							 value="${staffInfo.sNo }" readonly></td>
					</tr>
					<tr>
						<th>이름</th>
						<td><input type="text" name="sname" class="inputText"
							value="${staffInfo.sName }"></td>
					</tr>
					<tr>
						<th>주민번호</th>
						<td><input type="text" maxlength="6" name="jumin1" size="10"
							class="inputText" value="${staffInfo.jumin1 }"> - <input
							type="password" maxlength="7" name="jumin2" size="10"
							class="inputText" value="${staffInfo.jumin2 }"></td>
					</tr>
					<tr>
						<th>성별</th>
						<td><input type="radio" name="gendercd" value="1">남&nbsp;&nbsp;&nbsp;<input
							type="radio" name="gendercd" value="${staffInfo.genderCd }">여</td>
					</tr>
					<tr>
						<th>이메일</th>
						<td><input type="text" name="email1" class="inputText"
							value="${staffInfo.mail1 }">@<input type="text"
							name="email2" class="inputText" value="${staffInfo.mail2 }">
							<select class="select" name="email3">
								<option>선택하세요</option>
								<option value="naver.com">naver.com</option>
								<option value="nate.com">nate.com</option>
								<option value="hanmail.net">hanmail.net</option>
								<option value="gmail.com">과장</option>
								<option value="msn.com">msn.com</option>
								<option value="">직접입력</option>
						</select></td>
					</tr>
					<tr>
						<th>전화번호</th>
						<td><input type="text" class="hp" name="hp1"
							value="${staffInfo.hp1 }">-<input type="text" class="hp"
							name="hp2" value="${staffInfo.hp2 }">-<input type="text"
							class="hp" name="hp3" value="${staffInfo.hp3 }"></td>
					</tr>
					<tr>
						<th>부서</th>
						<td><select class="select" name="deptcd">
								<option value="">선택하세요</option>
								<c:choose>
								<c:when test="${staffInfo.deptName=='관리부'}">
								<option value="0001" selected>관리부</option>
								<option value="1001">개발부</option>
								<option value="2001">영업부</option>
								<option value="3001">인사부</option>
								</c:when>
								<c:when test="${staffInfo.deptName=='개발부'}">
								<option value="0001">관리부</option>
								<option value="1001" selected>개발부</option>
								<option value="2001">영업부</option>
								<option value="3001">인사부</option>
								</c:when>
								<c:when test="${staffInfo.deptName=='영업부'}">
								<option value="0001">관리부</option>
								<option value="1001">개발부</option>
								<option value="2001" selected>영업부</option>
								<option value="3001">인사부</option>
								</c:when>
								<c:otherwise>
								<option value="0001">관리부</option>
								<option value="1001">개발부</option>
								<option value="2001">영업부</option>
								<option value="3001" selected>인사부</option>
								</c:otherwise>
								</c:choose>
						</select></td>
					</tr>
					<tr>
						<td rowspan="9" style="background-color: #e6e6e6;"></td>
						<th>직급</th>
						<td><select class="select" name="jobcd">
								<option value="">선택하세요</option>
								<c:choose>
								<c:when test="${staffInfo.jobName=='사원'}">
								<option value="0000" selected>사원</option>
								<option value="0001">주임</option>
								<option value="0002">대리</option>
								<option value="1001">과장</option>
								<option value="1002">차장</option>
								<option value="1003">부장</option>
								<option value="2001">상무</option>
								<option value="3001">대표</option>
								</c:when>
								<c:when test="${staffInfo.jobName=='주임'}">
								<option value="0000">사원</option>
								<option value="0001" selected>주임</option>
								<option value="0002">대리</option>
								<option value="1001">과장</option>
								<option value="1002">차장</option>
								<option value="1003">부장</option>
								<option value="2001">상무</option>
								<option value="3001">대표</option>
								</c:when>
								<c:when test="${staffInfo.jobName=='대리'}">
								<option value="0000">사원</option>
								<option value="0001">주임</option>
								<option value="0002" selected>대리</option>
								<option value="1001">과장</option>
								<option value="1002">차장</option>
								<option value="1003">부장</option>
								<option value="2001">상무</option>
								<option value="3001">대표</option>
								</c:when>
								<c:when test="${staffInfo.jobName=='과장'}">
								<option value="0000">사원</option>
								<option value="0001">주임</option>
								<option value="0002">대리</option>
								<option value="1001" selected>과장</option>
								<option value="1002">차장</option>
								<option value="1003">부장</option>
								<option value="2001">상무</option>
								<option value="3001">대표</option>
								</c:when>
								<c:when test="${staffInfo.jobName=='차장'}">
								<option value="0000">사원</option>
								<option value="0001">주임</option>
								<option value="0002">대리</option>
								<option value="1001">과장</option>
								<option value="1002" selected>차장</option>
								<option value="1003">부장</option>
								<option value="2001">상무</option>
								<option value="3001">대표</option>
								</c:when>
								<c:when test="${staffInfo.jobName=='부장'}">
								<option value="0000">사원</option>
								<option value="0001">주임</option>
								<option value="0002">대리</option>
								<option value="1001">과장</option>
								<option value="1002">차장</option>
								<option value="1003" selected>부장</option>
								<option value="2001">상무</option>
								<option value="3001">대표</option>
								</c:when>
								<c:when test="${staffInfo.jobName=='상무'}">
								<option value="0000">사원</option>
								<option value="0001">주임</option>
								<option value="0002">대리</option>
								<option value="1001">과장</option>
								<option value="1002">차장</option>
								<option value="1003">부장</option>
								<option value="2001" selected>상무</option>
								<option value="3001">대표</option>
								</c:when>
								<c:otherwise>
								<option value="0000">사원</option>
								<option value="0001">주임</option>
								<option value="0002">대리</option>
								<option value="1001">과장</option>
								<option value="1002">차장</option>
								<option value="1003">부장</option>
								<option value="2001">상무</option>
								<option value="3001" selected>대표</option>
								</c:otherwise>
								</c:choose>
						</select></td>
					</tr>
					<tr>
						<th>입사일</th>
						<td><input type="text" class="inputText" name="joindt"
							value="${staffInfo.joinDt }" readonly></td>
					</tr>
					<tr>
						<th>퇴사일</th>
						<td><input type="text" class="inputText" name="retiredt"
							value="${staffInfo.retireDt }" readonly></td>
					</tr>
					<tr>
						<th>우편번호</th>
						<td><input type="text" name="zipcode" class="inputText"
							value="${staffInfo.zipCode }"><input type="button"
							value="우편번호 검색" class="btn"></td>
					</tr>
					<tr>
						<th>주소</th>
						<td><input type="text" class="juso" name="addr1"
							value="${staffInfo.addr1 }"></td>
					</tr>
					<tr>
						<th>상세주소</th>
						<td><input type="text" class="juso" name="addr2"
							value="${staffInfo.addr2 }"></td>
					</tr>
					<tr>
						<th>급여</th>
						<td><input type="text" class="inputText" name="sal"
							 value="${staffInfo.sal }" readonly></td>
					</tr>
					<tr>
						<th>비고</th>
						<td><textarea name="skill">${staffInfo.skill }</textarea></td>
					</tr>
					<tr>
						<th>등록일</th>
						<td><input type="text" class="inputText" name="regdt"
							 value="${staffInfo.regDt }" readonly></td>
					</tr>
				</table>
				<input type="submit" value="수정" style="margin-left: 250px"><input
					type="button" value="취소" onclick="history.go(-1);"
					style="margin-left: 10px"> <br>
				<br>
		</form>
	</div>
	<jsp:include page="../main/footer.jsp"></jsp:include>
</body>
</c:otherwise>
</c:choose>
</html>