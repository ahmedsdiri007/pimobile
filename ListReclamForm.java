/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.ui.util.Resources;
import com.codename1.ui.util.Resources;
import com.codename1.components.InfiniteProgress;
import com.codename1.components.MultiButton;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import static com.codename1.io.Log.e;
import com.codename1.ui.Button;
import com.codename1.ui.ButtonGroup;
import com.codename1.ui.Component;
import static com.codename1.ui.Component.BOTTOM;
import static com.codename1.ui.Component.CENTER;
import static com.codename1.ui.Component.LEFT;
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
import com.codename1.ui.Tabs;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.animations.CommonTransitions;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Rectangle;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.mycompany.entities.Reclamation;
import com.mycompany.services.ServiceReclamation;
import com.resto.Entity.resto;
import com.resto.service.RestoService;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author HP
 */
public final class ListReclamForm extends BaseForm{
    Form current;
    
    public ListReclamForm(Resources res){
        super("Newsfeed",BoxLayout.y());
        
        Toolbar tb = new Toolbar(true);
        current = this;
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Mes Reclamations");
        getContentPane().setScrollVisible(false);
        
        
        
        tb.addSearchCommand(e -> {
            
        });
        
        Tabs swipe = new Tabs();
        
        Label s1 = new Label();
       Label s2 = new Label();
       

       addTab(swipe, s1, res.getImage("res.png"),"","",res);
        
        //
         
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
        for (int iter = 0; iter < rbs.length; iter++) {
            rbs[iter] = RadioButton.createToggle(unselectedWalkthru, bg);
            rbs[iter].setPressedIcon(selectedWalkthru);
            rbs[iter].setUIID("Label");
            radioContainer.add(rbs[iter]);
        }

        rbs[0].setSelected(true);
        swipe.addSelectionListener((i, ii) -> {
            if (!rbs[ii].isSelected()) {
                rbs[ii].setSelected(true);
            }
        });

        Component.setSameSize(radioContainer, s1, s2);
        add(LayeredLayout.encloseIn(swipe, radioContainer));

        ButtonGroup barGroup = new ButtonGroup();
         RadioButton partage = RadioButton.createToggle("Mes Reclamations", barGroup);
        partage.setUIID("SelectBar");
        RadioButton mesListes = RadioButton.createToggle("Ajouter Reclamation", barGroup);
        mesListes.setUIID("SelectBar");
      
       
        Label arrow = new Label(res.getImage("news-tab-down-arrow.png"), "Container");



        partage.addActionListener((e) -> {
               InfiniteProgress ip = new InfiniteProgress();
        final Dialog ipDlg = ip.showInifiniteBlocking();
        
          ListReclamForm a = new ListReclamForm(res);
            a.show();
            refreshTheme();
        });
        
         mesListes.addActionListener((e) -> {
               InfiniteProgress ip = new InfiniteProgress();
        final Dialog ipDlg = ip.showInifiniteBlocking();
        
          AjoutReclamationForm a = new AjoutReclamationForm(res);
            a.show();
            refreshTheme();
        });
      

    
        partage.setSelected(true);
        arrow.setVisible(false);
        addShowListener(e -> {
            arrow.setVisible(true);
            updateArrowPosition(partage, arrow);
        });
        bindButtonSelection(mesListes, arrow);
        bindButtonSelection(partage, arrow);
        // special case for rotation
        addOrientationListener(e -> {
            updateArrowPosition(barGroup.getRadioButton(barGroup.getSelectedIndex()), arrow);
        });

       
         ArrayList<Reclamation>list = ServiceReclamation.getInstance().affichageReclamations();
    
        
      for(Reclamation rec : list) {
          String urlImage ="h2.png";
           
          Image placeHolder = Image.createImage(120,90);
          EncodedImage enc = EncodedImage.createFromImage(placeHolder, false);
          URLImage urlim = URLImage.createToStorage(enc, urlImage, urlImage,URLImage.RESIZE_SCALE);
          
          addButton(urlim,rec,res);
                  ScaleImageLabel image = new ScaleImageLabel(urlim);
                  
                   Container containerImg = new Container();
                  
                  image.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
                  
      }
        //
        String nom = null;
        MultiButton button = new MultiButton(nom); 
        Button reserver = new Button("reserver");
        
         button.setHeight(100);

        //button.setIcon(Image);
        button.setTextLine1(nom);
        
        
        
             
         //button.setTextLine4(Contenu);
         button.addActionListener(e->{
            
               //displayoneBook a = new displayoneBook(l,res);
         
           //  dialog(rres);
         });
          
        reserver.addActionListener(e -> {
         
           // System.out.println(idl);
           
        });
    }

  
 
    
     private void addStringValue(String s , Component v){
       add(BorderLayout.west(new Label(s,"PaddedLabel"))
               .add(BorderLayout.CENTER,v));
        
   add(createLineSeparator(0xeeeee));
}

