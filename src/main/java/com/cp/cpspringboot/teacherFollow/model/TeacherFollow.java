package com.cp.cpspringboot.teacherFollow.model;

public class TeacherFollow {
	private Long id;
	private Long touserid;
	private Long fromuserid;
	private int count;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getTouserid() {
		return touserid;
	}
	public void setTouserid(Long touserid) {
		this.touserid = touserid;
	}
	public Long getFromuserid() {
		return fromuserid;
	}
	public void setFromuserid(Long fromuserid) {
		this.fromuserid = fromuserid;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}