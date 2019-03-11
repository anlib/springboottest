package com.cp.cpspringboot.teacherExperience.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cp.cpspringboot.teacherExperience.mapper.TeacherExperienceMapper;
import com.cp.cpspringboot.teacherExperience.model.TeacherExperience;
import com.cp.cpspringboot.teacherExperience.service.TeacherExperienceService;
import java.util.Map;

/**
 * Teacher服务接口实现类
 * @author anlib
 *
 */
@Service(value = "teacherExperienceService")  //  该注解一定要写，否则无法注册bean
public class TeacherExperienceServiceImpl implements TeacherExperienceService{

    @Autowired
    private TeacherExperienceMapper TeacherExperienceMapper;  //  注入mapper

    /*
     * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
     * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
     * pageNum 开始页数
     * pageSize 每页显示的数据条数
     * */
    @Override
    public List<TeacherExperience> findTeacherExperience(Map<String, Object> map) {
    	return TeacherExperienceMapper.findTeacherExperience(map);
    }
   
}