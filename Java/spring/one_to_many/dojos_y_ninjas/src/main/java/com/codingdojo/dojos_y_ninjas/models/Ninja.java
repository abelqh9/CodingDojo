package com.codingdojo.dojos_y_ninjas.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "ninjas")
public class Ninja {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	private String first_name;
	
	@NotEmpty
	private String last_name;
	
	@NotNull
	@Min(0)
	@Max(100)
	private Integer age;
	
	@DateTimeFormat(pattern = "yyyy-MM-DD")
	private Date created_at;
	
	@DateTimeFormat(pattern = "yyyy-MM-DD")
	private Date updated_at;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dojo_id")
	private Dojo dojo;
	
	public Ninja() {
		
	}
	
	public Ninja(String first_name, String last_name, Integer age, Dojo dojo) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.age = age;
		this.dojo = dojo;
	}
	
	@PrePersist
	public void onCreate() {
		this.created_at = new Date();
	}
	
	@PreUpdate
	public void onUpdate() {
		this.updated_at = new Date();
	}
	
	//GETTERS AND SETTER
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

	public Dojo getDojo() {
		return dojo;
	}

	public void setDojo(Dojo dojo) {
		this.dojo = dojo;
	}
}
