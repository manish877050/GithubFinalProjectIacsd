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

import lombok.Data;

@Data
@Entity
@Table(name="userOrder")
public class UserOrder {
	@Id
	@Column(name = "userOrder_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id ;  
	@Column(name = "userId")
	private Integer userId ;   
	@Column(name = "totalAmount")
	private Double totalAmount;
	@Column(name = "tax")
	private Integer tax;   
	@Column(name = "paymentStatus",length=50)
	private String paymentStatus ; 
	@Column(name = "paymentType",length=50)
	private String paymentType;    
	@Column(name = "deliveryStatus",length=50)
	private String deliveryStatus; 
	@CreationTimestamp
	@Column(name = "createdOn", nullable = false, updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdOn;
	
	public UserOrder() {
		System.out.println("Bean "+getClass().getName()+" Created...");
	}

}



