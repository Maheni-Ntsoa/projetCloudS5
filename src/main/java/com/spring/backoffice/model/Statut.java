package com.spring.backoffice.model;

import javax.persistence.*;

@Entity
@Table(name = "Statut")
public class Statut {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nomstatut")
    private String nomstatut;

    public Statut() {
    }

    public Statut(String nomstatut) {
        this.nomstatut = nomstatut;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomstatut() {
        return nomstatut;
    }

    public void setNomstatut(String nomstatut) {
        this.nomstatut = nomstatut;
    }
}
