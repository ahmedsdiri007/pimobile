/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabaani.service;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;

import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.ParseException;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.codename1.io.JSONParser;
import com.codename1.io.MultipartRequest;

import com.tabaani.entity.Hotel;
/**
 *
 * @author Ahmed Sdiri
 */
public class HotelService {
     ArrayList<Hotel> listHotel = new ArrayList<>();
 //  ArrayList<Hotel> listlivreone = new ArrayList<>(); 
    public ArrayList<Hotel> HotelParseJson(String json) throws ParseException {

        ArrayList<Hotel> listHotel1 = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();

            Map<String, Object> experiences = j.parseJSON(new CharArrayReader(json.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) experiences.get("root");

            for (Map<String, Object> obj : list) {

                Hotel e = new Hotel();
               // float id = Float.parseFloat(obj.get("idExperience").toString());
              
                float id = Float.parseFloat(obj.get("idHotel").toString());
                float prix = Float.parseFloat(obj.get("tarif").toString());
         
                 e.setId_hotel((int) id);
                //e.set((int) id);
                e.setNom(obj.get("nom").toString());
                e.setEmplacement(obj.get("emplacement").toString());
                e.setContact(obj.get("contact").toString());
           
                e.setTarif((int)prix);
                e.setCateg(obj.get("categ").toString());
                e.setTypes(obj.get("type").toString());
                 e.setImg(obj.get("imageName").toString());
                 
                listHotel1.add(e);

            }

        } catch (IOException ex) {
        }
         //System.out.println(listLivre1);
        return listHotel1;
    }
     
     public ArrayList<Hotel> getListHotel() {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://127.0.0.1:8000/mobile/hotels");

        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                HotelService hs = new HotelService() ;
                try {
                    listHotel = hs.HotelParseJson(new String(con.getResponseData()));
                } catch (ParseException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listHotel;
    
    }
}
