package com.example.spring01_mvc.part01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.spring01_mvc.part01.dto.HelloDTO;

//http://127.0.0.1:8090/hello
//http://localhost:8090/hello

@Controller
public class HelloController {
	//hello 주소창
	@GetMapping(value="/hello")
	@ResponseBody
	public String hello() {
		return "Hello Spring boot!!";
	}
	
	//http:127.0.0.1:8090/member
	//value=속성명 (value안적어도 가능)
	@GetMapping(value="/member")
	@ResponseBody
	public String member() {
		HelloDTO dto = new HelloDTO();
		dto.setName("홍길동");
		dto.setAge(30);
		return dto.toString();
	}
}//end class
