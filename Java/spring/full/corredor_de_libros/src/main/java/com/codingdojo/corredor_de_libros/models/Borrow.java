package com.codingdojo.corredor_de_libros.models;

import java.util.Date;

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

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "borrows")
public class Borrow {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-DD")
    private Date created_at;
    
    @DateTimeFormat(pattern = "yyyy-MM-DD")
    private Date updated_at;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;
    
    @PrePersist
    public void onCreated() {
    	this.created_at = new Date();
    }
    
    @PreUpdate
    public void onUpdated() {
    	this.updated_at = new Date();
    }
    
    public Borrow() {}
    
    public Borrow(User user, Book book) {
    	this.user = user;
    	this.book = book;
    }

  //GETTERS AND SETTERS
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
	
}
