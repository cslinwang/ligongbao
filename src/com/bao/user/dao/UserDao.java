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
	 * 数据库校验数据
	 * 
	 * @param userName
	 * @return
	 **/
	
	// 查询Uid
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

	// 查询是否为本用户登陆
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

	// 查询用户名是否存在数据库中
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

	// 查询emial是否存在数据库中
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

	// 增加用户
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

	// 用户登录
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

	// 按用户名查找
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

	// 修改密码
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
			System.out.println("修改密码出错");
			se.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return b;
	}

}
