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
import com.cp.cpspringboot.teacherScore.model.TeacherScore;
import com.cp.cpspringboot.teacherScore.service.TeacherScoreService;

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

	/**
	 * 查询信息
	 * @return
	 */
	@RequestMapping(value = "/list/{pageNum}/{pageSize}", method = RequestMethod.POST, produces = {
	"application/json;charset=UTF-8" }) // 次路由信息,全路径应该是ip:port/工程/teacher/findTeacher
public List<TeacherScore> findTeacherScoreList(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize,
	@RequestBody Map<String, Object> params, TeacherScore teacherScore) {
		
//		 System.out.println("------- POST: list -------");
//		 for (Map.Entry<String, Object> entry : params.entrySet()) {
//			 System.out.println("Key = " + entry.getKey() + ", Value = " +
//			 entry.getValue());
//		 }
		 
		Map<String, Object> map = new HashMap<String, Object>();
		if (params.get("listpid") != null && !"".equals(params.get("listpid"))) {
			map.put("listpid", params.get("listpid"));
		}
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
		}
		return teacherScoreService.findTeacherScore(pageNum, pageSize, map);
	}
	
}