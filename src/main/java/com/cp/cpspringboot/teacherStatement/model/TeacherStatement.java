package com.cp.cpspringboot.teacherStatement.model;

public class TeacherStatement {
	private int id;
	private String amount;
	private String status;
	private String type;
	private String forteacher;
	private String subject;
	private String posttime;
	private String start;
	private String end;
	private int score;
	private int listpid;
	private String listsetid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getForteacher() {
		return forteacher;
	}
	public void setForteacher(String forteacher) {
		this.forteacher = forteacher;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getPosttime() {
		return posttime;
	}
	public void setPosttime(String posttime) {
		this.posttime = posttime;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public int getListpid() {
		return listpid;
	}
	public void setListpid(int listpid) {
		this.listpid = listpid;
	}
	public String getListsetid() {
		return listsetid;
	}
	public void setListsetid(String listsetid) {
		this.listsetid = listsetid;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	
}