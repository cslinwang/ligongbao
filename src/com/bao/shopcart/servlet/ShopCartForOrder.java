package com.bao.shopcart.servlet;

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
import com.bao.shopcart.domain.ShopCart;
import com.bao.shopcart.service.ShopCartService;
import com.bao.user.domain.User;

/*
 * π∫ŒÔ≥µΩ·À„
 * */
public class ShopCartForOrder extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ShopCartService shopcartService = new ShopCartService();
		AddressService addressService = new AddressService();
		List<Address> addressList = new ArrayList<Address>();
		HttpSession session = request.getSession(false);
		User user = (User) session.getAttribute("user");
		List<ShopCart> shopcartList = new ArrayList<ShopCart>();
		if (user == null) {
			response.sendRedirect("/LiGongBao/jsps/err.jsp");
		} else {
			addressList = addressService.findByUid(user.getUid());
			request.setAttribute("addressList", addressList);
			shopcartList = shopcartService.findByUid(user.getUid());
			request.setAttribute("shopCartLise", shopcartList);
			request.getRequestDispatcher("/jsps/pays.jsp").forward(request,
					response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
