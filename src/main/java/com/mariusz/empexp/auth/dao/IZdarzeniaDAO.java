package com.mariusz.empexp.auth.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mariusz.empexp.auth.domain.Zdarzenia;

public interface IZdarzeniaDAO extends JpaRepository<Zdarzenia,Long> {

}
