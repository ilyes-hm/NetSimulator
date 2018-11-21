/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sim2.pkg0;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import static sim2.pkg0.Aleatoire.arrayActionneur;
import static sim2.pkg0.Aleatoire.arrayNoeud;
import static sim2.pkg0.Aleatoire.arrayStation;
import static sim2.pkg0.Fenetre.group2;
import static sim2.pkg0.Choix.stage;

/**
 *
 * @author ilyes
 */
public class Fichier {
    
    public void fichier(Fenetre z)
    {
    FileChooser fileChooser = new FileChooser();
    FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("All files ", "*.*");
    fileChooser.getExtensionFilters().add(extFilter);
    File file = fileChooser.showOpenDialog(z.stage2); 
    
    if(file!=null){
    
    read(file,group2);
    stage.close();
    
    }
    
    
    
    }
    
    
    public void read(File file,Group grp) {
        Fenetre z = new Fenetre();
        Message m=new Message();
        Outils o=new Outils();
        List<String> lines = new ArrayList<String>();
		String line;
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));

			while ((line = br.readLine()) != null) {
				lines.add(line);
			}
			br.close();
		} catch (IOException ex) {
			Logger.getLogger(Fichier.class.getName()).log(Level.SEVERE, null, ex);
		}
                String k;
                int tt = 0;
                String idd ="",iddb="";
                int l,id = 0,idb = 0;
                double xx = 0,yy = 0,rr = 0,xxb=0,yyb=0;
                
                for(int i=0;i<lines.size();i++){
                  //  k=Integer.parseInt(lines.get(i));
                  int t=0;
                  if(lines.get(i).startsWith("b")){
                    String Sb[]=lines.get(i).split(" ");
                    iddb=Sb[t];
                    idb=Integer.parseInt(Sb[t+1]);
                    xxb=Double.parseDouble(Sb[t+2]);
                    yyb=Double.parseDouble(Sb[t+3]);
                    
                  }
                  else{
                  String [] S=lines.get(i).split(" ");
                  idd=S[t];
                    id=Integer.parseInt(S[t+1]);
                    xx=Double.parseDouble(S[t+2]);
                    yy=Double.parseDouble(S[t+3]);
                    tt=Integer.parseInt(S[t+4]);
                    rr=Double.parseDouble(S[t+5]);
                  }
                  //k=String.valueOf(lines.get(i).charAt(t));
                //  l=Integer.parseInt(lines.get(i++));
                    /*if(S.length==4){
                    
                    System.out.println(xx+" "+yy);
                    }*/
                    
                    
                    
                    
                    
                    
                    
                    if(idd.startsWith("n")){
                    //System.out.println(id+"  "+xx+"  "+yy);
                    Circle c=new Circle();
                    c.setRadius(10);
                    c.setCenterX(xx);
                    c.setCenterY(yy);
                    c.setStrokeWidth(2);
                    c.setStroke(Color.BLACK);
                    c.setFill(Color.BLUE);
                    if(tt==1){c.setFill(Color.BLUE);t=1;}
                    if(tt==2){c.setFill(Color.RED);t=2;}
                    if(tt==3){c.setFill(Color.YELLOW);t=3;}
                    if(tt==4){c.setFill(Color.GREEN);t=4;}
                    
                    
                    grp.getChildren().add(c);
                    Capteur obj_noeud = new Capteur(id,xx,yy,rr,tt); //creation de l'objet Noeud
                    arrayNoeud.add(obj_noeud);
                    }
                    else{
                    if(idd.startsWith("a")){
                        Polygon triangle = new Polygon();
                        
                        triangle.getPoints().addAll(new Double[]{ // creation du triangle
                        xx, yy,
                        xx-10, yy+15,
                        xx+10, yy+15
                        });
                
                        triangle.setFill(Color.BLUE);
                        triangle.setStroke(Color.BLACK);
                        triangle.setStrokeWidth(2);
                        if(tt==1){triangle.setFill(Color.BLUE);t=1;}
                        if(tt==2){triangle.setFill(Color.RED);t=2;}
                        if(tt==3){triangle.setFill(Color.YELLOW);t=3;}
                        if(tt==4){triangle.setFill(Color.GREEN);t=4;}
                        grp.getChildren().add(triangle);
                        Actionneur obj_act = new Actionneur(id,xx,yy,rr,tt); //creation de l'objet Noeud
                        arrayActionneur.add(obj_act);
                    }
                    }
                    if(iddb.startsWith("b")){ 
                        
                        Rectangle rectangle = new Rectangle();                          // STATION DE BASE---------------------------------
                        rectangle.setLayoutX(xxb);
                        rectangle.setLayoutY(yyb);
                        rectangle.setWidth(60);
                        rectangle.setHeight(60);
                        rectangle.setStroke(Color.WHITE);
                        rectangle.setStrokeWidth(2);
                        rectangle.setFill(Color.BLACK);
                        grp.getChildren().add(rectangle);
                        Station obj_st=new Station(idb,xxb,yyb);
                        arrayStation.add(obj_st);
                    }
                    }
                
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
                    o.send(sel_x,sel_y,new_noeud);
                });
                menuItem2.setOnAction((ActionEvent e)->{
                    o.portee(new_noeud);
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
                }
		//return lines;
	}