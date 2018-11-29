package com.orderly.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.orderly.dao.ITaskDAO;
import com.orderly.dto.Task;

@Component
public class TaskService implements ITaskService {
	
	@Autowired
	ITaskDAO taskDAO;

	@Override
	public Task fetchById(int id) {
		return null;
	}

	@Override
	public boolean save(Task task) throws Exception {
		taskDAO.save(task);
		return false;
	}

	@Override
	public List<Task> fetchTask(String string) throws Exception {
		return null;
	}

	@Override
	public void setTaskDAO(ITaskDAO taskDAO) {
		
	}

	@Override
	public ITaskDAO getTaskDAO() {
		return null;
	}

	@Override
	public List<Task> fetchTasksByColumnId(int columnID) {
		return null;
	}

}
