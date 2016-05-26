package com.bao.user.service;

import cn.itcast.commons.CommonUtils;

import com.bao.user.dao.UserDao;
import com.bao.user.domain.User;

public class UserService {

	UserDao userdao = new UserDao();
	User user = new User();

	// У���û���
	public boolean valiDateUserName(String userName) {
		return userdao.searchName(userName);
	}

	// У������
	public boolean valiDateUserEmail(String userEmail) {
		return userdao.searchEmail(userEmail);
	}

	// �����û�
	public boolean Insert(String userName, String userPass, String userEmail) {

		this.user.setUid(CommonUtils.uuid());
		this.user.setUsername(userName);
		this.user.setUserpass(userPass);
		this.user.setEmail(userEmail);
		this.user.setActivecode(CommonUtils.uuid() + CommonUtils.uuid());

		return userdao.Insert(user);
	}

	// �õ��û�ʵ��
	public User getUser() {
		return this.user;
	}

	// �û���¼
	public boolean loginValidate(String userName, String userPass) {

		return userdao.loginValidate(userName, userPass);
	}

	// ���û�������
	public User getUserByName(String userName) {

		return userdao.getUserByName(userName);
	}

	// �޸�����
	public boolean updatePassword(String uid, String userpass) {
		return userdao.updatePassword(uid, userpass);
	}

	// �ж��Ƿ�Ϊ�Ϸ��û�
	public boolean selectByUidPassword(String uid, String password) {
		return userdao.selectByUidPassword(uid, password);

	}

	public String getUserUid(String userName, String userPass) {
		return userdao.getUserUid(userName, userPass);
	}

}
