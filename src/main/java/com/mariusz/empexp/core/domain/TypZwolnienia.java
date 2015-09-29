package com.mariusz.empexp.core.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name = "Core_Typ_Zwolnienia")

public class TypZwolnienia implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @NotNull
    @Column(name = "id_typ_zwolnienia",columnDefinition="tinyint")
    private Short idTypZwolnienia;
    
    @NotNull(message="{notNull}")
    @Size.List({
    	@Size(min=5,message="{typ_zwolnienia.nazwa.size.min}"),
    	@Size(max=40,message="{typ_zwolnienia.nazwa.size.max}")
    })
    @Column(name = "nazwa",length=40)
    private String nazwa;
    
  

	public TypZwolnienia() {
    }

    public TypZwolnienia(Short idTypZwolnienia) {
        this.idTypZwolnienia = idTypZwolnienia;
    }

    public TypZwolnienia(Short idTypZwolnienia, String nazwa) {
        this.idTypZwolnienia = idTypZwolnienia;
        this.nazwa = nazwa;
    }

	public Short getIdTypZwolnienia() {
		return idTypZwolnienia;
	}

	public void setIdTypZwolnienia(Short idTypZwolnienia) {
		this.idTypZwolnienia = idTypZwolnienia;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
    
    
 
    
    @Override
	public boolean equals(final Object other) {
		if (!(other instanceof TypZwolnienia)) {
			return false;
		}
		TypZwolnienia castOther = (TypZwolnienia) other;
		return new EqualsBuilder().append(idTypZwolnienia,
				castOther.idTypZwolnienia).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(idTypZwolnienia).toHashCode();
	}

}