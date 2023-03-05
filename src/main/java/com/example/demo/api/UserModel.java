package com.example.demo.api;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;




public class UserModel {
	private String user_id;
	private String user_name;
	private String user_dob;
	private String user_email;
	private String user_mobile;
	private String user_password;
	private List<String> user_role;
	private String user_status;
	private String user_profile;
	private String otp;
	private String token;
	
	public UserModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserModel(Object user_id, Object user_name, Object user_mobile, Object user_email,
			Object user_password, List<String> user_role, Object user_status, Object token) {
		super();
		this.user_id = (String) user_id;
		this.user_name = (String) user_name;
		this.user_mobile = (String) user_mobile;
		this.user_email = (String) user_email;
		this.user_password = (String) user_password;
		this.user_role =user_role;
		this.user_status = (String) user_status;
		this.token = (String) token;
	}
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_dob() {
		return user_dob;
	}
	public void setUser_dob(String user_dob) {
		this.user_dob = user_dob;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_mobile() {
		return user_mobile;
	}
	public void setUser_mobile(String user_mobile) {
		this.user_mobile = user_mobile;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public List<String> getUser_role() {
		return user_role;
	}
	public void setUser_role(List<String> user_role) {
		this.user_role = user_role;
	}
	public String getUser_status() {
		return user_status;
	}
	public void setUser_status(String user_status) {
		this.user_status = user_status;
	}
	
	public String getUser_profile() {
		return user_profile;
	}
	public void setUser_profile(String user_profile) {
		this.user_profile = user_profile;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	@Override
	public String toString() {
		ObjectMapper mapperObj = new ObjectMapper();
		String jsonStr;
		try {
			jsonStr = mapperObj.writeValueAsString(this);
		} catch (IOException ex) {
			jsonStr = ex.toString();
		}
		return jsonStr;
	}
}
