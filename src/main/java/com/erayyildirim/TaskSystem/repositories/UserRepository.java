package com.erayyildirim.TaskSystem.repositories;

import java.util.List;
import java.util.Optional;


import com.erayyildirim.TaskSystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository  extends CrudRepository<User, String> {

	List<User> findByNameLike(String name);


	@Query("select u from User u where u.email =:email")
	User findByEmail(@Param("email") String email);

}
