<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript">
	function del_event(sno) {
		if (confirm("정말삭제하시겠습니까?")==true) {
			location.href="staff.jhj?command=staff_delete&sno=" + sno;
		} else {
			return;
		}
			
	}
</script>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>

<style type="text/css">
h3 {
	margin-bottom: 15px
}

fieldset {
	border: none;
}

legend {
	display: none;
}

img {
	border: none;
	width: 130px;
	height: 180px;
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

<style>
h2 {
	margin: 20px 0
}

.tab-content {
	padding: 10px 0;
}
</style>

</head>
<body>
<jsp:include page="../main/top.jsp"></jsp:include>
	<div style="width: 850px; margin: 0 auto;">
		<h2>사원 정보</h2>
		<form method="post" action="staff.jhj?command=staff_update_form">
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
								<img src="img/${staffInfo.pictureUrl }">
							</div>
							<br>
						</td>
						<th>사번</th>
						<td> ${staffInfo.sNo }
							<input type="hidden" value="${staffInfo.sNo }" name="sno">
						</td>
					</tr>
					<tr>
						<th>이름</th>
						<td>${staffInfo.sName }</td>
					</tr>
					<tr>
						<th>주민번호</th>
						<td>${staffInfo.jumin1 } - ${fn:substring(staffInfo.jumin2, 0 , 1) }******</td>
					</tr>
					<tr>
						<th>성별</th>
						
						<td>
							<c:choose>
								<c:when test="${staffInfo.genderCd == '1' }">
									남
								</c:when>
								<c:otherwise>
									여
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<th>이메일</th>
						<td>${staffInfo.email }</td>
					</tr>
					<tr>
						<th>전화번호</th>
						<td>${staffInfo.sPhone }</td>
					</tr>
					<tr>
						<th>부서</th>
						<td>${staffInfo.deptName }</td>
					</tr>
					<tr>
						<td rowspan="9" style="background-color: #e6e6e6;"></td>
						<th>직급</th>
						<td>${staffInfo.jobName }</td>
					</tr>
					<tr>
						<th>입사일</th>
						<td>${staffInfo.joinDt }</td>
					</tr>
					<tr>
						<th>퇴사일</th>
						<td>${staffInfo.retireDt }</td>
					</tr>
					<tr>
						<th>우편번호</th>
						<td>${staffInfo.zipCode }</td>
					</tr>
					<tr>
						<th>주소</th>
						<td>${staffInfo.addr1 }</td>
					</tr>
					<tr>
						<th>상세주소</th>
						<td>${staffInfo.addr2 }</td>
					</tr>
					<tr>
						<th>급여</th>
						<td>${staffInfo.sal }</td>
					</tr>
					<tr>
						<th>비고</th>
						<td>${staffInfo.skill }</td>
					</tr>
					<tr>
						<th>등록일</th>
						<td>${staffInfo.regDt }</td>
					</tr>
				</table>
				<%String no = request.getParameter("sno"); %>
				<input type="button" value="목록" onclick="history.go(-1);" style="margin: 0 auto;">
				<c:choose>
				<c:when test="${staffInfo.sNo == sNo}">
				<input type="submit" value="수정" style="margin-left: 10px">
				</c:when>
				</c:choose>
				<c:choose>
				<c:when test="${admin == 1000}">
				<input type="submit" value="수정" style="margin-left: 10px">
				</c:when>
				</c:choose>
				<c:choose>
				<c:when test="${admin == 1000}">
				<input type="button" value="삭제" onclick="del_event(<%=no%>);" style="margin-left: 10px"> <br>
				</c:when>
				</c:choose>
		</form>
		<div style="width: 850px; margin: 0 auto; margin-top: 20px">
			<ul class="nav nav-tabs">
				<li class="active"><a href="#home" data-toggle="tab">자격증 정보</a></li>
				<li><a href="#tab1" data-toggle="tab">경력 사항</a></li>
				<li><a href="#tab2" data-toggle="tab">학력 사항</a></li>
			</ul>

			<div class="tab-content">
				<div class="tab-pane active" id="home">
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
				</div>


				<div class="tab-pane" id="tab1">
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
				</div>
				<div class="tab-pane" id="tab2">
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
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="../main/footer.jsp"></jsp:include>
</body>
</html>