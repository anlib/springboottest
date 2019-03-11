package com.cp.cpspringboot.teacher.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cp.cpspringboot.teacher.model.Teacher;
import com.cp.cpspringboot.teacher.service.TeacherService;
import com.cp.cpspringboot.teacherCertificate.model.TeacherCertificate;
import com.cp.cpspringboot.teacherCertificate.service.TeacherCertificateService;
import com.cp.cpspringboot.teacherExperience.model.TeacherExperience;
import com.cp.cpspringboot.teacherExperience.service.TeacherExperienceService;
import com.cp.cpspringboot.teacherScore.model.TeacherScore;
import com.cp.cpspringboot.teacherScore.service.TeacherScoreService;
import com.cp.cpspringboot.teacherUniversity.model.TeacherUniversity;
import com.cp.cpspringboot.teacherUniversity.service.TeacherUniversityService;

/**
 * Teacher控制器
 * 
 * @author anlib
 *
 */
@RestController // 此注解指明该控制器直接返回数据，而不进行页面跳转
@RequestMapping("/teacher") // 定义路由信息
public class TeacherController {

	@Autowired
	private TeacherService teacherService;
	@Autowired
	private TeacherUniversityService teacherUniversityService;
	@Autowired
	private TeacherExperienceService teacherExperienceService;
	@Autowired
	private TeacherCertificateService teacherCertificateService;
	@Autowired
	private TeacherScoreService teacherScoreService;

	/**
	 * post查询list信息
	 * 
	 * @return
	 */
	// @RequestMapping(value = "/list/{pageNum}/{pageSize}", method =
	// RequestMethod.GET, produces = {"application/json;charset=UTF-8"}) //
	// 次路由信息,全路径应该是ip:port/工程/teacher/findTeacher
	// public List<Teacher> findTeacherListGet(@PathVariable("pageNum") int
	// pageNum,
	// @PathVariable("pageSize") int pageSize){
	// System.out.println("------- GET: list -------");
	// return teacherService.findTeacherPage(pageNum, pageSize);
	// }
	@RequestMapping(value = "/list/{pageNum}/{pageSize}", method = RequestMethod.POST, produces = {
			"application/json;charset=UTF-8" }) // 次路由信息,全路径应该是ip:port/工程/teacher/findTeacher
	public List<Teacher> findTeacherList(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize,
			@RequestBody Map<String, Object> params, Teacher teacher) {
//		System.out.println("------- POST: list -------");
//		for (Map.Entry<String, Object> entry : params.entrySet()) {
//			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
//		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("active", 1);
		if (params.get("order") != null && !"".equals(params.get("order"))) {
			String order = (String) params.get("order");
			switch (order) {
			case "综合排序":
				order = "posttime";
				break;
			case "距离最近":
				String latitude = String.valueOf(params.get("latitude"));
				String longitude = String.valueOf(params.get("longitude"));
				order = "ACOS(SIN((" + latitude + " * 3.1415) / 180) * SIN((latitude * 3.1415) / 180) + COS(("
						+ latitude + " * 3.1415) / 180) * COS((latitude * 3.1415) / 180) * COS((" + longitude
						+ " * 3.1415) / 180 - (longitude * 3.1415) / 180)) * 6380 asc";
				break;
			case "教学经验":
				order = "experience DESC";
				break;
			case "价格最低":
				order = "price";
				break;
			case "价格最高":
				order = "price DESC";
				break;
			case "评价最高":
				order = "score DESC";
				break;
			default:
				order = "posttime";
			}
			map.put("order", order);
		}
		if (params.get("grade") != null && !"".equals(params.get("grade"))) {
			map.put("grade", (String) params.get("grade"));
		}
		if (params.get("taught") != null && !"".equals(params.get("taught"))) {
			map.put("taught", (String) params.get("taught"));
		}
		if (params.get("area") != null && !"".equals(params.get("area"))) {
			map.put("area", (String) params.get("area"));
		}
		if (params.get("openid") != null && !"".equals(params.get("openid"))) {
			map.put("openid", (String) params.get("openid").toString());
		}
		if (params.get("ids") != null && !"".equals(params.get("ids"))) {
			map.put("ids", params.get("ids"));
		}
		@SuppressWarnings("unchecked")
		Map<String, Object> form = (Map<String, Object>) params.get("form");
		// for (Map.Entry<String, Object> entry : ((Map<String, Object>)
		// form).entrySet()) {
		// System.out.println("Key = " + entry.getKey() + ", Value = " +
		// entry.getValue());
		// }
		if (form != null && !"".equals(form)) {

			String teachervalue = (String) form.get("teacher");
			if (teachervalue != null && !"".equals(teachervalue)) {
				map.put("teacher", teachervalue);
			}
			String gender = (String) form.get("gender");
			if (gender != null && !"".equals(gender)) {
				map.put("gender", gender);
			}
			String experience = (String) form.get("experience");
			if (experience != null && !"".equals(experience)) {
				map.put("experience", experience);
			}
		}
//		for (Map.Entry<String, Object> entry : map.entrySet()) {
//			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
//		}
		// System.out.println("===========pageNum : " + pageNum);
		return teacherService.findTeacherPage(pageNum, pageSize, map);
	}

