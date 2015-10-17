package com.mariusz.empexp.auth.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mariusz.empexp.auth.dao.IUzytkownikDAO;
import com.mariusz.empexp.auth.domain.Uzytkownik;
import com.mariusz.empexp.core.exception.ServiceException;

@Service("IUzytkownikService")
@Transactional
public class UzytkownikServiceImpl implements IUzytkownikService{

	@Autowired
	protected IUzytkownikDAO dao;
	
	
	@Override
	public Uzytkownik create(Uzytkownik user) throws ServiceException {
		
		if(dao.exists(user.getLogin())==false){
			dao.save(user);
		}
			else{
				throw new ServiceException("errorUserExist");
			}
		
		 return null;
	}

	@Override
	public boolean delete(Uzytkownik user) {
		dao.delete(user);
		return false;
	}

	//@Transactional
	@Override
	public boolean deleteByID(String login) {
		dao.delete(login);
		return false;
	}
	

	@Transactional(readOnly=true)
	@Override
	public Uzytkownik findByID(String login) {
		return dao.findOne(login);
	}

	@Transactional(readOnly=true)
	@Override
	public List<Uzytkownik> findAll() {
		return dao.findAll();
	}

	@Override
	public Uzytkownik saveUzytkownik(Uzytkownik user) {	
		return dao.save(user);
	}

	
	public void setDao(IUzytkownikDAO dao) {
		this.dao = dao;
	}

	
	
	
	
}
