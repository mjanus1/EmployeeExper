package com.mariusz.empexp.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mariusz.empexp.core.domain.Zatrudnienie;

public interface IZatrudnienieDAO extends JpaRepository<Zatrudnienie, Short> {

}
