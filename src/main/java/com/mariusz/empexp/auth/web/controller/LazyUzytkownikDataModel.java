package com.mariusz.empexp.auth.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
//import org.springframework.data.jpa.domain.Specifications;
import org.springframework.web.jsf.FacesContextUtils;

import java.util.List;
import java.util.Map;
import javax.faces.context.FacesContext;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import com.mariusz.empexp.auth.domain.Uzytkownik;
import com.mariusz.empexp.auth.domain.Uzytkownik._Uzytkownik;
import com.mariusz.empexp.auth.domain.spec.UzytkownikSpecification;
import com.mariusz.empexp.auth.service.IUzytkownikService;

public class LazyUzytkownikDataModel extends LazyDataModel<Uzytkownik> {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LoggerFactory.getLogger(LazyUzytkownikDataModel.class);

	private static final long serialVersionUID = 1L;
	
	private List<Uzytkownik> datasource;

	public LazyUzytkownikDataModel(List<Uzytkownik> datasource) {
		this.datasource = datasource;
	}
	
	
	 @Override
	    public Uzytkownik getRowData(String rowKey) {
		if (logger.isDebugEnabled()) {
			logger.debug("getRowData(String) - logGetRow - rowKey={}", rowKey); //$NON-NLS-1$
		}

	        for(Uzytkownik u : datasource) {
	            if(u.getLogin().equals(rowKey))
	                return u;
	        }
	 
	        return null;
	    }
    @Override
	public Object getRowKey(Uzytkownik uzytkownik)
	{
		if (logger.isDebugEnabled()) {
			logger.debug("getRowKey(Uzytkownik) - getRowKey - uzytkownik={}", uzytkownik); //$NON-NLS-1$
		}

		return uzytkownik.getLogin();
	}
    //public abstract load(PageRequest page,Map<String,Object> filters)
	
	
	public List<Uzytkownik> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,Object> filters)
		{
		Direction direction=null;
		if(sortOrder==SortOrder.ASCENDING)
			direction=Direction.ASC;
		else if(sortOrder==SortOrder.DESCENDING)
			direction=Direction.DESC;

		if (logger.isDebugEnabled()) {
			logger.debug("load(int, int, String, SortOrder, Map<String,Object>) - load - first={}, pageSize={}, sortField={}, sortOrder={}, filters={}", first, pageSize, sortField, sortOrder, filters); //$NON-NLS-1$
		}
		
		
		PageRequest request=null;
		if(sortField==null||sortField.length()==0)
			request=new PageRequest((first)/pageSize, pageSize);
		else
			request=new PageRequest((first)/pageSize, pageSize,new Sort(direction, sortField));
		
		//load(requets,filters)
		
		ApplicationContext ctx = FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
		IUzytkownikService servis=ctx.getBean(IUzytkownikService.class);
		
		Specification<Uzytkownik> loginSpec=null;
		//Specifications.where(specA).and(specB);
		String loginValue=(String) filters.get(_Uzytkownik.LOGIN);
		
		if(loginValue!=null&&loginValue.length()>0)
			loginSpec=UzytkownikSpecification.likeLogin(loginValue);
		
		if (logger.isDebugEnabled()) {
			logger.info("load(int, int, String, SortOrder, Map<String,Object>) - request={}, spec={}", request, loginSpec); //$NON-NLS-1$
		}
		
		Page<Uzytkownik> resultPage=null;
		  if(loginSpec==null)
			 resultPage=servis.findAll(request);
		  else
			resultPage=servis.findAll(loginSpec, request);

		  if (logger.isDebugEnabled()) {
			  logger.debug("load(int, int, String, SortOrder, Map<String,Object>) - spring result - resultPage={}", resultPage); //$NON-NLS-1$
		  }
		  
		this.setRowCount((int)resultPage.getTotalElements());
		List<Uzytkownik> datasource=resultPage.getContent();

		if (logger.isDebugEnabled()) {
			logger.debug("load(int, int, String, SortOrder, Map<String,Object>) - result query - datasource={}", datasource); //$NON-NLS-1$
		}
		/*
		Specification<Todo> specA = ...
		Specification<Todo> specB = ...
		List<Todo> searchResults = repository.findAll(
    	Specifications.where(specA).and(
        Specifications.not(specB)
    )
);
		*/
		return datasource;
	}

	public List<Uzytkownik> getDatasource() {
		return datasource;
	}

	public void setDatasource(List<Uzytkownik> datasource) {
		this.datasource = datasource;
	}
}