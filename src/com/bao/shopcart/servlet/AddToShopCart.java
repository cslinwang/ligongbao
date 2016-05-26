package com.bao.shopcart.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.itcast.commons.CommonUtils;

import com.bao.shopcart.domain.ShopCart;
import com.bao.shopcart.service.ShopCartService;
import com.bao.user.domain.User;

/*
 * 往购物车里面添加商品
 * */
public class AddToShopCart extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		ShopCartService shopcartService = new ShopCartService();
		ShopCart shopCart = new ShopCart();
		Boolean b = false;

		if (user == null) {
			response.sendRedirect("/LiGongBao/jsps/err.jsp");
		} else {
			String sid = CommonUtils.uuid();
			String uid = user.getUid();
			String nid = request.getParameter("nid");
			String stime = new Date().toString();
			shopCart.setSid(sid);
			shopCart.setUid(uid);
			shopCart.setNid(nid);
			shopCart.setStime(stime);
			b = shopcartService.addShopCart(shopCart);
			response.sendRedirect("/LiGongBao/jsps/AddShopCartsucc.jsp");

		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
