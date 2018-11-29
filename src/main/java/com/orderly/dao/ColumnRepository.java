package com.orderly.dao;

import org.springframework.data.repository.CrudRepository;

import com.orderly.dto.Cols;

public interface ColumnRepository extends CrudRepository<Cols, Integer> {

}
