package com.bao.order.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bao.order.domain.Order;
import com.bao.order.service.OrderService;
import com.bao.user.domain.User;

public class OrderServlet extends HttpServlet{

	  OrderService orderservice = new OrderService();
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Order> OrderList = new ArrayList<Order>();

		HttpSession session = request.getSession(false);

		User user = (User) session.getAttribute("user");

		if (user == null) {
			response.sendRedirect("/LiGongBao/jsps/err.jsp");
		} else {

			OrderList = orderservice.findByUid(user.getUid());

			request.setAttribute("Orderlist", OrderList);

			request.getRequestDispatcher("/jsps/order.jsp").forward(request,response);
		}
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

        doPost(request,response);
   }
}