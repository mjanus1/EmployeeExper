package com.mariusz.empexp.auth.dao;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.mariusz.empexp.auth.domain.Uzytkownik;


public interface IUzytkownikDAO extends JpaRepository<Uzytkownik, String>,JpaSpecificationExecutor<Uzytkownik>{
	
	public Page<Uzytkownik> findAll(Specification<Uzytkownik> spec,Pageable peagable);
}
