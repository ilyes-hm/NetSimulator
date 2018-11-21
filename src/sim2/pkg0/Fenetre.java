/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sim2.pkg0;

import static com.sun.org.apache.bcel.internal.util.SecuritySupport.getResourceAsStream;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import static sim2.pkg0.Aleatoire.arrayActionneur;
import static sim2.pkg0.Aleatoire.arrayNoeud;
import static sim2.pkg0.Aleatoire.arrayStation;
import static sim2.pkg0.Outils.arrayNoeudChemin;
import static sim2.pkg0.Outils.arrayNoeudChemin_act;
import static sim2.pkg0.Outils.arrayNoeudValide;
import static sim2.pkg0.Outils.arrayNoeudValide_act;
import static sim2.pkg0.Outils.arrayNoeudValide_nextHop2;
import static com.sun.org.apache.bcel.internal.util.SecuritySupport.getResourceAsStream;

/**
 *
 * @author ilyes
 */
public class Fenetre {
    
    public static Stage stage2 = new Stage();                                                  //GLOBAL THINGS
    public static Group group2 = new Group();
    public static Scene scene2 = new Scene(group2, 1200, 700 ,Color.CADETBLUE);
    
  //  public static Bars bars = new Bars();
    
   // Bars x = new Bars();
   // Outils y = new Outils();
    
    //Bars bars = new Bars();
    //Outils outils= new Outils();
    
    public void board()
    {
        
        
        
        
        
        //.choix.stage.close();
    //public static Outils outils = new Outils();
    
        
       // bars.bars(this);
      //stage2.getIcons().add(new Image("/home/samy/NetBeansProjects/Sim2.0/Files/icon.png"));
        stage2.setTitle("SIMULATEUR des Reseaux des Objets Coopérants ");
  
       // stage2.getIcons().add(new Image("icon.jpg"));
        
    
    //bars.bars();
    //y.outils();
    
    
      /* Rootage rt = new Rootage();
       rt.root();*/
     /*   arrayNoeud.clear();
    arrayActionneur.clear();
    arrayStation.clear();
    
    arrayNoeudValide.clear();
    arrayNoeudChemin.clear();
    arrayNoeudValide_act.clear();
    arrayNoeudValide_nextHop2.clear();
    arrayNoeudChemin_act.clear();*/

    stage2.setScene(scene2);                                                      //ADD SCENE TO STAGE
    stage2.show(); 
    }
    
}
