package com.erayyildirim.TaskSystem;

import com.erayyildirim.TaskSystem.model.Task;
import com.erayyildirim.TaskSystem.model.User;
import com.erayyildirim.TaskSystem.service.TaskService;
import com.erayyildirim.TaskSystem.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskSystemApplicationTests {


	@Autowired
	private UserService userService;

	@Autowired
	private TaskService taskService;


	@Before
	public void initDb(){
		{
			User user = new User("testuser@gmail.com","testUser","12345");
			userService.createUser(user);
		}
		{
			User user = new User("testadmin@gmail.com","testAdminr","1234567");
			userService.createAdmin(user);
		}

		Task userTask = new Task("14/02/2018","00:00","13:00","Work");

		User user = userService.findOneUser("testuser@gmail.com");

		taskService.addTask(userTask,user);

	}

	@Test
	public void testUser(){
		User user = userService.findOneUser("testuser@gmail.com");
		Assert.assertNotNull(user);

		User admin = userService.findOneUser("testadmin@gmail.com");
		Assert.assertEquals(admin.getEmail(),"testadmin@gmail.com");
	}

	@Test
	public void testTask(){
		User user = userService.findOneUser("testuser@gmail.com");
		List<Task> taskList = taskService.findUserTask(user);
		Assert.assertNotNull(taskList);
	}

}
