package com.project001.staff.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project001.common.Action;

/**
 * Servlet implementation class EmpController
 */
@WebServlet("/staff.jhj")
public class StaffController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StaffController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		ServletContext context = getServletContext();
		String savePath = "img";
		String uploadFilePath = context.getRealPath(savePath);
		request.setAttribute("uploadFilePath", uploadFilePath);
		
		String command = request.getParameter("command");
		StaffActionFactory sf = StaffActionFactory .getInstance();
		Action action = sf.getAction(command);
		if(action!=null){
			action.execute(request, response);
		}
	}

}
