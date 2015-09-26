package com.mariusz.empexp.auth.domain;


import java.io.Serializable;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;


@Entity
@Table(name = "Auth_Grupa")

public class Grupa implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_grupa")
    private Integer idGrupa;
	
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nazwa")
    private String nazwa;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "opis")
    private String opis;  
    
    @ManyToMany
    @JoinTable(name = "Auth_Role_W_Grupie", joinColumns = {
    	@JoinColumn(name = "id_grupa", referencedColumnName = "id_grupa")}, inverseJoinColumns = {
        @JoinColumn(name = "kod_roli", referencedColumnName = "kod_roli")})
    private Set<Rola> zbiorRul;

 
	public Grupa() {
    }

    public Grupa(Integer idGrupa) {
        this.idGrupa = idGrupa;
    }

    public Grupa(Integer idGrupa, String nazwa, String opis) {
        this.idGrupa = idGrupa;
        this.nazwa = nazwa;
        this.opis = opis;
    }
    
    //setery i getery 

	public Integer getIdGrupa() {
		return idGrupa;
	}

	public void setIdGrupa(Integer idGrupa) {
		this.idGrupa = idGrupa;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public Set<Rola> getZbiorRul() {
		return zbiorRul;
	}

	public void setZbiorRul(Set<Rola> zbiorRul) {
		this.zbiorRul = zbiorRul;
	}

	   
    @Override
	public boolean equals(final Object other) {
		if (!(other instanceof Grupa)) {
			return false;
		}
		Grupa castOther = (Grupa) other;
		return new EqualsBuilder().append(idGrupa, castOther.idGrupa)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(idGrupa).toHashCode();
	}

    
    
}
