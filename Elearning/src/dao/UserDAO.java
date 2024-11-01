package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Address;
import model.User;

public class UserDAO {

	public static void deActivate(String userid) throws  Exception {
		Connection con=config.DbUtils.connect();
		String sql="update users set active='N' where email=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, userid);
		ps.executeUpdate();
		con.close();		
	}

	public static User findUser(String userid) throws Exception {
		Connection con=config.DbUtils.connect();
		PreparedStatement ps=con.prepareStatement("SELECT * FROM users where email=?");
		ps.setString(1, userid);		
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			User user=new User();
			user.setName(rs.getString("name"));
			user.setGender(rs.getString("gender"));
			user.setEmail(rs.getString("email"));
			user.setRole(rs.getString("role"));
			user.setPhone(rs.getString("contact"));
			user.setActive(rs.getString("active"));			
			return user;
		}
		else {
			return null;
		}
	}

	public static boolean changeUser(User u) throws Exception {
		Connection con=config.DbUtils.connect();
		String sql="update users set name=?,gender=?,role=?,contact=?,active=? where email=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, u.getName());
		ps.setString(2, u.getGender());
		ps.setString(4, u.getPhone());
		ps.setString(5, u.getActive());
		ps.setString(3, u.getRole());
		ps.setString(6, u.getEmail());
		ps.executeUpdate();
		con.close();
		return true;
	}

	public static boolean updateProfile(User u) throws Exception {
		Connection con=config.DbUtils.connect();
		String sql="update users set name=?,gender=?,contact=? where email=?";
		String sql2="update address set line1=?,line2=?,city=?,state=? where addressid=?";
		PreparedStatement ps=con.prepareStatement(sql);
		PreparedStatement ps2=con.prepareStatement(sql2);
		ps.setString(1, u.getName());
		ps.setString(2, u.getGender());
		ps.setString(3, u.getPhone());
		ps.setString(4, u.getEmail());
		ps2.setString(1, u.getAddress().getLine1());
		ps2.setString(2, u.getAddress().getLine2());
		ps2.setString(3, u.getAddress().getCity());
		ps2.setString(4, u.getAddress().getState());
		ps2.setString(5, u.getAddressid());
		ps.executeUpdate();
		ps2.executeUpdate();
		con.close();
		return true;
	}

	public static boolean updatePassword(String userid,String pwd) throws Exception {
		Connection con=config.DbUtils.connect();
		String sql="update users set pwd=? where email=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, pwd);
		ps.setString(2, userid);		
		ps.executeUpdate();
		con.close();
		return true;
	}

	public static List<User> getUsers(String role) throws Exception {
		Connection con=config.DbUtils.connect();
		List<User> list=new ArrayList<>();
		Statement st=con.createStatement();
		ResultSet rs=null;
		if(role==null) {
			rs=st.executeQuery("SELECT * FROM users where role<>'ADM'");
		}else {
			rs=st.executeQuery("SELECT * FROM users where role<>'ADM' and role='"+role+"'");
		}
		while(rs.next())
		{
			User user=new User();
			user.setName(rs.getString("name"));
			user.setGender(rs.getString("gender"));
			user.setEmail(rs.getString("email"));
			user.setRole(getRole(rs.getString("role")));
			user.setPhone(rs.getString("contact"));
			user.setActive(rs.getString("active"));
			list.add(user);
		}
		return list;
	}

	public static String getRole(String code) throws Exception {
		Connection con=config.DbUtils.connect();
		PreparedStatement ps=con.prepareStatement("SELECT * FROM roles where code=?");
		ps.setString(1, code);		
		ResultSet rs=ps.executeQuery();
		rs.next();
		String role=rs.getString("name");
		con.close();
		return role;
	}

	public static boolean addUser(User u) throws Exception {
		int addid=saveAddress(u.getAddress());
		Connection con=config.DbUtils.connect();
		String sql="insert into users values(?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, u.getName());
		ps.setInt(2, u.getAge());
		ps.setString(3, u.getGender());
		ps.setString(4, u.getPhone());
		ps.setInt(5, addid);
		ps.setString(6, u.getPwd());
		ps.setString(7, "Y");
		ps.setString(8, u.getRole());
		ps.setString(9, u.getEmail());
		ps.executeUpdate();
		con.close();
		return true;
	}

	public static int saveAddress(Address address) throws Exception {
		Connection con=config.DbUtils.connect();
		String sql="insert into address(line1,line2,city,state,country,pincode) "
				+ "values(?,?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, address.getLine1());
		ps.setString(2, address.getLine2());
		ps.setString(3, address.getCity());
		ps.setString(4, address.getState());
		ps.setString(5, address.getCountry());
		ps.setString(6, address.getPincode());
		ps.executeUpdate();

		ResultSet rs=ps.getGeneratedKeys();
		if(rs.next()) {
			int result=rs.getInt(1);
			con.close();
			return result;
		}else {
			return -1;
		}
	}

	public static User validate(String userid,String pwd,String role) throws Exception {
		Connection con=config.DbUtils.connect();
		PreparedStatement ps=con.prepareStatement("SELECT * FROM users where email=? and pwd=? and role=?");
		ps.setString(1, userid);
		ps.setString(2, pwd);
		ps.setString(3, role);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			User u=new User();
			u.setEmail(userid);
			u.setRole(role);
			u.setPhone(rs.getString("contact"));
			u.setName(rs.getString("name"));
			u.setGender(rs.getString("gender"));
			u.setActive(rs.getString("active"));			
			String addid=rs.getString("address");
			ps=con.prepareStatement("select * from address where addressid=?");
			ps.setString(1, addid);
			ResultSet rs2=ps.executeQuery();
			if(rs2.next()) {
				Address address=new Address();
				address.setLine1(rs2.getString("line1"));
				address.setLine2(rs2.getString("line2"));
				address.setCity(rs2.getString("city"));
				address.setState(rs2.getString("state"));
				address.setPincode(rs2.getString("pincode"));
				u.setAddress(address);
			}
			con.close();
			return u;
		}else {
			con.close();
			return null;
		}	
	}

	public static boolean checkavail(String userid) throws Exception {
		Connection con=config.DbUtils.connect();
		PreparedStatement ps=con.prepareStatement("SELECT * FROM users where email=?");
		ps.setString(1, userid);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			con.close();
			return false;
		}else {
			con.close();
			return true;
		}		
	}
}
