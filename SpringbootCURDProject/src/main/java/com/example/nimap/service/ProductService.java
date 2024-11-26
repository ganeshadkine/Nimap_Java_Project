package com.example.nimap.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.nimap.dao.ProductInterface;
import com.example.nimap.entity.Category;
import com.example.nimap.entity.Product;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductService {
	
	@Autowired	
	private ProductInterface Pi;
	
	//-----get All Product--------------------------------------//
	public List<Product>getAllProduct(){
		
			
		List<Product>Pi1=(List<Product>)this.Pi.findAll();
		
		return Pi1;
	}
	
	//----Get The Product By Id-----------------------//
	public Product getProductById(Long P_id) {
		
			return this.Pi.findById(P_id).orElseThrow(() -> new EntityNotFoundException("Category not found with id: " + P_id));
		
	}
	
	
	//-------Add The Product-----------------------------//
	
	public Product addProduct(Product p) {
		
			return this.Pi.save(p);
	}
	
	
	//-------Update The Product By Id-------------------//
	
	public Product updateProduct(Product p,Long P_id) {
		
		p.setP_id(P_id);  //---if id of product in product table is diff and given user id is diff then first set the Product id and then update it with save function
		
		return this.Pi.save(p);
		
	}
	
	//-------delete the Product By Id-----------------//
	
	public void deleteProduct(Long P_id) {
		
		this.Pi.deleteById(P_id);  //---Deleting the id with the help off Pi.inbuild deleteId function
		
	}
	
	//----------Exxtra Method------------------------//
	//public Category getCategoryByProductId(Long productId) {
    //    return Pi.findById(productId).map(Product::getCategory).orElse(null);
    //}

}
