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
    private TeacherFollowMapper TeacherFollowMapper;

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

	@Override
	public List<TeacherFollow> findTeacherFollowCount(Map<String, Object> map) {
		return TeacherFollowMapper.findTeacherFollowCount(map);
	}

	@Override
	public int insert(TeacherFollow teacherFollow) {
		//String jsonString = JSONArray.toJSONString(teacherFollow);
  	    //System.out.println("teacherFollow:" + jsonString);
        if (teacherFollow!=null && !"".equals(teacherFollow)) {
            try {
                int effectCount = TeacherFollowMapper.insert(teacherFollow);
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
	public int delete(TeacherFollow teacherFollow) {
		if (teacherFollow!=null && !"".equals(teacherFollow)) {
            try {
                int effectCount = TeacherFollowMapper.delete(teacherFollow);
                if (effectCount > 0) {
                    return effectCount;
                } else {
                    throw new RuntimeException("删除失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("删除失败"+ e.getMessage());
            }
        }else {
            throw new RuntimeException("信息不能为空");
        }
	}
	
	
}