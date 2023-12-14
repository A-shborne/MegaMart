package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.Entity.Account;
import com.example.Entity.Cart;

public interface CartRepositroy extends JpaRepository<Cart, Long> {
	
	@Query(value = "select * from cart c where c.name = ?1  ", nativeQuery = true)
	public Cart findByAccount(String name); 
}
