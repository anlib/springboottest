package com.cp.cpspringboot.teacherStatement.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cp.cpspringboot.teacherStatement.mapper.TeacherStatementMapper;
import com.cp.cpspringboot.teacherStatement.model.TeacherStatement;
import com.cp.cpspringboot.teacherStatement.service.TeacherStatementService;
import com.github.pagehelper.PageHelper;

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

	@Override
	public int update(TeacherStatement teacherStatement) {
		if ((Integer)teacherStatement.getId() != null && !"".equals(teacherStatement.getId())) {
            try {
                int effectCount = TeacherStatementMapper.update(teacherStatement);
                if (effectCount > 0) {
                    return effectCount;
                } else {
                    throw new RuntimeException("更新失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("更新失败"+ e.getMessage());
            }
        }else {
            throw new RuntimeException("信息不能为空");
        }
	}

	@Override
	public int insert(TeacherStatement teacherStatement) {
		if (teacherStatement != null && !"".equals(teacherStatement)) {
			try {
				int effectCount = TeacherStatementMapper.insert(teacherStatement);
				// System.out.println("insertId:" + effectCount);
				if (effectCount > 0) {
					return effectCount;
				} else {
					throw new RuntimeException("插入失败");
				}
			} catch (Exception e) {
				throw new RuntimeException("插入失败" + e.getMessage());
			}
		} else {
			throw new RuntimeException("信息不能为空");
		}
	}
}