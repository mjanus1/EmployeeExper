package com.mariusz.empexp.core.domain;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;

@Entity
@Table(name = "Core_Adres")

public class Adres implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_adres")
    private Integer idAdres;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "ulica")
    private String ulica;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "nr_domu")
    private String nrDomu;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "nr_lokalu")
    private String nrLokalu;
    
    
    @OneToOne(optional = false)
    @JoinColumn(name="id_Miasto")
    private Miasto idMiasto;

    

	public Adres() {
		super();
	}


	public Adres(Integer idAdres, String ulica, String nrDomu, String nrLokalu,
			Miasto idMiasto) {
		super();
		this.idAdres = idAdres;
		this.ulica = ulica;
		this.nrDomu = nrDomu;
		this.nrLokalu = nrLokalu;
		this.idMiasto = idMiasto;
	}


	public Integer getIdAdres() {
		return idAdres;
	}


	public void setIdAdres(Integer idAdres) {
		this.idAdres = idAdres;
	}


	public String getUlica() {
		return ulica;
	}


	public void setUlica(String ulica) {
		this.ulica = ulica;
	}


	public String getNrDomu() {
		return nrDomu;
	}


	public void setNrDomu(String nrDomu) {
		this.nrDomu = nrDomu;
	}


	public String getNrLokalu() {
		return nrLokalu;
	}


	public void setNrLokalu(String nrLokalu) {
		this.nrLokalu = nrLokalu;
	}


	public Miasto getIdMiasto() {
		return idMiasto;
	}


	public void setIdMiasto(Miasto idMiasto) {
		this.idMiasto = idMiasto;
	}
    
   
	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof Adres)) {
			return false;
		}
		Adres castOther = (Adres) other;
		return new EqualsBuilder().append(idAdres, castOther.idAdres)
				.isEquals();
	}


	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(idAdres).toHashCode();
	}

    
}
