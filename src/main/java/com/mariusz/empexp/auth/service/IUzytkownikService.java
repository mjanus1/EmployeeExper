package com.mariusz.empexp.auth.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.mariusz.empexp.auth.domain.Uzytkownik;
import com.mariusz.empexp.dao.CRUD.ICRUDService;

public interface IUzytkownikService extends ICRUDService<Uzytkownik, String> {

	public Uzytkownik saveUzytkownik(Uzytkownik user);
	public Page<Uzytkownik> findAll(Specification<Uzytkownik> spec,Pageable peagable);
	
}
