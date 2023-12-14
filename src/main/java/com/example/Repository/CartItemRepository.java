package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entity.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

}
