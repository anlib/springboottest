package com.cp.cpspringboot.teacherFollow.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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
	 * @return
	 */
	@RequestMapping(value = "/list/{pageNum}/{pageSize}", method = RequestMethod.POST, produces = {
	"application/json;charset=UTF-8" })
public List<TeacherFollow> findTeacherFollowList(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize,
	@RequestBody Map<String, Object> params, TeacherFollow teacherFollow) {
//		 System.out.println("------- POST: list -------");
//		 for (Map.Entry<String, Object> entry : params.entrySet()) {
//			 System.out.println("Key = " + entry.getKey() + ", Value = " +
//			 entry.getValue());
//		 }
		Map<String, Object> map = new HashMap<String, Object>();
		if (params.get("touserid") != null && !"".equals(params.get("touserid"))) {
			map.put("touserid", params.get("touserid"));
		}
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
		}
		return teacherFollowService.findTeacherFollow(pageNum, pageSize, map);
	}
	
}