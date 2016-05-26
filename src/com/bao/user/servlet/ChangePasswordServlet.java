package com.bao.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bao.user.domain.User;

public class ChangePasswordServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		User        user    = (User)session.getAttribute("user");
		
		if(user==null){
			response.sendRedirect("/NoteHome/jsps/err.jsp");
		}else{
			response.sendRedirect("/NoteHome/jsps/UpdatePassword.jsp");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
          doGet(request,response);
	}

}
