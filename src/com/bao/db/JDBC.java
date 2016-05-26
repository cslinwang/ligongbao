package com.bao.db;

import java.sql.*;

public class JDBC {
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/notecomputer", "root", "mysql");
			System.out.println("成功连接...");
		} catch (Exception e) {
			// TODO: handle exception
		}

		return con;
	}

}
