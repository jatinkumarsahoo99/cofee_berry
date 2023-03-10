package com.example.demo.entity;

import lombok.Data;

@Data
public class AuthModel {
	
	private String user_id;
	
	@Override
	public String toString() {
		return "AuthModel [user_id=" + user_id + ", user_password=" + user_password + "]";
	}

	private String user_password;

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

}
