package com.app.service;

import com.app.dto.ResponseDTO;
import com.app.pojos.Category;

public interface ICategoryService {
	ResponseDTO getAllCategory();
	ResponseDTO createCategory(Category newCategory);
	ResponseDTO deleteCategory(Integer id);
}
