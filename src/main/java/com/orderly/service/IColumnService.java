package com.orderly.service;

import java.util.List;

import com.orderly.dao.IColumnDAO;
import com.orderly.dao.ITaskDAO;
import com.orderly.dto.Column;
import com.orderly.dto.Task;

public interface IColumnService {
	
	Task fetchById(int id);

	boolean save(Column column) throws Exception;

	List<Column> fetchColumn(String string) throws Exception;

	void setColumnDAO(IColumnDAO columnDAO);

	IColumnDAO getColumnDAO();

	List<Column> fetchColumnssByProjectId(int projectID);
}
