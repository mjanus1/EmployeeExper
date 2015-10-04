package com.mariusz.empexp.core.domain;

import java.io.Serializable;

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

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name = "Core_Adres")

public class Adres implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_adres")
    private Integer idAdres;
    
    @NotNull(message="{notNull}")
    @Size.List({
    	@Size(min=3,message="{adres.ulica.size.min}"),
    	@Size(max=40,message="{adres.ulica.size.max}")
    })
    @Column(name = "ulica",length=40)
    private String ulica;
    
    @NotNull(message="{notNull}")
    @Size.List({
    	@Size(min=1,message="{adres.nr_domu.size.min}"),
    	@Size(max=4,message="{adres.nr_domu.size.max}")
    })
    @Column(name = "nr_domu",length=4)
    private String nrDomu;
    
    @NotNull(message="{notNull}")
    @Size.List({
    	@Size(min=1,message="{adres.nr_lokalu.size.min}"),
    	@Size(max=4,message="{adres.nr_lokalu.size.max}")
    })
    @Column(name = "nr_lokalu",length=4)
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
