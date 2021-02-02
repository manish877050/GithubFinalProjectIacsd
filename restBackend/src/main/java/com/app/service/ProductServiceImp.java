package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.ResponseDTO;
import com.app.pojos.Brand;
import com.app.pojos.Category;
import com.app.pojos.Product;
import com.app.repository.IProductRepository;

@Service
@Transactional
public class ProductServiceImp implements IProductService {
	@Autowired
	IProductRepository repository;

	@Override
	public ResponseDTO getAllProducts() {

		return new ResponseDTO("success", "All products", repository.findAll());
	}

	@Override
	public ResponseDTO getSingleProduct(Integer id) {
		
		return new ResponseDTO("success","Product Found",repository.getOne(id));
	}

	@Override
	public ResponseDTO getProductByBrand(Brand brand) {
		 
		return new ResponseDTO("success","All product of specific brand",repository.findByBrand(brand));
	}

	@Override
	public ResponseDTO getProductByCategory(Category category) {
		
		return new ResponseDTO("success","All product of specific category",repository.findByCategory(category));
	}

	@Override
	public ResponseDTO createProduct(Product newProduct) {
		repository.save(newProduct);
		newProduct.getBrand();
		return new ResponseDTO("success","Product Added Successfully",newProduct);
	}

	@Override
	public ResponseDTO removeProduct(Integer Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseDTO updateProductDetails(Product updatableProduct) {
		// TODO Auto-generated method stub
		return null;
	}

}
