package com.example.spring01_mvc.part03.controller;

import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

								//(실제값 순서대로 작성해서 할 수 있다.)
// http://localhost:8090/pathcall/001/5000
//("/pathcall/{code}/{ptice}") -> @PathVariable 사용해야한다.
@Slf4j //log
@RestController
public class PathController {
		// http://localhost:8090/pathcall/001/5000
		@GetMapping(value="/pathcall/{code}/{price}")
		
						//500번 오류는 서버잘못,
						//400번 오류 데이터 타입이 서버에 넘어가는 값이 일치하지 않을 경우 발생
		public HashMap<String, Object> pathExecute(@PathVariable(name="code") String code,
												   @PathVariable(name="price")int price){
			log.info("code:{}, price:{}",code,price);
			
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("code", code);
			map.put("price", price);
		return map;
		}
}
