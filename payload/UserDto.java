package com.suman.blogapp.payload;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class UserDto {
	
	private int id;
	
	@NotEmpty
	@Size(min = 4, message = "name must be minimum of 4 charecter")
	private String name;
	
	@Email(message = "Email Address is not valid...!!")
	private String email;

	@NotEmpty
	@Size(min = 8, max = 15, message = "password must be within 8 to 15 charecter")
	private String password;
	
	@NotNull
	private String about;
}
