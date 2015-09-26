package com.mariusz.empexp.auth.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.mariusz.empexp.core.domain.Pracownik;
import com.mariusz.empexp.doc.domain.Dokument;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;

@Entity
@Table(name = "Auth_Uzytkownik")

public class Uzytkownik implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "login")
    private String login;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "haslo")
    private String haslo;
    
    @Column(name = "licza_prob_logowania", columnDefinition="tinyint")
    private Short liczaProbLogowania;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private boolean status;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "aktywne")
    private boolean aktywne;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "waznosc_konta_od")
    @Temporal(TemporalType.DATE)
    private Date waznoscKontaOd;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "waznosc_konta_do")
    @Temporal(TemporalType.DATE)
    private Date waznoscKontaDo;
    
    
    @ManyToMany    
    @JoinTable(name = "Auth_Uzytkownik_Grupa", joinColumns = {
    		@JoinColumn(name = "login")}, inverseJoinColumns = {
    		@JoinColumn(name = "id_grupa")})    
    private Set<Grupa> zbiorGrup;  
    
    @ManyToMany
    @JoinTable(name ="Auth_Uzytkownik_Rola", joinColumns= {
    		@JoinColumn(name="login")},inverseJoinColumns ={
    		@JoinColumn(name="kod_roli")	
    })
    private Set<Rola> zbiorRol;
    
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "login")
    private List<Dokument> listaDokumentow;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "login")
    private List<Zdarzenia> listaZdarzen;
    
    @OneToOne(optional=false)
    @JoinColumn(name = "id_pracownik")
    private Pracownik idPracownik;

  

	public Uzytkownik() {
    }

    public Uzytkownik(String login) {
        this.login = login;
    }

    public Uzytkownik(String login, String haslo, boolean status, boolean aktywne, Date waznoscKontaOd, Date waznoscKontaDo) {
        this.login = login;
        this.haslo = haslo;
        this.status = status;
        this.aktywne = aktywne;
        this.waznoscKontaOd = waznoscKontaOd;
        this.waznoscKontaDo = waznoscKontaDo;
    }

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getHaslo() {
		return haslo;
	}

	public void setHaslo(String haslo) {
		this.haslo = haslo;
	}

	public Short getLiczaProbLogowania() {
		return liczaProbLogowania;
	}

	public void setLiczaProbLogowania(Short liczaProbLogowania) {
		this.liczaProbLogowania = liczaProbLogowania;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public boolean isAktywne() {
		return aktywne;
	}

	public void setAktywne(boolean aktywne) {
		this.aktywne = aktywne;
	}

	public Date getWaznoscKontaOd() {
		return waznoscKontaOd;
	}

	public void setWaznoscKontaOd(Date waznoscKontaOd) {
		this.waznoscKontaOd = waznoscKontaOd;
	}

	public Date getWaznoscKontaDo() {
		return waznoscKontaDo;
	}

	public void setWaznoscKontaDo(Date waznoscKontaDo) {
		this.waznoscKontaDo = waznoscKontaDo;
	}

	public Set<Grupa> getZbiorGrup() {
		return zbiorGrup;
	}

	public void setZbiorGrup(Set<Grupa> zbiorGrup) {
		this.zbiorGrup = zbiorGrup;
	}

	public Set<Rola> getZbiorRol() {
		return zbiorRol;
	}

	public void setZbiorRol(Set<Rola> zbiorRol) {
		this.zbiorRol = zbiorRol;
	}

	public List<Dokument> getListaDokumentow() {
		return listaDokumentow;
	}

	public void setListaDokumentow(List<Dokument> listaDokumentow) {
		this.listaDokumentow = listaDokumentow;
	}

	public List<Zdarzenia> getListaZdarzen() {
		return listaZdarzen;
	}

	public void setListaZdarzen(List<Zdarzenia> listaZdarzen) {
		this.listaZdarzen = listaZdarzen;
	}

	public Pracownik getIdPracownik() {
		return idPracownik;
	}

	public void setIdPracownik(Pracownik idPracownik) {
		this.idPracownik = idPracownik;
	}
    
	  
    @Override
	public boolean equals(final Object other) {
		if (!(other instanceof Uzytkownik)) {
			return false;
		}
		Uzytkownik castOther = (Uzytkownik) other;
		return new EqualsBuilder().append(login, castOther.login).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(login).toHashCode();
	}
    
    
}
