package entity;

public class user {
private String uname;
private int pwd;
public user() {
	super();
}
public user(String uname, int pwd) {
	super();
	this.uname = uname;
	this.pwd = pwd;
}
public String getUname() {
	return uname;
}
public void setUname(String uname) {
	this.uname = uname;
}
public int getPwd() {
	return pwd;
}
public void setPwd(int pwd) {
	this.pwd = pwd;
}

}
