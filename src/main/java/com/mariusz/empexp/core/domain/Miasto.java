package com.mariusz.empexp.core.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name = "Core_Miasto")

public class Miasto implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_miasto")
    private Integer idMiasto;
    
    @NotNull(message="notNull")
    @Size.List({
    	@Size(min=3,message="{miasto.nazwa.size.min}"),
    	@Size(max=25,message="{miasto.nazwa.size.max}")
    })
    @Column(name = "nazwa",length=25)
    private String nazwa;
    
    @NotNull(message="{notNull}")
    @Size(min=6,max=6 ,message="{miasto.kod_pocztowy.size}")
    @Column(name = "kod_pocztowy", columnDefinition="char(6)")
    private String kodPocztowy;
  
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_woj")
    private Wojewodzctwo idWoj;

    

	public Miasto() {
		super();
	}

	public Miasto(Integer idMiasto, String nazwa, String kodPocztowy,
			Wojewodzctwo idWoj) {
		super();
		this.idMiasto = idMiasto;
		this.nazwa = nazwa;
		this.kodPocztowy = kodPocztowy;
		this.idWoj = idWoj;
	}

	public Integer getIdMiasto() {
		return idMiasto;
	}

	public void setIdMiasto(Integer idMiasto) {
		this.idMiasto = idMiasto;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public String getKodPocztowy() {
		return kodPocztowy;
	}

	public void setKodPocztowy(String kodPocztowy) {
		this.kodPocztowy = kodPocztowy;
	}

	public Wojewodzctwo getIdWoj() {
		return idWoj;
	}

	public void setIdWoj(Wojewodzctwo idWoj) {
		this.idWoj = idWoj;
	}
    
    

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof Miasto)) {
			return false;
		}
		Miasto castOther = (Miasto) other;
		return new EqualsBuilder().append(idMiasto, castOther.idMiasto)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(idMiasto).toHashCode();
	}
}

