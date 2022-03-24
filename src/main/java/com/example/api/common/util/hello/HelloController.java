package com.example.api.common.util.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import lombok.Data;

@RestController
public class HelloController {

	@ApiOperation(value = "hello world 출력", notes = "hello world 출력2")
	@GetMapping("/hello")
	public Hello hello() {
		return new Hello("hello world");
	}
	
	@Data
	private class Hello{
		private String message;
		public Hello(String message) {
			this.message = message;
		}
	}
}


