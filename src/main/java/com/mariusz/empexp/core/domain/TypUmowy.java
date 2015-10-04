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
@Table(name = "Core_Typ_Umowy")

public class TypUmowy implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_typ_umowy",columnDefinition="tinyint")
    private Short idTypUmowy;
    
    @NotNull(message="{notNull}")
    @Size.List({
    	@Size(min=5,message="{typ_umowy.rodzaj.size.min}"),
    	@Size(min=30,message="{typ_umowy.rodzaj.size.max}")
    })
    @Column(name = "rodzaj",length=30)
    private String rodzaj;
    
  
	public TypUmowy() {
    }

    public TypUmowy(Short idTypUmowy) {
        this.idTypUmowy = idTypUmowy;
    }

    public TypUmowy(Short idTypUmowy, String rodzaj) {
        this.idTypUmowy = idTypUmowy;
        this.rodzaj = rodzaj;
    }

	public Short getIdTypUmowy() {
		return idTypUmowy;
	}

	public void setIdTypUmowy(Short idTypUmowy) {
		this.idTypUmowy = idTypUmowy;
	}

	public String getRodzaj() {
		return rodzaj;
	}

	public void setRodzaj(String rodzaj) {
		this.rodzaj = rodzaj;
	}
    
   

    @Override
	public boolean equals(final Object other) {
		if (!(other instanceof TypUmowy)) {
			return false;
		}
		TypUmowy castOther = (TypUmowy) other;
		return new EqualsBuilder().append(idTypUmowy, castOther.idTypUmowy)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(idTypUmowy).toHashCode();
	}

}