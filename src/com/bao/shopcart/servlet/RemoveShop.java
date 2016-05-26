package com.bao.shopcart.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bao.shopcart.service.ShopCartService;
/*
 * 删除购物车里面的商品
 * */
public class RemoveShop extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            ShopCartService shopcartService = new ShopCartService();
            String sid = request.getParameter("sid");
            Boolean b = false;
            
            b = shopcartService.deleteBySid(sid);
            
            response.sendRedirect("/LiGongBao/ShopCartServlet");
         
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
