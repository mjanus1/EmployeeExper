package com.mariusz.empexp.core.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name = "Core_Wojewodzctwo")

public class Wojewodzctwo implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_woj")
    private Integer idWoj;
    
    @NotNull(message="{notNull}")
    @Size(min = 1, max = 15)
    @Column(name = "nazwa")
    private String nazwa;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idWoj")
    private List<Miasto> listaMiast;

	
    

	public Wojewodzctwo() {
		super();
	}

	public Wojewodzctwo(Integer idWoj, String nazwa, List<Miasto> listaMiast) {
		super();
		this.idWoj = idWoj;
		this.nazwa = nazwa;
		this.listaMiast = listaMiast;
	}

	public Integer getIdWoj() {
		return idWoj;
	}

	public void setIdWoj(Integer idWoj) {
		this.idWoj = idWoj;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public List<Miasto> getListaMiast() {
		return listaMiast;
	}

	public void setListaMiast(List<Miasto> listaMiast) {
		this.listaMiast = listaMiast;
	}
    
    
	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof Wojewodzctwo)) {
			return false;
		}
		Wojewodzctwo castOther = (Wojewodzctwo) other;
		return new EqualsBuilder().append(idWoj, castOther.idWoj).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(idWoj).toHashCode();
	}
}
