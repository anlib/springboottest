package com.cp.cpspringboot.teacher.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import com.cp.cpspringboot.teacher.model.Teacher;

/**
 * teacher表mapper接口
 * @author anlib
 */
@Mapper  //  该注解一定要加，否则无法映射到mybatis的***.xml局部配置文件
public interface TeacherMapper {
    List<Teacher> findTeacher();
    List<Teacher> findTeacher(Map<String, Object> map);
	int insert(Teacher teacher);
	int update(Teacher teacher);
}