package com.mariusz.empexp.doc.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name = "Dok_Typ_Dokumentu")

public class TypDokumentu implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @NotNull
    @Column(name = "id_typ_dokumentu",columnDefinition="tinyint")
    private Short idTypDokumentu;
    
    @NotNull(message="{notNull}")
    @Size.List({
    	@Size(min=1,message="{typDokumentu.nazwa.size.min}"),
    	@Size(max=30,message="{typDokumentu.nazwa.size.max}")
    })
    @Column(name = "nazwa",length=30)
    private String nazwa;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTypDokumentu")
    private List<Dokument> listaDokumentów;


	public TypDokumentu() {
    }

    public TypDokumentu(Short idTypDokumentu) {
        this.idTypDokumentu = idTypDokumentu;
    }

    public TypDokumentu(Short idTypDokumentu, String nazwa) {
        this.idTypDokumentu = idTypDokumentu;
        this.nazwa = nazwa;
    }

	public Short getIdTypDokumentu() {
		return idTypDokumentu;
	}

	public void setIdTypDokumentu(Short idTypDokumentu) {
		this.idTypDokumentu = idTypDokumentu;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public List<Dokument> getListaDokumentów() {
		return listaDokumentów;
	}

	public void setListaDokumentów(List<Dokument> listaDokumentów) {
		this.listaDokumentów = listaDokumentów;
	}
    

    @Override
	public boolean equals(final Object other) {
		if (!(other instanceof TypDokumentu)) {
			return false;
		}
		TypDokumentu castOther = (TypDokumentu) other;
		return new EqualsBuilder().append(idTypDokumentu,
				castOther.idTypDokumentu).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(idTypDokumentu).toHashCode();
	}
	
}

