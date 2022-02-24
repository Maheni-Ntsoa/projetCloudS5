package com.spring.backoffice.model;

import org.hibernate.annotations.Subselect;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@org.hibernate.annotations.Immutable
@Table(name = "`signalement_complet`")
@Subselect(" SELECT  id,\n" +
        "        idClient,\n" +
        "        idTypeSignalement,\n" +
        "        idRegion,\n" +
        "        idStatut,\n" +
        "        nom,\n" +
        "        prenom,\n" +
        "        email,\n" +
        "        dateHeure,\n" +
        "        designation,\n" +
        "        typeSignalement,\n" +
        "        nomRegion,\n" +
        "        nomStatut\n" +
        "    FROM signalement_complet\n" +
        "    GROUP BY id, idClient, idTypeSignalement,\n" +
        "            idRegion, idStatut, nom, prenom, email,\n" +
        "            dateHeure, designation,\n" +
        "            typeSignalement, nomRegion, nomStatut ")
public class SignalementComplet {

    @Id
    private Long id;
    private Long idclient;
    private Long idtypesignalement;
    private Long idregion;
    private Long idstatut;
    private String nom;
    private String prenom;
    private String email;
    private String dateheure;
    private String designation;
    private String typesignalement;
    private String nomregion;
    private String nomstatut;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdclient() {
        return idclient;
    }

    public void setIdclient(Long idclient) {
        this.idclient = idclient;
    }

    public Long getIdtypesignalement() {
        return idtypesignalement;
    }

    public void setIdtypesignalement(Long idtypesignalement) {
        this.idtypesignalement = idtypesignalement;
    }

    public Long getIdregion() {
        return idregion;
    }

    public void setIdregion(Long idregion) {
        this.idregion = idregion;
    }

    public Long getIdstatut() {
        return idstatut;
    }

    public void setIdstatut(Long idstatut) {
        this.idstatut = idstatut;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateheure() {
        return dateheure;
    }

    public void setDateheure(String dateheure) {
        this.dateheure = dateheure;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getTypesignalement() {
        return typesignalement;
    }

    public void setTypesignalement(String typesignalement) {
        this.typesignalement = typesignalement;
    }

    public String getNomregion() {
        return nomregion;
    }

    public void setNomregion(String nomregion) {
        this.nomregion = nomregion;
    }

    public String getNomstatut() {
        return nomstatut;
    }

    public void setNomstatut(String nomstatut) {
        this.nomstatut = nomstatut;
    }
}
