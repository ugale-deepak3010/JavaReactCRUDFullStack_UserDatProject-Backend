package com.FullStack_Project_SpringBoot_React.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
	
	@RequestMapping("/")
	public String helloMessage() {
		return "Hello Deepak";
	}
}
