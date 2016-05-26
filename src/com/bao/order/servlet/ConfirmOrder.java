package com.bao.order.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bao.computer.domain.Computer;
import com.bao.computer.service.ComputerService;
import com.bao.order.domain.Address;
import com.bao.order.service.AddressService;
import com.bao.user.domain.User;

public class ConfirmOrder extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		AddressService addressService = new AddressService();
		List<Address> addressList = new ArrayList<Address>();
		
		/*得到用户信息*/
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		
		/*获得商品信息*/
		String nid = request.getParameter("nid");
		
		/*根据nid得到电脑信息*/
		ComputerService computerService = new ComputerService();
		Computer        computer        = new Computer(); 
		computer = computerService.findByNid(nid);
		
		
		
		if(user==null){
			response.sendRedirect("/LiGongBao/jsps/err.jsp");
		}else{
			/*得到地址信息*/
			addressList   = addressService.findByUid(user.getUid());
			request.setAttribute("addressList", addressList);
			/*将电脑信息封装到request发送到客户端*/
			request.setAttribute("computer", computer);
			request.getRequestDispatcher("/jsps/pay.jsp").forward(request, response);
		}
       
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        doGet(request,response);
	}

}
