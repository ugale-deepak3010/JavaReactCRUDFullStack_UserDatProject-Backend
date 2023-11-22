package com.FullStack_Project_SpringBoot_React.Project_Exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class UserNotFoundAdvice {
	
	@ResponseBody
	@ResponseStatus( HttpStatus.NOT_FOUND )
	@ExceptionHandler(UserDataNotFoundException.class)
	public Map<String, String> exceptionHanler(UserDataNotFoundException userDataNotFoundException){
		
		Map<String, String> errorMap = new HashMap<>();
		errorMap.put("Error message: ", userDataNotFoundException.getMessage());
		
		return errorMap;
	}
}
