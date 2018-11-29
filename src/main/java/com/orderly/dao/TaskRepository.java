package com.orderly.dao;

import org.springframework.data.repository.CrudRepository;

import com.orderly.dto.Task;

public interface TaskRepository extends CrudRepository<Task, Integer> {

}
