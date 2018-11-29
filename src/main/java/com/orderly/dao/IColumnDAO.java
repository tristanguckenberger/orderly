package com.orderly.dao;

import java.util.List;

import com.orderly.dto.Column;

public interface IColumnDAO {
	
	boolean save(Column column) throws Exception;
	
	Iterable<Column> fetchAll() throws Exception;
	
	List<Column> fetchColumnsByProjectId(int projectId);
	
}
