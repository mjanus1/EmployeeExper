package com.mariusz.empexp.core.domain;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;

@Entity
@Table(name = "Typ_Umowy")

public class TypUmowy implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_typ_umowy")
    private Short idTypUmowy;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "rodzaj")
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