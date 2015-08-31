package com.mariusz.empexp.test;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;



@ManagedBean(name="kontroler")
@ViewScoped
public class Kontroler {

	private static final Logger logger=LoggerFactory.getLogger(Kontroler.class);
	
	public String akcjaPrototyp()
	{
		ApplicationContext ctx = FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
		Model model=ctx.getBean("model1",Model.class);
		logger.debug(model.toString());
		return null;
	}
	
	public String akcjaSingleton()
	{
		ApplicationContext ctx = FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
		Model model=ctx.getBean("model2",Model.class);
		logger.debug(model.toString());
		return null;
	}
}
