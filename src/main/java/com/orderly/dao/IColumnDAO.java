package com.orderly.dao;

import java.util.List;

import com.orderly.dto.Cols;

public interface IColumnDAO {
	
	boolean save(Cols cols) throws Exception;
	
	Iterable<Cols> fetchAll() throws Exception;
	
	List<Cols> fetchColumnsByProjectId(int projectId);
	
}
