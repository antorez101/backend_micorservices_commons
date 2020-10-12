package com.course.commons.service;

import java.util.Optional;



public interface CommonsService<E> {
	
	public E save(E e);
	
	public Iterable<E> getAll();
	
	public Optional<E> findById(Long id);
	
	public E update(E e);
	
	public void delete(Long id);

}
