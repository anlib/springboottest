package com.cp.cpspringboot.myTestTwo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cp.cpspringboot.myTestTwo.mapper.DeptMapper;
import com.cp.cpspringboot.myTestTwo.model.Dept;
import com.cp.cpspringboot.myTestTwo.service.DeptService;


/**
 * dept服务接口实现类
 * @author 
 *
 */
@Service(value = "deptService")  //  该注解一定要写，否则无法注册bean
public class DeptServiceImpl implements DeptService{

    @Autowired
    private DeptMapper DeptMapper;  //  注入mapper

    @Override
    public List<Dept> findAll() {
        return DeptMapper.findAll();
    }

    @Override
    public void addDept(Dept dept) {
    	DeptMapper.addDept(dept);
    }

}