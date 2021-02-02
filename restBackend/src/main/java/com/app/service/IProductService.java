
package com.app.service;

import com.app.dto.ResponseDTO;
import com.app.pojos.Brand;
import com.app.pojos.Category;
import com.app.pojos.Product;

public interface IProductService {

	ResponseDTO getAllProducts();

	ResponseDTO getSingleProduct(Integer id);

	ResponseDTO getProductByBrand(Brand brand);

	ResponseDTO getProductByCategory(Category category);

	ResponseDTO createProduct(Product newProduct);

	ResponseDTO removeProduct(Integer Id);
	
	ResponseDTO updateProductDetails(Product updatableProduct);

}
