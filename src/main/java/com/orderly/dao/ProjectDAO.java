package com.orderly.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.orderly.dto.Project;

@Component
public class ProjectDAO implements IProjectDAO {
	
	@Autowired
	ProjectRepository projectRepository;

	@Override
	public boolean save(Project project) throws Exception {
		projectRepository.save(project);
		return false;
	}

	@Override
	public List<Project> fetch(String searchFilter) throws Exception {
		return null;
	}

}
