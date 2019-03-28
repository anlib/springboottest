package com.cp.cpspringboot.teacherCertificate.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cp.cpspringboot.teacherCertificate.model.TeacherCertificate;
import com.cp.cpspringboot.teacherCertificate.service.TeacherCertificateService;
import com.cp.util.FileUtils;

/**
 * Teacher控制器
 * 
 * @author anlib
 *
 */
@RestController // 此注解指明该控制器直接返回数据，而不进行页面跳转
@RequestMapping("/teacherCertificate") // 定义路由信息
public class TeacherCertificateController {

	@Autowired
	private TeacherCertificateService teacherCertificateService;

	/**
	 * 根据id查询信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/pid/{pid}", produces = { "application/json;charset=UTF-8" })
	public List<TeacherCertificate> findTeacherCertificateOne(@PathVariable("pid") int pid) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("setid", 10);
		map.put("pid", pid);
		map.put("order", "id DESC");
//		for (Map.Entry<String, Object> entry : map.entrySet()) {
//			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
//		}
		List<TeacherCertificate> list = teacherCertificateService.findTeacherCertificate(map);
		return list;
	}

	/**
	 * 上传文件
	 * 
	 * @param request
	 * @return String
	 */
	@RequestMapping(value = "/upload/{pid}", method = RequestMethod.POST, produces = {
			"application/json;charset=UTF-8" })
	private List<String> uploadTeacherCertificate(@PathVariable("pid") int pid, HttpServletRequest request) {
		System.out.print("this is upload");
		// Teacher 为 setid = 10
		int setid = 10;
		String savePath = "/zls/htmldata/attachment";
		String servPath = "/opt/webphp/";
		//String servPath = "F:/suanzhe";
		String formFileName = "file";
		Map<Integer, String> map = FileUtils.multiUpload(request, formFileName, savePath, servPath);
		List<String> list = new ArrayList<String>();
		if (map != null) { // 如果上传成功
			TeacherCertificate teacherCertificate = new TeacherCertificate();
			teacherCertificate.setPid(pid);
			teacherCertificate.setSetid(setid);
			for (Entry<Integer, String> entry : map.entrySet()) {
				System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
				teacherCertificate.setCertificate(entry.getValue());
				int effectCount = teacherCertificateService.insert(teacherCertificate);
				list.add(teacherCertificate.getCertificate());
			}
		}
		//System.out.print(list);
		return list;
	}

}