package sql;

import java.sql.*;

import org.apache.jasper.tagplugins.jstl.core.If;

public class SqlCommand {
	static Connection con = null;
	static Statement st;
	static ResultSet UserSet;

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");								//loading and registering driver
			con = DriverManager.getConnection(Constants.path, Constants.username, Constants.pass);
//			System.out.println("\nConnection established.\n");
			st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			UserSet = st.executeQuery("Select * from scramUsers");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		if(con == null) {
			System.out.println("Connection is null.");
		}
		else {
			System.out.println("Connection established.");
		}
		
	}
	
	public static void addUser(User user) throws SQLException {
		
		String query = "insert into scramUsers(name,email,dob,password,mob) values(?,?,?,?,?)";
		
		PreparedStatement prepst = con.prepareStatement(query);
		prepst.setString(1, user.uname);
		prepst.setString(2, user.uemail);
		prepst.setString(3, user.udob);
		prepst.setString(4, user.upass);
		prepst.setLong(5, user.umob);
		prepst.executeUpdate();
		
//		System.out.println("\nRow inserted.");
	}
	
	public static User FetchUser(String email,String password) throws SQLException {
		String query = "Select * from scramUsers";
//		String query = "Select email,password from scramUsers";
//		PreparedStatement prepst = con.prepareStatement(query);
		//Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
//		UserSet = st.executeQuery("Select * from scramUsers");
		ResultSet rs = st.executeQuery(query);
		//ResultSetMetaData rsmd = rs.getMetaData();
		
		rs.beforeFirst();
		
		while(rs.next()) {
			System.out.println(rs.getString(1)+","+rs.getString(2)+","+email);
				if(rs.getString(3).equals(email)&&rs.getString(5).equals(password)) {
				   User user=new User(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getLong(6));
					return user;
				}
		}	
		return null;
	}
}
