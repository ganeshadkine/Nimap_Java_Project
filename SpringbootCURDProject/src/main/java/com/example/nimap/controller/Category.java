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
import com.example.nimap.service.CategoryService;

@RestController
@RequestMapping("/api")
public class Category {
	@Autowired
	private CategoryService cs=null;
	
	
	//---------Getting Method-----------------------------------------//
	@GetMapping("/categories")
	
	public ResponseEntity<List<com.example.nimap.entity.Category>> getAllCategory() {
	    List<com.example.nimap.entity.Category> categories = cs.getAll();
	    
	    if (categories.isEmpty()) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	    }
	    
	    return ResponseEntity.ok(categories);
	}

	
	//------Getting Handler Method By Id with Id------------------------------//
	
	@GetMapping("/categories/{C_id}")
	public ResponseEntity<Category> getCategorybyId(@PathVariable("C_id") Long C_id){
			
		com.example.nimap.entity.Category ci;  // Creating The variable of category with absolute Path
		
		ci=this.cs.getCategoryById(C_id);  //getting the CategoryId with the helpp of cs object and store into the ci variable of Category
	
		//--Checking The Condition if ci is null then throw the status in the Postman
				if(ci==null) {
					
					return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
				}
			return ResponseEntity.status(HttpStatus.FOUND).build();	
	}

	
	//----------Add The Category handler Method ----------------------------------------//
	
	@PostMapping("/categories")
	public ResponseEntity<Category> addCategory(@RequestBody com.example.nimap.entity.Category c){
			
			try {
				c=this.cs.addCategory(c); //Calling Add Category Method With The Help of CategoryService Class Object
				
				System.out.println("New Category Is Added"+c);
				
				return ResponseEntity.status(HttpStatus.CREATED).build(); //Return The Status With Help of ResponseEntity
			}
			catch(Exception e) {
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
			}
		
		
	}
	
	//--------Update The Category Handler Method with Id--------------//
	
	@PutMapping("/categories/{C_id}")
	public ResponseEntity<Category>updateCategory(@RequestBody com.example.nimap.entity.Category ci1,@PathVariable("C_id")Long C_id){
		
			try {
				
				ci1=this.cs.updateCategory(ci1, C_id);  //Calling The UpdateCategory Function With the help of CategoryRepository Object
				
				return  ResponseEntity.status(HttpStatus.FOUND).build();  //Return The Status With Help of ResponseEntity
				
			}catch(Exception e) {
				
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build(); //Return The Status With Help of ResponseEntity
				
			}
			
		
	}
	
	//-----Delete The Category Handler Method with ID----------------------//
	
	@DeleteMapping("/categories/{C_id}")	
	public ResponseEntity<Category> delCategory(@PathVariable("C_id")Long C_id){
		
		try {
			this.cs.deleteCategory(C_id); //Calling deleteCategory function With the Help of CategoryService Object i.e cs
			
			return ResponseEntity.status(HttpStatus.GONE).build(); //Return The Status With Help of ResponseEntity
			
			}catch(Exception e) {
				
				e.printStackTrace();
					
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); //Return The Status With Help of ResponseEntity
			}
		
	}

}
