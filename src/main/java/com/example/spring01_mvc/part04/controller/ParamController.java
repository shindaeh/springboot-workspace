package com.example.spring01_mvc.part04.controller;

import java.util.HashMap;

import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

//http://localhost:8090/paramcall?code=a001&price=1000
//code,price 2개의 값을 줘야하는데 1개가 비어있어서 오류 발생

//required =true(필수), 
//defaultValue="p000"(선택) 
//http://localhost:8090/paramcall?code=a001

//required =false, defaultValue="0"
//http://localhost:8090/paramcall?price=1000
//http://localhost:8090/paramcall

@Slf4j
@RestController
public class ParamController {

	@GetMapping(value="/paramcall")
	public HashMap<String, Object> paramCall(@RequestParam(name="code", required =true, defaultValue="p000") String code,
											 @RequestParam(name="price", required =false, defaultValue="0") Integer price){ //Integer는 객체여서 가능 
		//required =false일때 Integer price선언하면 오류없이 null을 받아서 정상처리한다.
		//required =false일때 int price선언하면 오류가 발생한다.
		log.info("code:{}, price:{}", code, price);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("code",code);
		map.put("price", price);
		return map;
	}
}
