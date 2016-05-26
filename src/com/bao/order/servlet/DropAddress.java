package com.bao.order.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bao.order.service.AddressService;

public class DropAddress extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
        AddressService addressService = new AddressService();
        String         aid            = request.getParameter("aid");
        boolean        b              = false;
        
        b = addressService.dropAddress(aid);
        
        if(b){
        	request.getRequestDispatcher("/ChangeAddress").forward(request, response);
        }else{
        	System.out.println("É¾³ýµØÖ·³ö´í");
        }
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
         doGet(request,response);
	}

}
