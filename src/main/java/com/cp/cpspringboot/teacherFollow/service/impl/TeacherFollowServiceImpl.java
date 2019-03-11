package com.cp.cpspringboot.teacherFollow.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cp.cpspringboot.teacherFollow.mapper.TeacherFollowMapper;
import com.cp.cpspringboot.teacherFollow.model.TeacherFollow;
import com.cp.cpspringboot.teacherFollow.service.TeacherFollowService;
import com.github.pagehelper.PageHelper;

import java.util.Map;

/**
 * Teacher服务接口实现类
 * @author anlib
 *
 */
@Service(value = "teacherFollowService")  //  该注解一定要写，否则无法注册bean
public class TeacherFollowServiceImpl implements TeacherFollowService{

    @Autowired
    private TeacherFollowMapper TeacherFollowMapper;  //  注入mapper

    /*
     * list
     * */
	public List<TeacherFollow> findTeacherFollow(int pageNum, int pageSize, Map<String, Object> map) {

	    PageHelper.startPage(pageNum, pageSize);
    	return TeacherFollowMapper.findTeacherFollow(map);
    }

	@Override
	public List<TeacherFollow> findTeacherFollow(Map<String, Object> map) {
    	return TeacherFollowMapper.findTeacherFollow(map);
	}
}