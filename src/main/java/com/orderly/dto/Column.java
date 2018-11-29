package com.orderly.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Column {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int columnId;
	private String columnName;
	private int projectId;
	
	public int getId() {
		return columnId;
	}
	public void setId(int columnId) {
		this.columnId = columnId;
	}
	public String getName() {
		return columnName;
	}
	public void setName(String columnName) {
		this.columnName = columnName;
	}
}
