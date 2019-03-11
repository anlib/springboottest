package com.cp.cpspringboot.teacherScore.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import com.cp.cpspringboot.teacherScore.model.TeacherScore;
import com.github.pagehelper.PageHelper;

/**
 * TeacherScore表mapper接口
 * @author anlib
 */
@Mapper  //  该注解一定要加，否则无法映射到mybatis的***.xml局部配置文件
public interface TeacherScoreMapper {

    List<TeacherScore> findTeacherScore(Map<String, Object> map);

	List<TeacherScore> findTeacherScoreCount(Map<String, Object> map);
}