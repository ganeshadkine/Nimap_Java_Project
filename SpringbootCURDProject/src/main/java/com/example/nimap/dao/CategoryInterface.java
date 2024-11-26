package com.example.nimap.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import com.example.nimap.entity.Category;

public interface CategoryInterface extends CrudRepository<Category, Long>,JpaRepository<Category,Long>{

}
