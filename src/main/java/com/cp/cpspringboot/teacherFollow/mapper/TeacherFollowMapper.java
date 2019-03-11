package com.cp.cpspringboot.teacherFollow.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import com.cp.cpspringboot.teacherFollow.model.TeacherFollow;
import com.github.pagehelper.PageHelper;

/**
 * TeacherFollow表mapper接口
 * @author anlib
 */
@Mapper  //  该注解一定要加，否则无法映射到mybatis的***.xml局部配置文件
public interface TeacherFollowMapper {

    List<TeacherFollow> findTeacherFollow(Map<String, Object> map);
}