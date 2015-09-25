package com.mariusz.empexp.core.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;

@Entity
@Table(name = "Firma")

public class Firma implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_firma")
    private Short idFirma;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "nazwa")
    private String nazwa;
    
    @OneToOne(optional = false)
    @JoinColumn(name = "id_adres")
    private Adres idAdres;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFirma")
    private List<Oddzial> listaOddzialow;

  
	public Firma() {
    }

    public Firma(Short idFirma) {
        this.idFirma = idFirma;
    }

	public Firma(Short idFirma, String nazwa, Adres idAdres) {
		super();
		this.idFirma = idFirma;
		this.nazwa = nazwa;
		this.idAdres = idAdres;
	}

	public Short getIdFirma() {
		return idFirma;
	}

	public void setIdFirma(Short idFirma) {
		this.idFirma = idFirma;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public Adres getIdAdres() {
		return idAdres;
	}

	public void setIdAdres(Adres idAdres) {
		this.idAdres = idAdres;
	}

	public List<Oddzial> getListaOddzialow() {
		return listaOddzialow;
	}

	public void setListaOddzialow(List<Oddzial> listaOddzialow) {
		this.listaOddzialow = listaOddzialow;
	}
    
	  @Override
		public boolean equals(final Object other) {
			if (!(other instanceof Firma)) {
				return false;
			}
			Firma castOther = (Firma) other;
			return new EqualsBuilder().append(idFirma, castOther.idFirma)
					.isEquals();
		}

		@Override
		public int hashCode() {
			return new HashCodeBuilder().append(idFirma).toHashCode();
		}

    
}