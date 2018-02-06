package com.erayyildirim.TaskSystem.repositories;

import java.util.List;

import com.erayyildirim.TaskSystem.model.Task;

import com.erayyildirim.TaskSystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository  extends JpaRepository<Task, Long>{

	List<Task> findByUser(User user);
	
}
