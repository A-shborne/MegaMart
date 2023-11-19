package com.example.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Service.SearchService;
import com.example.Utility.Response;

@RestController
@RequestMapping("/search")
public class SearchController {
	
	@Autowired
	private SearchService searchService;
	
	@GetMapping("/products")
	public ResponseEntity<Response> searchData(){
		Response response=new Response();
		
		response.setProductDTOs(searchService.searchProduct());
		
		return new ResponseEntity<Response>(response,HttpStatus.ACCEPTED);
	}

}
