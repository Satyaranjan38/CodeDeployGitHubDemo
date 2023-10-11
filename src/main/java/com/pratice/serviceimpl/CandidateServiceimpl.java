package com.pratice.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pratice.entities.Candidate;
import com.pratice.repository.CandidateRepository;
import com.pratice.repository.ResumeRepository;
import com.pratice.service.CandidateService;

@Service
public class CandidateServiceimpl implements CandidateService {

	@Autowired
	private CandidateRepository candidateRepository ;
	
	@Autowired
	private ResumeRepository resumeRepository ;

	@Override
	public Candidate saveCandidate(Candidate candidate) {
		// TODO Auto-generated method stub
		return candidateRepository.save(candidate);
	}

	
	
	
}
