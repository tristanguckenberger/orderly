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
		Project project = new Project();
		project.setId(id);
		project.setName("Test Project");
		return project;
	}

	@Override
	public Project save(Project project) throws Exception {
		return projectDAO.save(project);
	}

	@Override
	public void setProjectDAO(IProjectDAO projectDAO) {

	}

	@Override
	public IProjectDAO getProjectDAO() {
		return null;
	}

}
