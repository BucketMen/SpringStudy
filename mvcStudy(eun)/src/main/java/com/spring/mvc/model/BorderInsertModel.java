package com.spring.mvc.model;

/**
 * 
 * //모델: 데이터가 넘겨질때 사용 //밸류로 넘어올것, 보더타이틀-유저네임-파일-컨텐츠_텍스트에리어(4개의 파라미터가 넘어온다)
 *
 */
public class BorderInsertModel {
	private String border_title;
	private String user_name;
	private String file;
	private String content_textarea;
	private String user_ip;
	

	public String getBorder_title() {
		return border_title;
	}

	public void setBorder_title(String border_title) {
		this.border_title = border_title;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getContent_textarea() {
		return content_textarea;
	}

	public void setContent_textarea(String content_textarea) {
		this.content_textarea = content_textarea;
	}

	public String getUser_ip() {
		return user_ip;
	}

	public void setUser_ip(String user_ip) {
		this.user_ip = user_ip;
	}


}
