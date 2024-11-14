package com.github.Arthurp11.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.Arthurp11.exceptions.ResourceNotFoundException;
import com.github.Arthurp11.model.Company;
import com.github.Arthurp11.repositories.CompanyRepository;

@Service
public class CompanyServices {
private Logger logger = Logger.getLogger(ColorServices.class.getName());
	
	@Autowired
	CompanyRepository repository;
	
	public List<Company> findAll() {
		logger.info("Finding all colors!");
		
		return repository.findAll();
	}
	
	public Company findById(Long id) {
		logger.info("Finding one color!");
		
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
	}
	
	public Company create(Company color) {
		logger.info("Creating one color!");
		
		return repository.save(color);
	}
	
	public Company update(Company color) {
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
