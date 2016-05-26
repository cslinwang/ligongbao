package com.bao.user.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bao.user.service.UserService;
import com.bao.utils.Md5Utils;



public class UserServlet extends HttpServlet{
	Map<String,String> errMap      = null;                    //保存用户数据错误
	UserService        userservice = new UserService();       //实例化service
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req,resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//用来保存用户错误数据
		errMap = new HashMap<String, String>();
		
		String userName    = req.getParameter("userName");
        String userPass    = Md5Utils.MD5(req.getParameter("userPass"));
        String userRePass  = Md5Utils.MD5(req.getParameter("userRePass"));
        String userEmail   = req.getParameter("userEmail");
        String verifyImage = req.getParameter("verifyImage");
        
        
        
        System.err.println(userName+" "+userPass+" "+userEmail+" "+verifyImage);
        
        /**
         * 依次调用函数判断客户端提交额数据是否符合要求
         */
        valiDateUserName(userName);
        valiDateUserPass(userPass);
        valiDateUserRePass(userRePass,userPass);
        valiDateUserEmail(userEmail);
        valiDateUserVerifyCode(verifyImage);
        
        //如果用户输入有错误,将用户数据返回注册页面
        Map<String,String> requ = new HashMap<String, String>();
        requ.put("userName", userName);
        requ.put("userPass", userPass);
        requ.put("userRePass", userRePass);
        requ.put("userEmail", userEmail);
       
        //判断用户输入是否有错误
        if(errMap.size()!=0){
        	req.setAttribute("requ",requ);
            req.setAttribute("errMap", errMap);
        	req.getRequestDispatcher("/jsps/register.jsp").forward(req, resp);
        }else{
        	//判断是否插入成功
        	if(userservice.Insert(userName, userPass, userEmail)){
        		HttpSession session = req.getSession();
        		session.setAttribute("user", userservice.getUser());
        		session.setAttribute("sign", null);
        		req.getRequestDispatcher("/index.jsp").forward(req, resp);
        	}else{
        		//跳转到注册失败页面,提示用户重新注册
        		System.out.println("未知原因注册失败了");
        	}
        }
	}
	
    //校验用户名
	private void valiDateUserName(String userName){
		if(userName.length()==0){
			errMap.put("userName", "用户名不能为空");
		}else if(userName.trim().length()<4||userName.trim().length()>20){
			errMap.put("userName", "用户名长度必须为4-20");
		}else if(!userName.trim().matches("[0-9A-Za-z_]*")){
			errMap.put("userName", "用户名只能由数字字母和下划线组成");
		}else if(userservice.valiDateUserName(userName)){
			errMap.put("userName", "用户名已存在,请直接登录");
		}
	}
	
	//校验密码
	private void valiDateUserPass(String userPass){
		if(userPass.trim().length()==0){
			errMap.put("userPass", "密码不能为空");
		}else if(userPass.trim().length()<6||userPass.trim().length()>180){
			errMap.put("userPass", "密码长度必须为6-20");
		}
	}
	
	//校验确认密码
	private void valiDateUserRePass(String userRePass,String userPass){
		if(userRePass.trim().length()==0){
			errMap.put("userRePass", "确认密码不能为空");
		}else if(!userRePass.equals(userPass)){
			errMap.put("userRePass", "确认密码与密码不匹配");
		}
	}
	
	//校验邮箱
	private void valiDateUserEmail(String userEmail){
		Pattern p = Pattern.compile("^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\\.([a-zA-Z0-9_-])+)+$");
		Matcher m = p.matcher(userEmail);
		if (userEmail.trim().length() == 0) {
			errMap.put("userEmail", "邮箱不能为空");
		}else if (!m.matches()) {
			errMap.put("userEmail", "邮箱格式有误");
		}else if(userservice.valiDateUserEmail(userEmail)){
			errMap.put("userEmail", "该邮箱已被注册,请直接登录或换个邮箱");
		}
	}
	
	//校验验证码
	private void valiDateUserVerifyCode(String verifyImage){
		String verifyCode = (String) this.getServletContext().getAttribute("verifyCode");
		//System.out.println(verifyCode);
		if (verifyImage.trim().length() == 0) {
			errMap.put("verifyImage", "密码不能为空");
		} else if (!verifyImage.equalsIgnoreCase(verifyCode)) {
			errMap.put("verifyImage", "校验码错误");
		}
	}
}
