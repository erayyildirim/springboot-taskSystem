package com.erayyildirim.TaskSystem.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@Entity
public class Task {
	@Id
	@GeneratedValue
	private Long id;

	@NotEmpty
	private String date;

	@NotEmpty
	private String startTime;

	@NotEmpty
	private String stopTime;

	@NotEmpty
	@Column(length=1000)
	private String description;

	@ManyToOne
	@JoinColumn(name="USER_EMAIL")
	private User user;
	

	public Task(String date, String startTime, String stopTime, String description, User user) {
		this.date = date;
		this.startTime = startTime;
		this.stopTime = stopTime;
		this.description = description;
		this.user = user;
	}
	public Task(String date, String startTime, String stopTime, String description) {
		this.date = date;
		this.startTime = startTime;
		this.stopTime = stopTime;
		this.description = description;
	}

}
