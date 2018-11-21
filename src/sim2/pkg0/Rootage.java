/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sim2.pkg0;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;
import static sim2.pkg0.Aleatoire.arrayActionneur;
import static sim2.pkg0.Aleatoire.arrayNoeud;
import static sim2.pkg0.Aleatoire.arrayStation;
import static sim2.pkg0.Outils.arrayNoeudChemin;
import static sim2.pkg0.Outils.arrayNoeudChemin_act;
import static sim2.pkg0.Outils.arrayNoeudValide;
import static sim2.pkg0.Outils.arrayNoeudValide_act;
import static sim2.pkg0.Outils.arrayNoeudValide_nextHop2;
import static sim2.pkg0.Outils.erreur;

/**
 *
 * @author samy
 */
public class Rootage {
    Fenetre z = new Fenetre();
   // public ContextMenu cm=new ContextMenu();
    public void root(double mouseX, double mouseY,Capteur noeud_selected)
    {
        //************************************************************************************************MENU CONTEXTUEL 
        
                
              /*  
                
            ContextMenu cm=new ContextMenu();
                MenuItem menuItem1 = new MenuItem("Envoyer");
                MenuItem menuItem2 = new MenuItem("Portée");

                cm.getItems().addAll(menuItem1, menuItem2);
                menuItem1.setOnAction((ActionEvent e)->{
                    
                });
                
                menuItem2.setOnAction((ActionEvent e)->{
                    
                });
          
                cercle.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {
                if (e.getButton() == MouseButton.SECONDARY) {
                    cm.show(cercle, e.getScreenX(), e.getScreenY());
                   // group.getChildren().add(c);
                } 
                }
                });
        //ay temchi ki nediha l outils juste ta7t la creation !!
        */
        
        //************************************************************************************************
        
        
        
        
        
     //////////////////////////////////////////////////////////////////////////////////////////////////ROOTAGE
        
        
      //  z.scene2.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent mouseEvent_p) -> {
        
      // if (mouseEvent_p.isSecondaryButtonDown()) 
      //  {    
          System.out.println("CLICK DETECTED !!!!!!!!!!!!!");  
        double mouse_x,mouse_y;
        double noeud_x,noeud_y;
        double D_p;
        
        int size4;
        int w;
        
     //   Noeud noeud_selected=null;
         //   try {
              //  Noeud noeud_selected = new Noeud(0,0.0,0.0,0.0);
           // } catch (IOException ex) {
           //     Logger.getLogger(Outils.class.getName()).log(Level.SEVERE, null, ex);
            //}
        
            
            
        mouse_x=mouseX;
        mouse_y=mouseY;
        
     /*   size4=arrayNoeud.size();
        
        boolean found=false;
        
        for(w=0;w<size4;w++)
            {
                //System.out.println("forrrrrrrrrrrrrrrrrrrrrrrrr");
                noeud_x=arrayNoeud.get(w).x;
                noeud_y=arrayNoeud.get(w).y;
                
                D_p=sqrt((pow(noeud_x-mouse_x,2))+(pow(mouse_y-noeud_y,2)));
                
                if(D_p<=10)
                {
                noeud_selected=arrayNoeud.get(w);
                found=true;
                System.out.println("Noeud Selected : ");
                System.out.println(arrayNoeud.get(w).id);
                System.out.println(arrayNoeud.get(w).x);
                System.out.println(arrayNoeud.get(w).y);
                }
                
                
            }*/
    //    if(found==true)
      //  {              
           ///////////////////////////////////////////////////////////////////// CONTEXT MENU 
          /*  ContextMenu cm=new ContextMenu();
                MenuItem menuItem1 = new MenuItem("Envoyer");
                MenuItem menuItem2 = new MenuItem("Couleur");

                cm.getItems().addAll(menuItem1, menuItem2);*/
              //  cm.show(cercle, mouseEvent_p.getScreenX(), mouseEvent_p.getScreenY());
               // z.group2.getChildren().addAll(cm);
              //  menuItem1.setOnAction((ActionEvent e)->{
                    
             //   });
           /*     c.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {
                if (e.getButton() == MouseButton.SECONDARY) {
                    cm.show(c, e.getScreenX(), e.getScreenY());
                    group.getChildren().add(c);
                } 
                }
                });*/
            
           ///////////////////////////////////////////////////////////////////// 
            
        //********************************************************************** choisir le meilleur actionneur   
        int size_act=arrayActionneur.size();
        int n;
        double x_act,y_act;
        double x_noeud,y_noeud;
        double min_dist=0;
        double D_noeud_act=0;
        
        
        x_noeud=noeud_selected.x;
        y_noeud=noeud_selected.y;
        
        
        
        Actionneur act_dest = new Actionneur(0,0,0,0,1);
        
       // act_dest=arrayActionneur.get(0);
       
        
       // min_dist=sqrt((pow(x_noeud-arrayActionneur.get(0).x,2))+(pow(arrayActionneur.get(0).y-y_noeud,2)));;
       // System.out.println("Min Distance = "+min_dist);
        
            /*    System.out.println("LISTE ACTIONNEUR : ");
        for(int m=0;m<arrayActionneur.size();m++)
        {
            
        System.out.println(arrayActionneur.get(m).id);
        System.out.println(arrayActionneur.get(m).x);
        System.out.println(arrayActionneur.get(m).y);
        }*/
       boolean act_found=false;
       
       
       
        int c=0;
        
        for(n=0;n<size_act;n++)
        {
          // System.out.println("n="+n);
            
            if(noeud_selected.type==arrayActionneur.get(n).type)
            {
            //    System.out.println("TEST DE TYPE FAIT !! ");
            D_noeud_act=sqrt((pow(x_noeud-arrayActionneur.get(n).x,2))+(pow(arrayActionneur.get(n).y-y_noeud,2)));
            
            if(c==0)
            {min_dist=D_noeud_act;
            }
            
           // System.out.println("D_noeud_act = "+D_noeud_act);
            if(D_noeud_act<=min_dist )
            {
               // System.out.println("YA UN ACT CHOISI comme meilleur !! ");
            min_dist=D_noeud_act;
            act_dest=arrayActionneur.get(n);
            act_found=true;
            }
            c++;
            }
        
        }
        /*
        System.out.println("meilleur ACT_DEST = ");
        System.out.println(act_dest.id);
        System.out.println(act_dest.x);
        System.out.println(act_dest.y);*/
        if(act_found==true)
        {
            
        //**********************************************************************    
            
            
            
                         Message message = new Message();
                         /*  System.out.println(noeud_selected.id);
                           System.out.println(noeud_selected.x);
                           System.out.println(noeud_selected.y);*/
                           
                            message.envoyer_act(arrayNoeud,arrayActionneur,arrayStation,noeud_selected.id,noeud_selected,act_dest);
                            //System.out.println("apres envoyerrrrrrrrrr");
                        
                            int test;
                            test=arrayNoeudChemin.size();
                            //System.out.println("array noeud chemin = "+test);
                            
                            
                         int size3;
                      
                      size3=arrayNoeudChemin.size();
                    // System.out.println("size arrayNoeudChemin = "+size3);
                     
                    
                  /*  for(int q=0;q<size3;q++)
                    {
                    System.out.println(arrayNoeudChemin.get(q).);
                    }*/
                     
                     
                     
                      
                      int k;
                      
                      for(k=0;k<size3-1;k++)
                      {
                        //  System.out.println("REPEATED");
                          //--------------------------------------------
                          //Line line1=new Line(arrayNoeudChemin.get(k).x,arrayNoeudChemin.get(k).y,arrayNoeudChemin.get(k+1).x,arrayNoeudChemin.get(k+1).y);
                          Line line1=new Line(arrayNoeudChemin.get(k+1).x,arrayNoeudChemin.get(k+1).y,arrayNoeudChemin.get(k).x,arrayNoeudChemin.get(k).y);
                        Line line=new Line(arrayNoeudChemin.get(k+1).x,arrayNoeudChemin.get(k+1).y,arrayNoeudChemin.get(k).x,arrayNoeudChemin.get(k).y);
                        line.getStrokeDashArray().setAll(25d, 20d, 5d, 20d);
                        line.setStrokeWidth(2); 
                        line1.setStrokeWidth(2);
                        line.setStroke(Color.WHITE);
                        line1.setStroke(Color.BLUE);
                        final double maxOffset = 
                        line.getStrokeDashArray().stream()
                        .reduce(
                                0d, 
                                (a, b) -> a + b
                        );

                        Timeline timeline = new Timeline(
                        new KeyFrame(
                        Duration.ZERO, 
                        new KeyValue(
                                line.strokeDashOffsetProperty(), 
                                0, 
                                Interpolator.LINEAR
                        )
                        ),
                        new KeyFrame(
                        Duration.seconds(2), 
                        new KeyValue(
                                line.strokeDashOffsetProperty(), 
                                maxOffset, 
                                Interpolator.LINEAR
                        )
                        )
                    );
                    timeline.setCycleCount(Timeline.INDEFINITE);
                    timeline.play();
                          
                          //--------------------------------------------
                /*      Line line=new Line(arrayNoeudChemin.get(k).x,arrayNoeudChemin.get(k).y,arrayNoeudChemin.get(k+1).x,arrayNoeudChemin.get(k+1).y);
                      line.setStrokeWidth(2); 
                      line.setStroke(Color.RED);
    */
                      z.group2.getChildren().addAll(line1,line);
                      }
                      
               /*   Line line=new Line(arrayNoeudChemin.get(k).x,arrayNoeudChemin.get(k).y,act_dest.x,act_dest.y);
                      line.setStrokeWidth(2); 
                      line.setStroke(Color.RED);*/
               
                 Line line1=new Line(act_dest.x,act_dest.y,arrayNoeudChemin.get(k).x,arrayNoeudChemin.get(k).y);
                        Line line=new Line(act_dest.x,act_dest.y,arrayNoeudChemin.get(k).x,arrayNoeudChemin.get(k).y);
                        line.getStrokeDashArray().setAll(25d, 20d, 5d, 20d);
                        line.setStrokeWidth(2); 
                        line1.setStrokeWidth(2);
                        line.setStroke(Color.WHITE);
                        line1.setStroke(Color.BLUE);
                        final double maxOffset = 
                        line.getStrokeDashArray().stream()
                        .reduce(
                                0d, 
                                (a, b) -> a + b
                        );

                        Timeline timeline = new Timeline(
                        new KeyFrame(
                        Duration.ZERO, 
                        new KeyValue(
                                line.strokeDashOffsetProperty(), 
                                0, 
                                Interpolator.LINEAR
                        )
                        ),
                        new KeyFrame(
                        Duration.seconds(2), 
                        new KeyValue(
                                line.strokeDashOffsetProperty(), 
                                maxOffset, 
                                Interpolator.LINEAR
                        )
                        )
                    );
                    timeline.setCycleCount(Timeline.INDEFINITE);
                    timeline.play();
               
                      z.group2.getChildren().addAll(line1,line);
                      
                      ///////from actionneur to base
                         message.envoyer_base(arrayNoeud, arrayStation, act_dest);
                       
                         System.out.println("SIZE arrayNoeudCheminAct = "+arrayNoeudChemin_act.size());
                         
                      /*   Line line2=new Line(act_dest.x,act_dest.y,arrayNoeudChemin_act.get(0).x,arrayNoeudChemin_act.get(0).y);
                      line2.setStrokeWidth(2); 
                      line2.setStroke(Color.BLUE);*/
                      k=0;//*****
                      if(arrayNoeudChemin_act.isEmpty())
                      {
                          Line line2=new Line(arrayStation.get(0).x,arrayStation.get(0).y,act_dest.x,act_dest.y);
                        Line line3=new Line(arrayStation.get(0).x,arrayStation.get(0).y,act_dest.x,act_dest.y);
                        line3.getStrokeDashArray().setAll(25d, 20d, 5d, 20d);
                        line3.setStrokeWidth(2); 
                        line2.setStrokeWidth(2);
                        line3.setStroke(Color.WHITE);
                        line2.setStroke(Color.BLUE);
                        final double maxOffset2 = 
                        line3.getStrokeDashArray().stream()
                        .reduce(
                                0d, 
                                (a, b) -> a + b
                        );

                        Timeline timeline2 = new Timeline(
                        new KeyFrame(
                        Duration.ZERO, 
                        new KeyValue(
                                line3.strokeDashOffsetProperty(), 
                                0, 
                                Interpolator.LINEAR
                        )
                        ),
                        new KeyFrame(
                        Duration.seconds(2), 
                        new KeyValue(
                                line3.strokeDashOffsetProperty(), 
                                maxOffset2, 
                                Interpolator.LINEAR
                        )
                        )
                    );
                    timeline2.setCycleCount(Timeline.INDEFINITE);
                    timeline2.play();
                      
    
                      z.group2.getChildren().addAll(line2,line3);
                          
                          
                      
                      }//fin du if size==0
                          else
                      {  
                      System.out.println("DANS LE 2EME IF");
                      
                      
                      
                      Line line2=new Line(arrayNoeudChemin_act.get(0).x,arrayNoeudChemin_act.get(0).y,act_dest.x,act_dest.y);
                        Line line3=new Line(arrayNoeudChemin_act.get(0).x,arrayNoeudChemin_act.get(0).y,act_dest.x,act_dest.y);
                        line3.getStrokeDashArray().setAll(25d, 20d, 5d, 20d);
                        line3.setStrokeWidth(2); 
                        line2.setStrokeWidth(2);
                        line3.setStroke(Color.WHITE);
                        line2.setStroke(Color.BLUE);
                        final double maxOffset2 = 
                        line3.getStrokeDashArray().stream()
                        .reduce(
                                0d, 
                                (a, b) -> a + b
                        );

                        Timeline timeline2 = new Timeline(
                        new KeyFrame(
                        Duration.ZERO, 
                        new KeyValue(
                                line3.strokeDashOffsetProperty(), 
                                0, 
                                Interpolator.LINEAR
                        )
                        ),
                        new KeyFrame(
                        Duration.seconds(2), 
                        new KeyValue(
                                line3.strokeDashOffsetProperty(), 
                                maxOffset2, 
                                Interpolator.LINEAR
                        )
                        )
                    );
                    timeline2.setCycleCount(Timeline.INDEFINITE);
                    timeline2.play();
                      
    
                      z.group2.getChildren().addAll(line2,line3);
                         
                         
                    
                      
                       if(arrayNoeudChemin_act.size()!=1)
                       {
                      
                      
                         
                         int size7=arrayNoeudChemin_act.size();
                         
                        // System.out.println("size 7 = "+size7);
                    
                        
                         for(k=0;k<size7-1;k++)
                      {
                      /*    System.out.println("REPEATED");
                      Line line4=new Line(arrayNoeudChemin_act.get(k).x,arrayNoeudChemin_act.get(k).y,arrayNoeudChemin_act.get(k+1).x,arrayNoeudChemin_act.get(k+1).y);
                      line4.setStrokeWidth(2); 
                      line4.setStroke(Color.BLUE);*/
    
                           Line line4=new Line(arrayNoeudChemin_act.get(k+1).x,arrayNoeudChemin_act.get(k+1).y,arrayNoeudChemin_act.get(k).x,arrayNoeudChemin_act.get(k).y);
                        Line line5=new Line(arrayNoeudChemin_act.get(k+1).x,arrayNoeudChemin_act.get(k+1).y,arrayNoeudChemin_act.get(k).x,arrayNoeudChemin_act.get(k).y);
                        line5.getStrokeDashArray().setAll(25d, 20d, 5d, 20d);
                        line5.setStrokeWidth(2); 
                        line4.setStrokeWidth(2);
                        line5.setStroke(Color.WHITE);
                        line4.setStroke(Color.BLUE);
                        final double maxOffset4 = 
                        line5.getStrokeDashArray().stream()
                        .reduce(
                                0d, 
                                (a, b) -> a + b
                        );

                        Timeline timeline4 = new Timeline(
                        new KeyFrame(
                        Duration.ZERO, 
                        new KeyValue(
                                line5.strokeDashOffsetProperty(), 
                                0, 
                                Interpolator.LINEAR
                        )
                        ),
                        new KeyFrame(
                        Duration.seconds(2), 
                        new KeyValue(
                                line5.strokeDashOffsetProperty(), 
                                maxOffset, 
                                Interpolator.LINEAR
                        )
                        )
                    );
                    timeline4.setCycleCount(Timeline.INDEFINITE);
                    timeline4.play();
                          
                          
                          
                      z.group2.getChildren().addAll(line4,line5);
                      }
                         
                       }  
                         
                      
                      
                  
                      
                      
                      
                      
                     /*    Line line4=new Line(arrayNoeudChemin_act.get(k).x,arrayNoeudChemin_act.get(k).y,arrayStation.get(0).x,arrayStation.get(0).y);
                      line4.setStrokeWidth(2); 
                      line4.setStroke(Color.BLUE);*/
    
                       Line line4=new Line(arrayStation.get(0).x,arrayStation.get(0).y,arrayNoeudChemin_act.get(k).x,arrayNoeudChemin_act.get(k).y);
                        Line line5=new Line(arrayStation.get(0).x,arrayStation.get(0).y,arrayNoeudChemin_act.get(k).x,arrayNoeudChemin_act.get(k).y);
                        line5.getStrokeDashArray().setAll(25d, 20d, 5d, 20d);
                        line5.setStrokeWidth(2); 
                        line4.setStrokeWidth(2);
                        line5.setStroke(Color.WHITE);
                        line4.setStroke(Color.BLUE);
                        final double maxOffset4 = 
                        line5.getStrokeDashArray().stream()
                        .reduce(
                                0d, 
                                (a, b) -> a + b
                        );

                        Timeline timeline4 = new Timeline(
                        new KeyFrame(
                        Duration.ZERO, 
                        new KeyValue(
                                line5.strokeDashOffsetProperty(), 
                                0, 
                                Interpolator.LINEAR
                        )
                        ),
                        new KeyFrame(
                        Duration.seconds(2), 
                        new KeyValue(
                                line5.strokeDashOffsetProperty(), 
                                maxOffset, 
                                Interpolator.LINEAR
                        )
                        )
                    );
                    timeline4.setCycleCount(Timeline.INDEFINITE);
                    timeline4.play();
                     
                      z.group2.getChildren().addAll(line4,line5);
                      
                      }//fin du else size!=0    
                     
                     
                      
                      
                      
    }// fin if act_found = false        
        else if(act_found!=true)
        {
            Stage St=new Stage();
            Group gr=new Group();
            Scene sr=new Scene(gr,400,100);
            erreur.setText("ERREUR : Actionneur de meme type non trouvé !");
            erreur.setLayoutX(50);
            erreur.setLayoutY(50);
            erreur.setTextFill(Color.RED);
            gr.getChildren().add(erreur);
            St.setScene(sr);
            St.show();
        
        }
                      
                      
      //  } if found == true
       // } // ta3 IF
      //  });  // ta3 click
        
        //////////////////////////////////////////////////////////////////////////////////////////////////ROOTAGE
   /* arrayNoeud.clear();
    arrayActionneur.clear();
    arrayStation.clear();
    
    arrayNoeudValide.clear();
    arrayNoeudChemin.clear();
    arrayNoeudValide_act.clear();
    arrayNoeudValide_nextHop2.clear();
    arrayNoeudChemin_act.clear();*/
    
        
        
        
    }
    
    
}
