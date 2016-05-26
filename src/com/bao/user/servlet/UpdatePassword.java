package com.bao.user.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bao.user.domain.User;
import com.bao.user.service.UserService;
import com.bao.utils.Md5Utils;

public class UpdatePassword extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		UserService userService = new UserService();
		String oldpassword = Md5Utils.MD5(request.getParameter("oldpassword"));
		String newpassword = Md5Utils.MD5(request.getParameter("newpassword"));
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String uid = (String) session.getAttribute("uid");
		boolean flag = userService.selectByUidPassword(uid, oldpassword);
		if (flag) {
			System.out.println("‘≠√‹¬Î’˝»∑");
			if (user == null) {
				response.sendRedirect("/LiGongBao/jsps/err.jsp");
			} else {
				boolean b = userService.updatePassword(uid,
						newpassword);

				if (b) {
					System.out.println("a");
					session.removeAttribute("user");
					out.print(b);
					response.sendRedirect("/LiGongBao/jsps/login.jsp");
				} else {
					out.print("–ﬁ∏ƒ√‹¬Î ß∞‹");
					System.out.println("b");
					response.sendRedirect("/LiGongBao/jsps/UpdatePassword.jsp");
				}
			}
		} else {
			System.out.println("‘≠√‹¬Î¥ÌŒÛ");
			response.sendRedirect("/LiGongBao/jsps/UpdatePassword.jsp");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
