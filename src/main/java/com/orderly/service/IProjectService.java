package com.orderly.service;

import com.orderly.dao.IProjectDAO;
import com.orderly.dto.Project;

public interface IProjectService {
	
	Project fetchById(int id);

	Project save(Project project) throws Exception;

	void setProjectDAO(IProjectDAO projectDAO);

	IProjectDAO getProjectDAO();
}
