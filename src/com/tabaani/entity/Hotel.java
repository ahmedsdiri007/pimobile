/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabaani.entity;

/**
 *
 * @author Ahmed Sdiri
 */
public class Hotel {
    private int id_hotel; 
     private String nom;
      private String emplacement ; 
        private String contact ; 
       private float tarif ; 
       private String  img;
       private String categ;
       private String types;

    public Hotel(int id_hotel, String nom, String emplacement, String contact, float tarif, String img, String categ, String types) {
        this.id_hotel = id_hotel;
        this.nom = nom;
        this.emplacement = emplacement;
        this.contact = contact;
        this.tarif = tarif;
        this.img = img;
        this.categ = categ;
        this.types = types;
    }

    public String getCateg() {
        return categ;
    }

    public void setCateg(String categ) {
        this.categ = categ;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public Hotel(String nom, String emplacement, String contact, float tarif) {
        this.nom = nom;
        this.emplacement = emplacement;
        this.contact = contact;
        this.tarif = tarif;
    }

    public Hotel(String nom, String emplacement, String contact, float tarif, String img) {
        this.nom = nom;
        this.emplacement = emplacement;
        this.contact = contact;
        this.tarif = tarif;
        this.img = img;
    }

    public Hotel(int id_hotel, String nom, String emplacement, String contact, float tarif, String img) {
        this.id_hotel = id_hotel;
        this.nom = nom;
        this.emplacement = emplacement;
        this.contact = contact;
        this.tarif = tarif;
        this.img = img;
    }

    @Override
    public String toString() {
        return "Hotel{" + "id_hotel=" + id_hotel + ", nom=" + nom + ", emplacement=" + emplacement + ", contact=" + contact + ", tarif=" + tarif + ", img=" + img + '}';
    }


    

    public Hotel() {
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

       
    public int getId_hotel() {
        return id_hotel;
    }

    public void setId_hotel(int id_hotel) {
        this.id_hotel = id_hotel;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(String emplacement) {
        this.emplacement = emplacement;
    }

    public float getTarif() {
        return tarif;
    }

    public void setTarif(float tarif) {
        this.tarif = tarif;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

   
       
        
    
}

