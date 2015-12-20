package com.mariusz.empexp.auth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import com.mariusz.empexp.auth.dao.IRolaDAO;
import com.mariusz.empexp.auth.domain.Rola;
import com.mariusz.empexp.core.exception.ServiceException;

@Transactional
public class RolaServicesImpl implements IRolaService{

	@Autowired
	private IRolaDAO dao;
	
	public void setDao(IRolaDAO dao) {
		this.dao = dao;
	}

	
	@Override
	public Rola create(Rola object) throws ServiceException {
		
		return null;
	}

	@Override
	public boolean delete(Rola object) {
		
		return false;
	}

	@Override
	public List<Rola> findAll() {
		
		return null;
	}

	@Override
	public Page<Rola> findAll(Pageable pageable) {
		
		return null;
	}


	@Override
	public boolean deleteByID(String id) {
		
		return false;
	}


	@Override
	public Rola findByID(String id) {
		
		return null;
	}

}
