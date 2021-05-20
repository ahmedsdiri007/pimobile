/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabaani.service;

import com.codename1.io.MultipartRequest;
import com.codename1.io.NetworkManager;
import com.codename1.io.rest.Response;
import com.codename1.io.rest.Rest;
import com.codename1.util.Base64;

import com.tabaani.entity.ReservationH;
import java.util.Map;

/**
 *
 * @author Ahmed Sdiri
 */
public class ReservationHSerivce {
    public void addReservation(int idHotel ,ReservationH e) {
        MultipartRequest con = new MultipartRequest();// création d'une nouvelle demande de connexion
        String Url = "http://127.0.0.1:8000/mobile/newreserv?"+"idhotel="+idHotel + "&nbn=" + e.getNb_nuit()+ "&nbc=" + e.getNb_chambre() + "&type=" + e.getType() + "&nbp=" + e.getNb_personne() + "&date=" + e.getDate_res().toString() ;// création de l'URL
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion
          
        con.addResponseListener((ee) -> {
            
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
      /*   String accountSID = "AC308ef3aad8e93d42ad0c0b4fffc2f7e8";
            String authToken = "f0a3d6cb0a0350809d52ad045d717fba";
            String fromPhone = "+12562039254";
            String destinationPhone = "+21650750929";

            Response<Map> SMS = Rest.post("https://api.twilio.com/2010-04-01/Accounts/" + accountSID + "/Messages.json").
                    queryParam("To", destinationPhone).
                    queryParam("From", fromPhone).
                    queryParam("Body", "Votre Reservation a été effectué avec succes ").
                    header("Authorization", "Basic " + Base64.encodeNoNewline((accountSID + ":" + authToken).getBytes())).
                    getAsJsonMap();*/
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }    
}
