package sql;

public class User{
	String uname,uemail,udob,upass;
	int umob;
	
	public User(String uname, String uemail, String udob, String upass, int umob) {
		this.uname = uname;
		this.uemail = uemail;
		this.udob = udob;
		this.upass = upass;
		this.umob = umob;
	}
}