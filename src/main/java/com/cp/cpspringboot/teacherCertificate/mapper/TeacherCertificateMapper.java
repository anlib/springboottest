package com.cp.cpspringboot.teacherCertificate.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;

import com.cp.cpspringboot.teacher.model.Teacher;
import com.cp.cpspringboot.teacherCertificate.model.TeacherCertificate;

/**
 * TeacherCertificate表mapper接口
 * @author anlib
 */
@Mapper  //  该注解一定要加，否则无法映射到mybatis的***.xml局部配置文件
public interface TeacherCertificateMapper {
    List<TeacherCertificate> findTeacherCertificate(Map<String, Object> map);
	int update(TeacherCertificate teacherCertificate);
	int insert(TeacherCertificate teacherCertificate); 
    
}