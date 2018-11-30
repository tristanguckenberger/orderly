package com.orderly.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.orderly.dto.Cols;

public interface ColumnRepository extends CrudRepository<Cols, Integer> {
	List<Cols> findByProjectId(int projectId);
}
