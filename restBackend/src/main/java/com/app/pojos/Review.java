package com.app.pojos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "review")
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "review_id")
	private Integer id;
	@Column(name = "review", length = 100)
	private String review;
	@Column(name = "userId")
	private Integer userId;
	@Column(name = "productId")
	private Integer productId;
	@Column(name = "rating")
	private Integer rating;
	@CreationTimestamp
	@Column(name="createdOn" ,nullable = false, updatable = false)
	@DateTimeFormat(pattern="yyyy-MM-dd") 
	private Date createdOn;
	
	public Review() {
		System.out.println("Bean "+getClass().getName()+" Created...");
	}
}