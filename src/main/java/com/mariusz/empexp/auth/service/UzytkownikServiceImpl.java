package com.mariusz.empexp.auth.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mariusz.empexp.auth.dao.IUzytkownikDAO;
import com.mariusz.empexp.auth.domain.Uzytkownik;
import com.mariusz.empexp.core.exception.ServiceException;

@Service("IUzytkownikService")
public class UzytkownikServiceImpl implements IUzytkownikService{

	@Autowired
	protected IUzytkownikDAO dao;
	
	@Transactional
	@Override
	public Uzytkownik create(Uzytkownik user) throws ServiceException {
		
		 return dao.save(user);
	}

	@Override
	public boolean delete(Uzytkownik user) {
		dao.delete(user);
		return false;
	}

	@Override
	public boolean deleteByID(String login) {
		dao.delete(login);
		return false;
	}

	@Override
	public Uzytkownik findByID(String login) {
		return dao.findOne(login);
	}

	@Override
	public List<Uzytkownik> findAll() {
		return dao.findAll();
	}

	@Override
	public Uzytkownik saveUzytkownik(Uzytkownik user) {	
		return dao.save(user);
	}

	@Override
	public boolean existsUzytkownik(String login) {
		dao.exists(login);
		return false;
	}	
	
	public void setDao(IUzytkownikDAO dao) {
		this.dao = dao;
	}

	
	
	
}
