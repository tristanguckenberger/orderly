package com.orderly.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.orderly.dao.IProjectDAO;
import com.orderly.dto.Project;
@Component
public class ProjectService implements IProjectService {

	@Autowired
	IProjectDAO projectDAO;
	
	@Override
	public Project fetchById(int id) {
		return null;
	}

	@Override
	public boolean save(Project project) throws Exception {
		projectDAO.save(project);
		return false;
	}

	@Override
	public void setProjectDAO(IProjectDAO projectDAO) {

	}

	@Override
	public IProjectDAO getProjectDAO() {
		return null;
	}

}
