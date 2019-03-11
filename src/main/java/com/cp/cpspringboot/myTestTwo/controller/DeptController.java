package com.cp.cpspringboot.myTestTwo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cp.cpspringboot.myTestTwo.model.Dept;
import com.cp.cpspringboot.myTestTwo.service.DeptService;

/**
 * dept控制器
 * @author 
 *
 */
@RestController  //  此注解指明该控制器直接返回数据，而不进行页面跳转
@RequestMapping("/dept")  //  定义路由信息
public class DeptController {

    @Autowired
    private DeptService deptService;

    /**
     * 查询所有部门信息
     * @return
     */
    @RequestMapping("/findAll")  //  则次路由信息应该是/dept/findAll
    public List<Dept> findAll(){
        return deptService.findAll();
    }
}