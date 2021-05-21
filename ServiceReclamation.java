/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.services;

import com.mycompany.entities.Reclamation;
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
import com.mycompany.utils.Statics;
import com.resto.utils.statics;
import com.resto.Entity.resto;
import static com.resto.service.ReservationService.resultOk;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
 *
 * @author HP
 */
public class ServiceReclamation {
    // singleton
    public static ServiceReclamation instance = null;
    // initialisation connection request
    private ConnectionRequest req;
    public static ServiceReclamation getInstance()
    {if (instance == null) 
        instance = new ServiceReclamation(); 
    return instance;}
public ServiceReclamation()
{  req= new ConnectionRequest();
}
public void ajoutReclamation(Reclamation reclamation)
{String url= Statics.BASE_URL+"/addReclamation?objet="+reclamation.getObjet()+"&title="+reclamation.getTitle()+"&description="+reclamation.getDescription();
  System.out.println(url);
         req.setUrl(url);
        req.addResponseListener((e)-> { String str = new String(req.getResponseData());
        System.out.println("data == "+str);
         
      });
         NetworkManager.getInstance().addToQueueAndWait(req);
    
                }
     
public ArrayList<Reclamation>affichageReclamations() {
    ArrayList<Reclamation> result = new ArrayList<> ();
 String url = Statics.BASE_URL+"/displayReclamations"; 
        req.setUrl(url);
       System.out.println(url);

         req.addResponseListener(new ActionListener<NetworkEvent>(){
             @Override
             public void actionPerformed(NetworkEvent evt) {

                 JSONParser jsonp;
                 jsonp = new JSONParser();
try {
Map<String,Object>mapRecalamtions = jsonp.parseJSON(new CharArrayReader( new String(req.getResponseData()).toCharArray()));
List<Map<String,Object>> listOfMaps = (List<Map<String,Object>>) mapRecalamtions.get("root");
for (Map<String,Object> obj: listOfMaps) {
    Reclamation rec= new Reclamation();
float id = Float.parseFloat(obj.get("id").toString());
String objet = obj.get("objet").toString();
String title = obj.get("title").toString();
String description = obj.get("description").toString();
float statut = Float.parseFloat(obj.get("statut").toString());
rec.setId((int) id);
rec.setObjet(objet);
rec.setTitle(title);
rec.setDescription(description);
rec.setStatut((int) statut);
result.add(rec);
}    
}
catch (Exception ex) { ex.printStackTrace();}
             }});
NetworkManager.getInstance().addToQueueAndWait(req);
             return result;
     }
// public Reclamation DetailReclamation( int id, Reclamation reclamation) {
// String url= Statics.BASE_URL+"/detailReclamation?"+id;
// String str= new String(req.getResponseData());
//req.setUrl(url);
// req.addResponseListener(((evt) => {
// JSONParser jsonp;
// jsonp = new JSONParser();    
// try {
// Map<String,Object>mapRecalamtions = jsonp.parseJSON(new CharArrayReader( new String (str)).toCharArray()));
// reclamation.setObjet(obj.get("obj").toString());
// reclamation.setTitle(obj.get("title").toString());
// reclamation.setDescription(obj.get("description").toString());
// reclamation.setStatut(Integer.parseint(obj.get("statut").toString());
// }catch(IOException ex) { 
// System.out.println("error related to sql"+ex.getMessage());
// }
// System.out.println("data ==="+str);
// }}
//NetworkManager.getinstance().addToQueueAndWait(req);
        
// }

     public boolean deleteReclam(int $idrec){
         String url = statics.BASE_URL+"deleteReclamation?$id="+$idrec;
         
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