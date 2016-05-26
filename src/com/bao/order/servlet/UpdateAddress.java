package com.bao.order.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bao.order.domain.Address;
import com.bao.order.service.AddressService;

public class UpdateAddress extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
            AddressService addressService = new AddressService();
            Address        address        = new Address();  
            String         aid            = request.getParameter("aid");
            boolean        b              = false;
            
            address   =    addressService.findByAid(aid);
            b         =    addressService.dropAddress(aid);
            
            if(b){
            	request.setAttribute("address", address);
            	request.getRequestDispatcher("/jsps/UpdateAddress.jsp").forward(request, response);
            }
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        doGet(request,response);
	}

}
