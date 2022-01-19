package com.spring.backoffice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Region")
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nomregion")
    private String nomregion;

    public Region() {
    }

    public Region(String nomregion) {
        this.nomregion = nomregion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomregion() {
        return nomregion;
    }

    public void setNomregion(String nomregion) {
        this.nomregion = nomregion;
    }
}
