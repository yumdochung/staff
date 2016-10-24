package com.mars.project.controller;

import com.mars.common.Action;
import com.mars.project.action.ProjectCheckPassAction;
import com.mars.project.action.ProjectCheckPassFormAction;
import com.mars.project.action.ProjectDeleteAction;
import com.mars.project.action.ProjectListAction;
import com.mars.project.action.ProjectUpdateAction;
import com.mars.project.action.ProjectUpdateFormAction;
import com.mars.project.action.ProjectViewAction;
import com.mars.project.action.ProjectWriteAction;
import com.mars.project.action.ProjectWriteFormAction;

public class ProjectActionFactory {
private static ProjectActionFactory instance = new ProjectActionFactory();
	
	private ProjectActionFactory() {
		super();
	}
	
	public static ProjectActionFactory getInstance(){
		return instance;
	}
	
	public Action getAction(String command) {
		Action action = null;
		System.out.println("ActionFactory :" + command);
		
		if(command.equals("project_checkpass")){
			action = new ProjectCheckPassAction();
		}else if (command.equals("project_checkpass_form")){
			action = new ProjectCheckPassFormAction();
		}else if (command.equals("project_delete")){
			action = new ProjectDeleteAction();
		}else if (command.equals("project_list")){
			action = new ProjectListAction();
		}else if (command.equals("project_update")){
			action = new ProjectUpdateAction();
		}else if (command.equals("project_update_form")){
			action = new ProjectUpdateFormAction();
		}else if (command.equals("project_view")){
			action = new ProjectViewAction();
		}else if (command.equals("project_write")){
			action = new ProjectWriteAction();
		}else if (command.equals("project_write_form")){
			action = new ProjectWriteFormAction();
	}
	return action;
	}
}