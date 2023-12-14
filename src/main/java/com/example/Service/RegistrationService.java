package com.example.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DTO.AccountDTO;
import com.example.Entity.Account;
import com.example.Entity.Cart;
import com.example.Entity.CartItem;
import com.example.Repository.AccountRepository;
import com.example.Repository.CartRepositroy;
@Service
public class RegistrationService {
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private CartRepositroy cartRepositroy;
	
	
	
	public String registerUser(AccountDTO accountDTO) {
		 Account account = new Account();
		 account.setName(accountDTO.getName());
		 account.setCnfPassword(accountDTO.getCnfPassword());
		 account.setEmail(accountDTO.getEmail());
		 account.setPassword(accountDTO.getPassword());
		 Account account2=accountRepository.save(account);
		 createCart(account2);
		return "User have been registered..";
	}
	
	private void createCart(Account account) {
		
		Cart cart=new Cart();
		cart.setAccount(account);
		List<CartItem> list=new ArrayList<CartItem>();
		cart.setCartItems(list);
		cartRepositroy.save(cart);
		
	}
	
	public Boolean doEmailexsist(String email) {
		Optional<Account> account = accountRepository.findAccountByEmail(email);
		if(account.isPresent()) {
			return true;
		}else {
			return false;
		}
	}

}
