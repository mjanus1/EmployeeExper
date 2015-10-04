package com.mariusz.empexp.dao.CRUD;

import java.io.Serializable;
import java.util.List;

public interface IReadService<T,K extends Serializable> {

	public T findByID(K id);
	public List<T> findAll();
}
