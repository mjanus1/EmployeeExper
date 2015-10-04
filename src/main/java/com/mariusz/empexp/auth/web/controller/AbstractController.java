package com.mariusz.empexp.auth.web.controller;

import java.util.Map;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mariusz.empexp.core.exception.ServiceException;

public abstract class AbstractController {

	private static final Logger logger=LoggerFactory.getLogger(AbstractController.class);
	
	@ManagedProperty(value="#{errors}")
	public ResourceBundle resource;
	
	public void handleException(ServiceException exception)
	{
		//1Pobranie kody bledy
		//2 wyszukanie w pliku jaka jest wiadomosc 
		String errorCode=exception.getErrorCode();
		if(errorCode!=null)
		{
			String message=resource.getString(errorCode);
				logger.debug("tu jestem loger"+message);
				dodajBladGlobalny(""+message, "fewfwf");
						
		}
		
		//3 wyrzucenie faceMesage dla uzytkownika
	}
	
	
	
	public static void dodajWiadomoscGlobalna(String szczegoly,String podsumowanie)
	{
		//1 Tworzymy obiek klasy FacesMessage
		//1a wybieramy typ FacesMessage.[wskazany typ]
		FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_INFO,podsumowanie, szczegoly);
		//2 Dodajemy ta wiadomosc jako globalna
		//2a addMessage(clientID,message) clientID - jesli NUlll to wiadomosc globalna, jesli id komponentu to wiadomosc przypisana do znacznika
		FacesContext.getCurrentInstance().addMessage(null, msg);
		//Koniec
	}
	
	public static void dodajOstrzezenieGlobalne(String szczegoly,String podsumowanie)
	{
		FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_WARN,podsumowanie, szczegoly);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public static void dodajBladGlobalny(String szczegoly,String podsumowanie)
	{
		FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_ERROR,podsumowanie, szczegoly);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	
	
	//ponizej wiadomosci przypisane do znacznika
	
	
	public static void dodajWiadomosc(String clientID,String szczegoly,String podsumowanie)
	{
		//1 Tworzymy obiek klasy FacesMessage
		//1a wybieramy typ FacesMessage.[wskazany typ]
		FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_INFO,podsumowanie, szczegoly);
		//2 Dodajemy ta wiadomosc jako globalna
		//2a addMessage(clientID,message) clientID - jesli NUlll to wiadomosc globalna, jesli id komponentu to wiadomosc przypisana do znacznika
		FacesContext.getCurrentInstance().addMessage(clientID, msg);
	}
	
	public static void dodajOstrzezenie(String clientID,String szczegoly,String podsumowanie)
	{
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,podsumowanie,szczegoly);
		FacesContext.getCurrentInstance().addMessage(clientID, msg);
	}
	
	public static void dodajBlad(String clientID,String szczegoly,String podsumowanie)
	{
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,podsumowanie,szczegoly);
		FacesContext.getCurrentInstance().addMessage(clientID, msg);
	}
	
	public static String pobierzParametr(String parametr)
	{
		FacesContext ctx=FacesContext.getCurrentInstance();//pobranie kontesktu aplikacji JSF - mozemy zapomoca tego kontekstu dostac sie do niskopoziomowych funkcji
		ExternalContext etx=ctx.getExternalContext();//pobranie kontekstu Serlvety - daje dostep do wszytskich funkcji servlety
		Map<String,String> parameters=etx.getRequestParameterMap();//pobieranie parametrow zadania
		return parameters.get(parametr);
	}
	
	
	
	public void setResource(ResourceBundle resource) {
		this.resource = resource;
	}

	public ResourceBundle getResource() {
		return resource;
	}
	
	
}
