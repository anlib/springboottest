package com.cp.cpspringboot.teacherStatement.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cp.cpspringboot.teacherStatement.mapper.TeacherStatementMapper;
import com.cp.cpspringboot.teacherStatement.model.TeacherStatement;
import com.cp.cpspringboot.teacherStatement.service.TeacherStatementService;
import com.github.pagehelper.PageHelper;

import java.util.Map;

/**
 * Teacher服务接口实现类
 * @author anlib
 *
 */
@Service(value = "teacherStatementService")  //  该注解一定要写，否则无法注册bean
public class TeacherStatementServiceImpl implements TeacherStatementService{

    @Autowired
    private TeacherStatementMapper TeacherStatementMapper;  //  注入mapper

    /*
     * list
     * */
	public List<TeacherStatement> findTeacherStatement(int pageNum, int pageSize, Map<String, Object> map) {

	    PageHelper.startPage(pageNum, pageSize);
    	return TeacherStatementMapper.findTeacherStatement(map);
    }

	@Override
	public List<TeacherStatement> findTeacherStatement(Map<String, Object> map) {
    	return TeacherStatementMapper.findTeacherStatement(map);
	}
}