package com.mariusz.empexp.auth.service;


import com.mariusz.empexp.auth.domain.Uzytkownik;
import com.mariusz.empexp.dao.CRUD.ICRUDService;

public interface IUzytkownikService extends ICRUDService<Uzytkownik, String> {

	public Uzytkownik saveUzytkownik(Uzytkownik user);
	
	
}