    private void addTab(Tabs swipe,Label spacer, Image image, String string, String text, Resources res) {
      int size = Math.min(Display.getInstance().getDisplayWidth(), Display.getInstance().getDisplayHeight());
    
      if(image.getHeight()< size){
          image = image.scaledHeight(size);
      }
    
      if(image.getHeight()> Display.getInstance().getDisplayHeight() / 2){
          image = image.scaledHeight(Display.getInstance().getDisplayHeight() / 2);
      }
      
      ScaleImageLabel imageScale = new ScaleImageLabel(image);
      imageScale.setUIID("Container");
      imageScale.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
   
      Label overLay = new Label("","ImageOverlay");
      
      Container page1 =
              LayeredLayout.encloseIn(
              imageScale,
                      overLay,
                      BorderLayout.south(
                      BoxLayout.encloseY(
                      new SpanLabel(text, "LargewhiteText"),
                          //    FlowLayout.encloseIn(null),
                              
                              spacer
                      )
                      )
              );
      swipe.addTab("",res.getImage("h2.png"), page1);
   
      
      
    
    }
    
    public void bindButtonSelection(Button btn , Label l)
    {
        btn.addActionListener(e-> {
            if(btn.isSelected()){
                updateArrowPosition(btn,l);
            }
        });
    }

    private void updateArrowPosition(Button btn, Label l) {
         
        l.getUnselectedStyle().setMargin(LEFT,btn.getX() + btn.getWidth() / 2 - l.getWidth() / 2);
        l.getParent().repaint();

    }

    private void addButton(Image img, Reclamation rec, Resources res) {

        int height =Display.getInstance().convertToPixels(11.5f);
                int width =Display.getInstance().convertToPixels(14f);
                
                Button image = new Button(img.fill(width,height));
                image.setUIID("Label");

        Container cnt = BorderLayout.west(image) ;
        
        // TextArea ta = new TextArea(nomresto);
           // TextArea ta = new TextArea( rec.getNomresto()+ "\n" + rec.getNbplace()  , 8, 12);

  // ta.setUIID("NewsToLine");
   //ta.setEditable(false);
      Label  ObjetTxt = new Label("Objet :"+rec.getObjet(),"NewsToLine");

   Label TitleTxt = new Label("Title :"+rec.getTitle(),"NewsToLine");
      Label DescriptionTxt = new Label("Description :"+rec.getDescription(),"NewsToLine");
                        Label Txt = new Label("  :","NewsToLine");



  // cnt.add(BorderLayout.CENTER,BoxLayout.encloseY(ta));
   
   //cnt.add(BorderLayout.CENTER,BoxLayout.encloseY(BoxLayout.encloseX(nomTxt),BoxLayout.encloseX(nbplaceTxt)));
   
   
   
   //Suprimer
   
   Label lSupprimer =new Label("  ");
   lSupprimer.setUIID("NewsToLine");
   Style supprimerStyle = new Style(lSupprimer.getUnselectedStyle());
   supprimerStyle.setFgColor(0xf21f1f) ;
   
   FontImage supprimerImage = FontImage.createMaterial(FontImage.MATERIAL_DELETE, supprimerStyle);
   
   lSupprimer.setIcon(supprimerImage);
   lSupprimer.setTextPosition(RIGHT);
   
   //click delete icon
   lSupprimer.addPointerPressedListener(l  ->{
       Dialog dig = new Dialog("Suppression");
       System.out.println(rec.getId());
       
       ServiceReclamation.getInstance().deleteReclam(rec.getId());
       
       if(dig.show("Suppression","Vous voulez supprimer ce reclamation ?","Annuler","Oui")){
           dig.dispose();
       }
       else{
           dig.dispose();
           
           if(ServiceReclamation.getInstance().deleteReclam(rec.getId())){
               new ListReclamForm(res).show();
           }
       }
   });
   
   
   
   
   
   cnt.add(BorderLayout.CENTER,BoxLayout.encloseY(
           
           BoxLayout.encloseX(ObjetTxt),
           BoxLayout.encloseX(TitleTxt),
           BoxLayout.encloseX(DescriptionTxt),

           BoxLayout.encloseX(Txt,lSupprimer)));
   
   
   add(cnt);
   
    }
    
    
    
}
