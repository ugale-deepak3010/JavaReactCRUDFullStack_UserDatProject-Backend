package com.FullStack_Project_SpringBoot_React.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.FullStack_Project_SpringBoot_React.Model.UserData;
import com.FullStack_Project_SpringBoot_React.Project_Exception.UserDataNotFoundException;
import com.FullStack_Project_SpringBoot_React.Repository.UserRepository;

@RestController
@CrossOrigin("http://localhost:3000/")
public class UserDataController {

	@Autowired
	UserRepository userRepository;
	
	@PostMapping("user")
	public UserData postUserDataByAPI(@RequestBody UserData userData) {
		userRepository.save(userData);
		return userData;
	}
	
	@GetMapping("user")
	public List<UserData> getUserDataByAPI() {
		return userRepository.findAll();
		
	}
	
	@GetMapping("user/{id}")
	public UserData getUserDataByIdinAPI(@PathVariable Long id) {
		return userRepository.findById(id).orElseThrow(()->new UserDataNotFoundException(id));
		
	}
	
	@PutMapping("user/{id}")
	public UserData updateUserData(@RequestBody UserData newUserData, @PathVariable Long id ) {
		
		return userRepository.findById(id).map(userData ->{
			userData.setUsername(newUserData.getUsername());
			userData.setName(newUserData.getName());
			userData.setEmail(newUserData.getEmail());
			return userRepository.save(userData);
		} ).orElseThrow(()->new UserDataNotFoundException(id));
		
	}
	
	@DeleteMapping("user/{id}")
	public String deleteUserDataByIDinAPI(@PathVariable Long id) {
		if(!userRepository.existsById(id)) {
			throw new UserDataNotFoundException(id);
		}
		userRepository.deleteById(id);
		
		return "This user is of Id:"+id+" has been deleted! ";
	}
	
}





















