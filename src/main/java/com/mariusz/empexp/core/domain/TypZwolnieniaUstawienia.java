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
@Table(name = "Core_Typ_Zwolnienia_Ustawienia")

public class TypZwolnieniaUstawienia implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected TypZwolnieniaUstawieniaPK typZwolnieniaUstawieniaPK;
    
    @NotNull(message="{notNull}")
    @Column(name = "liczba_dni_wolnych",columnDefinition="tinyint")
    private Short liczbaDniWolnych;
    
    @NotNull(message="{notNull}")
    @Column(name = "platnosc_procent",columnDefinition="tinyint")
    private short platnoscProcent;
    


	public TypZwolnieniaUstawienia() {
    }


	public TypZwolnieniaUstawienia(
			TypZwolnieniaUstawieniaPK typZwolnieniaUstawieniaPK,
			Short liczbaDniWolnych, short platnoscProcent) {
		super();
		this.typZwolnieniaUstawieniaPK = typZwolnieniaUstawieniaPK;
		this.liczbaDniWolnych = liczbaDniWolnych;
		this.platnoscProcent = platnoscProcent;
	}


	public TypZwolnieniaUstawieniaPK getTypZwolnieniaUstawieniaPK() {
		return typZwolnieniaUstawieniaPK;
	}


	public void setTypZwolnieniaUstawieniaPK(
			TypZwolnieniaUstawieniaPK typZwolnieniaUstawieniaPK) {
		this.typZwolnieniaUstawieniaPK = typZwolnieniaUstawieniaPK;
	}


	public Short getLiczbaDniWolnych() {
		return liczbaDniWolnych;
	}


	public void setLiczbaDniWolnych(Short liczbaDniWolnych) {
		this.liczbaDniWolnych = liczbaDniWolnych;
	}


	public short getPlatnoscProcent() {
		return platnoscProcent;
	}


	public void setPlatnoscProcent(short platnoscProcent) {
		this.platnoscProcent = platnoscProcent;
	}

    
	 @Override
		public boolean equals(final Object other) {
			if (!(other instanceof TypZwolnieniaUstawienia)) {
				return false;
			}
			TypZwolnieniaUstawienia castOther = (TypZwolnieniaUstawienia) other;
			return new EqualsBuilder().append(typZwolnieniaUstawieniaPK,
					castOther.typZwolnieniaUstawieniaPK).isEquals();
		}


		@Override
		public int hashCode() {
			return new HashCodeBuilder().append(typZwolnieniaUstawieniaPK)
					.toHashCode();
		}

    

}
