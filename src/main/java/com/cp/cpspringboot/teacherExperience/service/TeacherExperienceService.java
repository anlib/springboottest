package com.cp.cpspringboot.teacherExperience.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import com.cp.cpspringboot.teacherExperience.model.TeacherExperience;

import ch.qos.logback.core.subst.Token.Type;

/**
 * teacher服务接口
 * @author anlib
 *
 */

public interface TeacherExperienceService {
    /**
     * 获取list信息
     * @return
     */
	List<TeacherExperience> findTeacherExperience(Map<String, Object> map); 
}