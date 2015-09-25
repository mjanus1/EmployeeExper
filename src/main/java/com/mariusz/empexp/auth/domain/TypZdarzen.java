package com.mariusz.empexp.auth.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;

@Entity
@Table(name = "Typ_Zdarzen")
@NamedQueries({
    @NamedQuery(name = "AuthTypZdarzen.findAll", query = "SELECT a FROM AuthTypZdarzen a")})
public class TypZdarzen implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_typ_zdarzenia")
    private Long idTypZdarzenia;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "opis")
    private String opis;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTypZdarzenia")
    private List<Zdarzenia> listaZdarzen;

   
	public TypZdarzen() {
    }

    public TypZdarzen(Long idTypZdarzenia) {
        this.idTypZdarzenia = idTypZdarzenia;
    }

    public TypZdarzen(Long idTypZdarzenia, String opis) {
        this.idTypZdarzenia = idTypZdarzenia;
        this.opis = opis;
    }

	public Long getIdTypZdarzenia() {
		return idTypZdarzenia;
	}

	public void setIdTypZdarzenia(Long idTypZdarzenia) {
		this.idTypZdarzenia = idTypZdarzenia;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public List<Zdarzenia> getListaZdarzen() {
		return listaZdarzen;
	}

	public void setListaZdarzen(List<Zdarzenia> listaZdarzen) {
		this.listaZdarzen = listaZdarzen;
	}
    
    
	 @Override
		public boolean equals(final Object other) {
			if (!(other instanceof TypZdarzen)) {
				return false;
			}
			TypZdarzen castOther = (TypZdarzen) other;
			return new EqualsBuilder().append(idTypZdarzenia,
					castOther.idTypZdarzenia).isEquals();
		}

		@Override
		public int hashCode() {
			return new HashCodeBuilder().append(idTypZdarzenia).toHashCode();
		}

}
