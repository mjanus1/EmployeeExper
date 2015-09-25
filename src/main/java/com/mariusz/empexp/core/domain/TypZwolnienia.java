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
@Table(name = "Typ_Zwolnienia")

public class TypZwolnienia implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_typ_zwolnienia")
    private Short idTypZwolnienia;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "nazwa")
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