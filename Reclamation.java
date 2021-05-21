/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities;
/**
 *
 * @author HP
 */
public class Reclamation {
private int id;
private int iduser;
private String daterec;
private String objet;
private String title;
private String description;
private int statut;
private int idReserv;

    public Reclamation() {
    }

    public Reclamation(int iduser, String daterec, String objet, String title, String description, int statut, int idReserv) {
        this.iduser = iduser;
        this.daterec = daterec;
        this.objet = objet;
        this.title = title;
        this.description = description;
        this.statut = statut;
        this.idReserv = idReserv;
    }

    public Reclamation(int id, int iduser, String daterec, String objet, String title, String description, int statut, int idReserv) {
        this.id = id;
        this.iduser = iduser;
        this.daterec = daterec;
        this.objet = objet;
        this.title = title;
        this.description = description;
        this.statut = statut;
        this.idReserv = idReserv;
    }

    public Reclamation(String objet, String title, String description) {
        this.objet = objet;
        this.title = title;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public int getIduser() {
        return iduser;
    }

    public String getDaterec() {
        return daterec;
    }

    public String getObjet() {
        return objet;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getStatut() {
        return statut;
    }

    public int getIdReserv() {
        return idReserv;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public void setDaterec(String daterec) {
        this.daterec = daterec;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatut(int statut) {
        this.statut = statut;
    }

    public void setIdReserv(int idReserv) {
        this.idReserv = idReserv;
    }
    

}

