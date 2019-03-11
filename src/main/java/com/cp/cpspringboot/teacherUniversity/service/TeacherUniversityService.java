package com.cp.cpspringboot.teacherUniversity.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import com.cp.cpspringboot.teacherUniversity.model.TeacherUniversity;

import ch.qos.logback.core.subst.Token.Type;


/**
 * teacher服务接口
 * @author anlib
 *
 */
public interface TeacherUniversityService {
       /**
     * 获取list信息
     * @return
     */
    List<TeacherUniversity> findTeacherUniversity(Map<String, Object> map);
}