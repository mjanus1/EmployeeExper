package com.mariusz.empexp.abstraction;

import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.springframework.data.domain.Sort.Direction;


public abstract class Load<T> extends LazyDataModel<T> {

	private static final long serialVersionUID = 1L;

	public  List<T> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,Object> filters)
	{
		
		@SuppressWarnings("unused")
		Direction direction=null;
		if(sortOrder==SortOrder.ASCENDING)
			direction=Direction.ASC;
		else if(sortOrder==SortOrder.DESCENDING)
			direction=Direction.DESC;
		
		

		
		return null;
		
			
		
	}
	
	
	
}
