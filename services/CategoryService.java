package com.suman.blogapp.services;

import java.util.List;

import com.suman.blogapp.payload.CategoryDto;

public interface CategoryService {

	CategoryDto createCategory(CategoryDto categoryDto);
	
	CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);
	
	CategoryDto getCategory(Integer categoryDto);
	
	List<CategoryDto> getCategories();
	
	void deleteCategory(Integer categoryDto);
}
