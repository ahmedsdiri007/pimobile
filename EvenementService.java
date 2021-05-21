/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resto.service;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.ParseException;
import com.codename1.ui.events.ActionListener;
import com.resto.Entity.Evenement;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ghassen
 */
public class EvenementService {
         ArrayList<Evenement> listevenement = new ArrayList<>();
   ArrayList<Evenement> listevenementone = new ArrayList<>(); 
    public ArrayList<Evenement> EvenementParseJson(String json) throws ParseException {

        ArrayList<Evenement> listEvenement1 = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();

            Map<String, Object> experiences = j.parseJSON(new CharArrayReader(json.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) experiences.get("root");

            for (Map<String, Object> obj : list) {

                Evenement e = new Evenement();
               // float id = Float.parseFloat(obj.get("idExperience").toString());
              
               float id = Float.parseFloat(obj.get("idEvent").toString());
                
                 
                 e.setId_event((int) id);
                
                //e.set((int) id);
                e.setNomevent(obj.get("nomevent").toString());
            
                 
                listEvenement1.add(e);

            }

        } catch (IOException ex) {
        }
         //System.out.println(listLivre1);
        return listEvenement1;
    }
     
     public ArrayList<Evenement> getListEvenement() {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://127.0.0.1:8001/listevenement");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                EvenementService sc = new EvenementService();
                try {
                    listevenement = sc.EvenementParseJson(new String(con.getResponseData()));
                } catch (ParseException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listevenement;
    
    }
}
