package com.mariusz.empexp.auth.web.controller;

import java.util.Comparator;

import org.primefaces.model.SortOrder;

import com.mariusz.empexp.auth.domain.Uzytkownik;

public class LazyUzytkownikSort implements Comparator<Uzytkownik> {

	 private String sortField;
     
	    private SortOrder sortOrder;
	     
	    public LazyUzytkownikSort(String sortField, SortOrder sortOrder) {
	        this.sortField = sortField;
	        this.sortOrder = sortOrder;
	    }
	 
	    public int compare(Uzytkownik u1, Uzytkownik u2) {
	        try {
	            Object value1 = Uzytkownik.class.getField(this.sortField).get(u1);
	            Object value2 = Uzytkownik.class.getField(this.sortField).get(u2);
	 
	            @SuppressWarnings("unchecked")
				int value = ((Comparable<Object>)value1).compareTo(value2);
	             
	            return SortOrder.ASCENDING.equals(sortOrder) ? value : -1 * value;
	        }
	        catch(Exception e) {
	            throw new RuntimeException();
	        }
	    }
}
