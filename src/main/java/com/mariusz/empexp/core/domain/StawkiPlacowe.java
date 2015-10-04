package com.mariusz.empexp.core.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name = "Core_Stawki_Placowe")

public class StawkiPlacowe implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected StawkiPlacowePK stawkiPlacowePK;
    
    
    @NotNull(message="{notNull}")
    @Column(name = "podatek_dochodowy")
    private int podatekDochodowy;
    
    @NotNull(message="{notNull}")
    @Column(name = "skladka_chorobowa",columnDefinition="tinyint")
    private short skladkaChorobowa;
    
    @NotNull(message="{notNull}")
    @Column(name = "skladka_ubezpieczenie",columnDefinition="tinyint")
    private short skladkaUbezpieczenie;
  
 

	public StawkiPlacowe() {
    }

    public StawkiPlacowe(StawkiPlacowePK stawkiPlacowePK) {
        this.stawkiPlacowePK = stawkiPlacowePK;
    }

    public StawkiPlacowe(StawkiPlacowePK stawkiPlacowePK, int podatekDochodowy, short skladkaChorobowa, short skladkaUbezpieczenie) {
        this.stawkiPlacowePK = stawkiPlacowePK;
        this.podatekDochodowy = podatekDochodowy;
        this.skladkaChorobowa = skladkaChorobowa;
        this.skladkaUbezpieczenie = skladkaUbezpieczenie;
    }

    public StawkiPlacowe(short rok, short idTypUmowy) {
        this.stawkiPlacowePK = new StawkiPlacowePK(rok, idTypUmowy);
    }

	public StawkiPlacowePK getStawkiPlacowePK() {
		return stawkiPlacowePK;
	}

	public void setStawkiPlacowePK(StawkiPlacowePK stawkiPlacowePK) {
		this.stawkiPlacowePK = stawkiPlacowePK;
	}

	public int getPodatekDochodowy() {
		return podatekDochodowy;
	}

	public void setPodatekDochodowy(int podatekDochodowy) {
		this.podatekDochodowy = podatekDochodowy;
	}

	public short getSkladkaChorobowa() {
		return skladkaChorobowa;
	}

	public void setSkladkaChorobowa(short skladkaChorobowa) {
		this.skladkaChorobowa = skladkaChorobowa;
	}

	public short getSkladkaUbezpieczenie() {
		return skladkaUbezpieczenie;
	}

	public void setSkladkaUbezpieczenie(short skladkaUbezpieczenie) {
		this.skladkaUbezpieczenie = skladkaUbezpieczenie;
	}
	
	
	   
    @Override
	public boolean equals(final Object other) {
		if (!(other instanceof StawkiPlacowe)) {
			return false;
		}
		StawkiPlacowe castOther = (StawkiPlacowe) other;
		return new EqualsBuilder().append(stawkiPlacowePK,
				castOther.stawkiPlacowePK).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(stawkiPlacowePK).toHashCode();
	}
    

}
