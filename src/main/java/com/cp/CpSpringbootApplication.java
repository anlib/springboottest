package com.cp;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EnableCaching
//@MapperScan("com.cp.cpspringboot.myTestTwo.mapper") 这里注释掉，如将来需要去掉开注释
public class CpSpringbootApplication extends SpringBootServletInitializer {

	@RequestMapping(value = "/test")
	public String order() {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>(); 
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) { 
		  System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue()); 
		}
		
		return "这是服务test";
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CpSpringbootApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(CpSpringbootApplication.class, args);
	}
	/**  
     * 文件上传配置  
     * @return  
     */  
    @SuppressWarnings("deprecation")
	@Bean  
    public MultipartConfigElement multipartConfigElement() {  
        MultipartConfigFactory factory = new MultipartConfigFactory();  
        //单个文件最大  
        factory.setMaxFileSize("20MB"); //KB,MB  
        /// 设置总上传数据总大小  
        factory.setMaxRequestSize("200MB");  
        return factory.createMultipartConfig();  
    }  
}