package com.cp.cpspringboot.teacherUniversity.model;

public class TeacherUniversity {
	//id, university, enrol, graduation, major, education, pid, setid
	private Long id;
	private String university;
	private String enrol;
	private String graduation;
	private String major;
	private String education;
	private int pid;
	private int setid;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUniversity() {
		return university;
	}
	public void setUniversity(String university) {
		this.university = university;
	}
	public String getEnrol() {
		return enrol;
	}
	public void setEnrol(String enrol) {
		this.enrol = enrol;
	}
	public String getGraduation() {
		return graduation;
	}
	public void setGraduation(String graduation) {
		this.graduation = graduation;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getSetid() {
		return setid;
	}
	public void setSetid(int setid) {
		this.setid = setid;
	}
	
	
}