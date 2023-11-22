package com.FullStack_Project_SpringBoot_React.Project_Exception;

@SuppressWarnings("serial")
public class UserDataNotFoundException extends RuntimeException {

	public UserDataNotFoundException(Long id) {
		super("Could not found User Data for this id : "+ id);
		// TODO Auto-generated constructor stub
	}
	
}
