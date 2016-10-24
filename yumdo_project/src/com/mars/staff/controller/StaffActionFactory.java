package com.mars.staff.controller;

import com.mars.common.Action;
import com.mars.staff.action.StaffDeleteAction;
import com.mars.staff.action.StaffIdCheckAction;
import com.mars.staff.action.StaffIdCheckFormAction;
import com.mars.staff.action.StaffInfoAction;
import com.mars.staff.action.StaffInfoFormAction;
import com.mars.staff.action.StaffInsertAction;
import com.mars.staff.action.StaffInsertFormAction;
import com.mars.staff.action.StaffListAction;
import com.mars.staff.action.StaffLoginAction;
import com.mars.staff.action.StaffLoginFormAction;
import com.mars.staff.action.StaffLogoutAction;
import com.mars.staff.action.StaffOkmanAction;
import com.mars.staff.action.StaffOkmanFormAction;
import com.mars.staff.action.StaffUpdateAction;
import com.mars.staff.action.StaffUpdateFormAction;
import com.mars.staff.action.StaffViewAction;
import com.mars.staff.action.StaffZipcodeAction;

public class StaffActionFactory {
	private static StaffActionFactory instance = new StaffActionFactory();
	
	private StaffActionFactory() {
		super();
	}
	
	public static StaffActionFactory getInstance(){
		return instance;
	}
	
	public Action getAction(String command) {
		Action action = null;
		System.out.println("ActionFactory :" + command);
		
		if(command.equals("staff_insert")){
			action = new StaffInsertAction();
		}else if (command.equals("staff_insert_form")){
			action = new StaffInsertFormAction();
		}else if (command.equals("staff_delete")){
			action = new StaffDeleteAction();
		}else if (command.equals("staff_update")){
			action = new StaffUpdateAction();
		}else if (command.equals("staff_update_form")){
			action = new StaffUpdateFormAction();
		}else if (command.equals("staff_view")){
			action = new StaffViewAction();
		}else if (command.equals("staff_idcheck")){
			action = new StaffIdCheckAction();
		}else if (command.equals("staff_idcheck_form")){
			action = new StaffIdCheckFormAction();
		}else if (command.equals("staff_login")){
			action = new StaffLoginAction();
		}else if (command.equals("staff_login_form")){
			action = new StaffLoginFormAction();	
		}else if (command.equals("staff_logout")){
			action = new StaffLogoutAction();
		}else if (command.equals("staff_okman")){
			action = new StaffOkmanAction();
		}else if (command.equals("staff_okman_form")){
			action = new StaffOkmanFormAction();
		}else if (command.equals("staff_list")){
			action = new StaffListAction();
		}else if (command.equals("staff_info")){
			action = new StaffInfoAction();
		}else if (command.equals("staff_info_form")){
			action = new StaffInfoFormAction();
		}else if (command.equals("zipcode")){
			action = new StaffZipcodeAction();
		}
		return action;
		}
	}

