package com.orderly.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.orderly.dto.Task;

@Component
public class TaskDAO implements ITaskDAO {
	
	@Autowired
	TaskRepository taskRepository;

	@Override
	public boolean save(Task task) throws Exception {
		taskRepository.save(task);
		return false;
	}

	@Override
	public List<Task> fetchTasksByColumnId(int columnId) {
		return null;
	}

}
