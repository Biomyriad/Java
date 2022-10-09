package com.projectmanager.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.projectmanager.models.Project;
import com.projectmanager.models.User;

@Repository
public interface ProjectsRepository extends CrudRepository<Project, Long>{
	
	List<Project> findAll();
	
	List<Project> findAllByJoinedUsers(User user);
	
	List<Project> findByJoinedUsersNotContains(User user);
	
}
