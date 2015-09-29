package com.mariusz.empexp.auth.web.controller;


import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.mariusz.empexp.auth.domain.Uzytkownik;
import com.mariusz.empexp.auth.service.UzytkownikServiceImpl;
import com.mariusz.empexp.core.exception.ServiceException;


@ManagedBean(name="rejestracjaK")
@ViewScoped
public class UzytkownikController {

	private static final Logger logger=LoggerFactory.getLogger(UzytkownikController.class);
	
	@Autowired
	protected UzytkownikServiceImpl serwis;

	private Uzytkownik user=new Uzytkownik();
	private String powtorz_haslo;
	
	public String rejestrujAkcja()
	{
		try 
		{
		
			logger.debug("ferferferf");
			user.setLogin("user111");
			user.setHaslo("dfdfffd");
			user.setLiczaProbLogowania((short) 0);
			user.setStatus(false);
			user.setAktywne(true);
			user.setWaznoscKontaOd(new Date(0));
			user.setWaznoscKontaDo(new Date(0));
			serwis.create(user);
			
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return null;
	}
		
	 public boolean sprawdzhasla(){
		    if (!powtorz_haslo.equals(user.getHaslo())){
		       
		    	//JSFUtility.dodajOstrzezenie("rejestrujForm:repeathaslo", "hasła nie pasują", "");
		    return false;
		    }
		    return true;
		    
	  }
	
	
	

	public String getPowtorz_haslo() {
		return powtorz_haslo;
	}

	public void setPowtorz_haslo(String powtorz_haslo) {
		this.powtorz_haslo = powtorz_haslo;
	}

	public UzytkownikController() {
		super();
	}

	public UzytkownikServiceImpl getSerwis() {
		return serwis;
	}

	public void setSerwis(UzytkownikServiceImpl serwis) {
		this.serwis = serwis;
	}

	public Uzytkownik getUser() {
		return user;
	}

	public void setUser(Uzytkownik user) {
		this.user = user;
	}

	
	
}
