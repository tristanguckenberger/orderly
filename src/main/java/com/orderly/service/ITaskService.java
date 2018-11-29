package com.orderly.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.orderly.dao.ITaskDAO;
import com.orderly.dto.Task;

public interface ITaskService {
	
	Task fetchById(int id);

	boolean save(Task task) throws Exception;

	List<Task> fetchTask(String string) throws Exception;

	void setTaskDAO(ITaskDAO taskDAO);

	ITaskDAO getTaskDAO();

	List<Task> fetchTasksByColumnId(int columnID);
}
