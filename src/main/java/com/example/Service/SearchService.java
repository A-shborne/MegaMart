package com.example.Service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.DTO.ProductDTO;
import com.example.Entity.Product;
import com.example.Repository.ProductRepository;

@Service
public class SearchService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public List<ProductDTO> searchUser(){
		List<Product> list= productRepository.findAll();
		List<ProductDTO> data= new LinkedList<ProductDTO>();
		for (Product p:list) {
			
		}
		return null;
	}

}
