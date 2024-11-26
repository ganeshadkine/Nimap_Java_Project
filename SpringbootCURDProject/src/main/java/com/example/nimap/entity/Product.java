package com.example.nimap.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long P_id;
	
	
	private String P_name;
	
	
	private String P_price;
	
	 @ManyToOne    //Many Product table contain one Category so here Category is foregin key in product and bidirectional relationship 
	 @JoinColumn(name = "C_id")
	 private Category category;

	public long getP_id() {
		return P_id;
	}

	public void setP_id(long p_id) {
		P_id = p_id;
	}

	public String getP_name() {
		return P_name;
	}

	public void setP_name(String p_name) {
		P_name = p_name;
	}

	public String getP_price() {
		return P_price;
	}

	public void setP_price(String p_price) {
		P_price = p_price;
	}

	public Category getCategory_id() {
		return category;
	}

	public void setCategory_id(Category category_id) {
		this.category = category_id;
	}

	@Override
	public String toString() {
		return "Product [P_id=" + P_id + ", P_name=" + P_name + ", P_price=" + P_price + ", category_id=" + category
				+ "]";
	}

	public Product(long p_id, String p_name, String p_price, Category category_id) {
		super();
		P_id = p_id;
		P_name = p_name;
		P_price = p_price;
		this.category = category_id;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
