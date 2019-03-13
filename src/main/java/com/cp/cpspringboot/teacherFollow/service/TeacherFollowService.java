package com.cp.cpspringboot.teacherFollow.service;

import java.util.List;
import java.util.Map;

import com.cp.cpspringboot.teacherFollow.model.TeacherFollow;

/**
 * teacher服务接口
 * 
 * @author anlib
 *
 */
public interface TeacherFollowService {
	/**
	 * 获取list信息
	 * 
	 * @return
	 */
	List<TeacherFollow> findTeacherFollow(int pageNum, int pageSize, Map<String, Object> map);

	List<TeacherFollow> findTeacherFollow(Map<String, Object> map);

	List<TeacherFollow> findTeacherFollowCount(Map<String, Object> map);

	int insert(TeacherFollow teacherFollow);

	int delete(TeacherFollow teacherFollow);
}