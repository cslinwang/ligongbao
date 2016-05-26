package com.bao.computer.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bao.computer.domain.Computer;
import com.bao.computer.service.ComputerService;


/**
 * 按nid查询电脑信息
 * @author DBQ
 *
 */
public class ComputerInfo extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
        ComputerService computerService = new ComputerService();
        Computer        computer        = new Computer();
        
        String nid = (String) request.getParameter("nid");
        computer   = computerService.findByNid(nid);
        
        request.setAttribute("computer", computer);
        
        request.getRequestDispatcher("/jsps/computer.jsp").forward(request, response);
        
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
         doGet(request,response);
	}

}
