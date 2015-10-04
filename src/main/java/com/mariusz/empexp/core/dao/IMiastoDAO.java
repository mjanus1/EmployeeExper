package com.mariusz.empexp.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mariusz.empexp.core.domain.Miasto;

public interface IMiastoDAO extends JpaRepository<Miasto, Integer> {

}
