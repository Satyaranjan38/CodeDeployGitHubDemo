package com.pratice.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pratice.entities.Candidate;
import com.pratice.entities.Interview;
import com.pratice.entities.Resume;
import com.pratice.repository.CandidateRepository;
import com.pratice.repository.InterviewRepository;
import com.pratice.repository.ResumeRepository;
import com.pratice.service.InterviewService;

@Service
public class InterviewServiceimpl implements InterviewService {

	@Autowired
	private InterviewRepository interviewRepository ; 
	
	@Autowired
	private CandidateRepository candidateRepository ; 
	
	
	@Autowired 
	private ResumeRepository resumeRepository ; 
	
	@Override
	public List<Interview> getAll() {
		// TODO Auto-generated method stub
		return interviewRepository.findAll();
	}
	@Override
	public Interview saveInterview(Interview interview) {
		// TODO Auto-generated method stub
		return interviewRepository.save(interview);
	}
	@Override
	public String sheduleInterview(String c_id, String i_id) {
		// TODO Auto-generated method stub
		Candidate ca= candidateRepository.findById(c_id).orElse(null);
		
		List<Interview>list= new ArrayList<>();
		
		Interview in = interviewRepository.findById(i_id).orElse(null);
		
		list.add(in);
	
		ca.setInterview(list);	
		
		candidateRepository.save(ca);
		
		interviewRepository.save(in);
		
			return "candidate"+candidateRepository.findById(c_id)+"interview scheduled sucessfully";	
		
	}

}
