
package com.bao.order.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.itcast.commons.CommonUtils;

import com.bao.order.domain.Order;
import com.bao.order.service.OrderService;
import com.bao.shopcart.domain.ShopCart;
import com.bao.shopcart.service.ShopCartService;
import com.bao.user.domain.User;

public class AddServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		OrderService orderService = new OrderService();
		ShopCartService  shopcartService = new ShopCartService();
		List<ShopCart>   shopcartList    = new ArrayList<ShopCart>();
		
		//得到用户和电脑的id
        String aid = request.getParameter("addressAid");
       
        
        //得到用户id
        HttpSession session = request.getSession(false);
        User        user    = (User)session.getAttribute("user");
        
        
        
        if(user==null){
        	response.sendRedirect("/LiGongBao/jsps/err.jsp");
        }else{
        	
        	shopcartList = shopcartService.findByUid(user.getUid());
        	for(ShopCart shopcart : shopcartList){
        		 Order order = new Order();
        		 
        		 order.setOid(CommonUtils.uuid());
                 order.setNid(shopcart.getNid());
                 order.setUid(user.getUid());
                 order.setAid(aid);
                 order.setStime(new Date().toLocaleString());
                 order.setStatu(0);
                 order.setCounts(1);
                 
                 boolean b = orderService.addOrder(order);
                 if(b){
                	 System.out.println("订单记录保存成功");
                 }else{
                 	System.out.println("订单记录保存失败");
                 }
        	}
        	
        	request.getRequestDispatcher("/jsps/AddOrderSucc.jsp").forward(request, response);
        }
        
        
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
          doGet(request,response);
	}

}
