package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.ResponseDTO;
import com.app.pojos.Category;
import com.app.repository.ICategoryRepository;

@Service
@Transactional
public class CategoryServiceImpl implements ICategoryService {
	@Autowired
	ICategoryRepository repository;

	@Override
	public ResponseDTO getAllCategory() {
		return new ResponseDTO("success", "All Categoryies", repository.findAll());
	}

	@Override
	public ResponseDTO createCategory(Category newCategory) {
		try {
			repository.save(newCategory);
		} catch (Exception exp) {
			return new ResponseDTO("error", "Failed to Created", exp);
		}
		return new ResponseDTO("success", "New Category Created", newCategory);
	}

	@Override
	public ResponseDTO deleteCategory(Integer id) {
		Category category = repository.getOne(id);
		repository.delete(category);
		return new ResponseDTO("success", "category deleted successfully");
	}

}
