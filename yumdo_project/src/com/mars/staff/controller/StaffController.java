package com.mars.staff.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mars.common.Action;

@WebServlet("/staff")
public class StaffController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StaffController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
//		doPost(request, response);
		String command = request.getParameter("command");
		System.out.println("staff에서 요청을 받음 확인"+command);
		StaffActionFactory sf = StaffActionFactory.getInstance();
		Action action = sf.getAction(command);
		if(action!=null){
			action.execute(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
//		response.setContentType("text/html; charset=UTF-8");
//		ServletContext context = getServletContext();
//		String savePath = "img";
//		String uploadFilePath = context.getRealPath(savePath);
//		request.setAttribute("uploadFilePath", uploadFilePath);
//	
//		String command = request.getParameter("command");
//		System.out.println("staff에서 요청을 받음 확인"+command);
//		StaffActionFactory sf = StaffActionFactory.getInstance();
//		Action action = sf.getAction(command);
//		if(action!=null){
//			action.execute(request, response);
//	}
	}

}
