package com.mariusz.empexp.core.domain;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;

@Entity
@Table(name = "Stawki_Placowe")

public class StawkiPlacowe implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected StawkiPlacowePK stawkiPlacowePK;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "podatek_dochodowy")
    private int podatekDochodowy;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "skladka_chorobowa")
    private short skladkaChorobowa;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "skladka_ubezpieczenie")
    private short skladkaUbezpieczenie;
  
    /*
    @JoinColumn(name = "id_typ_umowy", referencedColumnName = "id_typ_umowy", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TypUmowy coreTypUmowy;
*/
 

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
