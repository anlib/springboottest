package com.cp.cpspringboot.myTestTwo.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.cp.cpspringboot.myTestTwo.model.Dept;

/**
 * dept表mapper接口
 * @author 
 *
 */
@Mapper  //  该注解一定要加，否则无法映射到mybatis的***.xml局部配置文件
public interface DeptMapper {

    List<Dept> findAll(); 

    void addDept(Dept dept);
}