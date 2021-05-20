/*
 * Copyright (c) 2016, Codename One
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated 
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation 
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, 
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions 
 * of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A 
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF 
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE 
 * OR THE USE OR OTHER DEALINGS IN THE SOFTWARE. 
 */

package com.mycompany.gui;

import com.codename1.components.FloatingHint;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import com.tabaani.entity.Hotel;
import com.tabaani.entity.ReservationH;
import com.tabaani.service.ReservationHSerivce;
import java.util.Date;
import static jdk.nashorn.internal.objects.NativeJava.type;

/**
 * Signup UI
 *
 * @author Shai Almog
 */
public class addReservationh extends BaseForm {

    public addReservationh(Hotel ho ,Resources res) {
        super(new BorderLayout());
        Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        tb.setUIID("Container");
        getTitleArea().setUIID("Container");
        Form previous = Display.getInstance().getCurrent();
        tb.setBackCommand("", e -> previous.showBack());
        setUIID("SignIn");
                
      TextField nbn = new TextField("", "nombre de nuit", 201, TextField.NUMERIC);
       
        
         TextField nbc = new TextField("", "nombre de chambre", 201, TextField.NUMERIC);
       
    
         Picker dater = new Picker();
  
       
        TextField nbp = new TextField("", "nombre de personne", 201, TextField.NUMERIC);
     
       
        //TextField date = new TextField("", "date", 45, TextField.ANY);
 
     //   date.setHint("date");
      ComboBox<String> type= new ComboBox<>();
      type.addItem("adultes");
      type.addItem("enfants + adultes");
       type.addItem("conference");
        nbn.setSingleLineTextArea(false);
        nbc.setSingleLineTextArea(false);
        
        nbp.setSingleLineTextArea(false);
        Button next = new Button("Reserver");
        Button signIn = new Button("Sign In");
        signIn.addActionListener(e -> previous.showBack());
        signIn.setUIID("Link");
        Label alreadHaveAnAccount = new Label("Already have an account?");
        
        Container content = BoxLayout.encloseY(
                new Label("Reservation", "LogoLabel"),
                new FloatingHint(nbp),
                createLineSeparator(),
                new FloatingHint(nbn),
                createLineSeparator(),
                new FloatingHint(nbc),
                createLineSeparator(),
                dater,
                createLineSeparator(),
                type,
                createLineSeparator()
        );
        content.setScrollableY(true);
        add(BorderLayout.CENTER, content);
        add(BorderLayout.SOUTH, BoxLayout.encloseY(
                next
                
        ));
        next.requestFocus();
        next.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent evt) {
      int nbrnuit =  Integer.parseInt(nbn.getText());
      int nbrc =  Integer.parseInt(nbc.getText());
      String typer= type.getSelectedItem();
       int nombrep =Integer.parseInt( nbp.getText());
       Date datereservation=dater.getDate();
     
        
                    
              ReservationHSerivce rs = new ReservationHSerivce();
              ReservationH u= new ReservationH(nbrnuit,nbrc,typer,nombrep,datereservation);
              System.out.println(ho.getId_hotel());
              rs.addReservation(ho.getId_hotel(),u);
              System.out.println(u);
              nbn.clear();
              nbc.clear();
           //   type.clear();
              nbp.clear();
              nbp.clear();
              //cmdp.clear();
              com.codename1.messaging.Message m = new com.codename1.messaging.Message("voici votre reservation \n"
                      +"nombre de nuit: "+ nbrnuit+"\n"
                      +"nombre de chambre: "+nbrc +"\n" 
                      +"type: "+typer+"\n"
                      +"nombre de personne: "+nombrep+"\n"
                      +"date de reservation: "+datereservation      );
                                 Display.getInstance().sendMessage(new String[] {"ahmedradhi.sdiri@esprit.tn"}, "Menus", m);
               new displayHotel(res).hi.showBack();
              
             }  
        
      });
       
    };
    }
    

