package com.github.Arthurp11;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.Arthurp11.model.Color;
import com.github.Arthurp11.services.ColorServices;

@RestController
@RequestMapping("/api/color/v1")
public class ColorController {
	
	@Autowired
	ColorServices service;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Color> findAll() {
		return service.findAll();
	}
	
	@GetMapping(value = "/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Color findById(@PathVariable(value = "id") Long id) {
		return service.findById(id);	
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Color create(@RequestBody Color color) {
		return service.create(color);
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Color update(@RequestBody Color color) {
		return service.update(color);
	}
	
	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable(value = "id") Long id) {
		service.delete(id);
	}
}
