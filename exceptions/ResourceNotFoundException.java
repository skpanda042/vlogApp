package com.suman.blogapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

		String resourceName;
		String fieldName;
		long fieldValue;
		
		public ResourceNotFoundException(String resourceName, String fieldName, long fieldValue){
			super(String.format("%s is not found with %s : %s", resourceName,fieldName,fieldValue));
				this.resourceName = resourceName;
				this.fieldName = fieldName;
				this.fieldValue = fieldValue;
		}
}
