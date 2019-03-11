package com.cp.cpspringboot.teacherCertificate.service;

import java.util.List;
import java.util.Map;

import com.cp.cpspringboot.teacherCertificate.model.TeacherCertificate;


/**
 * teacher服务接口
 * @author anlib
 *
 */
public interface TeacherCertificateService {
       /**
     * 获取list信息
     * @return
     */
    List<TeacherCertificate> findTeacherCertificate(Map<String, Object> map);
	int update(TeacherCertificate teacherCertificate);
	int insert(TeacherCertificate teacherCertificate); 
}