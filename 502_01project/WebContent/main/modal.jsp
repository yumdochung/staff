<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="container" style="width:450px; z-index:10011;">
			  <!-- Modal -->
			  <div class="modal fade" id="myModal" role="dialog" style="width:450px">
			    <div class="modal-dialog" id="myModal_in" style="width:450px; margin-top:200px">
			    
			      <!-- Modal content-->
			      <div class="modal-content">
			        <div class="modal-header">
			          <button type="button" class="close" data-dismiss="modal">&times;</button>
			          <h4 class="modal-title" id="modalTitle" style="text-align: center;">&nbsp;</h4>
			        </div>
			        <div class="modal-body" align="center">
			          <p id="modalMsg">&nbsp;</p>
			        </div>
			        <div class="modal-footer">
			        	<button type="button" id="btn-default" class="btn btn-default" data-dismiss="modal">닫기</button>
			        </div>
			      </div>
			    </div>
			  </div>
			</div>
			<button type="button" style="visibility:hidden" id="modal_btn" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Open Modal</button>
