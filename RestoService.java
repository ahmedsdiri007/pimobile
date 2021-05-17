/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resto.service;

import com.resto.Entity.resto;
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
import com.codename1.util.Base64;
import com.resto.utils.statics;
import com.resto.Entity.resto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ghassen
 */
public class RestoService {
   
    
    public static RestoService instance = null ;
    
    public static boolean resultOk = true;
    
    private ConnectionRequest req;
    
    
    
    public static RestoService getInstance(){
        if(instance == null )
            instance = new RestoService();
        return instance;
    }
     public  RestoService() {
     req = new ConnectionRequest();
     }
     
     public void ajouterResto(resto resto){
         
         String url ="http://127.0.0.1:8000/add_RestoM?"+"budget="+resto.getBudget()+"&nbplace="+resto.getNbplace()+"&nomresto="+resto.getNomresto()+"&restopic="+resto.getRestopic();
         
         
         System.out.println(url);
         req.setUrl(url);
        req.addResponseListener((e)-> { String str = new String(req.getResponseData());
        System.out.println("data == "+str);
         
      });
         NetworkManager.getInstance().addToQueueAndWait(req);
    
                }
     
     public ArrayList<resto>affichageResto(){
         
         
         ConnectionRequest con = new ConnectionRequest();
        
         ArrayList<resto> result = new ArrayList<>();
         
        String url = "http://127.0.0.1:8000/list_RestoM";
         req.setUrl(url);
                  System.out.println(url);

         req.addResponseListener(new ActionListener<NetworkEvent>(){
             @Override
             public void actionPerformed(NetworkEvent evt) {

                 JSONParser jsonp;
                 jsonp = new JSONParser();
                 
                 try{
                    Map<String,Object>mapResto = jsonp.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray()));
                      List<Map<String,Object>> listOfMaps = (List<Map<String,Object>>) mapResto.get("root");
               
                for(Map<String,Object> obj : listOfMaps){
                
                    resto re = new resto();
                   
                    float nbplace = Float.parseFloat(obj.get("nbplace").toString());
                    float budget =Float.parseFloat(obj.get("budget").toString());
                    String nomresto = obj.get("nomresto").toString();

                 //  re.setId_resto((id_resto);
                    re.setNbplace((int)nbplace);
                    re.setBudget((int)budget);
                    re.setNomresto(nomresto);

                    System.out.println(re);
                    result.add(re);
                 }     
                 
                 }catch(Exception ex) {
                     ex.printStackTrace();
                 }
             }                                      


             
         });
              NetworkManager.getInstance().addToQueueAndWait(req);
             return result;
     }
     
     
     
     
     public boolean deleteResto(int id_resto){
         String url = statics.BASE_URL+"delete_RestoM?id_resto="+id_resto;
         
         req.setUrl(url);
         
         req.addExceptionListener(new ActionListener<NetworkEvent>() {
        
             @Override
             public void actionPerformed(NetworkEvent evt) {
                 
                req.removeResponseCodeListener(this);
                
             }
         });
         NetworkManager.getInstance().addToQueueAndWait(req);
                 return resultOk;
     }
     
}
     

     
