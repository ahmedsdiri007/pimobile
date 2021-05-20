/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;


import com.codename1.admob.AdMobManager;
import com.codename1.components.ImageViewer;
import com.codename1.components.MultiButton;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import com.codename1.notifications.LocalNotification;
import com.codename1.ui.Button;
import com.codename1.ui.ButtonGroup;
import com.codename1.ui.Component;
import static com.codename1.ui.Component.BOTTOM;
import static com.codename1.ui.Component.CENTER;
import static com.codename1.ui.Component.RIGHT;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.RadioButton;
import com.codename1.ui.Slider;
import com.codename1.ui.SwipeableContainer;
import com.codename1.ui.Tabs;
import com.codename1.ui.TextArea;
import com.codename1.ui.animations.CommonTransitions;
import com.codename1.ui.geom.Rectangle;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import java.util.List;

import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.LayeredLayout;
import com.tabaani.entity.Hotel;
import com.tabaani.service.HotelService;




/**
 *
 * @author Mohamedhabib - pc
 */
public class displayHotel {
    public static int idu=3;
    public static int idl=0;
    Form hi = new Form("", new BoxLayout(BoxLayout.Y_AXIS));
    private AdMobManager admob;
    int n = 0;
//h.add(lb);
  public displayHotel(Resources res) {
             Toolbar tb = new Toolbar(true);
        hi.setToolbar(tb);
        hi.getTitleArea().setUIID("Container");
        hi.setTitle("Hotels");
        hi.getContentPane().setScrollVisible(false);
        
       
        
        Tabs swipe = new Tabs();

      

        Label spacer1 = new Label();
        Label spacer2 = new Label();
        addTab(swipe, res.getImage("hoteljpg.jpg"), spacer1,"hotels");
        swipe.setUIID("Container");
        swipe.getContentPane().setUIID("Container");
        swipe.hideTabs();
        
        ButtonGroup bg = new ButtonGroup();
        int size = Display.getInstance().convertToPixels(1);
        Image unselectedWalkthru = Image.createImage(size, size, 0);
        Graphics g = unselectedWalkthru.getGraphics();
        g.setColor(0xffffff);
        g.setAlpha(100);
        g.setAntiAliased(true);
        g.fillArc(0, 0, size, size, 0, 360);
        Image selectedWalkthru = Image.createImage(size, size, 0);
        g = selectedWalkthru.getGraphics();
        g.setColor(0xffffff);
        g.setAntiAliased(true);
        g.fillArc(0, 0, size, size, 0, 360);
        RadioButton[] rbs = new RadioButton[swipe.getTabCount()];
        FlowLayout flow = new FlowLayout(CENTER);
        flow.setValign(BOTTOM);
        Container radioContainer = new Container(flow);
        for(int iter = 0 ; iter < rbs.length ; iter++) {
            rbs[iter] = RadioButton.createToggle(unselectedWalkthru, bg);
            rbs[iter].setPressedIcon(selectedWalkthru);
            rbs[iter].setUIID("Label");
            radioContainer.add(rbs[iter]);
        }
                
        rbs[0].setSelected(true);
        swipe.addSelectionListener((i, ii) -> {
            if(!rbs[ii].isSelected()) {
                rbs[ii].setSelected(true);
            }
        });
        
        Component.setSameSize(radioContainer, spacer1, spacer2);
        hi.add(LayeredLayout.encloseIn(swipe, radioContainer));
        hi.getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Hotels", "Title")
                        
                )
        );
        addSideMenu(res);
        TextField search=new TextField();
        
     /*  hi.getToolbar().addCommandToRightBar("add", res.getImage(""), e -> {
      // new addBook().su.show();
       });*/
        HotelService hs = new HotelService();
      

     List<Hotel> list = hs.getListHotel();
          for (Hotel l:list)
      {
         String img=l.getImg();
        Image Image = res.getImage("/"+img);
//        Image.scaledSmallerRatio(20, 20);
        ImageViewer imgv = new ImageViewer(Image);
      //  System.out.println(Image);
        //  addItem(l);
     
    
hi.add(createRankWidget(l,l.getId_hotel(),l.getNom(), l.getEmplacement(),l.getTarif(),l.getContact(),l.getImg(),res));
 hi.showBack();
    }
    
  }
  
          public SwipeableContainer createRankWidget(Hotel l,int id,String name, String auteur,float price,String Contenu,String img,Resources res) {
            MultiButton button = new MultiButton(name);  
            Button reserver = new Button("Commender");
        //add(reserver);
    

      
        button.setHeight(100);

        //button.setIcon(Image);
        button.setTextLine1(name);
        button.setTextLine2(auteur);
        button.setTextLine3("" + price);
        
             
         //button.setTextLine4(Contenu);
         button.addActionListener(e->{
            
               displayoneHotel a = new displayoneHotel(l,res);
         
             //dialog(l,res);
         });
          
        reserver.addActionListener(e -> {
         
           // System.out.println(idl);
          /*  Commande ser = new Commande();
            ServiceCommande se= new ServiceCommande();
            se.Commender(id);
            Dialog.show("Sign In", "your book "+name+"has been ordered", "ok", null);*/
        });
       
    return new SwipeableContainer(FlowLayout.encloseCenterMiddle(createStarRankSlider()), 
            button);
}
private Slider createStarRankSlider() {
    Slider starRank = new Slider();

     return starRank;
}
   private void initStarRankStyle(Style s, Image star) {
    s.setBackgroundType(Style.BACKGROUND_IMAGE_TILE_BOTH);
    s.setBorder(Border.createEmpty());
    s.setBgImage(star);
    s.setBgTransparency(0);
}
       private void dialog(Hotel e,Resources res) {
       
        Dialog d = new Dialog(e.getNom());
        String img=e.getImg();
        TextArea popupBody = new TextArea( e.getEmplacement() + "\n" + e.getTarif() + "\n" + e.getContact() + "\n"  , 8, 12);
  
        popupBody.setUIID("Label");
        popupBody.setEditable(false);
        Button b = new Button("test");
        d.setLayout(new BorderLayout());
        
        d.addComponent(BorderLayout.CENTER, popupBody);
      //  d.add(BorderLayout.SOUTH,imgv);
   
        d.setTransitionInAnimator(CommonTransitions.createEmpty());
        d.setTransitionOutAnimator(CommonTransitions.createFade(300));
        Rectangle rec = new Rectangle();
        rec.setX(700);
        rec.setY(1000);
        d.showPopupDialog(rec);
    }
        private void notif()
  {
         LocalNotification n = new LocalNotification();
        n.setId("demo-notification");
        n.setAlertBody("your book has been added to your Order list");
        n.setAlertTitle("Order added!");
        n.setAlertSound("/notification_sound_bells.mp3"); //file name must begin with notification_sound


        Display.getInstance().scheduleLocalNotification(
                n,
                System.currentTimeMillis() + 10 * 1000, // fire date/time
                LocalNotification.REPEAT_MINUTE  // Whether to repeat and what frequency
        );
  }
