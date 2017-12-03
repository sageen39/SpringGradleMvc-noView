package com.aquarii.controller;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.aquarii.domain.Project;
import com.aquarii.service.ProjectService;

@RestController
@RequestMapping("/project")
public class ProjectController {
	
	private Logger logger = LoggerFactory.getLogger(ProjectController.class);
	
	@Autowired
	private ProjectService projectService;

	
	@RequestMapping(value ="/add",method = RequestMethod.POST)
	public boolean addProject(@RequestBody Project project) {
		
		logger.info("{}",project.toString());
		throw new RuntimeErrorException(null, "Run Time Error!!");
		//return this.projectService.createProject(project);
		
	}
	
	@RequestMapping(value ="/findall",method = RequestMethod.GET)
	public List<Project> getAll() {
		logger.info("Finding Projects");
		 List<Project> projects = this.projectService.findAll();
		
		return projects;
	}
	
	@RequestMapping(value="/{projectId}", method = RequestMethod.GET)
	public Project findById(@PathVariable("projectId") Long projectId) {
		return this.projectService.findById(projectId);
	}
	
	
	@RequestMapping(value="/upload", method = RequestMethod.POST)
	public String uploadFile(@RequestPart("file") MultipartFile file) {

		if(!file.isEmpty()) {
			return "The File Name & Size is: "+file.getName()+" "+file.getSize();
		}
		return null;
		
		
				
	}
}
