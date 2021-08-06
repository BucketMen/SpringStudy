package com.spring.mvc.model;

public class Student {
	private int seq;//seq=순번을 의미한다
	private String id;
	private String name;
	private String phone;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public Student(int seq, String id, String name, String phone) {
		super();
		this.seq = seq;
		this.id = id;
		this.name = name;
		this.phone = phone;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
