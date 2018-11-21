/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sim2.pkg0;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ToolBar;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;
import javafx.util.Duration;
import static sim2.pkg0.Aleatoire.arrayActionneur;
import static sim2.pkg0.Aleatoire.arrayNoeud;
import static sim2.pkg0.Aleatoire.arrayStation;

/**
 *
 * @author ilyes
 */
public class Outils {
 
    ToggleButton noeud = new ToggleButton("NOEUD");              //bouttons de type
    ToggleButton actionneur = new ToggleButton("ACTIONNEUR");
    ToggleButton relation = new ToggleButton("RELATION");
    ToggleButton base = new ToggleButton("BASE");
    
    TextField fieldx = new TextField();                    //fields et labels pour ajouter                        
    TextField fieldy = new TextField();
    Label labelx = new Label("X");                                          
    Label labely = new Label("Y");
    Button ajouter = new Button("AJOUTER");
    
    Label label_type = new Label("TYPE DES NOEUDS : ");
    public ToggleButton type1 = new ToggleButton("TYPE 1");
    public ToggleButton type2 = new ToggleButton("TYPE 2");
    public ToggleButton type3 = new ToggleButton("TYPE 3");
    public ToggleButton type4 = new ToggleButton("TYPE 4");
    
    Label label_aleatoire = new Label("TYPE DES NOEUDS \n ALEATOIRE ");
    ToggleButton aleatoire = new ToggleButton("ALEATOIRE");
    
    public static Label erreur = new Label();
    
    Fenetre z = new Fenetre();
    
    ToolBar toolBar = new ToolBar                                               //TOOLBAR
        (   
                noeud,
                actionneur,
                base,    
                new Separator(),
                labelx,
                fieldx,
                labely,
                fieldy,
                ajouter,
                new Separator(),
                label_type,
                type1,
                type2,
                type3,
                type4,
                new Separator(),
                label_aleatoire,
                aleatoire,
                new Separator()/*,
                erreur*/
        );
    
    double pos_x_noeud,pos_y_noeud,r,pos_x_act,pos_y_act;
            int i,j;
     
            
            
            
    public static ArrayList<Capteur> arrayNoeudValide= new ArrayList<Capteur>();
    public static ArrayList<Capteur> arrayNoeudChemin= new ArrayList<Capteur>();
    
    public static ArrayList<Capteur> arrayNoeudValide_act= new ArrayList<Capteur>();
    public static ArrayList<Capteur> arrayNoeudValide_nextHop2= new ArrayList<Capteur>();
    public static ArrayList<Capteur> arrayNoeudChemin_act= new ArrayList<Capteur>();
    
    
    double mou_x,mou_y;
    
