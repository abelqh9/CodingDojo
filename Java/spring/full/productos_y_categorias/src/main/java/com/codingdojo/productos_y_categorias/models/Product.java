package com.codingdojo.productos_y_categorias.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
    private String name;
	
	@NotEmpty
    private String description;
	
	@NotNull
	@Min(0)
    private float price;
	
    @Column(updatable=false)
    private Date created_at;
    
    private Date updated_at;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
    		name = "categories_products",
    		joinColumns = @JoinColumn(name = "product_id"),
    		inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categories;
    		
    public Product() {}
    
    public Product(String name, String description, float price, List<Category> categories) {
    	this.name = name;
    	this.description = description;
    	this.price = price;
    	this.categories = categories;
    }
    
    @PrePersist
    public void onCreated() {
    	this.created_at = new Date();
    }
    
    @PreUpdate
    public void onUpdated() {
    	this.updated_at = new Date();
    }
    
    //Setters And Getters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
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

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
}
