package com.orderly.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.orderly.dto.Cols;

@Component
public class ColumnDAO implements IColumnDAO {
	
	@Autowired
	ColumnRepository columnRepository;

	@Override
	public boolean save(Cols cols) throws Exception {
		// TODO Auto-generated method stub
		columnRepository.save(cols);
		return false;
	}

	@Override
	public Iterable<Cols> fetchAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cols> fetchColumnsByProjectId(int projectId) {
		// TODO Auto-generated method stub
		return null;
	}

}
