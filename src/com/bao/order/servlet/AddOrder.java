package com.bao.order.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.itcast.commons.CommonUtils;

import com.bao.order.domain.Order;
import com.bao.order.service.OrderService;
import com.bao.user.domain.User;

public class AddOrder extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		OrderService orderService = new OrderService();
		Order        order        = new Order();
		
		//�õ��û��͵��Ե�id
        String aid = request.getParameter("addressAid");
        String nid = request.getParameter("nid");
        
        //�õ��û�id
        HttpSession session = request.getSession(false);
        User        user    = (User)session.getAttribute("user");
        
        
        
        if(user==null){
        	response.sendRedirect("/LiGongBao/jsps/err.jsp");
        }else{
        	//����Ϣ��װ��Order����
            order.setOid(CommonUtils.uuid());
            order.setNid(nid);
            order.setUid(user.getUid());
            order.setAid(aid);
            order.setStime(new Date().toLocaleString());
            order.setStatu(0);
            order.setCounts(1);
            
            boolean b = orderService.addOrder(order);
            if(b){
            	request.getRequestDispatcher("/jsps/AddOrderSucc.jsp").forward(request, response);
            }else{
            	System.out.println("������¼����ʧ��");
            }
        }
        
        
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            doGet(request,response);
	}

}
