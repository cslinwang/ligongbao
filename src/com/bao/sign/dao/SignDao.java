package com.bao.sign.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bao.db.JDBC;

public class SignDao {
	// 增加签到人
	public int addSigner(String uid) {
		Connection con = JDBC.getConnection();
		int num = 0;
		try {
			String sql = "insert into note_date(uid) values(?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, uid);
			num = pst.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}

	// 判断签到
	public String selectBySign(String uid) {
		Connection con = JDBC.getConnection();
		String oldDate = null;
		try {
			String sql = "select * from note_date where uid=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, uid);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				oldDate = rs.getString("date");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return oldDate;
	}

	// 签到
	public int sign(String date, String uid) {
		Connection con = JDBC.getConnection();
		int num = 0;
		try {
			String sql = "update note_date set date=? where uid=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, date);
			pst.setString(2, uid);
			// System.out.println("date~~"+date+":"+uid);
			num = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println(num);
		return num;
	}


}
