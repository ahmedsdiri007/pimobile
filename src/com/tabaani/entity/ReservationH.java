/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabaani.entity;

;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Ahmed Sdiri
 */
public class ReservationH {
    private int id_res;
    private int id_user;
    private int id_hotel;
    private int nb_nuit;
    private int nb_chambre;
    private String type;
    private int nb_personne;
    private Date date_res;

    public ReservationH() {
    }

    public Date getDate_res() {
        return date_res;
    }

    public void setDate_res(Date date_res) {
        this.date_res = date_res;
    }

    public ReservationH( int nb_nuit, int nb_chambre, String type, int nb_personne, Date date_res) {
      
        this.nb_nuit = nb_nuit;
        this.nb_chambre = nb_chambre;
        this.type = type;
        this.nb_personne = nb_personne;
        this.date_res = date_res;
    }

    public ReservationH(int id_res, int id_user, int id_hotel, int nb_nuit, int nb_chambre, String type, int nb_personne, Date date_res) {
        this.id_res = id_res;
        this.id_user = id_user;
        this.id_hotel = id_hotel;
        this.nb_nuit = nb_nuit;
        this.nb_chambre = nb_chambre;
        this.type = type;
        this.nb_personne = nb_personne;
        this.date_res = date_res;
    }

    public int getId_res() {
        return id_res;
    }

    public void setId_res(int id_res) {
        this.id_res = id_res;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_hotel() {
        return id_hotel;
    }

    public void setId_hotel(int id_hotel) {
        this.id_hotel = id_hotel;
    }

    public int getNb_nuit() {
        return nb_nuit;
    }

    public void setNb_nuit(int nb_nuit) {
        this.nb_nuit = nb_nuit;
    }

    public int getNb_chambre() {
        return nb_chambre;
    }

    public void setNb_chambre(int nb_chambre) {
        this.nb_chambre = nb_chambre;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNb_personne() {
        return nb_personne;
    }

    public void setNb_personne(int nb_personne) {
        this.nb_personne = nb_personne;
    }




    @Override
    public String toString() {
        return "ReservationH{" + "id_res=" + id_res + ", id_user=" + id_user + ", id_hotel=" + id_hotel + ", nb_nuit=" + nb_nuit + ", nb_chambre=" + nb_chambre + ", type=" + type + ", nb_personne=" + nb_personne + ", date_res=" + date_res + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.id_res;
        hash = 59 * hash + this.id_user;
        hash = 59 * hash + this.id_hotel;
        hash = 59 * hash + this.nb_nuit;
        hash = 59 * hash + this.nb_chambre;
        hash = 59 * hash + Objects.hashCode(this.type);
        hash = 59 * hash + this.nb_personne;
        hash = 59 * hash + Objects.hashCode(this.date_res);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ReservationH other = (ReservationH) obj;
        if (this.id_res != other.id_res) {
            return false;
        }
        if (this.id_user != other.id_user) {
            return false;
        }
        if (this.id_hotel != other.id_hotel) {
            return false;
        }
        if (this.nb_nuit != other.nb_nuit) {
            return false;
        }
        if (this.nb_chambre != other.nb_chambre) {
            return false;
        }
        if (this.nb_personne != other.nb_personne) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.date_res, other.date_res)) {
            return false;
        }
        return true;
    }
    
    
}
