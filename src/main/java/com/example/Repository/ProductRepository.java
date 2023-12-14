package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.Entity.Product;

public interface ProductRepository extends JpaRepository<Product, String>{
	@Query(value = "select * from product p where p.product_name= ?1", nativeQuery = true)
	public Product findByProductName(String productName);

}
