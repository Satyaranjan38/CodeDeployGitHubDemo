package com.pratice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pratice.entities.Resume;
import com.pratice.service.ResumeService;

@RestController
@RequestMapping("/re")
public class ResumeController {

	@Autowired
	private ResumeService resumeService ; 
	
	@PostMapping("/save")
	public Resume saveResume(@RequestBody Resume resume ) {
		return resumeService.saveResume(resume); 
				
	}
}
