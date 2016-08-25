package com.project001.project.controller;


import com.project001.common.Action;
import com.project001.project.controller.action.ProjectDeleteAction;
import com.project001.project.controller.action.ProjectInfoAction;
import com.project001.project.controller.action.ProjectInsert2FormAction;
import com.project001.project.controller.action.ProjectInsertFormAction;
import com.project001.project.controller.action.ProjectListAction;
import com.project001.project.controller.action.ProjectSearchAction;
import com.project001.project.controller.action.ProjectStaffInsertActionForm;
import com.project001.project.controller.action.ProjectStaffSearch;
import com.project001.project.controller.action.ProjectUpdateAction;
import com.project001.project.controller.action.ProjectUpdateFormAction;

public class ProjectFactory {

	private static ProjectFactory instance = new ProjectFactory();
	
	public static ProjectFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) {
		
		Action pa = null;
		System.out.println("ProjectAction : " + command);
		
		if (command.equals("project_list")) {
			pa = new ProjectListAction();
		} else if (command.equals("project_insert_form")) {
			pa = new ProjectInsertFormAction();
		} else if (command.equals("project_insert2_form")) {
			pa = new ProjectInsert2FormAction();
		} else if (command.equals("project_info")) {
			pa = new ProjectInfoAction();
		} else if (command.equals("project_update_form")) {
			pa = new ProjectUpdateFormAction();
		} else if (command.equals("project_update")) {
			pa = new ProjectUpdateAction();
		} else if (command.equals("project_delete")) {
			pa = new ProjectDeleteAction();
		} else if (command.equals("project_search")) {
			pa = new ProjectSearchAction();
		} else if (command.equals("project_staff")){
			pa = new ProjectStaffInsertActionForm();
		} else if (command.equals("staff_search")){
			pa = new ProjectStaffSearch();
		}
		
		return pa;
	}
}