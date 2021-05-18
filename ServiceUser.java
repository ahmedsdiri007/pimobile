/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Dialog;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.util.Resources;
import com.mycompany.gui.Afficheruser;
import com.mycompany.gui.entities.User;
import com.mycompany.gui.utils.DataSource;
import com.mycompany.gui.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author hp
 */
public class ServiceUser {
    String json;
public ArrayList<User> users;
      
    private ConnectionRequest request;

    private boolean responseResult;
       
  public ServiceUser() {
        request = DataSource.getInstance().getRequest();
    }
   
  
     
  
    
    //Affichage    
     public ArrayList<User> parseJeu(String jsonText) {
        try {
            users = new ArrayList<>();

            JSONParser jp = new JSONParser();
            Map<String, Object> demandeListJson = jp.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
          //   public DemandeTaxi(int id, int iduser, String lieudepart, String lieuarrive, String region, String periode, String username, String dated, int etat, float prix) {

            List<Map<String, Object>> list = (List<Map<String, Object>>) demandeListJson.get("root");
            
            for (Map<String, Object> obj : list) {
                // Map<String, Object> cours = ( Map<String, Object> ) obj.get("cours");
                  //int iduser=(int)Float.parseFloat(userlist.get("id").toString());
                 // String username = userlist.get("username").toString();
                 
           String email = obj.get("email").toString();
           String username= obj.get("role").toString();
          
           users.add(new User (email,username));
             
               
            }

        } catch (IOException ex) {
        }
          
        return users ;
    }
     
     
     
     
        public ArrayList<User> parseUser(String jsonText,String email) {
        try {
            System.out.println("jsontext="+jsonText);
            users = new ArrayList<>();
int i=0;
            JSONParser jp = new JSONParser();
            System.out.println("1");
            Map<String, Object> demandeListJson = jp.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            System.out.println("2222");
            
          //   public DemandeTaxi(int id, int iduser, String lieudepart, String lieuarrive, String region, String periode, String username, String dated, int etat, float prix) {

            List<Map<String, Object>> list = (List<Map<String, Object>>) demandeListJson.get("root");
            System.out.println("List="+list.get(i));
            System.out.println("3333");
            for (Map<String, Object> obj : list) {
                System.out.println("4444444444444444");
                // Map<String, Object> cours = ( Map<String, Object> ) obj.get("cours");
                  //int iduser=(int)Float.parseFloat(userlist.get("id").toString());
                 // String username = userlist.get("username").toString();
                 
           if(email.equals(obj.get("email").toString()));
           { String password= obj.get("password").toString();
          
           users.add(new User (email,"",password));
               System.out.println("user="+email+"/"+password);
           }
       
                System.out.println("i="+i);
                    i++;
            }

        } catch (IOException ex) {
        }
          
        return users ;
    }
     
     
     
     
     
      //Affichage    

     
     
     
     
     
    
    public ArrayList<User> afficherusr() {
////String url="newjeuxmobile?password="+d.get()+"&description="+d.getDescription()+"&topscore="+d.getTopscore()+"&diff="+d.getDiff()+"&source="+d.getSource()+"&cours="+d.getCours();

        request.setUrl("http://127.0.0.1:8000/user/AfficherUserMobile"); 
        request.setPost(false);
        System.out.println("here");
        request.addResponseListener(new ActionListener<NetworkEvent>() {
          
            @Override
            public void actionPerformed(NetworkEvent evt) {
                users= parseJeu(new String(request.getResponseData()));
                System.out.println(users.get(0).getEmail());
                System.out.println(users.get(0).getRole());
                request.removeResponseListener(this);
            }
        });
    
        NetworkManager.getInstance().addToQueueAndWait(request);
System.out.println("doneeeeee");
        return users;
    }
    
     
  
    
//Add Account
 /* public boolean register (User u) {
        String url = Statics.BASE_URL + "/user/registerM new?email=" + u.getEmail()
                + "&username=" + u.getUsername() + "&password=" + u.getPassword();
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }    
  */  
    
//Edit Account
  /*
    public boolean editUser(User u) {
        String url = Statics.BASE_URL + "/editUsersM ?id=" + u.getId() + "&email=" + u.getEmail()
                + "&username=" + u.getUsername() + "&password=" + u.getPassword();
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }

    
  //Delete Account
    
   public boolean deleteProduct(int id) {
        String url = Statics.BASE_URL + "/deleteM ?id=" + id;
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }  
    */
  public boolean  signin (String mail ,  String password , Resources res ){
   
   String url = "http:/127.0.0.1:8000/user/signinm?email="+mail+"&password="+password;
      System.out.println("url="+url);


        request.setUrl(url);
        request.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                responseResult = request.getResponseCode() == 200; // Code HTTP 200 OK
                request.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(request);

        return responseResult;
       
   } 
   
