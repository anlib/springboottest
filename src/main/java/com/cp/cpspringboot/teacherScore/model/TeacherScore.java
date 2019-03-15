package com.cp.cpspringboot.teacherScore.model;

public class TeacherScore {
	private Long id;
	private String content;
	private String fromuserid;
	private String score;
	private int listpid;
	private int listsetid;
	private int statementid;
	private int count;
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
	public String getFromuserid() {
		return fromuserid;
	}
	public void setFromuserid(String fromuserid) {
		this.fromuserid = fromuserid;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public int getListpid() {
		return listpid;
	}
	public void setListpid(int listpid) {
		this.listpid = listpid;
	}
	public int getListsetid() {
		return listsetid;
	}
	public void setListsetid(int listsetid) {
		this.listsetid = listsetid;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getStatementid() {
		return statementid;
	}
	public void setStatementid(int statementid) {
		this.statementid = statementid;
	}
	
}