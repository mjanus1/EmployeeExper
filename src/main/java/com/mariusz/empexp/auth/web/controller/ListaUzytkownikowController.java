package com.mariusz.empexp.auth.web.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;
import org.primefaces.model.LazyDataModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;

import com.mariusz.empexp.abstraction.AbstractController;
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
	private Page<Uzytkownik> pageSortAndPading;
	private List<Uzytkownik> listaFiltracji;
	
	private LazyDataModel<Uzytkownik> lazyModel;
	private LazyUzytkownikDataModel lazyData;
	
	@PostConstruct
	public void init()
	{
		System.out.println("Init");
		//isPostback() - zwraca true jesli juz bylismy na tej stronie i wykonalismy jakas akcje
		if(!FacesContext.getCurrentInstance().isPostback())//gwarancje ze kod wykona sie tylko przy pierwszym wyswietleniu strony
		{
			
			lazyModel=new LazyUzytkownikDataModel(servis.findAll());
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
	
	public void onRowEdit(RowEditEvent event) {
		Uzytkownik userEdytowany =(Uzytkownik)event.getObject();
		Uzytkownik user = servis.findByID(userEdytowany.getLogin());
		
		if(userEdytowany!=user && userEdytowany!=null)
		{
	    	servis.saveUzytkownik(userEdytowany);
			AbstractController.dodajWiadomoscGlobalna("użytkownika: "+user.getLogin(),"Pomyślnie zaktualizowano");	
		}
			
    }
	public void onRowCancel(RowEditEvent event) {
		
		Uzytkownik u =(Uzytkownik)event.getObject();
		AbstractController.dodajWiadomoscGlobalna("użytkownika: "+u.getLogin(),"Anulowano edycje");
       
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


	public Page<Uzytkownik> getPageSortAndPading() {
		return pageSortAndPading;
	}


	public void setPageSortAndPading(Page<Uzytkownik> pageSortAndPading) {
		this.pageSortAndPading = pageSortAndPading;
	}


	public LazyUzytkownikDataModel getLazyData() {
		return lazyData;
	}


	public void setLazyData(LazyUzytkownikDataModel lazyData) {
		this.lazyData = lazyData;
	}


	public LazyDataModel<Uzytkownik> getLazyModel() {
		return lazyModel;
	}


	public void setLazyModel(LazyDataModel<Uzytkownik> lazyModel) {
		this.lazyModel = lazyModel;
	}


	
}
