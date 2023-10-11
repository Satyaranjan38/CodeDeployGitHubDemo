package com.pratice.service;

import java.util.List;
import java.util.Optional;

import com.pratice.entities.Candidate;
import com.pratice.entities.Interview;
import com.pratice.entities.Resume;

public interface InterviewService {

	List<Interview> getAll();
	
	Interview saveInterview(Interview interview ); 
	
	String sheduleInterview(String c_id , String i_id );
	

}
