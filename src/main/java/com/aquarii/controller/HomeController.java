package com.aquarii.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aquarii.domain.Project;

@RestController
public class HomeController {

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	//@ResponseBody
	public List<Project> goHome() {
	
		List<Project> projects = new ArrayList<>();
		Project project = new Project();
		project.setName("First Project");
		project.setDescription("This is a simple project sponsered by NASA");
		
		projects.add(project);
		
		System.out.println(project.toString());
		return projects;
	}

}
