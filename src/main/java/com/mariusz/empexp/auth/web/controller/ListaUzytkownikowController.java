package com.mariusz.empexp.auth.web.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mariusz.empexp.auth.domain.Uzytkownik;
import com.mariusz.empexp.auth.service.IUzytkownikService;
import com.mariusz.empexp.core.exception.ServiceException;

@ManagedBean(name="listaUserowForm")
@ViewScoped

public class ListaUzytkownikowController extends AbstractController implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger logger=LoggerFactory.getLogger(ListaUzytkownikowController.class);
	
	@ManagedProperty(value="#{IUzytkownikService}")
	protected IUzytkownikService servis;
	
	private List<Uzytkownik> listaUserow;
	private List<Uzytkownik> listaFiltracji;

	
	public void init()
	{
		System.out.println("Init");
		//isPostback() - zwraca true jesli juz bylismy na tej stronie i wykonalismy jakas akcje
		if(!FacesContext.getCurrentInstance().isPostback())//gwarancje ze kod wykona sie tylko przy pierwszym wyswietleniu strony
		{ 
			listaUserow=servis.findAll();	
		}
	}
	
	
	public String usunUzytkownikaAkcja()throws ServiceException
	{
		try
		{
			return usunUzytkownika();
		}
		catch(ServiceException e)
		{
			logger.debug(""+e);
		}
		
		return null;
	}
	
	public String usunUzytkownika()throws ServiceException
	{
		String login=pobierzParametr("login");
		logger.debug("pobrano login:" +login);
		if(login!=null)
		{
			servis.deleteByID(login);
			dodajWiadomoscGlobalna("Usunięto Uzytkownika", "");
			this.listaUserow=servis.findAll();
		}
		 else
			dodajBladGlobalny("Nie można usunąć użytkownika", "");
		return null;
	}
	
	
	
	
	
	public IUzytkownikService getServis() {
		return servis;
	}

	public void setServis(IUzytkownikService servis) {
		this.servis = servis;
	}

	public List<Uzytkownik> getListaUserow() {
		return listaUserow;
	}

	public void setListaUserow(List<Uzytkownik> listaUserow) {
		this.listaUserow = listaUserow;
	}

	public List<Uzytkownik> getListaFiltracji() {
		return listaFiltracji;
	}

	public void setListaFiltracji(List<Uzytkownik> listaFiltracji) {
		this.listaFiltracji = listaFiltracji;
	}
	
}
