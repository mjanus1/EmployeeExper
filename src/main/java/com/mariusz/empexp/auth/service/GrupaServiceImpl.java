package com.mariusz.empexp.auth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mariusz.empexp.auth.dao.IGrupaDAO;
import com.mariusz.empexp.auth.domain.Grupa;
/*
@Component("idGrupa")//podstawowe dodanie klasy do kontenera sprng
@Scope(scopeName="singleton")//okreslenie zasiegu
*/
@Service("IGrupaService")//stereotyp dla klas serwisu
//@Repository("id dao") - stereotyp dla klas DAO(jka nie uzywamy Sping JPA Data), dodatkowa cecha wszytskie wyjatki niewyryfikowalne opakowuje w DataAccessException
@Transactional //wszytskie metody maja byc wykonywane w ramach transakcji
public class GrupaServiceImpl implements IGrupaService {

	@Autowired
	//@Qualifier("idElemenut dao") - wskazuje ktory komponent ma byc wstrzykniety
	private IGrupaDAO dao;
	//rollbackFor=Exception.class - oznacza wycofanie wszytskich zmian na bazie danych jesli wystapi jakikolwiek wyjatek klasy Exception
	//@Transactional(rollbackFor=Exception.class)//wskazanie ze ta metoda jest wykonywana w ramach transakcji
	@Transactional
	@Override
	public Grupa saveGrupa(Grupa grupa) {
		
		return dao.save(grupa);
	}

	@Transactional(readOnly=true)//przy operacjahc tylko odczytujacyh baze danych to read-onyly=true
	@Override
	public Grupa findGrupaById(Integer id) {
		
		return dao.findOne(id);
	}
	
	//Spring wymaga setDao aby wstrzyknac obiekt dao
	public void setDao(IGrupaDAO dao) {
		this.dao = dao;
	}

	@Override
	public Grupa create(Grupa object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Grupa object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteByID(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public Grupa findByID(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Grupa> findAll() {
		// TODO Auto-generated method stub
		return null;
	}


	

}
