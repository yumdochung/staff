package com.project001.staff.controller;

import com.project001.common.Action;
import com.project001.login.controller.LogOut;
import com.project001.staff.controller.action.StaffAcaInsertAction;
import com.project001.staff.controller.action.StaffCarInsertAction;
import com.project001.staff.controller.action.StaffDeleteAction;
import com.project001.staff.controller.action.StaffInfoAction;
import com.project001.staff.controller.action.StaffInsert2Action;
import com.project001.staff.controller.action.StaffInsertAction;
import com.project001.staff.controller.action.StaffInsertFormAction;
import com.project001.staff.controller.action.StaffLicInsertAction;
import com.project001.staff.controller.action.StaffListAction;
import com.project001.staff.controller.action.StaffSelectBykeyAction;
import com.project001.staff.controller.action.StaffToMain;
import com.project001.staff.controller.action.StaffUpdateAction;
import com.project001.staff.controller.action.StaffUpdateFromAction;
import com.project001.staff.controller.action.StaffZipcodeAction;



	public class StaffActionFactory {
		private static StaffActionFactory instance = new StaffActionFactory();
		
		private StaffActionFactory() {
			super();
		}
		
		public static StaffActionFactory getInstance() {
			return instance;
		}
		
		public Action getAction(String command) {
			Action action = null;
			
			if (command.equals("staff_list")){
				action = new StaffListAction();
			}else if (command.equals("staff_select_by_keyword")) {
				action = new StaffSelectBykeyAction();
			}else if (command.equals("staff_insert_form")) {
				action = new StaffInsertFormAction();
			}else if (command.equals("staff_insert")){
				action = new StaffInsertAction();
			}else if (command.equals("staff_info")) {
				action = new StaffInfoAction();
			}else if (command.equals("go_main")) {
				action = new StaffToMain();
			}else if (command.equals("staff_update_form")) {
				action = new StaffUpdateFromAction();
			}else if (command.equals("staff_update")) {
				action = new StaffUpdateAction();
			}else if (command.equals("staff_delete")){
				action = new StaffDeleteAction();
			}else if (command.equals("staff_insert2_form")){
				action = new StaffInsert2Action();
			}else if (command.equals("staff_lic")){
				action = new StaffLicInsertAction();
			}else if (command.equals("staff_car")){
				action = new StaffCarInsertAction();
			}else if (command.equals("staff_aca")){
				action = new StaffAcaInsertAction();
			}else if (command.equals("logout")){
				action = new LogOut();
			}else if (command.equals("zipcode")){
				action = new StaffZipcodeAction();
			}
			return action;
		}
}
