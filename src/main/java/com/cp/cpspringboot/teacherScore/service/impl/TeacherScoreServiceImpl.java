package com.cp.cpspringboot.teacherScore.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cp.cpspringboot.teacherScore.mapper.TeacherScoreMapper;
import com.cp.cpspringboot.teacherScore.model.TeacherScore;
import com.cp.cpspringboot.teacherScore.service.TeacherScoreService;
import com.github.pagehelper.PageHelper;

import java.util.Map;

/**
 * Teacher服务接口实现类
 * @author anlib
 *
 */
@Service(value = "teacherScoreService")  //  该注解一定要写，否则无法注册bean
public class TeacherScoreServiceImpl implements TeacherScoreService{

    @Autowired
    private TeacherScoreMapper TeacherScoreMapper;  //  注入mapper

    /*
     * list
     * */
	public List<TeacherScore> findTeacherScore(int pageNum, int pageSize, Map<String, Object> map) {

	    PageHelper.startPage(pageNum, pageSize);
    	return TeacherScoreMapper.findTeacherScore(map);
    }

	@Override
	public List<TeacherScore> findTeacherScore(Map<String, Object> map) {
    	return TeacherScoreMapper.findTeacherScore(map);
	}

	@Override
	public List<TeacherScore> findTeacherScoreCount(Map<String, Object> map) {
		return TeacherScoreMapper.findTeacherScoreCount(map);
	}

	@Override
	public int insert(TeacherScore teacherScore) {
        if (teacherScore!=null && !"".equals(teacherScore)) {
            try {
                int effectCount = TeacherScoreMapper.insert(teacherScore);
                if (effectCount > 0) {
                    return effectCount;
                } else {
                    throw new RuntimeException("插入失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("插入失败"+ e.getMessage());
            }
        }else {
            throw new RuntimeException("信息不能为空");
        }
	}

}