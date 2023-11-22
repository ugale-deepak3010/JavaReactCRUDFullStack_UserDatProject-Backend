package com.FullStack_Project_SpringBoot_React.Repository;

//import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import com.FullStack_Project_SpringBoot_React.Model.UserData;

//@SpringBootApplication
public interface UserRepository extends JpaRepository<UserData, Long> {

}
