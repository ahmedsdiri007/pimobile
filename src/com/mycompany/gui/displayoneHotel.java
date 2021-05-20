/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;


import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import java.io.IOException;

import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.UIBuilder;
import com.tabaani.entity.Hotel;
/**
 *
 * @author Mohamedhabib - pc
 */
public class displayoneHotel {
    Form hi = new Form("", new BoxLayout(BoxLayout.Y_AXIS));
    EncodedImage enc;
    Image imgs;
    ImageViewer imgv;
 private Resources theme;

  
    public displayoneHotel(Hotel l,Resources res)
    {
             
 
     String img=l.getImg();
    String url="http://127.0.0.1:8000/images/hotel/"+img;
        hi.getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label(l.getNom(), "Title")
                        
                )
        );
         //installSidemenu(res);
        
        hi.getToolbar().addCommandToLeftBar("", res.getImage("60577.png"),new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent evt) {
               displayHotel a = new displayHotel(res);
                a.hi.showBack();
         }
     });
       
        TextArea popupBody = new TextArea("Emplacement:"+ l.getEmplacement() + "\n" +"Tarif: "+ l.getTarif()+"dt" + "\n"+ "Contact: "+ l.getContact() + "\n"+"Categorie: "+ l.getCateg() + "\n"+"Type Service: "+ l.getTypes() + "\n"  , 8, 12);
        popupBody.setEditable(false);
         try {
            enc = EncodedImage.create("/load.png");
                    } catch (IOException ex) {
     
        }
        // Form f1 = new Form("",new BoxLayout(BoxLayout.Y_AXIS));
          Button reserver = new Button("Reserver");
          reserver.addActionListener(e -> {
        new addReservationh(l,res).show();
         
        });
        imgs = URLImage.createToStorage(enc, url, url, URLImage.RESIZE_SCALE_TO_FILL);
    
         imgv = new ImageViewer(imgs);
        Container C1= new Container( new BoxLayout(BoxLayout.Y_AXIS));
        
        C1.add(popupBody);
        Container C2= new Container(new BoxLayout(BoxLayout.Y_AXIS));
        C2.add(imgv);
       hi.add(C2);
      hi.add(C1);
      hi.add(reserver);
       
       hi.show();   
    }
     public void installSidemenu(Resources res) {
        Image selection = res.getImage("selection-in-sidemenu.png");
        
        Image inboxImage = null;
        if(isCurrentInbox()) inboxImage = selection;

        Image trendingImage = null;
        if(isCurrentTrending()) trendingImage = selection;
        
        Image calendarImage = null;
        if(isCurrentCalendar()) calendarImage = selection;
        
        Image statsImage = null;
        if(isCurrentStats()) statsImage = selection;
        
        Button inboxButton = new Button("Inbox", inboxImage);
        inboxButton.setUIID("SideCommand");
        inboxButton.getAllStyles().setPaddingBottom(0);
        Container inbox = FlowLayout.encloseMiddle(inboxButton, 
                new Label("18", "SideCommandNumber"));
        inbox.setLeadComponent(inboxButton);
        inbox.setUIID("SideCommand");
        //inboxButton.addActionListener(e -> new InboxForm().show());
        hi.getToolbar().addComponentToSideMenu(inbox);
    
   
    }
      protected boolean isCurrentInbox() {
        return false;
    }
    
    protected boolean isCurrentTrending() {
        return false;
    }

    protected boolean isCurrentCalendar() {
        return false;
    }

    protected boolean isCurrentStats() {
        return false;
    }
  
}
