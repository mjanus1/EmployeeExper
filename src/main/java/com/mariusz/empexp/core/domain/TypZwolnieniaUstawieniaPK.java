package com.mariusz.empexp.core.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Embeddable
public class TypZwolnieniaUstawieniaPK implements Serializable {
	private static final long serialVersionUID = 1L;

    @NotNull(message="{notNull}")
    @Column(name = "rok")
    private Short rok;
    
    @NotNull
    @Column(name = "id_typ_zwolnienia",columnDefinition="tinyint")
    private Short idTypZwolnienia;

  
	public TypZwolnieniaUstawieniaPK() {
    }

    public TypZwolnieniaUstawieniaPK(Short rok, Short idTypZwolnienia) {
        this.rok = rok;
        this.idTypZwolnienia = idTypZwolnienia;
    }

	public Short getRok() {
		return rok;
	}

	public void setRok(Short rok) {
		this.rok = rok;
	}

	public short getIdTypZwolnienia() {
		return idTypZwolnienia;
	}

	public void setIdTypZwolnienia(short idTypZwolnienia) {
		this.idTypZwolnienia = idTypZwolnienia;
	}
    
    
	  @Override
		public boolean equals(final Object other) {
			if (!(other instanceof TypZwolnieniaUstawieniaPK)) {
				return false;
			}
			TypZwolnieniaUstawieniaPK castOther = (TypZwolnieniaUstawieniaPK) other;
			return new EqualsBuilder().append(rok, castOther.rok)
					.append(idTypZwolnienia, castOther.idTypZwolnienia).isEquals();
		}

		@Override
		public int hashCode() {
			return new HashCodeBuilder().append(rok).append(idTypZwolnienia)
					.toHashCode();
		}

    
}
