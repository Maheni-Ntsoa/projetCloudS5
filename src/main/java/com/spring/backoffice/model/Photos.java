package com.spring.backoffice.model;

import org.bson.types.Binary;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;

@Document(collection = "photos")
public class Photos {
    @Id
    private String id;

    @Field("idSignalement")
    private String idSignalement;

    @Field("idClient")
    private String idclient;

    @Field("photos")
    private Binary[] photos;

    public Photos() {
    }

    public Photos(String idSignalement, String idclient, Binary[] photos) {
        this.idSignalement = idSignalement;
        this.idclient = idclient;
        this.photos = photos;
    }

    public String getIdSignalement() {
        return idSignalement;
    }

    public void setIdSignalement(String idSignalement) {
        this.idSignalement = idSignalement;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdclient() {
        return idclient;
    }

    public void setIdclient(String idclient) {
        this.idclient = idclient;
    }

    public Binary[] getPhotos() {
        return photos;
    }

    public void setPhotos(Binary[] photos) {
        this.photos = photos;
    }
}
