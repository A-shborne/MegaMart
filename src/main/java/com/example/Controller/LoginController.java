package com.example.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DTO.LoginDTO;
import com.example.Service.LoginService;
import com.example.Utility.Error;
import com.example.Utility.Response;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@PostMapping("/user")
	public ResponseEntity<Response> loginUser(@RequestBody @Valid LoginDTO dto){
		Response response= new Response();
		ResponseEntity<Response> entity = null;
		if(loginService.validateUser(dto)) {
			response.setMessage("User logged in successfully....");
			entity= new ResponseEntity<Response>(response,HttpStatus.ACCEPTED);
		}else {
			Error error= new Error();
			error.setMessage("Invalid User...");
			error.setCode(02);	
			response.setError(error);
			entity= new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

}
