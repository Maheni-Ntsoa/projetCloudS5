package com.spring.backoffice.model;

import org.hibernate.annotations.Subselect;

import javax.persistence.*;

@Entity
@org.hibernate.annotations.Immutable
@Table(name = "`signalement_region`")
@Subselect("SELECT  nomregion,\n" +
        "        count(idRegion) AS Nombre\n" +
        "FROM signalement_region\n" +
        "GROUP BY nomRegion ")
public class StatRegion {

    @Id

    private String nomregion;
    private int nombre;

    public StatRegion() {
    }

    public StatRegion(String nomregion, int nombre) {
        this.nomregion = nomregion;
        this.nombre = nombre;
    }


    public String getNomregion() {
        return nomregion;
    }

    public void setNomregion(String nom) {
        this.nomregion = nom;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }
}
