package com.mariusz.empexp.doc.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.mariusz.empexp.auth.domain.Uzytkownik;
import com.mariusz.empexp.core.domain.Pracownik;

@Entity
@Table(name = "Dok_Dokument")

public class Dokument implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_dokument")
    private Integer idDokument;
    
    @NotNull(message="{notNull}")
    @Size.List({
    	@Size(min=2,message="{dokument.nazwa.size.min}"),
    	@Size(max=100,message="{dokument.nazwa.size.max}")
    })
    @Column(name = "nazwa",length=100)
    private String nazwa;
    
    @NotNull(message="{dokument.plik.required}")
    @Lob
    @Column(name = "plik", columnDefinition="image")
    private byte[] plik;
    
    @NotNull(message="{notNull}")
    @Column(name = "data_dodania")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataDodania;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_typ_dokumentu")
    private TypDokumentu idTypDokumentu;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_pracownik")
    private Pracownik idPracownik;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "login")
    private Uzytkownik login;

  
	public Dokument() {
    }

    public Dokument(Integer idDokument) {
        this.idDokument = idDokument;
    }

    public Dokument(Integer idDokument, String nazwa, byte[] plik, Date dataDodania) {
        this.idDokument = idDokument;
        this.nazwa = nazwa;
        this.plik = plik;
        this.dataDodania = dataDodania;
    }

	public Integer getIdDokument() {
		return idDokument;
	}

	public void setIdDokument(Integer idDokument) {
		this.idDokument = idDokument;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public byte[] getPlik() {
		return plik;
	}

	public void setPlik(byte[] plik) {
		this.plik = plik;
	}

	public Date getDataDodania() {
		return dataDodania;
	}

	public void setDataDodania(Date dataDodania) {
		this.dataDodania = dataDodania;
	}

	public TypDokumentu getIdTypDokumentu() {
		return idTypDokumentu;
	}

	public void setIdTypDokumentu(TypDokumentu idTypDokumentu) {
		this.idTypDokumentu = idTypDokumentu;
	}

	public Pracownik getIdPracownik() {
		return idPracownik;
	}

	public void setIdPracownik(Pracownik idPracownik) {
		this.idPracownik = idPracownik;
	}

	public Uzytkownik getLogin() {
		return login;
	}

	public void setLogin(Uzytkownik login) {
		this.login = login;
	}
    
	  
    @Override
	public boolean equals(final Object other) {
		if (!(other instanceof Dokument)) {
			return false;
		}
		Dokument castOther = (Dokument) other;
		return new EqualsBuilder().append(idDokument, castOther.idDokument)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(idDokument).toHashCode();
	}

    
}

