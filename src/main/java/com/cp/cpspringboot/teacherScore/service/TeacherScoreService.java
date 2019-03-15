package com.cp.cpspringboot.teacherScore.service;

import java.util.List;
import java.util.Map;

import com.cp.cpspringboot.teacherScore.model.TeacherScore;


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

	List<TeacherScore> findTeacherScoreCount(Map<String, Object> map);

	int insert(TeacherScore teacherScore);
}