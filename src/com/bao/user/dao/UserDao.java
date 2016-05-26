package com.bao.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bao.db.JDBC;
import com.bao.user.domain.User;


public class UserDao {
	Connection con = JDBC.getConnection();

	/**
	 * ���ݿ�У������
	 * 
	 * @param userName
	 * @return
	 **/
	
	// ��ѯUid
	public String getUserUid(String userName, String userPass) {
		String uid = null;
		try {
			String sql = "select * from note_user where username like ? and userpass like ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, userName);
			pst.setString(2, userPass);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				System.out.println("yes");
				uid = rs.getString("uid");
			} else {
				System.out.println("no");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return uid;
	}

	// ��ѯ�Ƿ�Ϊ���û���½
	public boolean selectByUidPassword(String uid, String password) {
		boolean flag = false;
		try {
			String sql = "select * from note_user where uid=? and userpass=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, uid);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	// ��ѯ�û����Ƿ�������ݿ���
	public boolean searchName(String userName) {
		String sql = "select *  from note_user where username like ?";
		boolean result = true;
		ResultSet rs = null;
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, userName);
			rs = pst.executeQuery();
			if (rs.next()) {
				result = true;
			} else {
				result = false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	// ��ѯemial�Ƿ�������ݿ���
	public boolean searchEmail(String userEmail) {
		String sql = "select * from note_user where email like ?";
		boolean result = true;
		ResultSet rs = null;
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, userEmail);
			rs = pst.executeQuery();
			if (rs.next()) {
				result = true;
			} else {
				result = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		}
		return result;
	}

	// �����û�
	public boolean Insert(User user) {
		int num = 0;
		try {
			String sql = "insert into note_user(uid,username,userpass,email,activecode) values(?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, user.getUid());
			pst.setString(2, user.getUsername());
			pst.setString(3, user.getUserpass());
			pst.setString(4, user.getEmail());
			pst.setString(5, user.getActivecode());
			num = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (num != 0) {
			return true;
		} else {
			return false;
		}

	}

	// �û���¼
	public boolean loginValidate(String userName, String userPass) {

		ResultSet res = null;
		boolean result = false;
		try {
			String sql = "select * from note_user where username like ? and userpass like ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, userName);
			pst.setString(2, userPass);
			res = pst.executeQuery();
			if (res.next()) {
				result = true;
			} else {
				result = false;
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
		}

		return result;
	}

	// ���û�������
	public User getUserByName(String userName) {
		User user = new User();
		ResultSet res = null;
		try {
			String sql = "select * from note_user where username like ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, userName);
			res = pst.executeQuery();
			while (res.next()) {
				user.setUid(res.getString("uid"));
				user.setUsername(res.getString("username"));
				user.setUserpass(res.getString("userpass"));
				user.setStatu(res.getInt("statu"));
				user.setEmail(res.getString("email"));
				user.setUlevel(res.getInt("ulevel"));
				user.setActivecode(res.getString("activecode"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;

	}

	// �޸�����
	public boolean updatePassword(String uid, String userpass) {
		int num=0;
		boolean b = true;
		try {
			String sql = "update note_user set userpass=? where uid like ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, userpass);
			pst.setString(2, uid);
			num = pst.executeUpdate();
			if (num!=0) {
				b = true;
			} else {
				b = false;
			}
		} catch (SQLException se) {
			System.out.println("�޸��������");
			se.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return b;
	}

}
