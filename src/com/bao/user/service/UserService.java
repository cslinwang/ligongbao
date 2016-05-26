package com.bao.user.service;

import cn.itcast.commons.CommonUtils;

import com.bao.user.dao.UserDao;
import com.bao.user.domain.User;

public class UserService {

	UserDao userdao = new UserDao();
	User user = new User();

	// 校验用户名
	public boolean valiDateUserName(String userName) {
		return userdao.searchName(userName);
	}

	// 校验邮箱
	public boolean valiDateUserEmail(String userEmail) {
		return userdao.searchEmail(userEmail);
	}

	// 增加用户
	public boolean Insert(String userName, String userPass, String userEmail) {

		this.user.setUid(CommonUtils.uuid());
		this.user.setUsername(userName);
		this.user.setUserpass(userPass);
		this.user.setEmail(userEmail);
		this.user.setActivecode(CommonUtils.uuid() + CommonUtils.uuid());

		return userdao.Insert(user);
	}

	// 得到用户实体
	public User getUser() {
		return this.user;
	}

	// 用户登录
	public boolean loginValidate(String userName, String userPass) {

		return userdao.loginValidate(userName, userPass);
	}

	// 按用户名查找
	public User getUserByName(String userName) {

		return userdao.getUserByName(userName);
	}

	// 修改密码
	public boolean updatePassword(String uid, String userpass) {
		return userdao.updatePassword(uid, userpass);
	}

	// 判断是否为合法用户
	public boolean selectByUidPassword(String uid, String password) {
		return userdao.selectByUidPassword(uid, password);

	}

	public String getUserUid(String userName, String userPass) {
		return userdao.getUserUid(userName, userPass);
	}

}
