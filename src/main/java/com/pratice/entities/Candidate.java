package com.pratice.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="candidate")
public class Candidate {

	@Column
	@Id
	private String c_id  ;
	@Column
	private String c_name ;
	@Column
	private String email ;
	
	
	@OneToMany(mappedBy = "candidate", cascade =  CascadeType.ALL)
	private List<Resume> resume;
	
	
	@OneToMany(mappedBy ="candidate" , cascade = CascadeType.ALL)
	private List<Interview> interview ; 
	
	public String getC_id() {
		return c_id;
	}
	public List<Interview> getInterview() {
		return interview;
	}
	public void setInterview(List<Interview> interview) {
		this.interview = interview;
	}
	public void setC_id(String c_id) {
		this.c_id = c_id;
	}
	public List<Resume> getResume() {
		return resume;
	}
	public void setResume(List<Resume> resume) {
		this.resume = resume;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Candidate [c_id=" + c_id + ", c_name=" + c_name + ", email=" + email + "]";
	}
	
	
	
	
}
