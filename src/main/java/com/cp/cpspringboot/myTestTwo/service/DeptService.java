package com.cp.cpspringboot.myTestTwo.service;

import java.util.List;

import com.cp.cpspringboot.myTestTwo.model.Dept;

/**
 * dept服务接口
 * @author 
 *
 */
public interface DeptService {
    /**
     * 获取所有部门信息
     * @return
     */
    List<Dept> findAll(); 
    /**
     * 添加部门 
     * @param dept
     */
    void addDept(Dept dept);
}