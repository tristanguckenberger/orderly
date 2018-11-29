package com.orderly.service;

import java.util.List;

import com.orderly.dao.IColumnDAO;
import com.orderly.dao.ITaskDAO;
import com.orderly.dto.Cols;
import com.orderly.dto.Task;

public interface IColumnService {
	
	Task fetchById(int id);

	boolean save(Cols cols) throws Exception;

	List<Cols> fetchColumn(String string) throws Exception;

	void setColumnDAO(IColumnDAO columnDAO);

	IColumnDAO getColumnDAO();

	List<Cols> fetchColumnsByProjectId(int projectID);
}
