package com.cp.cpspringboot.teacher.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cp.cpspringboot.teacher.mapper.TeacherMapper;
import com.cp.cpspringboot.teacher.model.Teacher;
import com.cp.cpspringboot.teacher.service.TeacherService;
import com.github.pagehelper.PageHelper;

/**
 * Teacher服务接口实现类
 * @author anlib
 *
 */
@Service(value = "teacherService")  //  该注解一定要写，否则无法注册bean
public class TeacherServiceImpl implements TeacherService{

    @Autowired
    private TeacherMapper TeacherMapper;  //  注入mapper

    /*
     * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
     * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
     * pageNum 开始页数
     * pageSize 每页显示的数据条数
     * */
    @Override
    public List<Teacher> findTeacherPage(int pageNum, int pageSize, Map<String, Object> map) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        return TeacherMapper.findTeacher(map);
    }
    
    public List<Teacher> findTeacher(Map<String, Object> map) {
    	return TeacherMapper.findTeacher(map);
    }
    
    @Transactional
    @Override
    public int insert(Teacher teacher) {
    	//String jsonString = JSONArray.toJSONString(teacher);
  	    //System.out.println("teacher:" + jsonString);
        if (teacher!=null && !"".equals(teacher)) {
            try {
                int effectCount = TeacherMapper.insert(teacher);
//                System.out.println("insertId:" + effectCount);
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

	@Override
	public int update(Teacher teacher) {
		if (((Integer)teacher.getId() != null && !"".equals(teacher.getId())) 
				|| (teacher.getOpenid()!=null && !"".equals(teacher.getOpenid()) )) {
            try {
                int effectCount = TeacherMapper.update(teacher);
//                System.out.println("insertId:" + effectCount);
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
 
}