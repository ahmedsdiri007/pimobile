/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.ScaleImageLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.layouts.Layout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;

/**
 *
 * @author hp
 */
public class BackForm extends Form {
     public BackForm() {
         super(new BorderLayout());
            getTitleArea().setUIID("Container");
        setUIID("Back");
  // add(BorderLayout.NORTH, new Label(res.getImage("logoTabaani.png"), "LogoLabel"));
    Button next0 = new Button("Manage Users");
     
     Button next = new Button("Manage Hotel Reservation");
     
     Button next1 = new Button("Manage restaurant reservation");
     
     Button next2 = new Button("Manage transport reservation");
     
     
     Button next3 = new Button("Manage complaint");

   

    
        //To change body of generated methods, choose Tools | Templates.
        next0.addActionListener((e)->{
     new Afficheruser().show();
 });


     
}   
    public void show() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    
}



   


     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
    

