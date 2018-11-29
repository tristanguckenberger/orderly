package com.orderly.dao;

import org.springframework.data.repository.CrudRepository;

import com.orderly.dto.Project;

public interface ProjectRepository extends CrudRepository<Project, Integer> {

}
