package com.mariusz.empexp.auth.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mariusz.empexp.auth.dao.IUzytkownikDAO;
import com.mariusz.empexp.auth.domain.Uzytkownik;
import com.mariusz.empexp.core.exception.ServiceException;

@Service("IUzytkownikService")
@Transactional  //<D extends ICRUDDAO>
public class UzytkownikServiceImpl implements IUzytkownikService{

	private static final Logger logger=LoggerFactory.getLogger(UzytkownikServiceImpl.class);
	
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
		logger.debug("Start deleteByID(login={})",login);
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
		logger.debug("findAll()");
		return dao.findAll();
	}
	
	@Override
	public Page<Uzytkownik> findAll(Pageable pageable) {
		return dao.findAll(pageable);
	}


	@Override
	public Page<Uzytkownik> findAll(Specification<Uzytkownik> spec,Pageable peagable) {
	
		return dao.findAll(spec, peagable);
	}


	@Override
	public Uzytkownik saveUzytkownik(Uzytkownik user) {	
		return dao.save(user);
	}

	
	public void setDao(IUzytkownikDAO dao) {
		this.dao = dao;
	}

	public IUzytkownikDAO getDao() {
		return dao;
	}


	
	
}
