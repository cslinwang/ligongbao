package com.bao.computer.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bao.computer.domain.Computer;
import com.bao.computer.service.ComputerService;



public class SearchComputer extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ComputerService computerService = new ComputerService();
		List<Computer>  computerList    = new ArrayList<Computer>();	
		String name = request.getParameter("name");
		computerList  = computerService.findByNname(name);
		request.setAttribute("computerList", computerList);
		request.getRequestDispatcher("/jsps/SearchComputer.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            doGet(request,response);
	}

}
