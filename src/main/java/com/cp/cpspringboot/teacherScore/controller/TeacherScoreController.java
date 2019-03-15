package com.cp.cpspringboot.teacherScore.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.cp.cpspringboot.teacher.model.Teacher;
import com.cp.cpspringboot.teacher.service.TeacherService;
import com.cp.cpspringboot.teacherScore.model.TeacherScore;
import com.cp.cpspringboot.teacherScore.service.TeacherScoreService;
import com.cp.cpspringboot.teacherStatement.model.TeacherStatement;
import com.cp.cpspringboot.teacherStatement.service.TeacherStatementService;

/**
 * Teacher控制器
 * 
 * @author anlib
 *
 */
@RestController // 此注解指明该控制器直接返回数据，而不进行页面跳转
@RequestMapping("/teacherScore") // 定义路由信息
public class TeacherScoreController {

	@Autowired
	private TeacherScoreService teacherScoreService;
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private TeacherStatementService teacherStatementService;

	/**
	 * 查询信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/list/{pageNum}/{pageSize}", method = RequestMethod.POST, produces = {
			"application/json;charset=UTF-8" }) // 次路由信息,全路径应该是ip:port/工程/teacher/findTeacher
	public List<TeacherScore> findTeacherScoreList(@PathVariable("pageNum") int pageNum,
			@PathVariable("pageSize") int pageSize, @RequestBody Map<String, Object> params,
			TeacherScore teacherScore) {

		// System.out.println("------- POST: list -------");
		// for (Map.Entry<String, Object> entry : params.entrySet()) {
		// System.out.println("Key = " + entry.getKey() + ", Value = " +
		// entry.getValue());
		// }

		Map<String, Object> map = new HashMap<String, Object>();
		if (params.get("listpid") != null && !"".equals(params.get("listpid"))) {
			map.put("listpid", params.get("listpid"));
		}
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
		}
		return teacherScoreService.findTeacherScore(pageNum, pageSize, map);
	}

	/**
	 * 查询数量信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/count", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	public List<TeacherScore> findTeacherScoreCount(@RequestBody Map<String, Object> params) {
		// System.out.println("------- POST: list -------");
		// for (Map.Entry<String, Object> entry : params.entrySet()) {
		// System.out.println("Key = " + entry.getKey() + ", Value = " +
		// entry.getValue());
		// }
		Map<String, Object> map = new HashMap<String, Object>();
		if (params.get("listpid") != null && !"".equals(params.get("listpid"))) {
			map.put("listpid", params.get("listpid"));
		}
		if (params.get("fromuserid") != null && !"".equals(params.get("fromuserid"))) {
			map.put("fromuserid", params.get("fromuserid"));
		}
		map.put("setid", 10);
		// for (Map.Entry<String, Object> entry : map.entrySet()) {
		// System.out.println("Key = " + entry.getKey() + ", Value = " +
		// entry.getValue());
		// }
		return teacherScoreService.findTeacherScoreCount(map);
	}

	/**
	 * 添加
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	private Map<String, Object> addTeacherScore(@RequestBody TeacherScore teacherScore) {
		System.out.println("------- POST: teacherScore -------");
		String jsonString = JSONArray.toJSONString(teacherScore);
		System.out.println(jsonString);
		teacherScore.setListsetid(10);
		int effectCount = teacherScoreService.insert(teacherScore);
		// (获取总数 乘以原来 的平均分数 + 现在提交的分数) / 总数+1
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("listpid", teacherScore.getListpid());
		map.put("fromuserid", teacherScore.getFromuserid());
		map.put("listsetid", 10);
		// 获取该评论该老师的人数
		List<TeacherScore> list = teacherScoreService.findTeacherScoreCount(map);
		map.remove("listpid");
		map.remove("fromuserid");
		map.remove("listsetid");
		map.put("id", teacherScore.getListpid());
		// 获取该老师的平均分值
		List<Teacher> listTeacher = teacherService.findTeacher(map);
		int scoreOld = listTeacher.get(0).getScore();
		if (scoreOld > 10){
			scoreOld = 10;
		}
		int count = list.get(0).getCount();
		int score = Math.round(((count * scoreOld) + Integer.parseInt(teacherScore.getScore())) / (count + 1));
		//System.out.println("------------score: " + score);
		if (score > 10){
			score = 10;
		}
		// 更新 用户表的平均分值
		Teacher teacher = new Teacher();
		teacher.setScore(score);
		teacher.setId(teacherScore.getListpid());
		effectCount = teacherService.update(teacher);
		// 更新交易表的已经评价状态
		TeacherStatement teacherStatement = new TeacherStatement();
		if ((Integer) teacherScore.getStatementid() != null && !"".equals(teacherScore.getStatementid())) {
			teacherStatement.setScore(1);
			teacherStatement.setId(teacherScore.getStatementid());
			effectCount = teacherStatementService.update(teacherStatement);
		}
		// 返回前端
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("effectCount", effectCount);
		return modelMap;
	}

}