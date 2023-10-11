package com.pratice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pratice.entities.Candidate;
@Repository

public interface CandidateRepository  extends JpaRepository<Candidate,String>{

}