	/**
	 * 根据id查询信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/id/{id}", produces = { "application/json;charset=UTF-8" })
	public Map<String, Object> findTeacherOne(@PathVariable("id") int id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		// for (Map.Entry<String, Object> entry : map.entrySet()) {
		// System.out.println("Key = " + entry.getKey() + ", Value = " +
		// entry.getValue());
		// }
		List<Teacher> listTeacher = teacherService.findTeacher(map);
		// for (Teacher teacher : listTeacher) {
		// System.out.println("getTeacher:" + teacher.getTeacher());
		// }
		map.remove("id");
		map.put("pid", id);
		// for (Map.Entry<String, Object> entry : map.entrySet()) {
		// System.out.println("Key = " + entry.getKey() + ", Value = " +
		// entry.getValue());
		// }
		List<TeacherUniversity> listTeacherUniversity = teacherUniversityService.findTeacherUniversity(map);
		List<TeacherExperience> listTeacherExperience = teacherExperienceService.findTeacherExperience(map);
		List<TeacherCertificate> listTeacherCertificate = teacherCertificateService.findTeacherCertificate(map);
		map.remove("id");
		map.put("listpid", id);
		List<TeacherScore> listTeacherScore = teacherScoreService.findTeacherScore(map);
		Map<String, Object> mapReturn = new HashMap<String, Object>();
		mapReturn.put("teacher", listTeacher);
		mapReturn.put("university", listTeacherUniversity);
		mapReturn.put("experience", listTeacherExperience);
		mapReturn.put("certificate", listTeacherCertificate);
		mapReturn.put("score", listTeacherScore);
		return mapReturn;
	}

	/**
	 * 添加 teacher
	 * 
	 * @param teacher
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	private Map<String, Object> addTeacher(@RequestBody Teacher teacher) {
		// System.out.println("------- POST: add -------");
		// String jsonString = JSONArray.toJSONString(teacher);
		// System.out.println(jsonString);
		int effectCount = teacherService.insert(teacher);
		// System.out.println(teacher.getId());
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("insertId", teacher.getId());
		return modelMap;
	}

	/**
	 * 修改 teacher
	 * 
	 * @param teacher
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	private Map<String, Object> updateTeacher(@RequestBody Teacher teacher) {
		int effectCount = teacherService.update(teacher);
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("updateId", teacher.getId());
		// modelMap.put("myflag", teacher.getMyflag());
		return modelMap;
	}
//bak code	
//	@RequestMapping(value = "/test", method = RequestMethod.GET)
//	public void doGet(HttpServletRequest request, HttpServletResponse response)
//	{
//		System.out.println("------------------------------------------test");
//	}
//	@RequestMapping(value = "/test", method = RequestMethod.POST)
//	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
//	}

	public static void main(String[] args) {

		
	}
}