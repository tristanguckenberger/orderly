package com.orderly.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.orderly.dto.Task;

public interface TaskRepository extends CrudRepository<Task, Integer> {
	List<Task> findByColumnId(int columnId);
}
