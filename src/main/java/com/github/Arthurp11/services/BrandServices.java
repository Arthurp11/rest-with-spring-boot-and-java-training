package com.github.Arthurp11.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.Arthurp11.exceptions.ResourceNotFoundException;
import com.github.Arthurp11.model.Brand;
import com.github.Arthurp11.repositories.BrandRepository;

@Service
public class BrandServices {

	private Logger logger = Logger.getLogger(ColorServices.class.getName());
	
	@Autowired
	BrandRepository repository;
	
	public List<Brand> findAll() {
		logger.info("Finding all colors!");
		
		return repository.findAll();
	}
	
	public Brand findById(Long id) {
		logger.info("Finding one color!");
		
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
	}
	
	public Brand create(Brand color) {
		logger.info("Creating one color!");
		
		return repository.save(color);
	}
	
	public Brand update(Brand color) {
		logger.info("Updating one color!");
		
		var entity = repository.findById(
				color.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		
		entity.setName(color.getName());
		
		return repository.save(color);
	}
	
	public void delete(Long id) {
		logger.info("Deleting one color!");
		
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		
		repository.delete(entity);
	}
}
