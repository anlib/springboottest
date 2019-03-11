package com.cp.cpspringboot.teacherExperience.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cp.cpspringboot.teacherExperience.model.TeacherExperience;
import com.cp.cpspringboot.teacherExperience.service.TeacherExperienceService;

/**
 * Teacher控制器
 * 
 * @author anlib
 *
 */
@RestController // 此注解指明该控制器直接返回数据，而不进行页面跳转
@RequestMapping("/teacherExperience") // 定义路由信息
public class TeacherExperienceController {

	@Autowired
	private TeacherExperienceService teacherExperienceService;

	/**
	 * 根据id查询信息
	 * @return
	 */
	@RequestMapping(value = "/id/{id}", produces = { "application/json;charset=UTF-8" })
	public List<TeacherExperience> findTeacherExperienceOne(@PathVariable("id") int id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
		}
		List<TeacherExperience> list = teacherExperienceService.findTeacherExperience(map);
		return list;
	}
	
}