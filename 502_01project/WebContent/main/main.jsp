<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome to Mars</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="js/comm.js"></script>
<script src="//code.jquery.com/jquery.min.js"></script>
<!-- <script src="../js/jquery-ui.min.js"></script>
<link rel="stylesheet" href="../css/jquery-ui.css"> -->
<style type="text/css">
*{margin:0;padding:0;}
li{list-style:none;}
a{text-decoration:none;color:#000;}
#gallery{width:900px;margin:30px auto;
border:1px solid #999;
box-shadow:0 5px 5px rgba(0, 0, 0, 0.3);}
#gallery h1{text-align:center;}
#gallery img{border:1px solid #666;}
#photo{text-align:center;}
#gallery ul{width:800px;margin:0 auto;
overflow:hidden;}
#photo_list ul li{width:100px;float:left;text-align:center;}
#photo_list{width:300px;margin:10px auto;
/*border:1px dashed #000;*/overflow:hidden;}
.btn_wrap{text-align:center;}
.btn_wrap a{font-weight:bold;}
</style>
<script type="text/javascript">
window.onload=function(){
    /*① 포토 목록에 작은 이미지를 클릭했을 때
            큰 이미지를 바꿉니다. */
    
    /* 클릭 이벤트를 등록 하기위해서 
    포토 목록에 4개의 <a>를 모두 선택합니다.*/
    var list_zone=document.getElementById("inner_list");
    var list_a=list_zone.getElementsByTagName("a");
    
    /*
      포토 리스트의 모든 <a>에 클릭 이벤트를 등록하기 위해서
      반복문을 이용하여 4개의 <a>에 모두 이벤트를 등록했습니다.
    */
    for(var i=0; i<list_a.length; i++){
      list_a[i].onclick=function(){
       var ph=document.getElementById("photo").children[0];
       ph.src=this.href;
       return false; // <a>를 클릭했을 때 링크가 되지 않도록 합니다.
      }
    }
  
   /*② 이전, 다음 버튼을 클릭할 때 마다 <ul>이 100px만큼
          증가 또는 감소되어 좌·우측으로 이동됩니다. */
   
   /*다음 버튼을 클릭했을 때 마다 <ul>이 100px만큼
      좌측으로 이동해야 합니다.*/
   var b_btn=document.getElementById("next_btn");
   var m_num=0;
   b_btn.onclick=function(){
   if(m_num>=list_a.length-3) return false;
   m_num++;
   list_zone.style.marginLeft=-100*m_num+"px";
  
    return false; // <a>를 클릭했을 때 링크가 되지 않도록 합니다.
  }
  
   /*이전 버튼을 클릭했을 때 마다 <ul>이 100px만큼
      우측으로 이동해야 합니다.*/
   var n_btn=document.getElementById("before_btn");
  
   n_btn.onclick=function(){
   if(m_num<=0) return false;
   m_num--;
   list_zone.style.marginLeft=-100*m_num+"px";
  
    return false; // <a>를 클릭했을 때 링크가 되지 않도록 합니다.
  }
}
</script>
</head>
<body>
	<jsp:include page="top.jsp"></jsp:include>
	<div style="width: 850px; margin: 0 auto;">
	 <div id="gallery">
    <h1>Department office</h1>
    <p id="photo">
    <img src="img/main1.jpg" width="540" alt="" />
    </p>
    <div id="photo_list">
      <ul  id="inner_list">
        <li><a href="../img/main1.jpg">
        <img src="../img/main1_sm.jpg" alt="사진1" /></a></li>
        <li><a href="../img/main2.jpg">
        <img src="../img/main2_sm.jpg" alt="사진2" /></a></li>
        <li><a href="../img/main3.jpg">
        <img src="../img/main3_sm.jpg" alt="사진3" /></a></li>
        <li><a href="../img/main4.jpg">
        <img src="../img/main4_sm.jpg" alt="사진4" /></a></li>
      </ul>
    </div>
    <p class="btn_wrap">
    <a href="#" id="before_btn">&lt;</a>
    <a href="#" id="next_btn">&gt;</a>
    </p>
  </div>
		<p style="font-size: 25pt; font-weight: 10px; font-face:Century; text-shadow: 2px 2px 2px gray; margin-top: 0px; margin-bottom: 0px; text-align: center;">
		Welcome to Mars have a good time
		</p><br>
		<table style="margin-left: auto;">
			<tr>
				<td align="left" width="300px">공지사항</td>
				
				
				<c:choose>
						<c:when test="${ck=='0' }">
							<td align="right"><a href="notice.jhj?command=notice_list">more</a></td>
						</c:when>
						<c:otherwise>
							<td align="right">more</td>
						</c:otherwise>
					</c:choose>
			</tr>
			<c:forEach items="${notice }" var="notice">
				<tr>
					<c:choose>
						<c:when test="${ck=='0' }">
							<td><a href="notice.jhj?command=notice_info&no=${notice.no }">${notice.title }</a></td>
						</c:when>
						<c:otherwise>
							<td>${notice.title }</td>
						</c:otherwise>
					</c:choose>
					<td>(${notice.nRegDt })</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
	<jsp:include page="modal.jsp"></jsp:include>
</body>
</html>