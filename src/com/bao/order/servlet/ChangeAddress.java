package com.bao.order.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bao.order.domain.Address;
import com.bao.order.service.AddressService;
import com.bao.user.domain.User;

public class ChangeAddress extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
        AddressService addressService = new AddressService();
        List<Address>  addressList    = new ArrayList<Address>();
        
        /*获得用户信息*/
        HttpSession session = request.getSession(false);
        User        user    = (User)session.getAttribute("user");
        
        if(user==null){
        	 response.sendRedirect("/LiGongBao/jsps/err.jsp");
        }else{
        
        addressList = addressService.findByUid(user.getUid());
        
        request.setAttribute("addressList", addressList);
        request.getRequestDispatcher("/jsps/ChangeAddress.jsp").forward(request, response);
        }
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        doGet(request,response);
	}

}
