package com.mariusz.empexp.auth.service;

import com.mariusz.empexp.auth.domain.Grupa;

public interface IGrupaService extends ICRUDService<Grupa, Integer>{

	public Grupa saveGrupa(Grupa grupa);
	public Grupa findGrupaById(Integer id);
}
