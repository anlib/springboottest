package com.cp.cpspringboot.teacherExperience.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;

import com.cp.cpspringboot.teacherExperience.model.TeacherExperience;
import com.cp.cpspringboot.teacherUniversity.model.TeacherUniversity;

/**
 * TeacherUniversity表mapper接口
 * @author anlib
 */
@Mapper  //  该注解一定要加，否则无法映射到mybatis的***.xml局部配置文件
public interface TeacherExperienceMapper {
    List<TeacherExperience> findTeacherExperience(Map<String, Object> map);
}