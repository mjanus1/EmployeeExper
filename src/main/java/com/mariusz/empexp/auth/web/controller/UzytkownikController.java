package com.mariusz.empexp.auth.web.controller;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mariusz.empexp.auth.domain.Uzytkownik;
import com.mariusz.empexp.auth.service.IUzytkownikService;
import com.mariusz.empexp.core.exception.ServiceException;


@ManagedBean(name="rejestracjaK")
@ViewScoped

public class UzytkownikController {

	private static final Logger logger=LoggerFactory.getLogger(UzytkownikController.class);
	
	@ManagedProperty(value="#{IUzytkownikService}")
	protected IUzytkownikService serwis;
	
	
	
	private Uzytkownik user=new Uzytkownik();
	private String powtorz_haslo;
	
	public String rejestrujAkcja() throws ServiceException
	{
		
		logger.debug("ferferferf");
		logger.debug("login: "+user.getLogin());
		serwis.create(user);
		logger.debug("login: "+user.getLogin());
	
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



	public void setSerwis(IUzytkownikService serwis) {
		this.serwis = serwis;
	}

	public Uzytkownik getUser() {
		return user;
	}

	public void setUser(Uzytkownik user) {
		this.user = user;
	}

	
	
}
