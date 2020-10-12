package com.course.commons.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;


public class CommonsServiceImpl<E, R extends CrudRepository<E, Long>> implements CommonsService<E>{
	
	@Autowired
	protected R repository;
	
	
	@Override
	public E save(E entity) {		
		return repository.save(entity);
	}

	@Override
	public Iterable<E> getAll() {		
		return repository.findAll();
	}

	@Override
	public Optional<E> findById(Long id) {
		
		return repository.findById(id);
	}

	@Override
	public E update(E entity) {
		
		return repository.save(entity);
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
		
	}


}
