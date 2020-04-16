package com.lyh.pojo;

public class user {
	private int id;
	private String username;
	private String password;
	private String password_salt;
	private String status;
	private String qxname;
	public user() {
		super();
	}
	public user(int id, String username, String password, String password_salt, String status, String qxname) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.password_salt = password_salt;
		this.status = status;
		this.qxname = qxname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword_salt() {
		return password_salt;
	}
	public void setPassword_salt(String password_salt) {
		this.password_salt = password_salt;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getQxname() {
		return qxname;
	}
	public void setQxname(String qxname) {
		this.qxname = qxname;
	}
	
	
}
