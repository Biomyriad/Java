package com.projectmanager.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectmanager.models.Project;
import com.projectmanager.models.User;
import com.projectmanager.repositories.ProjectsRepository;

@Service
public class ProjectsService {

	@Autowired
	ProjectsRepository projectsRepository;
	
    public List<Project> allProjects() {
        return projectsRepository.findAll();
    }
    
    public Project findProject(Long id) {
		return projectsRepository.findById(id).orElse(null);
    }
    
    public Project createProject(Project p) {
        return projectsRepository.save(p);
    }
    
    public Project updateProject(Project p) {
        return projectsRepository.save(p);
    }
    
    public void deleteProject(Long id) {
    	projectsRepository.deleteById(id);
    }
    
	public List<Project> getAssignedUsers(User user){
		return projectsRepository.findAllByJoinedUsers(user);
	}
	
	public List<Project> getUnassignedUsers(User user){
		return projectsRepository.findByJoinedUsersNotContains(user);
	}
    
}
