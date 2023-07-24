package com.suman.blogapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suman.blogapp.payload.ApiResponse;
import com.suman.blogapp.payload.UserDto;
import com.suman.blogapp.services.UserService;

@RestController
@RequestMapping("api/user")
public class UserController {

		@Autowired
		private UserService userService;
		
		@PostMapping("/createUser")
		public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
			UserDto dto = this.userService.createUser(userDto);
			return new ResponseEntity<>(dto, HttpStatus.CREATED);
		}
		
		@PutMapping("/{userId}")
		public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable Integer userId){
			UserDto updateUser = this.userService.updateUser(userDto, userId);
			return ResponseEntity.ok(updateUser);
		}
		
		@DeleteMapping("/{userId}")
		public ResponseEntity<ApiResponse> deleteUser(@PathVariable ("userId") Integer uid){
			this.userService.deleteUser(uid);
			return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted successfully", true), HttpStatus.OK);	
		}
		
		@GetMapping()
		public ResponseEntity<List<UserDto>> getAllUser(){
			return ResponseEntity.ok(this.userService.getAllUsers());
		}
		
		@GetMapping("/{userId}")
		public ResponseEntity<UserDto> getSingleUser(@PathVariable Integer userId){
			return ResponseEntity.ok(this.userService.getUserById(userId));
			
		}
}



























