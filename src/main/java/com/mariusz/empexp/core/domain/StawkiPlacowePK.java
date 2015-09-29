package com.mariusz.empexp.core.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Embeddable
public class StawkiPlacowePK implements Serializable {
	private static final long serialVersionUID = 1L;
	
    @NotNull(message="{noNull}")
    @Column(name = "rok")
    private short rok;
	
    @NotNull
    @Column(name = "id_typ_umowy" ,columnDefinition="tinyint")
    private short idTypUmowy;

	public StawkiPlacowePK() {
    }

    public StawkiPlacowePK(short rok, short idTypUmowy) {
        this.rok = rok;
        this.idTypUmowy = idTypUmowy;
    }

    public short getRok() {
        return rok;
    }

    public void setRok(short rok) {
        this.rok = rok;
    }

    public short getIdTypUmowy() {
        return idTypUmowy;
    }

    public void setIdTypUmowy(short idTypUmowy) {
        this.idTypUmowy = idTypUmowy;
    }
    
    
    @Override
  	public boolean equals(final Object other) {
  		if (!(other instanceof StawkiPlacowePK)) {
  			return false;
  		}
  		StawkiPlacowePK castOther = (StawkiPlacowePK) other;
  		return new EqualsBuilder().append(rok, castOther.rok)
  				.append(idTypUmowy, castOther.idTypUmowy).isEquals();
  	}

  	@Override
  	public int hashCode() {
  		return new HashCodeBuilder().append(rok).append(idTypUmowy)
  				.toHashCode();
  	}
    
}
