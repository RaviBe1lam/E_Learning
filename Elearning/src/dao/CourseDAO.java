package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Course;

public class CourseDAO {
	public static boolean addCourse(Course course) throws Exception {
		Connection con=config.DbUtils.connect();
		String sql="insert into course values(?,?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, course.getCcode());
		ps.setString(2, course.getCname());
		ps.setInt(3, course.getDuration());
		ps.setInt(4, course.getAmount());
		ps.setString(5, course.getUserid());
		ps.setString(6, "Y");
		ps.executeUpdate();
		return true;
	}

	public static List<Course> getAllCourses() throws Exception { 
		List<Course> list=new ArrayList<>();
		Connection con=config.DbUtils.connect();
		PreparedStatement ps=con.prepareStatement("SELECT * FROM course where active='Y'");		
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			Course c=new Course();
			c.setCcode(rs.getString("ccode"));
			c.setCname(rs.getString("cname"));
			c.setAmount(rs.getInt("amount"));
			c.setDuration(rs.getInt("duration"));
			c.setUserid(rs.getString("userid"));
			c.setActive(rs.getString("active"));
			list.add(c);
		}
		return list;
	}

	public static List<Course> searchCourses(String cname) throws Exception { 
		List<Course> list=new ArrayList<>();
		Connection con=config.DbUtils.connect();
		PreparedStatement ps=con.prepareStatement("SELECT * FROM course where cname like ? and active='Y'");
		ps.setString(1, "%"+cname+"%");
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			Course c=new Course();
			c.setCcode(rs.getString("ccode"));
			c.setCname(rs.getString("cname"));
			c.setAmount(rs.getInt("amount"));
			c.setDuration(rs.getInt("duration"));
			c.setUserid(rs.getString("userid"));
			c.setActive(rs.getString("active"));
			list.add(c);
		}
		return list;
	}

	public  static List<Course> getUserCourse(String userid) throws Exception{
		List<Course> list=new ArrayList<>();
		Connection con=config.DbUtils.connect();
		PreparedStatement ps=con.prepareStatement("SELECT * FROM course where userid=?");
		ps.setString(1, userid);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			Course c=new Course();
			c.setCcode(rs.getString("ccode"));
			c.setCname(rs.getString("cname"));
			c.setAmount(rs.getInt("amount"));
			c.setDuration(rs.getInt("duration"));
			c.setUserid(rs.getString("userid"));
			c.setActive(rs.getString("active"));
			list.add(c);
		}
		return list;
	}

	public  static List<Course> searchUserCourse(String userid,String cname) throws Exception{
		List<Course> list=new ArrayList<>();
		Connection con=config.DbUtils.connect();
		PreparedStatement ps=con.prepareStatement("SELECT * FROM course where cname like ? and userid=?");
		ps.setString(1, "%"+cname+"%");
		ps.setString(2, userid);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			Course c=new Course();
			c.setCcode(rs.getString("ccode"));
			c.setCname(rs.getString("cname"));
			c.setAmount(rs.getInt("amount"));
			c.setDuration(rs.getInt("duration"));
			c.setUserid(rs.getString("userid"));
			c.setActive(rs.getString("active"));
			list.add(c);
		}
		return list;
	}

	public static Course findCourse(String ccode) throws Exception{
		Connection con=config.DbUtils.connect();
		PreparedStatement ps=con.prepareStatement("SELECT * FROM course where ccode=?");
		ps.setString(1, ccode);
		ResultSet rs=ps.executeQuery();

		if(rs.next()) {
			Course c=new Course();	
			c.setCcode(rs.getString("ccode"));
			c.setCname(rs.getString("cname"));
			c.setAmount(rs.getInt("amount"));
			c.setDuration(rs.getInt("duration"));
			c.setUserid(rs.getString("userid"));
			c.setActive(rs.getString("active"));
			con.close();
			return c;
		}
		return null;
	}

	public static void deactivate(String ccode,String action) throws Exception{
		Connection con=config.DbUtils.connect();
		PreparedStatement ps=null;
		if(action.equals("n")) {
			ps=con.prepareStatement("UPDATE course set active='N' where ccode=?");
		}else {
			ps=con.prepareStatement("UPDATE course set active='Y' where ccode=?");
		}
		ps.setString(1, ccode);
		ps.executeUpdate();			
	}

	public static void changeCourse(Course course) throws Exception {
		Connection con=config.DbUtils.connect();
		String sql="update course set cname=?,duration=?,amount=? where ccode=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(4, course.getCcode());
		ps.setString(1, course.getCname());
		ps.setInt(2, course.getDuration());
		ps.setInt(3, course.getAmount());				
		ps.executeUpdate();		
	}

}
