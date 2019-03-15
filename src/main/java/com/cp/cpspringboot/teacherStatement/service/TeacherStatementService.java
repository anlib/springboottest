package com.cp.cpspringboot.teacherStatement.service;

import java.util.List;
import java.util.Map;

import com.cp.cpspringboot.teacherStatement.model.TeacherStatement;

/**
 * teacher服务接口
 * @author anlib
 */
public interface TeacherStatementService {
       /**
     * 获取list信息
     * @return
     */
    List<TeacherStatement> findTeacherStatement(int pageNum, int pageSize, Map<String, Object> map);
	List<TeacherStatement> findTeacherStatement(Map<String, Object> map);

	int update(TeacherStatement teacherStatement);
	int insert(TeacherStatement teacherStatement);
}