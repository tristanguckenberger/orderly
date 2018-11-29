package com.orderly.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.orderly.dao.IColumnDAO;
import com.orderly.dao.ITaskDAO;
import com.orderly.dto.Cols;
import com.orderly.dto.Task;

@Component
public class ColumnService implements IColumnService {
	
	@Autowired
	IColumnDAO columnDAO;

	@Override
	public Task fetchById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean save(Cols cols) throws Exception {
		columnDAO.save(cols);
		return false;
	}

	@Override
	public List<Cols> fetchColumn(String string) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setColumnDAO(IColumnDAO columnDAO) {
		// TODO Auto-generated method stub

	}

	@Override
	public IColumnDAO getColumnDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cols> fetchColumnsByProjectId(int projectID) {
		// TODO Auto-generated method stub
		return null;
	}

}
