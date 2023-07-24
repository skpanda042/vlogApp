package com.suman.blogapp.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.suman.blogapp.config.AppConstants;
import com.suman.blogapp.payload.ApiResponse;
import com.suman.blogapp.payload.PostDto;
import com.suman.blogapp.payload.PostResponse;
import com.suman.blogapp.services.PostService;

@RestController
@RequestMapping("/api")
public class PostController {
	
	@Autowired 
	private PostService postService; 

	@PostMapping("/user/{userId}/category/{categoryId}/posts")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto, @PathVariable Integer userId, @PathVariable Integer categoryId){
		PostDto dto = postService.createPost(postDto, userId, categoryId);
		return new ResponseEntity<PostDto>(dto, HttpStatus.CREATED);
	}
	
	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable Integer userId){
		List<PostDto> p1 = this.postService.getPostByUser(userId);
		return new ResponseEntity<List<PostDto>>(p1, HttpStatus.OK);
	}
	
	@GetMapping("/category/{categoryId}/posts")
	public ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable Integer categoryId){
		List<PostDto> p2 = this.postService.getPostByCategory(categoryId);
		return new ResponseEntity<List<PostDto>>(p2, HttpStatus.OK);
	}
	
	@GetMapping("/posts")
	public ResponseEntity<PostResponse> getAllPost(
			@RequestParam(value = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false)Integer pageSize,
			@RequestParam(value="sortBy", defaultValue= AppConstants.SORT_BY, required=false) String sortBy,
			@RequestParam(value="sortDir", defaultValue= AppConstants.SORT_DIR, required=false)String sortDir)
	{
		PostResponse postResponse = this.postService.getAllPosts(pageNumber, pageSize, sortBy, sortDir);
		return new ResponseEntity<PostResponse>(postResponse, HttpStatus.OK);
	}
	
	@GetMapping("/post/{postId}")
	public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId){
		return ResponseEntity.ok(this.postService.getPostById(postId));
	}
	
	@DeleteMapping("/post/{postId}")
	public ApiResponse deleteById(@PathVariable Integer postId){
		postService.deleteById(postId);
		return new ApiResponse ("post Deleted successfully", true);
	}
	
	@PutMapping("/post/{postId}")
	public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable Integer postId){
		PostDto updatedPost = postService.updatePost(postDto, postId);
		return new ResponseEntity<PostDto> (updatedPost, HttpStatus.OK);
	}
	
	@GetMapping("/posts/search/{keywords}")
	public ResponseEntity<List<PostDto>> searchPostByTitle(@PathVariable ("keywords") String keywords){
		List<PostDto> result = postService.searchPosts(keywords);
		return new ResponseEntity<List<PostDto>> (result, HttpStatus.OK);
	}
}
