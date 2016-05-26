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




/**
 * 显示所有电脑信息类
 * @author 宋国全
 *
 */
public class ComputerServlet extends HttpServlet{

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ComputerService computerservice =new ComputerService();
		
         List<Computer> computerList = new ArrayList<Computer>();
      
         int page=0;
         
         if(request.getParameter("page") == null){
        	 page = 0;
         }else{
        	 page = Integer.parseInt(request.getParameter("page"));
         }
         
         computerList = computerservice.findAll(page);
         
         request.setAttribute("computerlist", computerList);
         request.setAttribute("page", (int) Math.floor(computerservice.findCount()/20));
         request.setAttribute("pa", page);
         
         
         request.getRequestDispatcher("/jsps/body.jsp").forward(request, response);
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

         doPost(request,response);
    }
}