private void addTab(Tabs swipe, Image img, Label spacer,  String commentsStr) {
        int size = Math.min(Display.getInstance().getDisplayWidth(), Display.getInstance().getDisplayHeight());
        if(img.getHeight() < size) {
            img = img.scaledHeight(size);
        }
        Label likes = new Label("");
        Style heartStyle = new Style(likes.getUnselectedStyle());
        heartStyle.setFgColor(0xff2d55);
        FontImage heartImage = FontImage.createMaterial(FontImage.MATERIAL_FAVORITE, heartStyle);
        likes.setIcon(heartImage);
        likes.setTextPosition(RIGHT);

        Label comments = new Label(commentsStr);
        FontImage.setMaterialIcon(comments, FontImage.MATERIAL_CHAT);
        if(img.getHeight() > Display.getInstance().getDisplayHeight() / 2) {
            img = img.scaledHeight(Display.getInstance().getDisplayHeight() / 2);
        }
        ScaleImageLabel image = new ScaleImageLabel(img);
        image.setUIID("Container");
        image.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
        Label overlay = new Label(" ", "ImageOverlay");
        
        Container page1 = 
            LayeredLayout.encloseIn(
                image,
                overlay,
                BorderLayout.south(
                    BoxLayout.encloseY(
                            new SpanLabel("", "LargeWhiteText"),
                            FlowLayout.encloseIn(likes, comments),
                            spacer
                        )
                )
            );

        swipe.addTab("", page1);
    }
    
     protected void addSideMenu(Resources res) {
          //   String admobId = "ca-app-pub-3940256099942544~3347511713";
        String admobId = "ca-app-pub-3940256099942544/1033173712";
        if (Display.getInstance().getPlatformName().equals("ios")) {
            admobId = "ca-app-pub-3940256099942544/1033173712";
        }

        // Note:  admobId is the ID of the target ads you want to display
        // not your admob App ID.
        // See instructions for Android and iOS below for specifying admob app ID
        // via build hints.
        admob = new AdMobManager(admobId);
        Toolbar tb = hi.getToolbar();
        Image img = res.getImage("profile-background.jpg");
        if(img.getHeight() > Display.getInstance().getDisplayHeight() / 3) {
            img = img.scaledHeight(Display.getInstance().getDisplayHeight() / 3);
        }
        ScaleImageLabel sl = new ScaleImageLabel(img);
        sl.setUIID("BottomPad");
        sl.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
        
        tb.addComponentToSideMenu(LayeredLayout.encloseIn(
                sl,
                FlowLayout.encloseCenterBottom(
                        new Label(res.getImage("profile-pic.jpg"), "PictureWhiteBackgrond"))
        ));
        
        tb.addMaterialCommandToSideMenu("Newsfeed", FontImage.MATERIAL_UPDATE, e -> new NewsfeedForm(res).show());
        tb.addMaterialCommandToSideMenu("Profile", FontImage.MATERIAL_SETTINGS, e -> new ProfileForm(res).show());
      tb.addMaterialCommandToSideMenu("Hotel", FontImage.MATERIAL_EXIT_TO_APP, e ->{
                      if (n % 2 == 0) {
                admob.loadAndShow();
               n++;
           } else {
                n++;
         displayHotel a = new displayHotel(res);
           a.hi.show();
                      }
        });
        tb.addMaterialCommandToSideMenu("Logout", FontImage.MATERIAL_EXIT_TO_APP, e -> new WalkthruForm(res).show());
          
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

 
