package com.spring.backoffice.model;

import javax.persistence.*;

@Entity
@Table(name = "Typesignalement")
public class TypeSignalement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "typesignalement")
    private String typesignalement;

    public TypeSignalement() {
    }

    public TypeSignalement(String typesignalement) {
        this.typesignalement = typesignalement;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypesignalement() {
        return typesignalement;
    }

    public void setTypesignalement(String typesignalement) {
        this.typesignalement = typesignalement;
    }
}
