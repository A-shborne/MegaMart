package com.example.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Entity.Account;

//@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
	
	@Query(value = "select * from account a where email= ?1",nativeQuery = true)
	Optional<Account> findAccountByEmail(String email);

} 
