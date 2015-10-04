package com.mariusz.empexp.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mariusz.empexp.core.domain.Firma;

public interface IFirmaDAO extends JpaRepository<Firma,Short>{

}
