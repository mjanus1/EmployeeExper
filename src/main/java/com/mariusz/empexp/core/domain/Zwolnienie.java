package com.mariusz.empexp.core.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name = "Core_Zwolnienie")

public class Zwolnienie implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_zwolnienie")
    private Integer idZwolnienie;
    
    @NotNull(message="{notNull}")
    @Column(name = "data_od")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataOd;
    
    @NotNull(message="{notNull}")
    @Column(name = "data_do")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataDo;
    
    @NotNull(message="{notNull}")
    @Size(min = 1, max = 500)
    @Size.List({
    	@Size(min=10,message="{zwolnienie.opis.size.min}"),
    	@Size(max=500 ,message="{zwolnienie.opis.size.max}")
    })
    @Column(name = "opis",length=500)
    private String opis;
  
    @OneToOne(optional = false)
    @JoinColumn(name = "id_typ_zwolnienia")
    private TypZwolnienia idTypZwolnienia;
  
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_pracownik")
    private Pracownik idPracownik;
    


	public Zwolnienie() {
    }

    public Zwolnienie(Integer idZwolnienie) {
        this.idZwolnienie = idZwolnienie;
    }

    public Zwolnienie(Integer idZwolnienie, Date dataOd, Date dataDo, String opis) {
        this.idZwolnienie = idZwolnienie;
        this.dataOd = dataOd;
        this.dataDo = dataDo;
        this.opis = opis;
    }

	public Integer getIdZwolnienie() {
		return idZwolnienie;
	}

	public void setIdZwolnienie(Integer idZwolnienie) {
		this.idZwolnienie = idZwolnienie;
	}

	public Date getDataOd() {
		return dataOd;
	}

	public void setDataOd(Date dataOd) {
		this.dataOd = dataOd;
	}

	public Date getDataDo() {
		return dataDo;
	}

	public void setDataDo(Date dataDo) {
		this.dataDo = dataDo;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public TypZwolnienia getIdTypZwolnienia() {
		return idTypZwolnienia;
	}

	public void setIdTypZwolnienia(TypZwolnienia idTypZwolnienia) {
		this.idTypZwolnienia = idTypZwolnienia;
	}

	public Pracownik getIdPracownik() {
		return idPracownik;
	}

	public void setIdPracownik(Pracownik idPracownik) {
		this.idPracownik = idPracownik;
	}
    
    

    @Override
	public boolean equals(final Object other) {
		if (!(other instanceof Zwolnienie)) {
			return false;
		}
		Zwolnienie castOther = (Zwolnienie) other;
		return new EqualsBuilder().append(idZwolnienie, castOther.idZwolnienie)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(idZwolnienie).toHashCode();
	}
	
}
