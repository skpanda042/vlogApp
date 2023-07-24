package com.suman.blogapp.payload;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class CategoryDto {

	private int categoryId;
	
	@NotBlank
	@Size(min = 4, message = "minimum size of title is 4")
	private String categoryTitle;
	
	@NotBlank
	@Size(min = 10, message = "minimum catagory of desc is 10")
	private String categoryDescription;
}
