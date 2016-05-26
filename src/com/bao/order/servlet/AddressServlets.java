package com.bao.order.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.itcast.commons.CommonUtils;

import com.bao.order.domain.Address;
import com.bao.order.service.AddressService;
import com.bao.shopcart.domain.ShopCart;
import com.bao.shopcart.service.ShopCartService;
import com.bao.user.domain.User;

public class AddressServlets extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AddressService addressService = new AddressService();
		ShopCartService shopcartService = new ShopCartService();
		Address address = new Address();
		boolean b = false;

		HttpSession session = request.getSession(false);
		User user = (User) session.getAttribute("user");
		if (user == null) {
			response.sendRedirect("/LiGongBao/jsps/err.jsp");
		} else {

			request.setCharacterEncoding("UTF-8");

			address.setAid(CommonUtils.uuid());
			address.setProvince((String) request.getParameter("province"));
			address.setCity((String) request.getParameter("city"));
			address.setCounty((String) request.getParameter("county"));
			address.setDetaileaddress((String) request
					.getParameter("DetailedAddress"));
			address.setPostalcode((String) request.getParameter("PostalCode"));
			address.setMobilennumber((String) request
					.getParameter("MobileNumber"));
			address.setAddressee((String) request.getParameter("Addressee"));
			address.setUid(user.getUid());

			b = addressService.addAddress(address);

			List<ShopCart> shopcartList = new ArrayList<ShopCart>();
			shopcartList = shopcartService.findByUid(user.getUid());

			if (b) {
				request.setAttribute("shopCartLise", shopcartList);
				List<Address> addressList = addressService.findByUid(user
						.getUid());
				request.setAttribute("addressList", addressList);
				request.getRequestDispatcher("/jsps/pays.jsp").forward(request,
						response);
			} else {
				System.out.println("Ôö¼ÓµØÖ·Ê§°Ü");
			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
