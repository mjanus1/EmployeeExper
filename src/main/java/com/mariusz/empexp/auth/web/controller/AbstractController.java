package com.mariusz.empexp.auth.web.controller;

import java.util.ResourceBundle;

import javax.faces.bean.ManagedProperty;

import com.mariusz.empexp.core.exception.ServiceException;

public abstract class AbstractController {

	@ManagedProperty(value="#{errors}")
	protected ResourceBundle resource;
	
	public void handleException(ServiceException exception)
	{
		//1Pobranie kody bledy
		//2 wyszukanie w pliku jaka jest wiadomosc 
		String errorCode=exception.getErrorCode();
		if(errorCode!=null)
		{
			String message=resource.getString(errorCode);
			//JSFUtility.sendErrorMessage(message);
		}
		//3 wyrzucenie faceMesage dla uzytkownika
	}
	
	public void setResource(ResourceBundle resource) {
		this.resource = resource;
	}
}
