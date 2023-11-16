package com.example.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DTO.LoginDTO;
import com.example.Entity.Account;
import com.example.Repository.AccountRepository;

@Service
public class LoginService {
	
	@Autowired
	private AccountRepository accountRepository;
	
	public Boolean validateUser(LoginDTO dto) {
		Optional<Account> acc= accountRepository.findById(dto.getName());
		if (acc.isPresent()) {
			if(dto.getPassword().equals(acc.get().getPassword())) {
				return true;
			}
		}
		return false;
	}

}
