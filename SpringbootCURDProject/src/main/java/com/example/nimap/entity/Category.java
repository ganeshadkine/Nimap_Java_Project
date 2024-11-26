package com.example.nimap.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="category")
public class Category {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long C_id;
	
	private String C_name;
	
	
	 	@Transient
	    private long totalElements;

	 	@Transient
	    private long totalPages;
	 	
	 	 @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
		  private List<Product> products = new ArrayList<>();
	 	
	 	
	    public Category(long c_id, String c_name, long totalElements, long totalPages, List<Product> products) {
			super();
			C_id = c_id;
			C_name = c_name;
			this.totalElements = totalElements;
			this.totalPages = totalPages;
			this.products = products;
		}

		public long getTotalElements() {
			return totalElements;
		}

		public void setTotalElements(long totalElements) {
			this.totalElements = totalElements;
		}

		public long getTotalPages() {
			return totalPages;
		}

		public void setTotalPages(long totalPages) {
			this.totalPages = totalPages;
		}

		
	
	

	public long getC_id() {
		return C_id;
	}

	public void setC_id(long c_id) {
		C_id = c_id;
	}

	public String getC_name() {
		return C_name;
	}

	public void setC_name(String c_name) {
		C_name = c_name;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Category(long c_id, String c_name, List<Product> products) {
		super();
		C_id = c_id;
		C_name = c_name;
		this.products = products;
	}

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
