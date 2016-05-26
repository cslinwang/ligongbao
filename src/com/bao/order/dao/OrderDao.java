package com.bao.order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bao.db.JDBC;
import com.bao.order.domain.Order;

public class OrderDao {

	Connection con = JDBC.getConnection();
	//
	// 按用户查询所有订单
	public List<Order> findByUid(String uid) {
		List<Order> orderList = new ArrayList<Order>();
		List<String> stringList = new ArrayList<String>();

		try {
			String sql = "select * from note_order where uid like ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, uid);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Order o = new Order();
				String nid = rs.getString("nid");
				o.setOid(rs.getString("oid"));
				o.setStime(rs.getString("stime"));
				o.setCounts(rs.getInt("counts"));
				o.setStatu(rs.getInt("statu"));
				o.setNid(nid);
				orderList.add(o);
				stringList.add(nid);
			}
			for (int i = 0; i < stringList.size(); i++) {
				String sq = "select * from note_computer where nid like ?";
				PreparedStatement ps = con.prepareStatement(sq);
				ps.setString(1, stringList.get(i));
				ResultSet res = ps.executeQuery();
				while (res.next()) {
					orderList.get(i).setImage(res.getString("nimage"));
					orderList.get(i).setNrprice(res.getFloat("nrprice"));
					orderList.get(i).setNname(res.getString("nname"));
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return orderList;
	}

	// 保存订单
	public int addOrder(Order order) {
		int num = 0;
		try {
			String sq = "insert into note_order(oid,uid,nid,stime,statu,counts,aid) values(?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sq);
			ps.setString(1, order.getOid());
			ps.setString(2, order.getUid());
			ps.setString(3, order.getNid());
			ps.setString(4, order.getStime());
			ps.setInt(5, order.getStatu());
			ps.setInt(6, order.getCounts());
			ps.setString(7, order.getAid());
			num = ps.executeUpdate();
		} catch (SQLException se) {
			System.out.println("增加记录出错");
			se.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return num;
	}
}
