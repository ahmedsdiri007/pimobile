/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resto.Entity;

/**
 *
 * @author Maryem Cherif
 */
public class resto {

  
    private int id_resto;
    private int nbplace;
    private float budget;
    private String nomresto;
    private String restopic;
    private int idCategorie;

    public resto(int id_resto, int nbplace, float budget, String nomresto, String restopic, int idCategorie) {
        this.id_resto = id_resto;
        this.nbplace = nbplace;
        this.budget = budget;
        this.nomresto = nomresto;
        this.restopic = restopic;
        this.idCategorie = idCategorie;
    }

    public resto(int nbplace, float budget, String nomresto, String restopic, int idCategorie) {
        this.nbplace = nbplace;
        this.budget = budget;
        this.nomresto = nomresto;
        this.restopic = restopic;
        this.idCategorie = idCategorie;
    }

     public resto(int nbplace, float budget, String nomresto, String restopic) {
        this.nbplace = nbplace;
        this.budget = budget;
        this.nomresto = nomresto;
        this.restopic = restopic;
        
    }
    public resto() {
    }

    public resto(String nomresto, float budget,int nbplace ) {
       this.nomresto = nomresto;
        this.budget = budget;
              this.nbplace = nbplace;

    }

    public int getId_resto() {
        return id_resto;
    }

    public void setId_resto(int id_resto) {
        this.id_resto = id_resto;
    }

  

    public int getNbplace() {
        return nbplace;
    }

    public void setNbplace(int nbplace) {
        this.nbplace = nbplace;
    }

    public float getBudget() {
        return budget;
    }

    public void setBudget(float budget) {
        this.budget = budget;
    }

    public String getNomresto() {
        return nomresto;
    }

    public void setNomresto(String nomresto) {
        this.nomresto = nomresto;
    }

    public String getRestopic() {
        return restopic;
    }

    public void setRestopic(String restopic) {
        this.restopic = restopic;
    }

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

   
   
}
