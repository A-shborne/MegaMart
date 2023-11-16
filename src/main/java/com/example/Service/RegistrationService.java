package com.example.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DTO.AccountDTO;
import com.example.Entity.Account;
import com.example.Repository.AccountRepository;

@Service
public class RegistrationService {
	
	@Autowired
	private AccountRepository accountRepository;
	
	
	
	public String registerUser(AccountDTO accountDTO) {
		 Account account = new Account();
		 account.setName(accountDTO.getName());
		 account.setCnfPassword(accountDTO.getCnfPassword());
		 account.setEmail(accountDTO.getEmail());
		 account.setPassword(accountDTO.getPassword());
		 accountRepository.save(account);
		return "User have been registered..";
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
