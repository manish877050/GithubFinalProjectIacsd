package com.app.pojos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
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
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private Integer id;
	@Column(name = "firstName", length = 100)
	private String firstName;
	@Column(name = "lastName", length = 100)
	private String lastName;
	@Column(name = "address", length = 100)
	@Embedded
	private Address address;
	@Column(name="phone",length = 14)
	private String phone;
	@Column(name = "email", length = 100)
	private String email;
	@Column(name = "password", length = 100)
	private String password;
	@CreationTimestamp
	@Column(name = "createdOn", nullable = false, updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdOn;
	@Column(name = "active")
	private Integer active;

	public User() {
		System.out.println("Bean " + getClass().getName() + " Created...");
	}
}
