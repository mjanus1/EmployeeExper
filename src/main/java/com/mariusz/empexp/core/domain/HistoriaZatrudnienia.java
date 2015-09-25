package com.mariusz.empexp.core.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;

@Entity
@Table(name = "Historia_Zatrudnienia")

public class HistoriaZatrudnienia implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_historia")
    private Integer idHistoria;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "zatrudniony_od")
    @Temporal(TemporalType.DATE)
    private Date zatrudnionyOd;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "zatrudniony_do")
    @Temporal(TemporalType.DATE)
    private Date zatrudnionyDo;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "nazwa_firmy")
    private String nazwaFirmy;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "opis_stanowiska")
    private String opisStanowiska;


    @ManyToOne(optional = false)
    @JoinColumn(name = "id_pracownik")
    private Pracownik idPracownik;
    
    
	
	public HistoriaZatrudnienia() {
		super();
	}


	public HistoriaZatrudnienia(Integer idHistoria, Date zatrudnionyOd,
			Date zatrudnionyDo, String nazwaFirmy, String opisStanowiska) {
		super();
		this.idHistoria = idHistoria;
		this.zatrudnionyOd = zatrudnionyOd;
		this.zatrudnionyDo = zatrudnionyDo;
		this.nazwaFirmy = nazwaFirmy;
		this.opisStanowiska = opisStanowiska;
	}


	public Integer getIdHistoria() {
		return idHistoria;
	}


	public void setIdHistoria(Integer idHistoria) {
		this.idHistoria = idHistoria;
	}


	public Date getZatrudnionyOd() {
		return zatrudnionyOd;
	}


	public void setZatrudnionyOd(Date zatrudnionyOd) {
		this.zatrudnionyOd = zatrudnionyOd;
	}


	public Date getZatrudnionyDo() {
		return zatrudnionyDo;
	}


	public void setZatrudnionyDo(Date zatrudnionyDo) {
		this.zatrudnionyDo = zatrudnionyDo;
	}


	public String getNazwaFirmy() {
		return nazwaFirmy;
	}


	public void setNazwaFirmy(String nazwaFirmy) {
		this.nazwaFirmy = nazwaFirmy;
	}


	public String getOpisStanowiska() {
		return opisStanowiska;
	}


	public void setOpisStanowiska(String opisStanowiska) {
		this.opisStanowiska = opisStanowiska;
	}
	
	
 
	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof HistoriaZatrudnienia)) {
			return false;
		}
		HistoriaZatrudnienia castOther = (HistoriaZatrudnienia) other;
		return new EqualsBuilder().append(idHistoria, castOther.idHistoria)
				.isEquals();
	}


	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(idHistoria).toHashCode();
	}


    
    
    
    
}


