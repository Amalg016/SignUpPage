package sql;

import java.sql.*;

public class SqlCommand {
	static Connection con = null;
	static Statement st;
	static ResultSet rs;

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");								//loading and registering driver
			con = DriverManager.getConnection(Constants.path, Constants.username, Constants.pass);
//			System.out.println("\nConnection established.\n");
//			st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
//			rs = st.executeQuery("Select * from scramUsers");
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
	
	public static boolean addUser(User user) throws SQLException {
		
		String query = "insert into scramUsers(name,email,dob,password,mob) values(?,?,?,?,?)";
		
		PreparedStatement prepst = con.prepareStatement(query);
		prepst.setString(1, user.uname);
		prepst.setString(2, user.uemail);
		prepst.setString(3, user.udob);
		prepst.setString(4, user.upass);
		prepst.setInt(5, user.umob);
		prepst.executeUpdate();
		
//		System.out.println("\nRow inserted.");
		return true;
	}
}
