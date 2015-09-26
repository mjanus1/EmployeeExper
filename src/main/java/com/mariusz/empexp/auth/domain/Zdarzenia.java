package com.mariusz.empexp.auth.domain;

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
@Table(name = "Auth_Zdarzenia")


public class Zdarzenia implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_zdarzenie")
    private Long idZdarzenie;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_zdarzenia")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataZdarzenia;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "parametry")
    private String parametry;
    
    @JoinColumn(name = "login")
    @ManyToOne(optional = false)
    private Uzytkownik login;
    
    
    @JoinColumn(name = "id_typ_zdarzenia")
    @ManyToOne(optional = false)
    private TypZdarzen idTypZdarzenia;
    

	public Zdarzenia() {
    }

    public Zdarzenia(Long idZdarzenie) {
        this.idZdarzenie = idZdarzenie;
    }

    public Zdarzenia(Long idZdarzenie, Date dataZdarzenia, String parametry) {
        this.idZdarzenie = idZdarzenie;
        this.dataZdarzenia = dataZdarzenia;
        this.parametry = parametry;
    }

	public Long getIdZdarzenie() {
		return idZdarzenie;
	}

	public void setIdZdarzenie(Long idZdarzenie) {
		this.idZdarzenie = idZdarzenie;
	}

	public Date getDataZdarzenia() {
		return dataZdarzenia;
	}

	public void setDataZdarzenia(Date dataZdarzenia) {
		this.dataZdarzenia = dataZdarzenia;
	}

	public String getParametry() {
		return parametry;
	}

	public void setParametry(String parametry) {
		this.parametry = parametry;
	}

	public Uzytkownik getLogin() {
		return login;
	}

	public void setLogin(Uzytkownik login) {
		this.login = login;
	}

	public TypZdarzen getIdTypZdarzenia() {
		return idTypZdarzenia;
	}

	public void setIdTypZdarzenia(TypZdarzen idTypZdarzenia) {
		this.idTypZdarzenia = idTypZdarzenia;
	}
    
   

    @Override
	public boolean equals(final Object other) {
		if (!(other instanceof Zdarzenia)) {
			return false;
		}
		Zdarzenia castOther = (Zdarzenia) other;
		return new EqualsBuilder().append(idZdarzenie, castOther.idZdarzenie)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(idZdarzenie).toHashCode();
	}

}