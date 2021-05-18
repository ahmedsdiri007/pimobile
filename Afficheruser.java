/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.Stroke;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.RoundRectBorder;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.mycompany.gui.entities.User;
import com.mycompany.gui.services.ServiceUser;
//import static javax.swing.Spring.height;
//import static javax.swing.Spring.width;

/**
 *
 * @author hp
 */
public class Afficheruser extends Form{
        Form previous;
    public Afficheruser() {
          super("User", BoxLayout.y());
         /* 
            ImageViewer client = null;
       try {
            client = new ImageViewer(Image.createImage("/clientfront.png"));
        } catch (IOException ex) {

        }
      add(client);*/
        
        System.out.println("bbbb");
        //supp
        Button image =new Button ();
        image.setUIID("Label");
        Container cnt =BorderLayout.west(image);
        //
        for(User d1 : new ServiceUser().afficherusr() )
         { Container n = new Container(BoxLayout.y());
           SpanLabel email =  new SpanLabel ("Email : "+d1.getEmail()) ;
             System.out.println("mail="+d1.getEmail());
           SpanLabel user = new SpanLabel ("Username: "+d1.getRole());
          // Label user =  new Label ("Username:"+d1.getRole() ,Username ,"NewsTopLine2");
                    System.out.println("name="+d1.getRole());

     
     
          n.addAll(email,user);
    Stroke borderStroke = new Stroke(3, Stroke.CAP_SQUARE, Stroke.JOIN_MITER, 3);
       n.getAllStyles().setBorder(RoundRectBorder.create().
        strokeColor(0).
        strokeOpacity(120).
        stroke(borderStroke));
        
        n.getAllStyles().setMargin(10,0,35,35);
           this.add(n);
            
       // Stroke borderStroke = new Stroke(3, Stroke.CAP_SQUARE, Stroke.JOIN_MITER, 3);
       Button Delete = new Button("Delete  ");
        Delete.getAllStyles().setBgColor(0xFF0000);
        Delete.getAllStyles().setBgTransparency(200);
        Delete.getAllStyles().setFgColor(0xFFFFFF);
        Delete.getAllStyles().setBorder(RoundRectBorder.create().
        strokeColor(0xFFFFFF).
        strokeOpacity(120).
        stroke(borderStroke));
        Delete.getAllStyles().setAlignment(CENTER);
        Delete.getAllStyles().setMargin(10,0,250,300);
            
               Button Update = new Button("Update  ");
        Update.getAllStyles().setBgColor(0xFF0000);
        Update.getAllStyles().setBgTransparency(200);
       Update.getAllStyles().setFgColor(0xFFFFFF);
       Update.getAllStyles().setBorder(RoundRectBorder.create().
        strokeColor(0xFFFFFF).
        strokeOpacity(120).
        stroke(borderStroke));
   
                
         
       // boutton supprimer
       Label Supprimer =new Label(" ");
       Supprimer.setUIID("NewaTopLine");
       Style supprimerStyle =new Style (Supprimer.getUnselectedStyle());
       supprimerStyle.setFgColor(0xf21f1f);
       FontImage supprimerImage =FontImage.createMaterial(FontImage.MATERIAL_DELETE,supprimerStyle);
       Supprimer.setIcon(supprimerImage);
       Supprimer.setTextPosition(RIGHT);
     /* n.add(BorderLayout.CENTER,(BoxLayout.encloseX(Supprimer
     
      BoxLayout.encloseX(emailTxt ),
      BoxLayout.encloseX(UsernameTxt , Supprimer)
       ));*/
       
       //button modifier
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
        /*
        
       Delete.addActionListener((e)->
                {
                    System.out.println("getID="+d1.getId());
                    System.out.println("test="+ new ServiceUser().supprimerjeu(d1.getId()));
               new  ServiceJeu().supprimerjeu(d1.getId());
              new  Afficherjeux().previous.show();
                
                
                });
       
            Update.addActionListener((e)->
                {
                    System.out.println("getID="+d1.getId());
                    System.out.println("test="+ new ServiceJeu().modifierJeu(d1));
               new  ServiceJeu().modifierJeu(d1);
              new  Afficherjeux().previous.show();
                
                
                });
                
                
           
     
          addAll(Delete,Update); 
         }
       
        
       // .show();

        this.getToolbar().addCommandToLeftBar("Return", null, (evt) -> {
           previous.showBack();
        }); */
    }
    
}

    public Afficheruser(Resources rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
