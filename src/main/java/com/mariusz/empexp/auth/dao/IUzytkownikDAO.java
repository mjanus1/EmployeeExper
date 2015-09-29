package com.mariusz.empexp.auth.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mariusz.empexp.auth.domain.Uzytkownik;

@Repository
public interface IUzytkownikDAO extends JpaRepository<Uzytkownik, String> {
	
	

}
