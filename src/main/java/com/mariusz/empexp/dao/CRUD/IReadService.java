package com.mariusz.empexp.dao.CRUD;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public interface IReadService<T,K extends Serializable> {

	public T findByID(K id);
	public List<T> findAll();
	public Page<T> findAll(Pageable pageable);
}
