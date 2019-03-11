package com.cp.cpspringboot.myTestOne;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import net.minidev.json.JSONObject;

@RestController
public class myTestOne {

	@GetMapping(value = "/json", produces = "application/json;charset=UTF-8")
	public String getInfoLocal() {
		JSONObject jsonTemp = new JSONObject();
		jsonTemp.put("id", "123");
		jsonTemp.put("name", "张三");
		return jsonTemp.toJSONString();
	}


}
