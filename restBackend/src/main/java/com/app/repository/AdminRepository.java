package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
	 Admin findByEmail(String email);

	Admin findByPhone(String number);

	Admin findByFirstName(String name);
	
	 

}
