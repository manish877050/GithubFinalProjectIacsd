package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Category;

public interface ICategoryRepository extends JpaRepository<Category,Integer> {
	
	Category findByTitle(String title);
}
