package com.mariusz.empexp.dao.CRUD;

import java.io.Serializable;


import com.mariusz.empexp.core.exception.ServiceException;


public interface ICRUDService<T,K extends Serializable> extends IReadService<T, K> {

	public T create(T object)throws ServiceException;
	public boolean delete(T object);
	public boolean deleteByID(K id);
	
}
