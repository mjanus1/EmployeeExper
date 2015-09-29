package com.mariusz.empexp.core.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Core_Oddzial")

public class Oddzial implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @NotNull
    @Column(name = "id_oddzial")
    private Integer idOddzial;
    
    @NotNull(message="{notNull}")
    @Size.List({
    	@Size(min=3,message="{oddzial.nazwa.size.min}"),
    	@Size(max=30,message="{oddzial.nazwa.size.max}")
    })
    @Column(name = "nazwa",length=30)
    private String nazwa;
    
    @OneToOne(optional = false)
    @JoinColumn(name = "id_ceo")
    private Pracownik idCeo;
    
    
    @OneToMany(mappedBy = "idOddzialNadrzedny")
    private List<Oddzial> coreOddzialCollection;
    
    @JoinColumn(name = "id_oddzial_nadrzedny")
    @ManyToOne
    private Oddzial idOddzialNadrzedny;
    
    
    @OneToOne(optional = false)
    @JoinColumn(name = "id_adres")
    private Adres idAdres;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOddzial")
    private List<Pracownik> listaPracownikow;

    @ManyToOne
    @JoinColumn(name="id_firma")
    private Firma idFirma;
    
    
    public Oddzial() {
    }

    public Oddzial(Integer idOddzial) {
        this.idOddzial = idOddzial;
    }

    public Oddzial(Integer idOddzial, String nazwa) {
        this.idOddzial = idOddzial;
        this.nazwa = nazwa;
    }
    
    
    
}
