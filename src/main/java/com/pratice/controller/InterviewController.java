package com.pratice.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pratice.entities.Candidate;
import com.pratice.entities.Interview;
import com.pratice.service.InterviewService;

@RestController
@RequestMapping("/in")
public class InterviewController {

	@Autowired
	private InterviewService interviewService ; 
	
	@PostMapping("/save")
	public Interview saveInterview (@RequestBody Interview interview) {
		return interviewService.saveInterview(interview);
	}
	
	@PutMapping("/{c_id}/{i_id}")
	public String schedule(@PathVariable String c_id,@PathVariable String i_id) {
		return interviewService.sheduleInterview(c_id, i_id); 
	}
	
}
