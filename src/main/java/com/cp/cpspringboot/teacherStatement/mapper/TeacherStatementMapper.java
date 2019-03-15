package com.cp.cpspringboot.teacherStatement.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cp.cpspringboot.teacherStatement.model.TeacherStatement;

/**
 * TeacherStatement表mapper接口
 * @author anlib
 */
@Mapper  //  该注解一定要加，否则无法映射到mybatis的***.xml局部配置文件
public interface TeacherStatementMapper {
    List<TeacherStatement> findTeacherStatement(Map<String, Object> map);
	int update(TeacherStatement teacherStatement);
	int insert(TeacherStatement teacherStatement);
}