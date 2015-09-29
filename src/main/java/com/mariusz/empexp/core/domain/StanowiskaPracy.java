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
@Table(name = "Core_Stanowiska_Pracy")

public class StanowiskaPracy implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @NotNull
    @Column(name = "id_stanowisko")
    private Integer idStanowisko;
    
    @NotNull(message="{notNull}")
    @Size(min = 5, max = 20)
    @Size.List({
    	@Size(min=1,message="{stanowiska_pracy.nazwa.size.min}"),
    	@Size(max=20,message="{stanowiska_pracy.nazwa.size.max}")
    })
    @Column(name = "nazwa_stanowiska",length=20)
    private String nazwaStanowiska;
    
    @NotNull(message="{notNull}")
    @Size(min = 1, max = 500)
    @Size.List({
    	@Size(min=2,message="{stanowiska_pracy.opis.size.min}"),
    	@Size(max=500,message="{stanowiska_pracy.opis.size.max}")
    })
    @Column(name = "opis_stanowiska",length=500)
    private String opisStanowiska;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idStanowisko")
    private List<Zatrudnienie> listaZatrudnien;

    
	public StanowiskaPracy() {
    }

    public StanowiskaPracy(Integer idStanowisko) {
        this.idStanowisko = idStanowisko;
    }

    public StanowiskaPracy(Integer idStanowisko, String nazwaStanowiska, String opisStanowiska) {
        this.idStanowisko = idStanowisko;
        this.nazwaStanowiska = nazwaStanowiska;
        this.opisStanowiska = opisStanowiska;
    }

	public Integer getIdStanowisko() {
		return idStanowisko;
	}

	public void setIdStanowisko(Integer idStanowisko) {
		this.idStanowisko = idStanowisko;
	}

	public String getNazwaStanowiska() {
		return nazwaStanowiska;
	}

	public void setNazwaStanowiska(String nazwaStanowiska) {
		this.nazwaStanowiska = nazwaStanowiska;
	}

	public String getOpisStanowiska() {
		return opisStanowiska;
	}

	public void setOpisStanowiska(String opisStanowiska) {
		this.opisStanowiska = opisStanowiska;
	}

	public List<Zatrudnienie> getListaZatrudnien() {
		return listaZatrudnien;
	}

	public void setListaZatrudnien(List<Zatrudnienie> listaZatrudnien) {
		this.listaZatrudnien = listaZatrudnien;
	}
    
	

    @Override
	public boolean equals(final Object other) {
		if (!(other instanceof StanowiskaPracy)) {
			return false;
		}
		StanowiskaPracy castOther = (StanowiskaPracy) other;
		return new EqualsBuilder().append(idStanowisko, castOther.idStanowisko)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(idStanowisko).toHashCode();
	}

    
}
