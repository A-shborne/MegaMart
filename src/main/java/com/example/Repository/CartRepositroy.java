package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entity.Cart;

public interface CartRepositroy extends JpaRepository<Cart, Long> {

}
