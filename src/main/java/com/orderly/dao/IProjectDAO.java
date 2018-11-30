package com.orderly.dao;

import java.util.List;

import com.orderly.dto.Project;

public interface IProjectDAO {
	
	Project save(Project project) throws Exception;

	List<Project> fetch(String searchFilter) throws Exception;

	Iterable<Project> fetchAll() throws Exception;
}
