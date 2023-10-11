package com.pratice.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pratice.entities.Resume;
import com.pratice.repository.CandidateRepository;
import com.pratice.repository.ResumeRepository;
import com.pratice.service.ResumeService;


@Service
public class ResumeServiceimpl implements ResumeService {

	@Autowired
	private CandidateRepository candidateRepository ; 
	
	@Autowired 
	private ResumeRepository resumeRepository ;

	@Override
	public Resume saveResume(Resume resume) {
		// TODO Auto-generated method stub
		return resumeRepository.save(resume);
	} 
	
	
}
