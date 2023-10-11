package com.pratice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pratice.entities.Interview;

@Repository
public interface InterviewRepository extends JpaRepository<Interview,String> {

	
}
