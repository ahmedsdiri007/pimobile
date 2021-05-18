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
import com.codename1.components.InfiniteProgress;
import com.codename1.components.SpanLabel;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.gui.entities.User;
import com.mycompany.gui.services.ServiceUser;
import com.sun.mail.smtp.SMTPTransport;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Account activation UI
 *
 * @author Shai Almog
 */
public class ActivateForm extends BaseForm {
TextField email;
    public ActivateForm(Resources res) {
        super(new BorderLayout());
        Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        tb.setUIID("IMGLogin");
        getTitleArea().setUIID("Container");
        Form previous = Display.getInstance().getCurrent();
        tb.setBackCommand("", e -> previous.showBack());
       setUIID("Activate");
        
        add(BorderLayout.NORTH, 
                BoxLayout.encloseY( 
                        new Label(res.getImage("oublier.png"), "LogoLabel"),      //smily.png
                        new Label("Awsome Thanks!", "LogoLabel")
                )
        );
        
        /*TextField code = new TextField("", "Enter Code", 20, TextField.PASSWORD);
        code.setSingleLineTextArea(false);
        
        Button signUp = new Button("Sign Up");
        Button resend = new Button("Resend");
        resend.setUIID("CenterLink");
        Label alreadHaveAnAccount = new Label("Already have an account?");
        Button signIn = new Button("Sign In");
        signIn.addActionListener(e -> previous.showBack());
        signIn.setUIID("CenterLink");
        
        Container content = BoxLayout.encloseY(
                new FloatingHint(code),
                createLineSeparator(),
                new SpanLabel("We've sent the confirmation code to your email. Please check your inbox", "CenterLabel"),
                resend,
                signUp,
                FlowLayout.encloseCenter(alreadHaveAnAccount, signIn)
        );
        content.setScrollableY(true);
        add(BorderLayout.SOUTH, content);
        signUp.requestFocus();
        signUp.addActionListener(e -> new NewsfeedForm(res).show());*/
      
         TextField emaill =new TextField ("","enter your password",20,TextField.ANY);
        emaill.setSingleLineTextArea(false);
        Button Validate =new Button("Validate");
        Label haveAnAcount =new Label ("Back to log in ?");
        Button signIn =new Button("Renew your password");
        signIn.addActionListener(e-> previous.showBack());
        signIn.setUIID("CenterLink");
        Container content =BoxLayout.encloseY(
              //  new Label (res.getImage("oublier.png"),"CenterLabel"),
        
        new FloatingHint (emaill),
        createLineSeparator(),
        Validate,
         FlowLayout.encloseCenter( haveAnAcount ), signIn
        );
        
       content.setScrollableY(true);
       
       add(BorderLayout.CENTER,content);
       
      Validate.requestFocus();       
       
      Validate.addActionListener((e)->{
      
      InfiniteProgress ip =new  InfiniteProgress ();
      final Dialog ipDialog =ip.showInfiniteBlocking();
      
      //Api Send mail
      sendMail (res,emaill.getText());
      ipDialog.dispose();
      Dialog.show("Password", "We have sent the password to your e-mail. please check your inbox", new Command("ok"));
      new SignInForm(res).show();
      refreshTheme();
      
      
      
      });
        
    }
   public void sendMail(Resources res,String s){
       try{
           System.out.println("ddddddddddddddddddddddddddddddddddddd");
       Properties props = new Properties();
		props.put("mail.smtp.transport.protocol", "smtp"); //SMTP protocol
		props.put("mail.smtps.host", "stmp.gmail.com"); //TLS Host
		props.put("mail.smtps.auth", "true"); //enable authentication
                System.out.println("bbbbbbbbbb");
	Session session= Session.getInstance(props, null);
        MimeMessage msg =new MimeMessage (session);
           System.out.println("cccccccccccccccccccccccccccccccccccccccc");
        msg.setFrom(new InternetAddress ("Reinatialisation mot de passe <nomEmail@domaine.com> "));
           System.out.println("LLLLLLLLLLLLLLLLLLLLLLLLLLLLLL");
           System.out.println("mail="+s);
        msg.setRecipients(Message.RecipientType.TO, s);
       msg.setSubject("Application nom : Comfirmation du");
       msg.setSentDate(new Date (System.currentTimeMillis()));
       
      ArrayList<User> mp=new ServiceUser().findmail(s);//nraj3oulou mdp
               String txt="Welcome to AppName: Enter this password:"+mp.get(0).getPassword()+" in the required field and press comfirm";
               msg.setText(txt);
               SMTPTransport st= (SMTPTransport)session.getTransport("smtps");
               
               st.connect("smtp.gmail.com",465,"eyabm17@gmail.com","71mbaye123");
               st.sendMessage(msg,msg.getAllRecipients());
               System.out.println("server response :"+st.getLastServerResponse());
       }
       catch(Exception e){
       e.printStackTrace();
       }
   } 
}
