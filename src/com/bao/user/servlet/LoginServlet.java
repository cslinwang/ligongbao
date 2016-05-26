package com.bao.user.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bao.sign.service.SignService;
import com.bao.user.service.UserService;
import com.bao.utils.Md5Utils;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
            UserService userService = new UserService();
            
            String userName = request.getParameter("userName");
            String userPass = Md5Utils.MD5(request.getParameter("userPass"));

            if(userService.loginValidate(userName, userPass)){
            	//创建session
            	HttpSession session = request.getSession(true);
            	session.setAttribute("user", userService.getUserByName(userName));
            	String uid=userService.getUserUid(userName, userPass);
            	session.setAttribute("uid", uid);
                SimpleDateFormat dateFormat = new SimpleDateFormat(
        				"yyyy/MM/dd");
        		String newDate=dateFormat.format(new Date());
        		String oldDate=new SignService().selectBySign(uid);
        		System.out.println(newDate+":"+oldDate);
        		if(newDate.equals(oldDate)){
                	session.setAttribute("sign", "已签到");
        		}else{
        			session.setAttribute("sign", null);
        		}

            	System.out.println(userService.getUserUid(userName, userPass));
            	request.getRequestDispatcher("/ComputerServlet").forward(request, response);
            }else{
            	request.setAttribute("status", "false");
            	request.getRequestDispatcher("/jsps/err.jsp").forward(request, response);
            }
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        doGet(request,response);
	}

}