    public void outils(Fenetre z, Choix x) throws IOException
    {
        
       // Writer fileNoeudWriter = new FileWriter("/home/samy/NetBeansProjects/Redaction Finale/SIMUL.F/Sim2.0/Files/fileNoeud.txt");
         Writer fileNoeudWriter = new FileWriter("./fileNoeud.txt");
       // Writer fileActionneurWriter = new FileWriter("/home/samy/NetBeansProjects/Sim2.0/Files/fileActionneur.txt");
        
        ToggleGroup togglegroup = new ToggleGroup();                                //TOGGLE BUTTON

        noeud.setToggleGroup(togglegroup);
        actionneur.setToggleGroup(togglegroup);
        relation.setToggleGroup(togglegroup);
        base.setToggleGroup(togglegroup);
        
        ToggleGroup type_group = new ToggleGroup();
        type1.setToggleGroup(type_group);
        type2.setToggleGroup(type_group);
        type3.setToggleGroup(type_group);
        type4.setToggleGroup(type_group);
        aleatoire.setToggleGroup(type_group);
        
        toolBar.setLayoutX(0);
        toolBar.setLayoutY(28);
        toolBar.prefHeightProperty().bind(z.stage2.heightProperty());
        toolBar.setOrientation(Orientation.VERTICAL);
        
        i=0;
        j=0;
        
        
        
        z.scene2.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent mouseEvent) -> {
        
      //  Writer fileNoeud = new FileWriter("/home/samy/NetBeansProjects/Sim2.0/Files/fileNoeud.txt");    
        
        
      
                      if(noeud.isSelected())                                    // NOEUD
                      {
                      
          //  try {                                                               //*** hna gali alt+ctrl zadli try catch ki jit ncreer logjet psk wa9il ki 3ad fih la methode file writer 
                Circle cercle =new Circle(mouseEvent.getSceneX(), mouseEvent.getSceneY(),10);
                
                mou_x=mouseEvent.getSceneX();
                mou_y=mouseEvent.getSceneY();
              
                pos_x_noeud=mouseEvent.getSceneX();
                pos_y_noeud=mouseEvent.getSceneY();
                r=100;
                
                
                  
                cercle.setFill(Color.BLUE);
                cercle.setStrokeWidth(2);
                cercle.setStroke(Color.BLACK);
                
                Random rand=new Random();
                int a;
                int t=1;
                a=rand.nextInt(4)+1;
                
                
                if(type1.isSelected()){cercle.setFill(Color.BLUE);t=1;}
                if(type2.isSelected()){cercle.setFill(Color.RED);t=2;}
                if(type3.isSelected()){cercle.setFill(Color.YELLOW);t=3;}
                if(type4.isSelected()){cercle.setFill(Color.GREEN);t=4;}
                if(aleatoire.isSelected()){
                    if(a==1){cercle.setFill(Color.BLUE);t=1;}
                    if(a==2){cercle.setFill(Color.RED);t=2;}
                    if(a==3){cercle.setFill(Color.YELLOW);t=3;}
                    if(a==4){cercle.setFill(Color.GREEN);t=4;}
                }
                
                Capteur obj_noeud = new Capteur(i,pos_x_noeud,pos_y_noeud,r,t);
                arrayNoeud.add(obj_noeud);
                      
                
           /*    cercle.setOnMouseDragged((MouseEvent event) -> {
                    double deltaX = event.getSceneX()  ;
                    double deltaY = event.getSceneY()  ;
                    cercle.relocate(deltaX,deltaY);
                    
                    arrayNoeud.get(i).x=deltaX;
                    arrayNoeud.get(i).y=deltaY;
               });*/
           
           z.group2.getChildren().addAll(cercle); 
                
               /* System.out.println(i);
                System.out.println(pos_x_noeud);
                System.out.println(pos_y_noeud);*/
               System.out.println("NODE : ");
                System.out.println(arrayNoeud.get(i).id+" ");
        System.out.println(arrayNoeud.get(i).x+" ");
        System.out.println(arrayNoeud.get(i).y+" ");
        System.out.println(arrayNoeud.get(i).type+" ");
                
                
              // Writer fileNoeudWriter = new FileWriter("/home/samy/NetBeansProjects/Sim2.0/Files/fileNoeud.txt"); 
            //   obj_noeud.SaveFileNoeud(arrayNoeud,i,fileNoeudWriter); 
                //fileNoeudWriter.close();
                
           
                
    
                
                
                
              
           /*   cercle.setOnMouseClicked(new EventHandler<MouseEvent>() {   //NOEUD CLICKED
                    @Override
                    public void handle(MouseEvent me) {
                       
                    
                    
                        
                       // if (me.isPrimaryButtonDown())                            //SHOW CHAMPS NOEUD
                     //  {
                        //  cercle.setStrokeWidth(30);
                        
                        
                        Circle champ = new Circle(mouseEvent.getSceneX(), mouseEvent.getSceneY(),arrayNoeud.get(i).rayon);
                        
                        champ.setStyle("-fx-fill: black;\n"+"-fx-opacity: 0.2;");
                        
                        champ.setOnMouseDragged((MouseEvent event) -> {
                            double deltaX = event.getSceneX()  ;
                            double deltaY = event.getSceneY()  ;
                            champ.relocate(deltaX,deltaY);
                            cercle.relocate(deltaX+80-10,deltaY+80-10);
                        });
                        
                        z.group2.getChildren().addAll(champ);
                      //  }
                        
                    
                        
                        
                    }
                });*/
              
              
              
             i++;   
             
          //  } catch (IOException ex) {
          //      Logger.getLogger(Outils.class.getName()).log(Level.SEVERE, null, ex);
          //  }
                    
                             
                }
                 
                      
                      
                      /*  System.out.println("LISTE NOeud : ");
        for(int m=0;m<arrayNoeud.size();m++)
        {
            
        System.out.println(arrayNoeud.get(m).id);
        System.out.println(arrayNoeud.get(m).x);
        System.out.println(arrayNoeud.get(m).y);
        }*/
                      
                      
                      
                       if(actionneur.isSelected())                              //ACTIONNEUR
                      {
                          
                         // try {
                              Polygon triangle = new Polygon();
                              
                              // triangle.setLayoutX(mouseEvent.getSceneX());
                              // triangle.setLayoutY( mouseEvent.getSceneY());
                              triangle.getPoints().addAll(new Double[]{
                                  mouseEvent.getSceneX(), mouseEvent.getSceneY(),
                                  mouseEvent.getSceneX()-10, mouseEvent.getSceneY()+15,
                                  mouseEvent.getSceneX()+10, mouseEvent.getSceneY()+15
                              });
                              
                              pos_x_act=mouseEvent.getSceneX();
                              pos_y_act=mouseEvent.getSceneY();
                              //iii=0;
                              
                              
                              triangle.setFill(Color.BLUE);
                              triangle.setStroke(Color.BLACK);
                              triangle.setStrokeWidth(2);
                              // triangle.setStrokeLineCap(StrokeLineCap.ROUND);
                              
                              
                              Random rand=new Random();
                              int a;
                              int t=1;
                              a=rand.nextInt(4)+1;
                              
                              
                              if(type1.isSelected()){triangle.setFill(Color.BLUE);t=1;}
                              if(type2.isSelected()){triangle.setFill(Color.RED);t=2;}
                              if(type3.isSelected()){triangle.setFill(Color.YELLOW);t=3;}
                              if(type4.isSelected()){triangle.setFill(Color.GREEN);t=4;}
                              if(aleatoire.isSelected()){
                                  if(a==1){triangle.setFill(Color.BLUE);t=1;}
                                  if(a==2){triangle.setFill(Color.RED);t=2;}
                                  if(a==3){triangle.setFill(Color.YELLOW);t=3;}
                                  if(a==4){triangle.setFill(Color.GREEN);t=4;}
                              }
                              
                              Actionneur obj_actionneur =new Actionneur(j,pos_x_act,pos_y_act,r+20,t);
                              arrayActionneur.add(obj_actionneur);
                              
                        /*      triangle.setOnMouseDragged((MouseEvent event) -> {
                                  double deltaX = event.getSceneX()  ;
                                  double deltaY = event.getSceneY() ;
                                  triangle.relocate(deltaX,deltaY);
                                  arrayActionneur.get(i).x=deltaX;
                                  arrayActionneur.get(i).y=deltaY;
                              
                              });*/
                              
                              z.group2.getChildren().addAll(triangle);
                              
                              
                           /*   triangle.setOnMouseClicked(new EventHandler<MouseEvent>() {  //SHOW CHAMP ACTIONNEUR
                                  @Override
                                  public void handle(MouseEvent me) {
                                      //  cercle.setStrokeWidth(30);
                                      Circle champ = new Circle(mouseEvent.getSceneX(), mouseEvent.getSceneY()+10,100);
                                      
                                      champ.setStyle("-fx-fill: black;\n"+"-fx-opacity: 0.2;");
                                      
                                      champ.setOnMouseDragged((MouseEvent event) -> {
                                          double deltaX = event.getSceneX()  ;
                                          double deltaY = event.getSceneY()  ;
                                          champ.relocate(deltaX,deltaY);
                                          triangle.relocate(deltaX+100-10,deltaY+100-10);
                                      });
                                      
                                      z.group2.getChildren().addAll(champ);
                                      
                                  }
                              });*/
                              
                              
                              
                              
                              System.out.println("ACTIONNEUR : ");
                              System.out.println(arrayActionneur.get(j).id);
                              System.out.println(arrayActionneur.get(j).x);
                              System.out.println(arrayActionneur.get(j).y);
                              System.out.println(arrayActionneur.get(j).type);
                              
                           //   obj_actionneur.SaveFileActionneur(arrayActionneur,iii,fileActionneurWriter);
                        
                      //    } catch (IOException ex) {
                       //       Logger.getLogger(Outils.class.getName()).log(Level.SEVERE, null, ex);
                       //   }
                             j++;
                      }
                       //+++++++++++++++++++++++++++
              
                       
                      
                       if(base.isSelected())                                    //STATION DE BASE
                      {
                          double pos_x,pos_y;
                             Rectangle rectangle = new Rectangle();
                             
                             rectangle.setLayoutX(mouseEvent.getSceneX());
                             rectangle.setLayoutY( mouseEvent.getSceneY());
                             pos_x=mouseEvent.getSceneX();
                             pos_y=mouseEvent.getSceneY();
                             rectangle.setWidth(60);
                             rectangle.setHeight(60);
                             rectangle.setStroke(Color.WHITE);
                             rectangle.setStrokeWidth(2);
                             rectangle.setFill(Color.BLACK);
                             
                             
                             Station obj_station = new Station(0,pos_x,pos_y); //creation de l'objet Station
                        arrayStation.add(obj_station);
                             
                             
                        /*     rectangle.setOnMouseDragged((MouseEvent event) -> { 
                                 double deltaX = event.getSceneX()  ; 
                                 double deltaY = event.getSceneY()  ; 
                                 rectangle.relocate(deltaX,deltaY);
                                 arrayStation.get(i).x=deltaX;
                                  arrayStation.get(i).y=deltaY;
                             
                             });*/
                             
                             z.group2.getChildren().addAll(rectangle);
                     
                        
                             
                             
                 /*   rectangle.setOnMouseClicked(new EventHandler<MouseEvent>() {     //SHOW CHAMP BASE
                    @Override
                    public void handle(MouseEvent me) {
                      //  cercle.setStrokeWidth(30);
                      Circle champ = new Circle(mouseEvent.getSceneX()+30, mouseEvent.getSceneY()+30,150);
                        
                        champ.setStyle("-fx-fill: black;\n"+"-fx-opacity: 0.2;");
                      
                        champ.setOnMouseDragged((MouseEvent event) -> { 
                                 double deltaX = event.getSceneX()  ; 
                                 double deltaY = event.getSceneY()  ; 
                                 champ.relocate(deltaX,deltaY);
                                 rectangle.relocate(deltaX+150-30,deltaY+150-30);
                                 });
                        
                        z.group2.getChildren().addAll(champ);
                        
                    }
                    });*/
                             
                             
                             
                      }
                       
                       
                     });
        
        
        
        //fileNoeudWriter.close();
        
        
        
        
      //  Rootage rt = new Rootage();
      //  rt.root();
       
        
        
         ajouter.setOnAction(actionEvent -> {           //AJOUTER****************************************************************
                double nbr=0;
                double nbr2=0;
               nbr=Integer.parseInt(fieldx.getText());
               nbr2=Integer.parseInt(fieldy.getText());
             
             
             if(noeud.isSelected())
                      {
                          Random rand=new Random();
                int a;
                int t=1;
                a=rand.nextInt(4)+1;
                      
                             Circle cercle =new Circle(nbr, nbr2,10);
                             cercle.setFill(Color.BLUE);
                             cercle.setStrokeWidth(2);
                             cercle.setStroke(Color.BLACK);
                             if(type1.isSelected()){cercle.setFill(Color.BLUE);t=1;}
                             if(type2.isSelected()){cercle.setFill(Color.RED);t=2;}
                             if(type3.isSelected()){cercle.setFill(Color.YELLOW);t=3;}
                             if(type4.isSelected()){cercle.setFill(Color.GREEN);t=4;}
                             if(aleatoire.isSelected()){
                    if(a==1){cercle.setFill(Color.BLUE);t=1;}
                    if(a==2){cercle.setFill(Color.RED);t=2;}
                    if(a==3){cercle.setFill(Color.YELLOW);t=3;}
                    if(a==4){cercle.setFill(Color.GREEN);t=4;}
                }
                             
                             
                             Capteur obj_noeud = new Capteur(i,nbr,nbr2,r,t);
                            arrayNoeud.add(obj_noeud);
                             
                         /*    cercle.setOnMouseDragged((MouseEvent event) -> { 
                                 double deltaX = event.getSceneX()  ; 
                                 double deltaY = event.getSceneY()  ; 
                                 cercle.relocate(deltaX,deltaY);});*/
                             
                             z.group2.getChildren().addAll(cercle);
                             
                             
                             
                             
                             
                      }
                      
                       if(actionneur.isSelected())
                      {
                        //  Double nbrr=nbr*1.0;
                        //  Double nbrr2=nbr*1.0;
                          
                          
                             Polygon triangle = new Polygon();
                             
                            // triangle.setLayoutX(mouseEvent.getSceneX());
                            // triangle.setLayoutY( mouseEvent.getSceneY());
                            triangle.getPoints().addAll(new Double[]{
                             nbr, nbr2,
                             nbr-10, nbr2+15,
                             nbr+10, nbr2+15
                             });
                            triangle.setFill(Color.BLUE);
                             triangle.setStroke(Color.BLACK);
                             triangle.setStrokeWidth(2);
                            // triangle.setStrokeLineCap(StrokeLineCap.ROUND);
                           Random rand=new Random();
                              int a;
                              int t=1;
                              a=rand.nextInt(4)+1;
                              
                              
                              if(type1.isSelected()){triangle.setFill(Color.BLUE);t=1;}
                              if(type2.isSelected()){triangle.setFill(Color.RED);t=2;}
                              if(type3.isSelected()){triangle.setFill(Color.YELLOW);t=3;}
                              if(type4.isSelected()){triangle.setFill(Color.GREEN);t=4;}
                              if(aleatoire.isSelected()){
                                  if(a==1){triangle.setFill(Color.BLUE);t=1;}
                                  if(a==2){triangle.setFill(Color.RED);t=2;}
                                  if(a==3){triangle.setFill(Color.YELLOW);t=3;}
                                  if(a==4){triangle.setFill(Color.GREEN);t=4;}
                              }
                             
                              Actionneur obj_actionneur =new Actionneur(j,nbr,nbr2,r+20,t);
                              arrayActionneur.add(obj_actionneur);
                              
                              
                      /*      triangle.setOnMouseDragged((MouseEvent event) -> { 
                                 double deltaX = event.getSceneX()  ; 
                                 double deltaY = event.getSceneY()  ; 
                                 triangle.relocate(deltaX,deltaY);});*/
                            
                             z.group2.getChildren().addAll(triangle);
                      }
                      
                       if(base.isSelected())
                      {
                          
                             Rectangle rectangle = new Rectangle();
                             
                             rectangle.setLayoutX(nbr);
                             rectangle.setLayoutY( nbr2);
                             rectangle.setWidth(60);
                             rectangle.setHeight(60);
                             rectangle.setStroke(Color.WHITE);
                             rectangle.setStrokeWidth(2);
                             rectangle.setFill(Color.BLACK);
                             
                             Station obj_station = new Station(0,nbr,nbr2); //creation de l'objet Station
                        arrayStation.add(obj_station);
                             
                             
                       /*      rectangle.setOnMouseDragged((MouseEvent event) -> { 
                                 double deltaX = event.getSceneX()  ; 
                                 double deltaY = event.getSceneY()  ; 
                                 rectangle.relocate(deltaX,deltaY);});*/
                             
                             z.group2.getChildren().addAll(rectangle);
                      }
                       
             
             
             
            });
         
                                                 
      aleatoire.setOnAction(actionEvent -> {                                    // BOUTTON ALEATOIRE
      
      
      
      
      
      
      });                                                                          
       
    
      
       //  fileActionneurWriter.close();
    z.group2.getChildren().addAll(toolBar);
    
  /*  arrayNoeud.clear();
    arrayActionneur.clear();
    arrayStation.clear();
    
    arrayNoeudValide.clear();
    arrayNoeudChemin.clear();
    arrayNoeudValide_act.clear();
    arrayNoeudValide_nextHop2.clear();
    arrayNoeudChemin_act.clear();*/
    
  ContextMenu cm=new ContextMenu();
                MenuItem menuItem1 = new MenuItem("Send");
                MenuItem menuItem2 = new MenuItem("Portée");
                

                cm.getItems().addAll(menuItem1, menuItem2);
                
    
                
                
  //  Noeud new_noeud=null;
    Capteur new_noeud = new Capteur(0,0,0,100,1);
                
  z.scene2.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent mouseEvent_p) -> {
      
      
      
  Capteur noeud_selected=null;
      if (mouseEvent_p.isSecondaryButtonDown()) 
      {
          System.out.println("SECONDARY DETECTED !!!!");
          double size4=arrayNoeud.size();
          double noeud_x,noeud_y;
          double D_p;
          double mouse_x=mouseEvent_p.getScreenX()-83;
          double mouse_y=mouseEvent_p.getScreenY()-32;
          boolean found=false;
          
         // System.out.println("mouse_x="+mouse_x+" mouse_y="+mouse_y);
          
          for(int w=0;w<size4;w++)
            {
                System.out.println("for--------------------------");
                noeud_x=arrayNoeud.get(w).x;
                noeud_y=arrayNoeud.get(w).y;
                
                System.out.println("X="+noeud_x+" Y="+noeud_y);
                
                D_p=sqrt((pow(noeud_x-mouse_x,2))+(pow(mouse_y-noeud_y,2)));
                System.out.println("D_p = "+D_p);
                if(D_p<=10)
                {
                noeud_selected=arrayNoeud.get(w);
                found=true;
           /*     System.out.println("Noeud Selected : ");
                System.out.println(noeud_selected.id);
                System.out.println(noeud_selected.x);
                System.out.println(noeud_selected.y*/
                }
                
            }
          
          int sizee=arrayActionneur.size(); // clic actionneur
          
          
          
          
           for(int q=0;q<sizee;q++)
            {
                System.out.println("for--------------------------");
                noeud_x=arrayActionneur.get(q).x;
                noeud_y=arrayActionneur.get(q).y;
                
              //  System.out.println("X="+noeud_x+" Y="+noeud_y);
                
                D_p=sqrt((pow(noeud_x-mouse_x,2))+(pow(mouse_y-noeud_y,2)));
              //  System.out.println("D_p = "+D_p);
                if(D_p<=10)
                {
                noeud_selected.id=arrayActionneur.get(q).id;
                noeud_selected.x=arrayActionneur.get(q).x;
                noeud_selected.y=arrayActionneur.get(q).y;
                noeud_selected.rayon=arrayActionneur.get(q).rayon;
                noeud_selected.type=arrayActionneur.get(q).type;
                
                found=true;
           /*     System.out.println("Noeud Selected : ");
                System.out.println(noeud_selected.id);
                System.out.println(noeud_selected.x);
                System.out.println(noeud_selected.y*/
                }
                
            }
          
          
          
          
          if (found == true)
          {
              System.out.println("FOUND = TRUE");
          double sel_x,sel_y;
          sel_x=noeud_selected.x;
          sel_y=noeud_selected.y;
           
          //System.out.println("iciiiiiiiii");
          
           new_noeud.id=noeud_selected.id;
           new_noeud.x=noeud_selected.x;
           new_noeud.y=noeud_selected.y;
           new_noeud.type=noeud_selected.type;
           new_noeud.rayon=noeud_selected.rayon;
           
          // new_noeud=noeud_selected;
           
      /*     System.out.println("Noeud sel interieur");
           System.out.println(noeud_selected.id);
                System.out.println(noeud_selected.x);
                System.out.println(noeud_selected.y);*/
          
          menuItem1.setOnAction((ActionEvent e)->{
                    send(sel_x,sel_y,new_noeud);
                });
                menuItem2.setOnAction((ActionEvent e)->{
                    portee(new_noeud);
                });
              
          
                
                
                
                
                
          Circle cerclee =new Circle(0, 0,15);
          cerclee.setFill(Color.WHITESMOKE);
          z.group2.getChildren().addAll(cerclee);
           cm.show(cerclee, mouseEvent_p.getScreenX(), mouseEvent_p.getScreenY());
      //cm.show(noeud, r, r);
          }
      }
      if (mouseEvent_p.isPrimaryButtonDown())
      {
      
          
          
      
      }
      
      
      
  
  });
  
    fileNoeudWriter.close();
    
    }
    
    
    
    
    
    
      
    public void send(double mouseX,double mouseY,Capteur noeud_selected)
    {
       try{ 
        
    Rootage rt = new Rootage();
       rt.root(mouseX,mouseY,noeud_selected);
       }
       catch(java.lang.StackOverflowError ex)
       {
            Stage er=new Stage();
            er.setTitle("ERREUR");
            Group gr=new Group();
            Scene sr=new Scene(gr,600,100);
            erreur.setText("ERREUR : Le réseaux n'est pas connexe, ou il y a un probléme de vide !");
            erreur.setLayoutX(50);
            erreur.setLayoutY(30);
            erreur.setTextFill(Color.RED);
            gr.getChildren().add(erreur);
            er.setScene(sr);
            er.show();
       
       }
       
    }
    
    public void portee(Capteur new_noeud)
    {
    Circle champ = new Circle( new_noeud.x,new_noeud.y ,new_noeud.rayon);
                        
                        champ.setStyle("-fx-fill: yellow;\n"+"-fx-opacity: 0.2;");
    z.group2.getChildren().addAll(champ);
    }
    
    
    
    
    
    
}
