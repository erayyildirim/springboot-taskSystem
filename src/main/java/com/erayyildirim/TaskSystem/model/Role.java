package com.erayyildirim.TaskSystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Role {

	@Id
	private String name;

	@ManyToMany(mappedBy = "roles")
	private List<User> users;



	public Role(String name) {

		this.name = name;
	}

}
