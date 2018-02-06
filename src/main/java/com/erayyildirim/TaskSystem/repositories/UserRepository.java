package com.erayyildirim.TaskSystem.repositories;

import java.util.List;


import com.erayyildirim.TaskSystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, String> {

	List<User> findByNameLike(String name); 

}
