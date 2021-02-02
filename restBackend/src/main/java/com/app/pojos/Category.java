package com.app.pojos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
@Entity
@Table(name = "category")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id")
	private Integer id;
	@Column(name = "title", length = 50, unique = true)
	private String title;
	@Column(name = "description", length = 50, unique = true)
	private String description;
	@Column(name = "price")
	private Double Price;

	// category 1<---->many brands
	@JsonManagedReference
	@OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
	private List<Brand> brand = new ArrayList<>();

	// category 1<---->many product
	@JsonManagedReference
	@OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
	private List<Product> products = new ArrayList<>();

	@CreationTimestamp
	@Column(name = "createdOn", nullable = false, updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdOn;

	public Category() {
		System.out.println("Bean " + getClass().getName() + " Created...");
	}

	public Category(Integer id, String title, String description, Double price, List<Brand> brand,
			List<Product> products, Date createdOn) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		Price = price;
		this.brand = brand;
		this.products = products;
		this.createdOn = createdOn;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return Price;
	}

	public void setPrice(Double price) {
		Price = price;
	}

	public List<Brand> getBrand() {
		return brand;
	}

	public void setBrand(List<Brand> brand) {
		this.brand = brand;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", title=" + title + ", description=" + description + ", Price=" + Price
				+ ", brand=" + brand + ", products=" + products + ", createdOn=" + createdOn + "]";
	}

}
