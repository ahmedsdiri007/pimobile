/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resto.service;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.MultipartRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.io.rest.Response;
import com.codename1.io.rest.Rest;
import com.codename1.l10n.ParseException;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.util.Resources;
import com.codename1.util.Base64;
import com.resto.Entity.Evenement;
import com.resto.Entity.reservation_evenement;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ghassen
 */
public class ReservationService {
        public static ReservationService instance = null ;
    
    public static boolean resultOk = true;
    
    private ConnectionRequest req;
    
    
    
    public static ReservationService getInstance(){
        if(instance == null )
            instance = new ReservationService();
        return instance;
    }
     public  ReservationService() {
     req = new ConnectionRequest();
     }
         ArrayList<reservation_evenement> listreservation = new ArrayList<>();
   ArrayList<reservation_evenement> listproduitsone = new ArrayList<>();
    private Resources theme;
    public ArrayList<reservation_evenement> ReservationParseJson(String json) throws ParseException {

        ArrayList<reservation_evenement> listReservation = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();

            Map<String, Object> experiences = j.parseJSON(new CharArrayReader(json.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) experiences.get("root");

            for (Map<String, Object> obj : list) {

                reservation_evenement re = new reservation_evenement();
               // float id = Float.parseFloat(obj.get("idExperience").toString());
              
               float id = Float.parseFloat(obj.get("id").toString());
               String nom =obj.get("nom").toString();
               String prenom =obj.get("prenom").toString();
//               String nomevent =obj.get("nomevent").toString();
                 String mail =obj.get("mail").toString();
                // re.setId((int) id);
                 re.setNom(nom);
                 re.setPrenom(prenom);
                 re.setMail(mail);
               
                
                 
                listReservation.add(re);

            }

        } catch (IOException ex) {
        }
         //System.out.println(listLivre1);
        return listReservation;
    }
     
     public ArrayList<reservation_evenement> getListProduits() {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://127.0.0.1:8001/displayReserv");

        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ReservationService sp = new ReservationService();
                try {
                    listreservation = sp.ReservationParseJson(new String(con.getResponseData()));
                } catch (ParseException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listreservation;
    
    }
         /* public ArrayList<Produits> getSortProduits(String sort) {
        ConnectionRequest con = new ConnectionRequest();
        String Url="http://localhost/deboo/web/app_dev.php/mobile/sortmob"+"/"+sort;
        con.setUrl(Url);

        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ProduitsService sp = new ProduitsService();
                try {
                    listproduits = sp.ProduitsParseJson(new String(con.getResponseData()));
                } catch (ParseException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listproduits;
    
    }*/
     
      public void addproduct(reservation_evenement e,String id) {
        MultipartRequest con = new MultipartRequest();// création d'une nouvelle demande de connexion
        String Url = "http://127.0.0.1:8001/addreservation?" + "nom=" + e.getNom()+ "&prenom=" + e.getPrenom()+ "&idEvenement=" + id+ "&mail=" + e.getMail() ;// création de l'URL
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion
          
        con.addResponseListener((ee) -> {
            
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
        /*String accountSID = "AC1c6984d48d5fa4351719fb94535c7c75";
            String authToken = "92e86bff39e84440a9c7c9ef1bb90184";
            String fromPhone = "+12025194835";
            String destinationPhone = "+21658407458";

            Response<Map> SMS = Rest.post("https://api.twilio.com/2010-04-01/Accounts/" + accountSID + "/Messages.json").
                    queryParam("To", destinationPhone).
                    queryParam("From", fromPhone).
                    queryParam("Body", "Votre Produit a ete ajouter avec succes ").
                    header("Authorization", "Basic " + Base64.encodeNoNewline((accountSID + ":" + authToken).getBytes())).
                    getAsJsonMap();*/
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }
      /*public void deleteProd(int idprod) {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
        String Url = "http://localhost/deboo/web/app_dev.php/mobile/deleteprod?" + "idproduct=" + idprod;// création de l'URL
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
  //new displayProduits(theme).show();
// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }*/
}
