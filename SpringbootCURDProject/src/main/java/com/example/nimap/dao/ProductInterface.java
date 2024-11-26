package com.example.nimap.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.nimap.entity.Product;

public interface ProductInterface extends CrudRepository<Product,Long>, JpaRepository<Product,Long>{

}
