/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resto.Entity;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author nour
 */
public class Evenement implements Serializable  {

    
   private int id_event;
  private int nb_place;
  private String lieux;
  private float prix;
  private String description;
  private String nomevent;
  private String eventpic;

    public Evenement() {
    }


    @Override
    public String toString() {
        return "Event{" + "id_event=" + id_event + ", nb_place=" + nb_place + ", lieux=" + lieux + ", prix=" + prix + ", description=" + description + ", nomevent=" + nomevent + ", eventpic=" + eventpic + '}';
    }

    public Evenement(String nomevent) {
        this.nomevent = nomevent;
    }
  

    public int getId_event() {
        return id_event;
    }

    public void setId_event(int id_event) {
        this.id_event = id_event;
    }

    public int getNb_place() {
        return nb_place;
    }

    public void setNb_place(int nb_place) {
        this.nb_place = nb_place;
    }

    public String getLieux() {
        return lieux;
    }

    public void setLieux(String lieux) {
        this.lieux = lieux;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNomevent() {
        return nomevent;
    }

    public void setNomevent(String nomevent) {
        this.nomevent = nomevent;
    }

    public String getEventpic() {
        return eventpic;
    }

    public void setEventpic(String eventpic) {
        this.eventpic = eventpic;
    }
 

    

    
}
