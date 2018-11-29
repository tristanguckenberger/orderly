package com.orderly.dao;

import java.util.List;
import com.orderly.dto.Task;

public interface ITaskDAO {

	boolean save(Task task) throws Exception;

	List<Task> fetchTasksByColumnId(int columnId);
}
