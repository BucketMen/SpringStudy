package com.spring.mvc.model.beans;
/**
 * model 과 bean의 차이점 숙지
 * 여기는 DB와의 연결을 담당한다.
 * bean은 변수와 getter,setter만 존재한다.
 * 
 **/
public class UserBean {
	private String user_id;
	private String user_pwd;
	private String user_name;
	private String user_birthday;
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pwd() {
		return user_pwd;
	}
	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_birthday() {
		return user_birthday;
	}
	public void setUser_birthday(String user_birthday) {
		this.user_birthday = user_birthday;
	}
}
