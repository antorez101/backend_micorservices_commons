package com.course.commons.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.course.commons.service.CommonsService;

public class CommonsController<E, S extends CommonsService<E>> {
	
	@Autowired
	protected S service;

	

	@GetMapping
	public ResponseEntity<Iterable<E>> getAll(){
		
		Iterable<E> entities = service.getAll();
		
		return new ResponseEntity<Iterable<E>>(entities, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<E> getById(@PathVariable Long id){
		Optional<E> entity = service.findById(id);
		if (entity.isPresent()) {
			return new ResponseEntity<E>(entity.get(), HttpStatus.OK);
		}
		return new ResponseEntity<E>(HttpStatus.NOT_FOUND);
	}
	
	
	@SuppressWarnings("deprecation")
	@PostMapping
	public ResponseEntity<E> save(@RequestBody E entity){
		
		service.save(entity);
		
		if (Optional.ofNullable(entity).isPresent()) {
			return new ResponseEntity<E>(entity, HttpStatus.CREATED);
		}
		return new ResponseEntity<E>(HttpStatus.METHOD_FAILURE);
	}
	
	@PutMapping
	public ResponseEntity<E> update(@RequestBody E entity){
		
		E entityUpdated = service.update(entity);
		
		if (null != entityUpdated) {
			return new ResponseEntity<E>(entityUpdated, HttpStatus.CREATED);
		}
		return new ResponseEntity<E>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(Long id){
		service.delete(id);
		return new ResponseEntity<E>(HttpStatus.NO_CONTENT);
	}
	
	

}
