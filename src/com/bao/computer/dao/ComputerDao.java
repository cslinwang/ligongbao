package com.bao.computer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bao.computer.domain.Computer;
import com.bao.db.JDBC;

public class ComputerDao {
	// 获取数据库连接
	Connection con = JDBC.getConnection();

	// 查询所有
	public List<Computer> findAll(int page) {
		int pag = page * 20;
		List<Computer> computerList = new ArrayList<Computer>();
		try {
			String sql = "select * from note_computer LIMIT ?,20";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, pag);
			ResultSet result = pst.executeQuery();
			// 循环输入
			while (result.next()) {
				Computer computer = new Computer();
				computer.setNid(result.getString(1));
				computer.setNname(result.getString(2));
				computer.setNprice(result.getFloat(3));
				computer.setNdiscount(result.getFloat(4));
				computer.setNimage(result.getString(5));
				computer.setNcompany(result.getString(6));
				computer.setNrprice(result.getFloat(7));
				computerList.add(computer);
			}
		} catch (SQLException e) {
			System.err.println("查询所有电脑出错");
			e.printStackTrace();
		}
		return computerList;
	}

	public int findCount() {
		int count = 0;
		try {
			String sql = "SELECT COUNT(*) FROM note_computer;";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	// 按nid查找电脑信息
	public Computer findByNid(String nid) {
		Computer computer = new Computer();
		try {
			String sql = "select * from note_computer where nid like ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, nid);
			ResultSet res = pst.executeQuery();
			while (res.next()) {
				computer.setNid(res.getString("nid"));
				computer.setNname(res.getString("nname"));
				computer.setNimage(res.getString("nimage"));
				computer.setNcompany(res.getString("ncompany"));
				computer.setNdiscount(res.getFloat("ndiscount"));
				computer.setNprice(res.getFloat("nprice"));
				computer.setNrprice(res.getFloat("nrprice"));
			}
		} catch (SQLException se) {
			System.err.println("按nid查询电脑错误");
			se.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return computer;
	}

	// 按用户名迷糊查询
	public List<Computer> findByNname(String nname) {
		List<Computer> computerList = new ArrayList<Computer>();
		try {
			String sql = "select * from note_computer where nname like ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, "%"+nname+"%");
			ResultSet res = pst.executeQuery();
			while (res.next()) {
				Computer computer = new Computer();
				computer.setNid(res.getString(1));
				computer.setNname(res.getString(2));
				computer.setNprice(res.getFloat(3));
				computer.setNdiscount(res.getFloat(4));
				computer.setNimage(res.getString(5));
				computer.setNcompany(res.getString(6));
				computer.setNrprice(res.getFloat(7));
				computerList.add(computer);
			}
		} catch (SQLException se) {
			System.err.println("按名字迷糊查询出错");
			se.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return computerList;
	}

}
