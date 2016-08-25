package com.project001.notice.controller;

import com.project001.common.Action;
import com.project001.notice.controller.action.NoticeDeleteAction;
import com.project001.notice.controller.action.NoticeInfoAction;
import com.project001.notice.controller.action.NoticeInsertAction;
import com.project001.notice.controller.action.NoticeInsertFormAction;
import com.project001.notice.controller.action.NoticeListAction;
import com.project001.notice.controller.action.NoticeRefly;
import com.project001.notice.controller.action.NoticeUpdateAction;
import com.project001.notice.controller.action.NoticeUpdateFormAction;

public class NoticeActionFactory {
	
	private NoticeActionFactory(){
		super();
	}
	private static NoticeActionFactory instance = new NoticeActionFactory();
	
	public static NoticeActionFactory getInstance(){
		return instance;
	}
	
	public Action getAction (String command) {
		Action action = null;
		if(command.equals("notice_list")){
			action = new NoticeListAction();
		}else if(command.equals("notice_insert_form")) {
			action = new NoticeInsertFormAction();
		}else if(command.equals("notice_insert")){
			action = new NoticeInsertAction();
		}else if(command.equals("notice_info")){
			action = new NoticeInfoAction();
		}else if(command.equals("notice_update_form")){
			action = new NoticeUpdateFormAction();
		}else if(command.equals("notice_update")){
			action = new NoticeUpdateAction();
		}else if(command.equals("notice_delete")){
			action = new NoticeDeleteAction();
		}else if(command.equals("notice_reply")){
			action = new NoticeRefly();
		}
		return action;
	}
	
}
