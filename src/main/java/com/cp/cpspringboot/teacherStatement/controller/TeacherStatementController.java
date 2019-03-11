package com.cp.cpspringboot.teacherStatement.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.cp.cpspringboot.teacherStatement.model.TeacherStatement;
import com.cp.cpspringboot.teacherStatement.service.TeacherStatementService;

/**
 * Teacher控制器
 * 
 * @author anlib
 */
@RestController // 此注解指明该控制器直接返回数据，而不进行页面跳转
@RequestMapping("/teacherStatement") // 定义路由信息
public class TeacherStatementController {

	@Autowired
	private TeacherStatementService teacherStatementService;

	/**
	 * 查询信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/list/{pageNum}/{pageSize}", method = RequestMethod.POST, produces = {
			"application/json;charset=UTF-8" })
	public List<TeacherStatement> findTeacherStatementList(@PathVariable("pageNum") int pageNum,
			@PathVariable("pageSize") int pageSize, @RequestBody Map<String, Object> params,
			TeacherStatement teacherStatement) {
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
		return teacherStatementService.findTeacherStatement(pageNum, pageSize, map);
	}

	/*
	 * 这个是get测试 /teacherStatement/list/1/1?listpid=9
	 */
	@RequestMapping(value = "/list/{pageNum}/{pageSize}", method = RequestMethod.GET, produces = {
			"application/json;charset=UTF-8" })
	public List<TeacherStatement> findTeacherStatementListGet(@PathVariable("pageNum") int pageNum,
			@PathVariable("pageSize") int pageSize, TeacherStatement teacherStatement) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("listpid", 9);
		return teacherStatementService.findTeacherStatement(pageNum, pageSize, map);
		// return findTeacherStatementList(pageNum, pageSize,params,
		// teacherStatement);
	}

}