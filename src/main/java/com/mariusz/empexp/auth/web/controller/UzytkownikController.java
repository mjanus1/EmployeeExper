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


public class UzytkownikController extends AbstractController {

	private static final Logger logger=LoggerFactory.getLogger(UzytkownikController.class);
	
	@ManagedProperty(value="#{IUzytkownikService}")
	protected IUzytkownikService serwis;
	
	private Uzytkownik user=new Uzytkownik();
	private String powtorz_haslo;
	

	
	public String rejestrujAkcja() throws ServiceException
	{
		try
		{
			return rejestruj();		
		}
		catch(ServiceException e )
		{
			handleException(e);
			logger.debug(""+e.getErrorCode());
		}
		return null;
		
	}
	

	
	
	public String rejestruj() throws ServiceException
	{
		if(sprawdzhasla()==true)
		{
			serwis.create(user);
			dodajWiadomoscGlobalna("Dodano nowego użytkownika", "");
			logger.debug("Dodano nowego uzytkownika");
		}
		else
		{
			dodajBlad("rejestrujForm:repeathaslo", "Hasła muszą być identyczne.", "");
		}
				
		return null;
	}
		

	public boolean sprawdzhasla(){
		    if (!powtorz_haslo.equals(user.getHaslo()))
		    {    	
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
