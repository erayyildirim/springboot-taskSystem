package com.erayyildirim.TaskSystem;

import com.erayyildirim.TaskSystem.model.User;
import com.erayyildirim.TaskSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskSystemApplication implements CommandLineRunner{

	@Autowired
	private UserService userService;

	public static void main(String[] args) {

		SpringApplication.run(TaskSystemApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		User user = new User("admin@admin.com","admin","1234");
		userService.createAdmin(user);
	}
}
