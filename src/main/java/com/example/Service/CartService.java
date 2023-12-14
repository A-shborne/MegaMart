package com.example.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DTO.AccountDTO;
import com.example.DTO.ProductDTO;
import com.example.Entity.Account;
import com.example.Entity.Cart;
import com.example.Entity.CartItem;
import com.example.Entity.Product;
import com.example.Repository.CartItemRepository;
import com.example.Repository.CartRepositroy;
import com.example.Repository.ProductRepository;

@Service
public class CartService {
	
	@Autowired
	CartRepositroy cartRepositroy;
	
	@Autowired
	CartItemRepository cartItemRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	public void addToCart(Account account, ProductDTO dto,int quantity) {
		Cart cart= cartRepositroy.findByAccount(account.getName());
		List<CartItem> cartItems=cart.getCartItems();
		Integer index=doesExisit(cartItems, dto);
		if(index==-1) {
			Product product=productRepository.findByProductName(dto.getProductName());
			CartItem cartItem=new CartItem();
			cartItem.setProduct(product);
			cartItem.setQuantity(quantity);
			cartItem.setCartOfferPrice(product.getPrice());
			cartItem.setCart(cart);
			CartItem cartItem2=cartItemRepository.save(cartItem);
			cartItems.add(cartItem2);
		}else {
			CartItem cartItem=cartItems.get(index);
			cartItem.setQuantity(cartItem.getQuantity()+quantity);
			CartItem cartItem2=cartItemRepository.save(cartItem);
			cartItems.set(index, cartItem2);
		}
		cart.setCartItems(cartItems);
		cartRepositroy.save(cart);
	}
	
	public double totalAmount(Account account) {
		Cart cart= cartRepositroy.findByAccount(account.getName());
		double amount=0;
		for(CartItem cartItem: cart.getCartItems()) {
			amount=amount+(cartItem.getCartOfferPrice()*cartItem.getQuantity());
		}
		return amount;
	}
	
	public Integer doesExisit(List<CartItem> cartItems, ProductDTO dto) {
		for(int i=0;i<cartItems.size();i++) {
			CartItem cartItem=cartItems.get(i);
			if(cartItem.getProduct().getProductName().equals(dto.getProductName())) {
				return i;
			}
		}
		return -1;
	}
}
