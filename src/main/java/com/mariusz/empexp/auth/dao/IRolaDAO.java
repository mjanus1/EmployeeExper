package com.mariusz.empexp.auth.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mariusz.empexp.auth.domain.Rola;

public interface IRolaDAO extends JpaRepository<Rola,String>  {

}
