/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.InfiniteProgress;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import static com.codename1.io.Log.e;
import com.codename1.ui.Button;
import com.codename1.ui.ButtonGroup;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.RadioButton;
import com.codename1.ui.Tabs;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.resto.Entity.resto;
import com.resto.service.RestoService;

/**
 *
 * @author Maryem Cherif
 */
public class AjoutRestoForm extends BaseForm{
 
    
    Form current;
    public AjoutRestoForm(Resources res){
        super("Newsfeed",BoxLayout.y());
        
        Toolbar tb = new Toolbar(true);
        current = this;
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Ajout Resto");
        getContentPane().setScrollVisible(false);
        
        
        
        tb.addSearchCommand(e -> {
            
        });
        
        Tabs swipe = new Tabs();
        
        Label s1 = new Label();
       Label s2 = new Label();
       

       addTab(swipe, s1, res.getImage("H1.png"),"","",res);
        
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
        RadioButton mesListes = RadioButton.createToggle("Mes Restos", barGroup);
        mesListes.setUIID("SelectBar");
        RadioButton liste = RadioButton.createToggle("Autres", barGroup);
        liste.setUIID("SelectBar");
        RadioButton partage = RadioButton.createToggle("Ajout resto", barGroup);
        partage.setUIID("SelectBar");
        Label arrow = new Label(res.getImage("news-tab-down-arrow.png"), "Container");


        mesListes.addActionListener((e) -> {
               InfiniteProgress ip = new InfiniteProgress();
        final Dialog ipDlg = ip.showInifiniteBlocking();
        
        //  ListReclamationForm a = new ListReclamationForm(res);
          //  a.show();
            refreshTheme();
        });

        add(LayeredLayout.encloseIn(
                GridLayout.encloseIn(3, mesListes, liste, partage),
                FlowLayout.encloseBottom(arrow)
        ));

        partage.setSelected(true);
        arrow.setVisible(false);
        addShowListener(e -> {
            arrow.setVisible(true);
            updateArrowPosition(partage, arrow);
        });
        bindButtonSelection(mesListes, arrow);
        bindButtonSelection(liste, arrow);
        bindButtonSelection(partage, arrow);
        // special case for rotation
        addOrientationListener(e -> {
            updateArrowPosition(barGroup.getRadioButton(barGroup.getSelectedIndex()), arrow);
        });

       
        
        
        
       //
       
       
       
        TextField nomresto = new TextField("","entrer nom!!");
        nomresto.setUIID("TestFieldBlack");
        addStringValue("nomresto",nomresto);
        
         TextField nbplace = new TextField("","entrer nombre de place !!");
        nbplace.setUIID("TestFieldBlack");
        addStringValue("nbplace",nbplace);
        
         TextField budget = new TextField("","entrer budget !!");
        budget.setUIID("TestFieldBlack");
        addStringValue("budget",budget);
        
        
        
        Button btnAjouter = new Button("Ajouter");  
        addStringValue("",btnAjouter);
       
        btnAjouter.addActionListener((e) -> {
        
        try {
            if(nomresto.getText().equals(" ") || nbplace.getText().equals(" ")|| budget.getText().equals(" ")  ){
           Dialog.show("Veuillez verifier les donnees","", "Annuler", "OK");
            }
            else{
                InfiniteProgress ip = new InfiniteProgress();;
                
               final Dialog iDialog = ip.showInfiniteBlocking();
                
               resto r= new resto(nomresto.getText(),Float.valueOf(budget.getText()),Integer.valueOf(nbplace.getText()));
               
               System.out.println("data resto == "+r);
               
               RestoService.getInstance().ajouterResto(r);
               
               iDialog.dispose();
               
               new ListRestoForm(res).show();
               
                
               
               refreshTheme();
            }
        } catch(Exception ex){
            ex.printStackTrace();
        }
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
                           //  FlowLayout.encloseIn(null),
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
    
    
}
