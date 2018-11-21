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
import javafx.event.EventHandler;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import static sim2.pkg0.Outils.arrayNoeudChemin;
import static sim2.pkg0.Outils.arrayNoeudChemin_act;
import static sim2.pkg0.Outils.arrayNoeudValide;
import static sim2.pkg0.Outils.arrayNoeudValide_act;
import static sim2.pkg0.Outils.arrayNoeudValide_nextHop2;

/**
 *
 * @author ilyes
 */
public class Aleatoire {
    public static Simulateur sim20 = new Simulateur();
    
    public static ArrayList<Capteur> arrayNoeud= new ArrayList<Capteur>();
    public static ArrayList<Actionneur> arrayActionneur= new ArrayList<Actionneur>();
    public static ArrayList<Station> arrayStation = new ArrayList<Station>();
    
    
    public void aleatoire(Fenetre board) throws IOException
    {
        
       /* if(!arrayNoeud.isEmpty())
        {
        arrayNoeud.clear();
        arrayActionneur.clear();
        }*/
      //  Writer fileNoeudWriter = new FileWriter("/home/samy/NetBeansProjects/Sim2.0/Files/fileNoeud.txt");
      //  Writer fileActionneurWriter = new FileWriter("/home/samy/NetBeansProjects/Sim2.0/Files/fileActionneur.txt");
        
        int nbr=0;
        int nbr2=0;
        nbr=Integer.parseInt(sim20.choix.field1.getText());//nombre de noeuds                     
        nbr2=Integer.parseInt(sim20.choix.field2.getText());//nombre d'actionneurs

        
        Random rand=new Random();
        double pos_x,pos_y,r,rayon;
        r=10;
        rayon=100;
                
               // Writer fileNoeud = new FileWriter("/home/samy/NetBeansProjects/Sim2.0/Files/fileNoeud.txt");

            for(int i=0;i<nbr;i++)                                              //CREATION DES NOEUDS-------------------------------- 
            {
                Circle cercle =new Circle();       //creation du cercle
                pos_x=rand.nextInt(980)+200;
                cercle.setLayoutX(pos_x);
                pos_y=rand.nextInt(630)+50;
                cercle.setLayoutY(pos_y);
                cercle.setRadius(r);
                cercle.setStrokeWidth(2);
                cercle.setStroke(Color.BLACK);
                cercle.setFill(Color.BLACK);
                
                
                int a; 
                int t=1;//donner le type aleatoirement
                a=rand.nextInt(4)+1;
                if(a==1){cercle.setFill(Color.BLUE);t=1;}
                if(a==2){cercle.setFill(Color.RED);t=2;}
                if(a==3){cercle.setFill(Color.YELLOW);t=3;}
                if(a==4){cercle.setFill(Color.GREEN);t=4;}
                
                
               /*cercle.setOnMouseDragged((MouseEvent event) -> { //changer position 
                    double deltaX = event.getSceneX()  ;
                    double deltaY = event.getSceneY()  ;
                    cercle.relocate(deltaX,deltaY);
               
               });*/
                
                
                board.group2.getChildren().add(cercle);
                
                
                Capteur obj_noeud = new Capteur(i,pos_x,pos_y,rayon,t); //creation de l'objet Noeud
                arrayNoeud.add(obj_noeud);
               // obj_noeud.SaveFileNoeud(arrayNoeud,i,fileNoeudWriter);
                
              /*  System.out.println("NODE : ");
                System.out.println(arrayNoeud.get(i).id+" ");
                System.out.println(arrayNoeud.get(i).x+" ");
                System.out.println(arrayNoeud.get(i).y+" ");
                System.out.println(arrayNoeud.get(i).rayon+" ");*/
                
               /* cercle.setOnMouseClicked(new EventHandler<MouseEvent>() {   
                    @Override
                    public void handle(MouseEvent me) {
                        
                     //   if (me.isPrimaryButtonDown())      //afficher le champs                      
                      //  {
                         double rayon;
                         rayon=50;
                         
                         Circle champ = new Circle(me.getSceneX(), me.getSceneY(),rayon);
                        
                          //Circle champ = new Circle(, ,rayon);
                         
                         
                         champ.setStyle("-fx-fill: black;\n"+"-fx-opacity: 0.2;");
                      
                         champ.setOnMouseDragged((MouseEvent event) -> { 
                                 double deltaX = event.getSceneX()  ; 
                                 double deltaY = event.getSceneY()  ; 
                                 champ.relocate(deltaX,deltaY);
                                 cercle.relocate(deltaX+rayon-10,deltaY+rayon-10);
                                 }); // changer position champs
                        
                        board.group2.getChildren().addAll(champ);
                   //   }
                        //------------------------------------------------------
                    //   if (me.isSecondaryButtonDown())
                     //   {
                        
                        System.out.println("SECNDDD");
                        ContextMenu contextMenu = new ContextMenu();
                        MenuItem register = new MenuItem("Register");
                        contextMenu.getItems().add(register);
                        board.group2.getChildren().addAll();  // hna hadi lparagraphe kan comment
                     //   }
                        
                        
                    }
                    }); */
            
            } // fin for Noeud
               
            for(int m=0;m<arrayNoeud.size();m++)
        {
            System.out.println("NOEUD :");
        System.out.println(arrayNoeud.get(m).id);
        System.out.println(arrayNoeud.get(m).x);
        System.out.println(arrayNoeud.get(m).y);}
            
            
             //   fileNoeudWriter.close();
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
       /*
        board.scene2.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent mouseEvent_p) -> {
        
        if (mouseEvent_p.isSecondaryButtonDown()) 
        {    
          System.out.println("CLICK DETECTED !!!!!!!!!!!!!");  
        double mouse_x,mouse_y;
        double noeud_x,noeud_y;
        double D_p;
        
        int size4;
        int w;
        
        Noeud noeud_selected=null;
         //   try {
              //  Noeud noeud_selected = new Noeud(0,0.0,0.0,0.0);
           // } catch (IOException ex) {
           //     Logger.getLogger(Outils.class.getName()).log(Level.SEVERE, null, ex);
            //}
        
            
            
        mouse_x=mouseEvent_p.getSceneX();
        mouse_y=mouseEvent_p.getSceneY();
        
        size4=arrayNoeud.size();
        
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
                System.out.println(arrayNoeud.get(w).id);
                System.out.println(arrayNoeud.get(w).x);
                System.out.println(arrayNoeud.get(w).y);
                }
                
                
            }
        if(found==true)
        {              
        Message message = new Message();
                           System.out.println(noeud_selected.id);
                           System.out.println(noeud_selected.x);
                           System.out.println(noeud_selected.y);
                           
                        //    message.envoyer(arrayNoeud,arrayActionneur,arrayStation,noeud_selected.id,noeud_selected);
                            //System.out.println("apres envoyerrrrrrrrrr");
                        
                            int test;
                            test=arrayNoeudChemin.size();
                            //System.out.println("array noeud chemin = "+test);
                            
                            
                         int size3;
                      
                      size3=arrayNoeudChemin.size();
                     System.out.println("size arrayNoeudChemin = "+size3);
                     
                     
                      
                      int k;
                      
                      for(k=0;k<size3-1;k++)
                      {
                          System.out.println("REPEATED");
                      Line line=new Line(arrayNoeudChemin.get(k).x,arrayNoeudChemin.get(k).y,arrayNoeudChemin.get(k+1).x,arrayNoeudChemin.get(k+1).y);
                      line.setStrokeWidth(2); 
                      line.setStroke(Color.RED);
    
                      board.group2.getChildren().addAll(line);
                      }
                      
                 Line line=new Line(arrayNoeudChemin.get(k).x,arrayNoeudChemin.get(k).y,arrayStation.get(0).x,arrayStation.get(0).y);
                      line.setStrokeWidth(2); 
                      line.setStroke(Color.RED);
    
                      board.group2.getChildren().addAll(line);
                      
                      
        }
        }
        });         


*/



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                
                
                
            for(int i=0;i<nbr2;i++)                                             //CREATION DES ACTIONNEURS------------------------
            {
                Polygon triangle = new Polygon();
                
                pos_x=rand.nextInt(980)+200;
                pos_y=rand.nextInt(630)+50;
                
                
                triangle.getPoints().addAll(new Double[]{ // creation du triangle
                    pos_x, pos_y,
                    pos_x-10, pos_y+15,
                    pos_x+10, pos_y+15
                    });
                
                triangle.setFill(Color.BLACK);
                triangle.setStroke(Color.BLACK);
                triangle.setStrokeWidth(2);
                    // triangle.setStrokeLineCap(StrokeLineCap.ROUND);

                int a; 
                int t=1;// donner le type aleatoirement
                a=rand.nextInt(4)+1;
                if(a==1){triangle.setFill(Color.BLUE);t=1;}
                if(a==2){triangle.setFill(Color.RED);t=2;}
                if(a==3){triangle.setFill(Color.YELLOW);t=3;}
                if(a==4){triangle.setFill(Color.GREEN);t=4;}
                
                
                board.group2.getChildren().addAll(triangle);
                
                
            /*    triangle.setOnMouseDragged((MouseEvent event) -> {   // changer position 
                                 double deltaX = event.getSceneX()  ; 
                                 double deltaY = event.getSceneY()  ; 
                                 triangle.relocate(deltaX,deltaY);});*/
                
                
                Actionneur obj_actionneur =new Actionneur(i,pos_x,pos_y,rayon+20,t); // creation de l'objet Actionneur
                arrayActionneur.add(obj_actionneur);
            //    obj_actionneur.SaveFileActionneur(arrayActionneur,i,fileActionneurWriter);
                
                
                
           /*     triangle.setOnMouseClicked(new EventHandler<MouseEvent>() {  //champs actionneur
                    @Override
                    public void handle(MouseEvent me) {
                     
                     double rayon;
                     rayon=100;
                        
                    Circle champ = new Circle(me.getSceneX(), me.getSceneY()+10,rayon);
                        
                    champ.setStyle("-fx-fill: black;\n"+"-fx-opacity: 0.2;");
                      
                    champ.setOnMouseDragged((MouseEvent event) -> { 
                        double deltaX = event.getSceneX()  ; 
                        double deltaY = event.getSceneY()  ; 
                        champ.relocate(deltaX,deltaY);
                        triangle.relocate(deltaX+100-10,deltaY+100-10);
                        });
                        
                        board.group2.getChildren().addAll(champ);
                        
                    }
                    });*/
                     
                     
                     
            } // fin for actionneur

            for(int m=0;m<arrayActionneur.size();m++)
        {
            System.out.println("ACTIONNEUR");
        System.out.println(arrayActionneur.get(m).id);
        System.out.println(arrayActionneur.get(m).x);
        System.out.println(arrayActionneur.get(m).y);}
            
            
          //  fileActionneurWriter.close();
                
                
                Rectangle rectangle = new Rectangle();                          // STATION DE BASE---------------------------------
                pos_x=rand.nextInt(920)+230;
                rectangle.setLayoutX(pos_x);
                pos_y=rand.nextInt(570)+80;
                rectangle.setLayoutY(pos_y);
                rectangle.setWidth(60);
                rectangle.setHeight(60);
                rectangle.setStroke(Color.WHITE);
                rectangle.setStrokeWidth(2);
                rectangle.setFill(Color.BLACK);
                
            /*    rectangle.setOnMouseDragged((MouseEvent event) -> { //changer position
                                 double deltaX = event.getSceneX()  ; 
                                 double deltaY = event.getSceneY()  ; 
                                 rectangle.relocate(deltaX,deltaY);});*/
                
                board.group2.getChildren().add(rectangle);
                
                Station obj_station = new Station(0,pos_x,pos_y); //creation de l'objet Station
                arrayStation.add(obj_station);
                
                
          /*       rectangle.setOnMouseClicked(new EventHandler<MouseEvent>() {     //champs Station
                    @Override
                    public void handle(MouseEvent me) {
                      
                    Random rand=new Random();
                    int rayon;
                    rayon=rand.nextInt(50)+100;
                      
                    Circle champ = new Circle(me.getSceneX()+30, me.getSceneY()+30,rayon);
                        
                    champ.setStyle("-fx-fill: black;\n"+"-fx-opacity: 0.2;");
                      
                   champ.setOnMouseDragged((MouseEvent event) -> { //changer position champs
                                 double deltaX = event.getSceneX()  ; 
                                 double deltaY = event.getSceneY()  ; 
                                 champ.relocate(deltaX,deltaY);
                                 rectangle.relocate(deltaX+rayon-30,deltaY+rayon-30);
                                 });
                        
                     board.group2.getChildren().addAll(champ);
                        
                    }
                    });*/
                
       
        
                
             //   Rootage rt = new Rootage();
             //   rt.root();

             
             
             
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
