package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Brand;
import com.app.pojos.Category;
import com.app.pojos.Product;

public interface IProductRepository extends JpaRepository<Product, Integer> {
	Product findByTitle(String title);

	List<Product> findByCategory(Category category);

	List<Product> findByBrand(Brand brand);

}