 // Ajout un compte
   
   public boolean  signup (TextField username , TextField email ,TextField password ,TextField comfirmPassword , Resources res ){
   
   String url = "http://localhost/final/final/jobs/public/index.php/user/signupm?username="+username.getText().toString()
           +"&email="+email.getText().toString()+"&password="+password.getText().toString();
      System.out.println("url="+url);


        request.setUrl(url);
        request.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                responseResult = request.getResponseCode() == 200; // Code HTTP 200 OK
                request.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(request);

        return responseResult;
       
   } 
   
 /*  
 //Login
 public boolean  signin (String username ,  String password , Resources rs) {
  //http://localhost/final/final/jobs/public/index.php/
 String url =Statics.BASE_URL+"/user/signinm?email="+username+"&password="+password;
 
      System.out.println("url="+url);
      req.setUrl(url);
         request.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                responseResult = request.getResponseCode() == 200; // Code HTTP 200 OK
                request.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(request);

        return responseResult;
    }
         
 */
 
 //mdp oublié
   /*
 public String getPasswordByEmail(String email, Resources rs){

String url = Statics.BASE_URL+"/user/getPasswordByEmail?email="+email;
 request=new ConnectionRequest(url,false);
  request.setUrl(url);
 
 String json2;
  request.addResponseListener((e)->{    
     JSONParser j= new JSONParser ();
      json =new String (request.getResponseData())+"";
              

     try{
               System.out.println("data=="+json);
                     Map<String,Object> password = j.parseJSON(new CharArrayReader(json.toCharArray()));
                              
     }
     
     catch(Exception ex){
      ex.printStackTrace();
     }
     NetworkManager.getInstance().addToQueueAndWait(request);   
     
 });
 
 
 return json;}
 */
 
 
             public ArrayList<User> findmail(String email) {
       String url = Statics.BASE_URL+"/user/getPasswordByEmail?email="+email;
                 System.out.println("Url="+url);
        request.setUrl(url);
        request.setPost(false);
        request.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                
                users= parseUser(new String(request.getResponseData()),email);
                request.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(request);

        return users;
    }
 
 
 

 
 }
 
 
 
  /****
    nom=my.get("surname").toString();
                                    prenom=my.get("name").toString();
                                    usr_type=my.get("roles").toString();
                                    username=name;
                                    id=Integer.parseInt(my.get("idu").toString());
                                    System.out.println(usr_type+id);
                                    Dialog.show("Authentification", "                                            SUCCESS","OK",null);
                                    if(usr_type.equals("a:1:{i:0;s:11:\"ROLE_CLIENT\";}"))
                                    {
                                        new ProfileClientForm(theme).show();
                                    }
                                    else if(usr_type.equals("a:1:{i:0;s:17:\"ROLE_GESTIONNAIRE\";}"))
                                    {
                                        new ProfileGestionnaireForm(theme).show();
                                    }
   /******/
   
   
   
    
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  
    

