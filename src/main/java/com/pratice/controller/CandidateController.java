package com.pratice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pratice.entities.Candidate;
import com.pratice.service.CandidateService;

@RestController
@RequestMapping("/api")
public class CandidateController {

	@Autowired
	private CandidateService candidateService ; 
	
	@PostMapping("/save")
	public Candidate saveCandidate(@RequestBody Candidate candidate) {
		return candidateService.saveCandidate(candidate);
	}
}
