package com.spring.backoffice.model;
import jdk.nashorn.internal.ir.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import javax.persistence.*;

@Entity
@Immutable
@Table(name = "`signalement_statut`")
@Subselect("SELECT  nomStatut,\n" +
        "        count(idRegion) AS Nombre\n" +
        "FROM signalement_statut\n" +
        "GROUP BY nomStatut ")
public class StatStatut {

    @Id

    private String nomstatut;
    private int nombre;

    public StatStatut() {
    }

    public StatStatut(String nomstatut, int nombre) {
        this.nomstatut = nomstatut;
        this.nombre = nombre;
    }

    public String getNomstatut() {
        return nomstatut;
    }

    public void setNomstatut(String nomstatut) {
        this.nomstatut = nomstatut;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }
}
