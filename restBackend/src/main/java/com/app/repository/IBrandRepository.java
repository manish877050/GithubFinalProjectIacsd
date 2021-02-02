package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Brand;

public interface IBrandRepository extends JpaRepository<Brand, Integer> {
	Brand findByTitle(String title);
}
