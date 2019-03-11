package com.cp.cpspringboot.teacherScore.model;

public class TeacherScore {
	private Long id;
	private String content;
	private String username;
	private String num;
	private String userid;
	private int listpid;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getListpid() {
		return listpid;
	}
	public void setListpid(int listpid) {
		this.listpid = listpid;
	}
	
}