package com.mariusz.empexp.auth.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import com.mariusz.empexp.auth.domain.Grupa;


public interface IGrupaDAO extends JpaRepository<Grupa, Integer>{

}
