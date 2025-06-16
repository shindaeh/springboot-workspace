package com.example.spring01_mvc.part05.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class TestResponseController {
	
	//http://localhost:8090/entity
	@GetMapping(value="/entity")
	public ResponseEntity<Object> hellocall() {
		log.info("ok");
							 //     객체     문자     HttpStatus.코드(코드,상태값에 따라서 status 값이 다르게 나온다.) 
															 //OK(OK는 상태값 _ 정상 작동시 status : 200값이 나온다.)
		return new ResponseEntity<Object>("entity", HttpStatus.OK);
	}
	
	//builder로 부르는 방법
	@GetMapping(value="/builder")
	// 데이터 외 코드,상태,헤더값을 넘겨야 할 경우 ResponseEntity사용
	// 헤더(headers)는 각종 상태창에 부가 설명해줄 값을 의미(첨부파일같은 의미로 생각하기)
	public ResponseEntity<Object> builderCall(){
		log.info("builder pattern");
								 //body라는 것은 넘겨줄 데이터를 뜻한다.
		//return ResponseEntity.ok().body("builder pattern");
		//아래 식과 위의식의 결과는 같다.
		return ResponseEntity.ok("builder pattern");
	}
}

/*
 * [ResponseEntity 작성방법]
 * 1. 생성자 패턴
 *  return new ResponseEntity<List<TodoDTO>>(HttpStatus.OK);
    return new ResponseEntity<List<TodoDTO>>(body, HttpStatus.OK);
    return new ResponseEntity<List<TodoDTO>>(headers, HttpStatus.OK);
    return new ResponseEntity<List<TodoDTO>>(body,headers, HttpStatus.OK);
 * 2. 빌더 패턴
 *  return ResponseEntity.ok() //상태
	.headers(headers) //헤더
	.body(body); //바디
	
	return ResponseEntity.ok().body(body);	
	return ResponseEntity.ok(body);	
	return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
 */


