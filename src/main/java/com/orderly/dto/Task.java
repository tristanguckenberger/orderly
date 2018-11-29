package com.orderly.dto;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Task {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int taskId;
	private String taskName;
	private String taskDescription;
	private int columnId;
	
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public String getName() {
		return taskName;
	}
	public void setName(String taskName) {
		this.taskName = taskName;
	}
	public String getDescription() {
		return taskDescription;
	}
	public void setDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}
}
