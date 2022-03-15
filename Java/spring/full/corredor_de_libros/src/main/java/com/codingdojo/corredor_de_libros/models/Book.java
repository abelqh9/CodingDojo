package com.codingdojo.corredor_de_libros.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "books")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @NotEmpty(message="¡Se requiere Title!")
    private String title;
    
    @NotEmpty(message="¡Se requiere Author!")
    private String author;
    
    @NotEmpty(message="¡Se requiere Thoughts!")
    @Size(min=10)
    private String thoughts;
    
    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-DD")
    private Date created_at;
    
    @DateTimeFormat(pattern = "yyyy-MM-DD")
    private Date updated_at;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    
    @OneToOne(mappedBy="book", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private Borrow borrow;
    
    @PrePersist
    public void onCreated() {
    	this.created_at = new Date();
    }
    
    @PreUpdate
    public void onUpdated() {
    	this.updated_at = new Date();
    }
    
    public Book() {}
    
    public Book(String title, String author, String thoughts, User user) {
    	this.title = title;
    	this.author = author;
    	this.thoughts = thoughts;
    	this.user = user;
    }

  //GETTERS AND SETTERS
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getThoughts() {
		return thoughts;
	}

	public void setThoughts(String thoughts) {
		this.thoughts = thoughts;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
