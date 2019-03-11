package com.cp.cpspringboot.teacherCertificate.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cp.cpspringboot.teacherCertificate.mapper.TeacherCertificateMapper;
import com.cp.cpspringboot.teacherCertificate.model.TeacherCertificate;
import com.cp.cpspringboot.teacherCertificate.service.TeacherCertificateService;
import com.github.pagehelper.PageHelper;

/**
 * Teacher服务接口实现类
 * @author anlib
 *
 */
@Service(value = "teacherCertificateService")  //  该注解一定要写，否则无法注册bean
public class TeacherCertificateServiceImpl implements TeacherCertificateService{

    @Autowired
    private TeacherCertificateMapper TeacherCertificateMapper;  //  注入mapper

    /*
     * list
     * */
	public List<TeacherCertificate> findTeacherCertificate(Map<String, Object> map) {
        PageHelper.startPage(1, 21);//pageNum, pageSize将参数传给这个方法就可以实现物理分页了
    	return TeacherCertificateMapper.findTeacherCertificate(map);
    }
	
	@Override
	public int update(TeacherCertificate teacherCertificate) {
		if (teacherCertificate.getId()!=null && !"".equals(teacherCertificate.getId())) {
            try {
                int effectCount = TeacherCertificateMapper.update(teacherCertificate);
//                System.out.println("insertId:" + effectCount);
                if (effectCount > 0) {
                    return effectCount;
                } else {
                    throw new RuntimeException("更新失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("更新失败"+ e.getMessage());
            }
        }else {
            throw new RuntimeException("信息不能为空");
        }
	}

    @Transactional
    @Override
    public int insert(TeacherCertificate teacherCertificate) {
        if (teacherCertificate!=null && !"".equals(teacherCertificate)) {
            try {
                int effectCount = TeacherCertificateMapper.insert(teacherCertificate);
//                System.out.println("insertId:" + effectCount);
                if (effectCount > 0) {
                    return effectCount;
                } else {
                    throw new RuntimeException("插入失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("插入失败"+ e.getMessage());
            }
        }else {
            throw new RuntimeException("信息不能为空");
        }
    }

}