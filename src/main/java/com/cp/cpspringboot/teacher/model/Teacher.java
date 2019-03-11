package com.cp.cpspringboot.teacher.model;

import java.util.Date;

public class Teacher {
	// id teacher avatar gender teaching_experience
	// address university edit_education edit_grade edit_subject
	// graduation(tinyint) auth wechat
	// mobile price style posttime(datetime) active(tinyint) flag(tinyint)
	private Long id;
	private String teacher;
	private String gender;
	private String avatar;
	private String experience;
	private String address;
	private String university;
	private String education;
	private String grade;
	private String taught;
	private String graduation;
	private String birthday;
	private String auth;
	private String wechat;
	private String mobile;
	private String price;
	private String pricetime;
	private String style;
	private String area;
	private String city;
	private String gradetaught;
	private String teachtime;	
	private String score;
	private String latitude;
	private String longitude;
	private String lastlongin;
	private int myflag;
	private String openid;
	private String posttime;
	private int active;
	private int flag;

	public int getMyflag() {
		return myflag;
	}

	public void setMyflag(int myflag) {
		this.myflag = myflag;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getTaught() {
		return taught;
	}

	public void setTaught(String taught) {
		this.taught = taught;
	}

	public String getGraduation() {
		return graduation;
	}

	public void setGraduation(String graduation) {
		this.graduation = graduation;
	}

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	public String getWechat() {
		return wechat;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getPosttime() {
		return posttime;
	}

	public void setPosttime(String posttime) {
		this.posttime = posttime;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public void setCreateTime(Date date) {
		// TODO Auto-generated method stub

	}

	public String getPricetime() {
		return pricetime;
	}

	public void setPricetime(String pricetime) {
		this.pricetime = pricetime;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	// 这里需要重写 toString()
	public String toString() {
		return "{area:" + this.area 
				+ ",grade:" + this.grade 
				+ ",taught:" + this.taught 
				+ ",area:" + this.area 
				+ "}";
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getGradetaught() {
		return gradetaught;
	}

	public void setGradetaught(String gradetaught) {
		this.gradetaught = gradetaught;
	}

	public String getTeachtime() {
		return teachtime;
	}

	public void setTeachtime(String teachtime) {
		this.teachtime = teachtime;
	}

	public String getLastlongin() {
		return lastlongin;
	}

	public void setLastlongin(String lastlongin) {
		this.lastlongin = lastlongin;
	}
}