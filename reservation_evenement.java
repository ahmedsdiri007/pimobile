/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resto.Entity;

/**
 *
 * @author ghassen
 */
public class reservation_evenement {
     private int id;
    private int idEvenement;
    private String mail ;
  private String nom;
  private String prenom;
  private int telephone; 
  String nameevent;
 private Evenement evnt;

    public reservation_evenement( String nom, String prenom,String mail) {
        
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
    }

    public reservation_evenement() {
    }
 

    public Evenement getEvnt() {
        return evnt;
    }

    public void setEvnt(Evenement evnt) {
        this.evnt = evnt;
    }
 
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdEvenement() {
        return idEvenement;
    }

    public void setIdEvenement(int idEvenement) {
        this.idEvenement = idEvenement;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
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

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getNameevent() {
        return nameevent;
    }

    public void setNameevent(String nameevent) {
        this.nameevent = nameevent;
    }

}
