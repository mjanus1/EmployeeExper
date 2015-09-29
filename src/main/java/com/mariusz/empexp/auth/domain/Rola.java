package com.mariusz.empexp.auth.domain;


import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;

@Entity
@Table(name = "Auth_Rola")
public class Rola implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @NotNull(message="{rola.kod_roli.required}")
	@Size.List({
		@Size(min=2,message="{rola.kod_roli.size.min}"),
		@Size(max=50,message="{rola.kod_roli.size.max}")
	})
    @Column(name = "kod_roli",length=50)
    private String kodRoli;
	
    @NotNull(message="{rola.nazwa_roli.required}")
    @Size.List({
		@Size(min=2,message="{rola.nazwa_roli.size.min}"),
		@Size(max=20,message="{rola.nazwa_roli.size.max}")
	})
    @Column(name = "nazwa_roli",length=20)
    private String nazwaRoli;
    
    @NotNull(message="{notNull}")
    @Size.List({
		@Size(min=2,message="{rola.opis.size.min}"),
		@Size(max=20,message="{rola.opis.size.max}")
	})
    @Column(name = "opis",length=200)
    private String opis;
    
    
    @ManyToMany(mappedBy = "zbiorRul")
    private Set<Grupa> zbiorGrup;
    
    @ManyToMany(mappedBy ="zbiorRol")
    private Set<Uzytkownik> zbiorUzytkownikow;


	public String getKodRoli() {
		return kodRoli;
	}


	public void setKodRoli(String kodRoli) {
		this.kodRoli = kodRoli;
	}


	public String getNazwaRoli() {
		return nazwaRoli;
	}


	public void setNazwaRoli(String nazwaRoli) {
		this.nazwaRoli = nazwaRoli;
	}


	public String getOpis() {
		return opis;
	}


	public void setOpis(String opis) {
		this.opis = opis;
	}


	public Set<Grupa> getZbiorGrup() {
		return zbiorGrup;
	}


	public void setZbiorGrup(Set<Grupa> zbiorGrup) {
		this.zbiorGrup = zbiorGrup;
	}



	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof Rola)) {
			return false;
		}
		Rola castOther = (Rola) other;
		return new EqualsBuilder().append(kodRoli, castOther.kodRoli)
				.isEquals();
	}


	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(kodRoli).toHashCode();
	}

    
}
