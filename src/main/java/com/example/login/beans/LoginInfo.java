package com.example.login.beans;

/*
 * Here we have our Login Information for future services and methods
 */
public class LoginInfo {
	private String username;
	private String password;
	
	public LoginInfo(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public LoginInfo() {
		this.username = "";
		this.password = "";
	}
	
	//getters n' setters
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
	
	//toString
	@Override
	public String toString() {
		return "LoginInfo [username=" + username + ", password=" + password + "]";
	}	
}
