package com.mariusz.empexp.auth.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mariusz.empexp.auth.domain.TypZdarzen;

public interface ITypZdarzenDAO extends JpaRepository<TypZdarzen,Long> {

}
