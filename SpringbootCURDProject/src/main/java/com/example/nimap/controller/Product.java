package com.example.nimap.controller;

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
import org.springframework.web.bind.annotation.RestController;
import com.example.nimap.service.ProductService;

@RestController
@RequestMapping("/api")
public class Product {

	@Autowired
	private ProductService ps=null;
	
	//---------Getting Method-----------------------------------------//
	
		@GetMapping("/products")
		public ResponseEntity<List<com.example.nimap.entity.Product>> getAllCategory() 
		{
		    List<com.example.nimap.entity.Product> product = ps.getAllProduct();
		    
		    if (product.isEmpty()) {
		        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		    }
		    
		    return ResponseEntity.ok(product);
		}

		//------Getting Handler Method By Id with Id------------------------------//
		
		@GetMapping("/products/{P_id}")
		public ResponseEntity<Product> getProductbyId(@PathVariable("P_id") Long P_id){
				
			com.example.nimap.entity.Product Pi;  // Creating The variable of category with absolute Path
			
			Pi=this.ps.getProductById(P_id);  //getting the ProductId with the helpp of ps object and store into the pi variable of Product
		
			//--Checking The Condition if ci is null then throw the status in the Postman
					if(Pi==null) {
						
						return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
					}
				return ResponseEntity.status(HttpStatus.FOUND).build();	
		}
	
	
		//----------Add The Product handler Method ----------------------------------------//
		
		@PostMapping("/products")
		public ResponseEntity<Product> addProduct(@RequestBody com.example.nimap.entity.Product Pi){
				
				try {
					Pi=this.ps.addProduct(Pi); //Calling Add Product Method With The Help of ProductService Class Object
					
					System.out.println("New Product Is Added"+Pi);
					
					return ResponseEntity.status(HttpStatus.CREATED).build(); //Return The Status With Help of ResponseEntity
				}
				catch(Exception e) {
					e.printStackTrace();
					return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
				}
			
			
		}
		
		//--------Update The Product Handler Method with Id--------------//
		
		@PutMapping("/products/{P_id}")
		public ResponseEntity<Product>updateProduct(@RequestBody com.example.nimap.entity.Product Pi1,@PathVariable("P_id")Long P_id){
			
				try {
					
					Pi1=this.ps.updateProduct(Pi1, P_id);  //Calling The UpdateProduct Function With the help of ProductRepository Object
					
					return  ResponseEntity.status(HttpStatus.FOUND).build();  //Return The Status With Help of ResponseEntity
					
				}catch(Exception e) {
					
					e.printStackTrace();
					return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build(); //Return The Status With Help of ResponseEntity
					
				}
				
			
		}
		
		
		//-----Delete The Product Handler Method with ID----------------------//
		
		@DeleteMapping("/products/{P_id}")	
		public ResponseEntity<Category> delProduct(@PathVariable("P_id")Long P_id){
			
			try {
				this.ps.deleteProduct(P_id); //Calling deleteProduct function With the Help of ProductService Object i.e ps
				
				return ResponseEntity.status(HttpStatus.GONE).build(); //Return The Status With Help of ResponseEntity
				
				}catch(Exception e) {
					
					e.printStackTrace();
						
					return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); //Return The Status With Help of ResponseEntity
				}
			
		}
}
