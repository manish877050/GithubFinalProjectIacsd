package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.ResponseDTO;
import com.app.pojos.Brand;
import com.app.repository.IBrandRepository;

@Service
@Transactional
public class BrandServiceImpl implements IBrandService {
	@Autowired
	IBrandRepository repository;
	
	
	@Override
	public ResponseDTO addBrand(Brand newBrand) {
		return new ResponseDTO("success", "Brand Added successfully",repository.save(newBrand));
	}

	@Override
	public ResponseDTO getAllBrands() {
		 
		return new ResponseDTO("success", "All Brands",repository.findAll());
	}

	@Override
	public ResponseDTO updateBrandDetail(Brand brand) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseDTO deleteBrand(int id) {
		Brand deletableBrand = repository.getOne(id);
		repository.delete(deletableBrand);
		return new ResponseDTO("success", "Brand Deleted successfully");
		
	}

}
