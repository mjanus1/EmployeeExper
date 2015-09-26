package com.mariusz.empexp.core.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import com.mariusz.empexp.doc.domain.Dokument;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;

@Entity
@Table(name = "Core_Pracownik")

public class Pracownik implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_pracownik")
    private Integer idPracownik;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "imie")
    private String imie;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "nazwisko")
    private String nazwisko;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_urodzenia")
    @Temporal(TemporalType.DATE)
    private Date dataUrodzenia;
    
    @Size(max = 9)
    @Column(name = "telefon_kom",columnDefinition="char(9)")
    private String telefonKom;
    
    @Size(max = 12)
    @Column(name = "telefon_stac",columnDefinition="char(12)")
    private String telefonStac;
    @Size(max = 9)
    @Column(name = "telefon_firmowy", columnDefinition="char(9)")
    private String telefonFirmowy;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "plec")
    private Character plec;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 11, max = 11)
    @Column(name = "pesel")
    private String pesel;
    
    @Size(max = 256)
    @Column(name = "mail")
    private String mail;
    @Size(max = 256)
    @Column(name = "mail_firmowy")
    private String mailFirmowy;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_zatrudnienia")
    @Temporal(TemporalType.DATE)
    private Date dataZatrudnienia;
    
    @Column(name = "data_zwolnienia")
    @Temporal(TemporalType.DATE)
    private Date dataZwolnienia;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 10, max = 10)
    @Column(name = "nip" , columnDefinition="char(10)")
    private String nip;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPracownik")
    private List<Zwolnienie> listaZwolnien;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPracownik")
    private List<Zatrudnienie> listaZatrudnien;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPracownik")
    private List<Dokument> listaDokumentow;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_przelozony")
    private Pracownik idPrzelozony;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_oddzial")
    private Oddzial idOddzial;
    
    @OneToOne(optional = false)
    @JoinColumn(name = "id_adres_zamieszkania")
    private Adres idAdresZamieszkania;

    @OneToOne(optional = false)
    @JoinColumn(name = "id_adres_korespondencja")
    private Adres idAdresKorespondencja;
    
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPracownik")
    private List<HistoriaZatrudnienia> historiaZatrudnien;
  

	public Pracownik() {
    }

    public Pracownik(Integer idPracownik) {
        this.idPracownik = idPracownik;
    }

    public Pracownik(Integer idPracownik, String imie, String nazwisko, Date dataUrodzenia, Character plec, String pesel, Date dataZatrudnienia, String nip) {
        this.idPracownik = idPracownik;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dataUrodzenia = dataUrodzenia;
        this.plec = plec;
        this.pesel = pesel;
        this.dataZatrudnienia = dataZatrudnienia;
        this.nip = nip;
    }

	public Integer getIdPracownik() {
		return idPracownik;
	}

	public void setIdPracownik(Integer idPracownik) {
		this.idPracownik = idPracownik;
	}

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public Date getDataUrodzenia() {
		return dataUrodzenia;
	}

	public void setDataUrodzenia(Date dataUrodzenia) {
		this.dataUrodzenia = dataUrodzenia;
	}

	public String getTelefonKom() {
		return telefonKom;
	}

	public void setTelefonKom(String telefonKom) {
		this.telefonKom = telefonKom;
	}

	public String getTelefonStac() {
		return telefonStac;
	}

	public void setTelefonStac(String telefonStac) {
		this.telefonStac = telefonStac;
	}

	public String getTelefonFirmowy() {
		return telefonFirmowy;
	}

	public void setTelefonFirmowy(String telefonFirmowy) {
		this.telefonFirmowy = telefonFirmowy;
	}

	public Character getPlec() {
		return plec;
	}

	public void setPlec(Character plec) {
		this.plec = plec;
	}

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMailFirmowy() {
		return mailFirmowy;
	}

	public void setMailFirmowy(String mailFirmowy) {
		this.mailFirmowy = mailFirmowy;
	}

	public Date getDataZatrudnienia() {
		return dataZatrudnienia;
	}

	public void setDataZatrudnienia(Date dataZatrudnienia) {
		this.dataZatrudnienia = dataZatrudnienia;
	}

	public Date getDataZwolnienia() {
		return dataZwolnienia;
	}

	public void setDataZwolnienia(Date dataZwolnienia) {
		this.dataZwolnienia = dataZwolnienia;
	}

	public String getNip() {
		return nip;
	}

	public void setNip(String nip) {
		this.nip = nip;
	}

	public List<Zwolnienie> getListaZwolnien() {
		return listaZwolnien;
	}

	public void setListaZwolnien(List<Zwolnienie> listaZwolnien) {
		this.listaZwolnien = listaZwolnien;
	}

	public List<Zatrudnienie> getListaZatrudnien() {
		return listaZatrudnien;
	}

	public void setListaZatrudnien(List<Zatrudnienie> listaZatrudnien) {
		this.listaZatrudnien = listaZatrudnien;
	}

	public List<Dokument> getListaDokumentow() {
		return listaDokumentow;
	}

	public void setListaDokumentow(List<Dokument> listaDokumentow) {
		this.listaDokumentow = listaDokumentow;
	}

	public Pracownik getIdPrzelozony() {
		return idPrzelozony;
	}

	public void setIdPrzelozony(Pracownik idPrzelozony) {
		this.idPrzelozony = idPrzelozony;
	}

	public Oddzial getIdOddzial() {
		return idOddzial;
	}

	public void setIdOddzial(Oddzial idOddzial) {
		this.idOddzial = idOddzial;
	}

	public Adres getIdAdresZamieszkania() {
		return idAdresZamieszkania;
	}

	public void setIdAdresZamieszkania(Adres idAdresZamieszkania) {
		this.idAdresZamieszkania = idAdresZamieszkania;
	}

	public Adres getIdAdresKorespondencja() {
		return idAdresKorespondencja;
	}

	public void setIdAdresKorespondencja(Adres idAdresKorespondencja) {
		this.idAdresKorespondencja = idAdresKorespondencja;
	}

	public List<HistoriaZatrudnienia> getHistoriaZatrudnien() {
		return historiaZatrudnien;
	}

	public void setHistoriaZatrudnien(List<HistoriaZatrudnienia> historiaZatrudnien) {
		this.historiaZatrudnien = historiaZatrudnien;
	}
    
	
	 @Override
		public boolean equals(final Object other) {
			if (!(other instanceof Pracownik)) {
				return false;
			}
			Pracownik castOther = (Pracownik) other;
			return new EqualsBuilder().append(idPracownik, castOther.idPracownik)
					.isEquals();
		}

		@Override
		public int hashCode() {
			return new HashCodeBuilder().append(idPracownik).toHashCode();
		}
    
}
