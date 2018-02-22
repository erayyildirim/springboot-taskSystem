package com.erayyildirim.TaskSystem.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Data
@NoArgsConstructor
@Entity
public class User{

	@Id
	@Email	//Email için Email.(bulunduğu sınıf)User.(field adı)email
	@NotEmpty //validasyondan sonra kendi mesajımızı vermek için messages.properties olusturuldu
	@Column(unique = true)
	private String email;

	@NotEmpty
	private String name;

	@Size(min = 4)
	private String password;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Task> tasks;
	

	//private List<String> roles;
	private String roles;



	public User(String email, String name, String password) {
		this.email = email;
		this.name = name;
		this.password = password;
	}
}
