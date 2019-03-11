package com.cp.cpspringboot.teacherScore.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import com.cp.cpspringboot.teacherScore.model.TeacherScore;

import ch.qos.logback.core.subst.Token.Type;


/**
 * teacher服务接口
 * @author anlib
 *
 */
public interface TeacherScoreService {
       /**
     * 获取list信息
     * @return
     */
    List<TeacherScore> findTeacherScore(int pageNum, int pageSize, Map<String, Object> map);

	List<TeacherScore> findTeacherScore(Map<String, Object> map);
}