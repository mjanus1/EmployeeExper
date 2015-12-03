package com.mariusz.empexp.auth.domain.spec;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
//import org.springframework.data.jpa.domain.Specifications;

import com.mariusz.empexp.auth.domain.Uzytkownik;
import com.mariusz.empexp.auth.domain.Uzytkownik._Uzytkownik;

public class UzytkownikSpecification {

	//klasy ktore maja tylko metody styatyczne powinny miec konstruktor prywatny (diagram klas->Utility)
	private UzytkownikSpecification(){
		
	}
	
	public static Specification<Uzytkownik> likeLogin(String loginPart)
	{
		return new Specification<Uzytkownik>() {

			@Override
			public Predicate toPredicate(Root<Uzytkownik> root,CriteriaQuery<?> query, CriteriaBuilder cb) {
				
				return cb.like(root.get(_Uzytkownik.LOGIN), "%"+loginPart+"%");
			}
		};
	}
}
