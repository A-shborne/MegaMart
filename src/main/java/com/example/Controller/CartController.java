package com.example.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DTO.ProductDTO;
import com.example.Entity.Account;
import com.example.Repository.AccountRepository;
import com.example.Service.CartService;
import com.example.Utility.Response;

@RestController
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@PostMapping("/add")
	public ResponseEntity<Response> addToCart(@RequestBody ProductDTO dto){
		
		Account account=accountRepository.getById("monster");
		
		cartService.addToCart(account, dto, 5);
		Response response=new Response();
		response.setMessage("Product added to the cart.....");
		
		return new ResponseEntity<Response>(response,HttpStatus.CREATED);
	}
	@GetMapping("/total")
	public ResponseEntity<Response> totalAmount(){
		Account account=accountRepository.getById("monster");
		double price=cartService.totalAmount(account);
		Response response=new Response();
		response.setMessage("Total Amount is "+price);
		return new ResponseEntity<Response>(response,HttpStatus.ACCEPTED);
	}
}
