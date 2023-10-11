package com.pratice.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "interview")
public class Interview {

	@Column
	@Id
	private String i_id;
	@Column
	private String interviewer;
	@Column
	private String start_time;
	@Column
	private String end_time;
	
	@ManyToOne
	@JoinColumn(name="candidate_id")
	private Candidate candidate ; 

	public String getI_id() {
		return i_id;
	}

	public void setI_id(String i_id) {
		this.i_id = i_id;
	}

	public String getInterviewer() {
		return interviewer;
	}

	public void setInterviewer(String interviewer) {
		this.interviewer = interviewer;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	@Override
	public String toString() {
		return "Interview [i_id=" + i_id + ", interviewer=" + interviewer + ", start_time=" + start_time + ", end_time="
				+ end_time + "]";
	}

}
