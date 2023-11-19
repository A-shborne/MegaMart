package com.example.Service;

import java.util.LinkedList;
import java.util.List;

import org.modelmapper.ModelMapper;
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
	
	@Autowired
	private ModelMapper mapper;
	
	public List<ProductDTO> searchProduct(){
		List<Product> list= productRepository.findAll();
		List<ProductDTO> data= new LinkedList<ProductDTO>();
		for (Product p:list) {
			ProductDTO dto=convertToDTO(p);
			data.add(dto);
		}
		return data;
	}
	
	private ProductDTO convertToDTO(Product product) {
		ProductDTO dto= mapper.map(product, ProductDTO.class);
		return dto;
	}

}
