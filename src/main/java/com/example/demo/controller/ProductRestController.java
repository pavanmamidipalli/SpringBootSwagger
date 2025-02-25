package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.repo.ProductRepository;

@RestController
public class ProductRestController {
	
	@Autowired
	ProductRepository repository;
	
	
	@RequestMapping(value="/products/",method=RequestMethod.GET)
	public List<Product> getProducts()
	{
		return repository.findAll();
	}
	@RequestMapping(value="/products/{id}",method=RequestMethod.GET)
	public Product getProduct(@PathVariable("id") int id)
	{
		//LOGGER.info("Finding product by ID:"+id);
		return repository.findById(id).get();
	}
	@RequestMapping(value="/products/",method=RequestMethod.POST)
	public Product createProduct(@RequestBody Product product)
	{
		return repository.save(product);
	}
	
	@RequestMapping(value="/products/",method=RequestMethod.PUT)
	public Product updateProduct(@RequestBody Product product)
	{
		return repository.save(product);
	}
	@RequestMapping(value="/products/{id}",method=RequestMethod.DELETE)
	public void deleteProduct(@PathVariable("id") int id)
	{
		 repository.deleteById(id);
	}
}
