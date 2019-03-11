package com.cp.cpspringboot.teacherUniversity.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cp.cpspringboot.teacherUniversity.mapper.TeacherUniversityMapper;
import com.cp.cpspringboot.teacherUniversity.model.TeacherUniversity;
import com.cp.cpspringboot.teacherUniversity.service.TeacherUniversityService;
import java.util.Map;

/**
 * Teacher服务接口实现类
 * @author anlib
 *
 */
@Service(value = "teacherUniversityService")  //  该注解一定要写，否则无法注册bean
public class TeacherUniversityServiceImpl implements TeacherUniversityService{

    @Autowired
    private TeacherUniversityMapper TeacherUniversityMapper;  //  注入mapper

    /*
     * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
     * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
     * pageNum 开始页数
     * pageSize 每页显示的数据条数
     * */
	public List<TeacherUniversity> findTeacherUniversity(Map<String, Object> map) {
		System.out.println("-----------------");
    	return TeacherUniversityMapper.findTeacherUniversity(map);
    }
}