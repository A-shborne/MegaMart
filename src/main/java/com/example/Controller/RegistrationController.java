package com.example.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DTO.AccountDTO;
import com.example.Service.RegistrationService;
import com.example.Utility.Error;
import com.example.Utility.Response;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/registration")
public class RegistrationController {
	
	@Autowired
	private RegistrationService registrationService;
	
	@PostMapping("/register")
	public ResponseEntity<Response> registerUser(@RequestBody @Valid AccountDTO accountDTO){
		Response response= new Response();
		if(registrationService.doEmailexsist(accountDTO.getEmail())) {
			Error error= new Error();
			error.setMessage("Email Id was already used");
			error.setCode(01);
			response.setError(error);
			return new ResponseEntity<Response>(response,HttpStatus.BAD_REQUEST);
		}
		
		response.setMessage(registrationService.registerUser(accountDTO));
		
		return new ResponseEntity<Response>(response,HttpStatus.ACCEPTED);
	}

}
