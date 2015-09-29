package com.mariusz.empexp.auth.service;


import com.mariusz.empexp.auth.domain.Uzytkownik;

public interface IUzytkownikService extends ICRUDService<Uzytkownik, String> {

	public Uzytkownik saveUzytkownik(Uzytkownik user);
	public boolean existsUzytkownik(String login);
	
	
}
