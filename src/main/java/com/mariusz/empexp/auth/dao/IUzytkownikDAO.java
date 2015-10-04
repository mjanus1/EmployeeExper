package com.mariusz.empexp.auth.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import com.mariusz.empexp.auth.domain.Uzytkownik;


public interface IUzytkownikDAO extends JpaRepository<Uzytkownik, String> {
	


}
