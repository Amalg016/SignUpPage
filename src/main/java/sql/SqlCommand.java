package sql;

import java.sql.*;

public class SqlCommand {
	Connection con = null;
	static Statement st;
	static ResultSet rs;

//	static {
//		
//	}
	
	public boolean addUser(User user) throws SQLException {
		System.out.println("\nConnection.\n");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");								//loading and registering driver
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scram", "root", "pass");
			System.out.println("\nConnection established.\n");
			st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = st.executeQuery("Select * from scramUsers");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		String query = "insert into scramUsers values(?,?,?,?,?)";
		
		PreparedStatement prepst = con.prepareStatement(query);
		prepst.setString(1, user.uname);
		prepst.setString(2, user.uemail);
		prepst.setString(3, user.udob);
		prepst.setString(4, user.upass);
		prepst.setInt(5, user.umob);
		prepst.executeUpdate();
		
		System.out.println("\nRow inserted.");
		return true;
	}
}
