package com.mariusz.empexp.auth.service;

import com.mariusz.empexp.auth.domain.Grupa;
import com.mariusz.empexp.dao.CRUD.ICRUDService;

public interface IGrupaService extends ICRUDService<Grupa, Integer>{

	public Grupa saveGrupa(Grupa grupa);
}
