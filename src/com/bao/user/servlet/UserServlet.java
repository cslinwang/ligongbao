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
	Map<String,String> errMap      = null;                    //�����û����ݴ���
	UserService        userservice = new UserService();       //ʵ����service
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req,resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//���������û���������
		errMap = new HashMap<String, String>();
		
		String userName    = req.getParameter("userName");
        String userPass    = Md5Utils.MD5(req.getParameter("userPass"));
        String userRePass  = Md5Utils.MD5(req.getParameter("userRePass"));
        String userEmail   = req.getParameter("userEmail");
        String verifyImage = req.getParameter("verifyImage");
        
        
        
        System.err.println(userName+" "+userPass+" "+userEmail+" "+verifyImage);
        
        /**
         * ���ε��ú����жϿͻ����ύ�������Ƿ����Ҫ��
         */
        valiDateUserName(userName);
        valiDateUserPass(userPass);
        valiDateUserRePass(userRePass,userPass);
        valiDateUserEmail(userEmail);
        valiDateUserVerifyCode(verifyImage);
        
        //����û������д���,���û����ݷ���ע��ҳ��
        Map<String,String> requ = new HashMap<String, String>();
        requ.put("userName", userName);
        requ.put("userPass", userPass);
        requ.put("userRePass", userRePass);
        requ.put("userEmail", userEmail);
       
        //�ж��û������Ƿ��д���
        if(errMap.size()!=0){
        	req.setAttribute("requ",requ);
            req.setAttribute("errMap", errMap);
        	req.getRequestDispatcher("/jsps/register.jsp").forward(req, resp);
        }else{
        	//�ж��Ƿ����ɹ�
        	if(userservice.Insert(userName, userPass, userEmail)){
        		HttpSession session = req.getSession();
        		session.setAttribute("user", userservice.getUser());
        		session.setAttribute("sign", null);
        		req.getRequestDispatcher("/index.jsp").forward(req, resp);
        	}else{
        		//��ת��ע��ʧ��ҳ��,��ʾ�û�����ע��
        		System.out.println("δ֪ԭ��ע��ʧ����");
        	}
        }
	}
	
    //У���û���
	private void valiDateUserName(String userName){
		if(userName.length()==0){
			errMap.put("userName", "�û�������Ϊ��");
		}else if(userName.trim().length()<4||userName.trim().length()>20){
			errMap.put("userName", "�û������ȱ���Ϊ4-20");
		}else if(!userName.trim().matches("[0-9A-Za-z_]*")){
			errMap.put("userName", "�û���ֻ����������ĸ���»������");
		}else if(userservice.valiDateUserName(userName)){
			errMap.put("userName", "�û����Ѵ���,��ֱ�ӵ�¼");
		}
	}
	
	//У������
	private void valiDateUserPass(String userPass){
		if(userPass.trim().length()==0){
			errMap.put("userPass", "���벻��Ϊ��");
		}else if(userPass.trim().length()<6||userPass.trim().length()>180){
			errMap.put("userPass", "���볤�ȱ���Ϊ6-20");
		}
	}
	
	//У��ȷ������
	private void valiDateUserRePass(String userRePass,String userPass){
		if(userRePass.trim().length()==0){
			errMap.put("userRePass", "ȷ�����벻��Ϊ��");
		}else if(!userRePass.equals(userPass)){
			errMap.put("userRePass", "ȷ�����������벻ƥ��");
		}
	}
	
	//У������
	private void valiDateUserEmail(String userEmail){
		Pattern p = Pattern.compile("^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\\.([a-zA-Z0-9_-])+)+$");
		Matcher m = p.matcher(userEmail);
		if (userEmail.trim().length() == 0) {
			errMap.put("userEmail", "���䲻��Ϊ��");
		}else if (!m.matches()) {
			errMap.put("userEmail", "�����ʽ����");
		}else if(userservice.valiDateUserEmail(userEmail)){
			errMap.put("userEmail", "�������ѱ�ע��,��ֱ�ӵ�¼�򻻸�����");
		}
	}
	
	//У����֤��
	private void valiDateUserVerifyCode(String verifyImage){
		String verifyCode = (String) this.getServletContext().getAttribute("verifyCode");
		//System.out.println(verifyCode);
		if (verifyImage.trim().length() == 0) {
			errMap.put("verifyImage", "���벻��Ϊ��");
		} else if (!verifyImage.equalsIgnoreCase(verifyCode)) {
			errMap.put("verifyImage", "У�������");
		}
	}
}
