package com.pratice.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="resume")

public class Resume {

	
	
	@Override
	public String toString() {
		return "Resume [r_id=" + r_id + ", collage_name=" + collage_name + ", applied_comapany=" + applied_comapany
				+ "]";
	}
	public String getR_id() {
		return r_id;
	}
	public void setR_id(String r_id) {
		this.r_id = r_id;
	}
	public String getCollage_name() {
		return collage_name;
	}
	public void setCollage_name(String collage_name) {
		this.collage_name = collage_name;
	}
	public String getApplied_comapany() {
		return applied_comapany;
	}
	public void setApplied_comapany(String applied_comapany) {
		this.applied_comapany = applied_comapany;
	}
	@Column
	@Id
	private String r_id ; 
	@Column
	private String collage_name ;
	@Column
	private String applied_comapany ; 
	 
	@ManyToOne
	@JoinColumn(name = "candidate_id")
	private Candidate candidate ; 
	
	
     
	
	

	
}
