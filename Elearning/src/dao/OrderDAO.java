package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Order;

public class OrderDAO {
	public static void saveOrder(Order order) throws Exception {
		Connection con=config.DbUtils.connect();
		String sql="insert into orders(userid,ccode,pur_date) values(?,?,curdate())";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, order.getUserid());
		ps.setString(2, order.getCcode());
		ps.executeUpdate();
		con.close();
	}
	
	public static List<Order> getUserOrders(String userid) throws Exception {
		Connection con=config.DbUtils.connect();
		String sql="SELECT * FROM orders WHERE userid=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, userid);
		ResultSet rs=ps.executeQuery();
		List<Order> list=new ArrayList<>();
		while(rs.next()) {
			Order order=new Order(rs.getInt("orderno"), 
					rs.getString("ccode"),rs.getString("userid")
					,rs.getString("pur_date"));
			list.add(order);
		}
		con.close();
		return list;
	}
	
	public static List<Order> getVendorOrders(String userid) throws Exception {
		Connection con=config.DbUtils.connect();
		String sql="SELECT * FROM orders WHERE ccode in (SELECT ccode from course where userid=?)";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, userid);
		ResultSet rs=ps.executeQuery();
		List<Order> list=new ArrayList<>();
		while(rs.next()) {
			Order order=new Order(rs.getInt("orderno"), 
					rs.getString("ccode"),rs.getString("userid")
					,rs.getString("pur_date"));
			list.add(order);
		}
		con.close();
		return list;
	}
	
	public static List<Order> getAllOrders() throws Exception {
		Connection con=config.DbUtils.connect();
		String sql="SELECT * FROM orders";
		PreparedStatement ps=con.prepareStatement(sql);		
		ResultSet rs=ps.executeQuery();
		List<Order> list=new ArrayList<>();
		while(rs.next()) {
			Order order=new Order(rs.getInt("orderno"), 
					rs.getString("ccode"),rs.getString("userid")
					,rs.getString("pur_date"));
			list.add(order);
		}
		con.close();
		return list;
	}
}
