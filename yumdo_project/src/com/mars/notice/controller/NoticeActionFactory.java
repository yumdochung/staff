package com.mars.notice.controller;

import com.mars.common.Action;
import com.mars.notice.action.NoticeDeleteAction;
import com.mars.notice.action.NoticeDetailAction;
import com.mars.notice.action.NoticeInsertAction;
import com.mars.notice.action.NoticeInsertFormAction;
import com.mars.notice.action.NoticeListAction;
import com.mars.notice.action.NoticeReplyDelete;
import com.mars.notice.action.NoticeReplyUpdate;
import com.mars.notice.action.NoticeUpdateAction;
import com.mars.notice.action.NoticeUpdateFormAction;
import com.mars.notice.action.NoticeReplyInsert;

public class NoticeActionFactory {
private static NoticeActionFactory instance = new NoticeActionFactory();
	
	private NoticeActionFactory() {
		super();
	}
	
	public static NoticeActionFactory getInstance(){
		return instance;
	}
	
	public Action getAction(String command) {
		Action action = null;
		System.out.println("NoticeActionFactory :" + command);
		if(command.equals("noticeList")){
			action = new NoticeListAction();
		}else if (command.equals("noticeInsertForm")) {
			action = new NoticeInsertFormAction();
		}else if (command.equals("noticeInsert")) {
			action = new NoticeInsertAction();
		}else if (command.equals("noticeDetail")) {
			action = new NoticeDetailAction();
		}else if (command.equals("noticeUpdateForm")) {
			action = new NoticeUpdateFormAction();
		}else if (command.equals("noticeUpdate")) {
			action = new NoticeUpdateAction();
		}else if (command.equals("noticeDelete")){
			action = new NoticeDeleteAction();
		}else if(command.equals("noticeReplyInsert")){
			action = new NoticeReplyInsert();
		}else if(command.equals("noticeReplyUpdate")){
			action = new NoticeReplyUpdate();
		}else if(command.equals("noticeReplyDelete")){
			action = new NoticeReplyDelete();
		}
		return action;
		}
}
