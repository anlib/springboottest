package com.cp.cpspringboot.teacher.service;

import java.util.List;
import java.util.Map;

import com.cp.cpspringboot.teacher.model.Teacher;

/**
 * teacher服务接口
 * @author anlib
 *
 */
public interface TeacherService {
    /**
     * 获取list信息带分页
     * @param teacher 
     * @return
     */
//    List<Teacher> findTeacherPage(int pageNum, int pageSize); 
    List<Teacher> findTeacherPage(int pageNum, int pageSize, Map<String, Object> map); 
    
    /**
     * 获取list信息
     * @return
     */
    List<Teacher> findTeacher(Map<String, Object> map);
	int insert(Teacher teacher);
	int update(Teacher teacher); 
}