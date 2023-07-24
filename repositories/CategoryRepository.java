package com.suman.blogapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suman.blogapp.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
