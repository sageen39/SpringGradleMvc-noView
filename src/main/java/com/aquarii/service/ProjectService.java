package com.aquarii.service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import com.aquarii.domain.Project;

public class ProjectService {
	
	private List<Project> projects = new LinkedList<>();
	
	
	public ProjectService() {
		Project javaProject = this.createProject("Java Project","This is a Java Project",1l);
		Project javaScriptProject = this.createProject("JavaScript Project","This is a JavaScript Project",2l);
		Project htmlProject = this.createProject("HTML Project","This is a HTML Project",3l);
		
		this.projects.addAll(Arrays.asList(new Project[] {javaProject,javaScriptProject,htmlProject}));
	}
	
	public Project createProject(String title, String description,Long id) {
		
		Project project = new Project();
		project.setName(title);
		project.setAuthorizedFunds(new BigDecimal("100000"));
		project.setAuthorizedHours(new BigDecimal("1000"));
		project.setProjectId(1L);
		project.setSpecial(false);
		project.setType("multi");
		project.setYear("2015");
		project.setDescription(description);

		return project;
	
	}
	
	public List<Project> findAll(){
		return this.projects;
	}
	
	public Project findById(Long id) {
		return this.projects.stream().filter(p -> {
			return p.getProjectId().equals(id);
		}).collect(Collectors.toList()).get(0);
	}
	
	public boolean createProject(Project project) {
		
		return projects.add(project);
	
	}
	

}
