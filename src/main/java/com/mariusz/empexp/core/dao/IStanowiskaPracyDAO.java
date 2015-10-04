package com.mariusz.empexp.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mariusz.empexp.core.domain.StanowiskaPracy;

public interface IStanowiskaPracyDAO extends JpaRepository<StanowiskaPracy, Integer> {

}
