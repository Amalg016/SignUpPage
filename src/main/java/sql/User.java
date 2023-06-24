package sql;

public class User{
	public String uname,uemail,udob,upass;
	public long umob;
	
	public User(String uname, String uemail, String udob, String upass, long umob) {
		this.uname = uname;
		this.uemail = uemail;
		this.udob = udob;
		this.upass = upass;
		this.umob = umob;
	}
}