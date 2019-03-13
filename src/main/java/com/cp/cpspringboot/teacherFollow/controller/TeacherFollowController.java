package com.cp.cpspringboot.teacherFollow.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.cp.cpspringboot.teacher.model.Teacher;
import com.cp.cpspringboot.teacherFollow.model.TeacherFollow;
import com.cp.cpspringboot.teacherFollow.service.TeacherFollowService;

/**
 * Teacher控制器
 * 
 * @author anlib
 *
 */
@RestController // 此注解指明该控制器直接返回数据，而不进行页面跳转
@RequestMapping("/teacherFollow") // 定义路由信息
public class TeacherFollowController {

	@Autowired
	private TeacherFollowService teacherFollowService;

	/**
	 * 查询信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/list/{pageNum}/{pageSize}", method = RequestMethod.POST, produces = {
			"application/json;charset=UTF-8" })
	public List<TeacherFollow> findTeacherFollowList(@PathVariable("pageNum") int pageNum,
			@PathVariable("pageSize") int pageSize, @RequestBody Map<String, Object> params,
			TeacherFollow teacherFollow) {
		// System.out.println("------- POST: list -------");
		// for (Map.Entry<String, Object> entry : params.entrySet()) {
		// System.out.println("Key = " + entry.getKey() + ", Value = " +
		// entry.getValue());
		// }
		Map<String, Object> map = new HashMap<String, Object>();
		if (params.get("touserid") != null && !"".equals(params.get("touserid"))) {
			map.put("touserid", params.get("touserid"));
		}		
		if (params.get("fromuserid") != null && !"".equals(params.get("fromuserid"))) {
			map.put("fromuserid", params.get("fromuserid"));
		}
//		for (Map.Entry<String, Object> entry : map.entrySet()) {
//			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
//		}
		return teacherFollowService.findTeacherFollow(pageNum, pageSize, map);
	}

	/**
	 * 查询数量信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/count", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	public List<TeacherFollow> findTeacherFollowCount(@RequestBody Map<String, Object> params) {
		// System.out.println("------- POST: list -------");
		// for (Map.Entry<String, Object> entry : params.entrySet()) {
		// System.out.println("Key = " + entry.getKey() + ", Value = " +
		// entry.getValue());
		// }
		Map<String, Object> map = new HashMap<String, Object>();
		if (params.get("touserid") != null && !"".equals(params.get("touserid"))) {
			map.put("touserid", params.get("touserid"));
		}		
		if (params.get("fromuserid") != null && !"".equals(params.get("fromuserid"))) {
			map.put("fromuserid", params.get("fromuserid"));
		}
		// for (Map.Entry<String, Object> entry : map.entrySet()) {
		// System.out.println("Key = " + entry.getKey() + ", Value = " +
		// entry.getValue());
		// }
		return teacherFollowService.findTeacherFollowCount(map);
	}

	/**
	 * 添加 
	 * @param 
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	private Map<String, Object> addTeacherFollow(@RequestBody TeacherFollow teacherFollow) {
//		System.out.println("------- POST: add -------");
//		String jsonString = JSONArray.toJSONString(teacherFollow);
//		System.out.println(jsonString);
		//查询数据是否已经存在
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("touserid", teacherFollow.getTouserid());
		modelMap.put("fromuserid", teacherFollow.getFromuserid());
		List<TeacherFollow> teacherFollowCount = teacherFollowService.findTeacherFollowCount(modelMap);
		modelMap.remove("touserid");
		modelMap.remove("fromuserid");
//		System.out.println("----------------teacherFollowCount----------------");
//		String jsonStringCount = JSONArray.toJSONString(teacherFollowCount);
//		System.out.println(jsonStringCount);
		//如果数据不存在则添加
		if (teacherFollowCount.get(0).getCount() == 0){
			int effectCount = teacherFollowService.insert(teacherFollow);
			// System.out.println(teacher.getId());
			modelMap.put("insertId", teacherFollow.getId());	
		}
		return modelMap;
	}
	
	/**
	 * 删除 
	 * @param 
	 * @return
	 */
	@RequestMapping(value = "/del", method = RequestMethod.POST)
	private Map<String, Object> delTeacherFollow(@RequestBody TeacherFollow teacherFollow) {
//		System.out.println("------- POST: del -------");
//		String jsonString = JSONArray.toJSONString(teacherFollow);
//		System.out.println(jsonString);
		Map<String, Object> modelMap = new HashMap<String, Object>();
			int effectCount = teacherFollowService.delete(teacherFollow);
			System.out.println(effectCount);
			modelMap.put("effectCount", effectCount);
		return modelMap;
	}
}