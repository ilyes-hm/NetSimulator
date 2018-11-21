/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sim2.pkg0;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
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
import static sim2.pkg0.Simulateur.bars;
import static sim2.pkg0.Simulateur.board;
import static sim2.pkg0.Simulateur.choix;

/**
 *
 * @author ilyes
 */


public class Choix {
    public static Stage stage = new Stage();
    public static Group group = new Group();
    public static Scene scene = new Scene(group, 900, 600,Color.CADETBLUE );
    
    MenuItem tuto;
    
    
    Button buttonAleatoire = new Button("Création des nœuds \n   ALEATOIREMENT");
    Button buttonSouris = new Button("  Création des nœuds \n  par CLIC DE SOURIS"); 
    Button buttonFichier = new Button("  Création des nœuds \n à partir d'un FICHIER"); 
    
    Button annuler = new Button("ANNULER");                                     //ANNULER PRECEDENT SUIVANT
    Button precedent = new Button("PRECEDENT");
    Button suivant = new Button("SUIVANT");
    
    public static TextField field1 = new TextField();                                          //FILEDS 
    public static TextField field2 = new TextField();
    
    
    public static Fenetre board = new Fenetre();
    public static Aleatoire aleatoire = new Aleatoire();
    public static Barre bars = new Barre();
    public static Outils outils= new Outils();
    
    
    public void choix(Group group22){                                                        // FONCTION CHOIX
        
       group.getChildren().clear();
      buttonAleatoire.setStyle(//"-fx-background-color:\n" + 
                             //  "linear-gradient(#f0ff35, #a9ff00),\n" +
                             //  "radial-gradient(center 50% -40%, radius 200%, #b8ee36 45%, #80c800 50%);\n" +
                             //  "-fx-background-radius: 6, 5;\n" +
                             //  "-fx-background-insets: 0, 1;\n" +
                               "-fx-font-size: 120%;"+
                                       
                                       "-fx-font-weight: bold;"+
                                      
                             //  "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );\n" +
                               "-fx-text-fill: black;"+
                                "-fx-color: gainsboro;"
                                );
      
      buttonSouris.setStyle(//"-fx-background-color:\n" + 
                             //  "linear-gradient(#f0ff35, #a9ff00),\n" +
                             //  "radial-gradient(center 50% -40%, radius 200%, #b8ee36 45%, #80c800 50%);\n" +
                             //  "-fx-background-radius: 6, 5;\n" +
                             //  "-fx-background-insets: 0, 1;\n" +
                               "-fx-font-size: 120%;"+
                                       
                                       "-fx-font-weight: bold;"+
                                      
                             //  "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );\n" +
                               "-fx-text-fill: black;"+
                                "-fx-color: gainsboro;");
      
      buttonFichier.setStyle(//"-fx-background-color:\n" + 
                             //  "linear-gradient(#f0ff35, #a9ff00),\n" +
                             //  "radial-gradient(center 50% -40%, radius 200%, #b8ee36 45%, #80c800 50%);\n" +
                             //  "-fx-background-radius: 6, 5;\n" +
                             //  "-fx-background-insets: 0, 1;\n" +
                               "-fx-font-size: 120%;"+
                                       
                                       "-fx-font-weight: bold;"+
                                      
                             //  "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );\n" +
                               "-fx-text-fill: black;"+
                                "-fx-color: gainsboro;");
    
    buttonAleatoire.setPrefSize(220,200);
    buttonSouris.setPrefSize(220,200);
    buttonFichier.setPrefSize(220,200);
    
    buttonAleatoire.setLayoutX(100);
    buttonAleatoire.setLayoutY(100);
    buttonSouris.setLayoutX(350);
    buttonSouris.setLayoutY(100);
    buttonFichier.setLayoutX(600);
    buttonFichier.setLayoutY(100);
    
     arrayNoeud.clear();
    arrayActionneur.clear();
    arrayStation.clear();
    
    arrayNoeudValide.clear();
    arrayNoeudChemin.clear();
    arrayNoeudValide_act.clear();
    arrayNoeudValide_nextHop2.clear();
    arrayNoeudChemin_act.clear();
    
    buttonAleatoire.setOnAction(actionEvent -> {                                //BUTTON ALEATOIRE
    group.getChildren().removeAll(buttonAleatoire,buttonSouris,buttonFichier);
    
    
    
    
    field1.setText("0");
    field2.setText("0");
    Label label1 = new Label("Nombre des Noeuds");
    Label label2 = new Label("Nombre d'Actionnaires");
    
    annuler.setLayoutX(500);                                                    //SET POSITIONS
    annuler.setLayoutY(500);
    precedent.setLayoutX(600);
    precedent.setLayoutY(500);
    suivant.setLayoutX(720);
    suivant.setLayoutY(500);
    
    label1.setLayoutX(300);
    label1.setLayoutY(200);
    label2.setLayoutX(300);
    label2.setLayoutY(300);
    field1.setLayoutX(500);
    field1.setLayoutY(200);
    field2.setLayoutX(500);
    field2.setLayoutY(300);
    
    group.getChildren().addAll(label1,label2,field1,field2,annuler,precedent,suivant);
    
    });
    
    annuler.setOnAction(actionEvent -> {                                        //ANNULER
        stage.close();
    });
    
    precedent.setOnAction(actionEvent -> {                                      //PRECEDENT
       
       group.getChildren().clear();
       group.getChildren().addAll(buttonAleatoire,buttonSouris,buttonFichier);
    });
    suivant.setOnAction(actionEvent -> {                                                  try {                                        //BOUTTON SUIVANT
        
        stage.close();
        
        group22.getChildren().clear();
        
        // board.board();
        bars.bars(board,choix);
        
        //board.board();
        //bars.bars(board);
        outils.outils(board,choix);
        
        
        try {
            aleatoire.aleatoire(board);
        } catch (IOException ex) {
            Logger.getLogger(Choix.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    } catch (IOException ex) {
              Logger.getLogger(Choix.class.getName()).log(Level.SEVERE, null, ex);
          }
      
   
    
    
        
        
    });
    
    
    buttonSouris.setOnAction(actionEvent -> {                                   try {
        //BOUTTON SOURIS
        //Souris souris = new Souris();
        stage.close();
        group22.getChildren().clear();
        board.board();
        bars.bars(board,choix);
        outils.outils(board,choix);
        
        
        // souris.souris(board);
           } catch (IOException ex) {
               Logger.getLogger(Choix.class.getName()).log(Level.SEVERE, null, ex);
           }
    });
    buttonFichier.setOnAction(actionEvent -> {                                  //BOUTTON FICHIER
   stage.close();
        group22.getChildren().clear();
        board.board();
        bars.bars(board,choix);
           try {
               outils.outils(board,choix);
           } catch (IOException ex) {
               Logger.getLogger(Choix.class.getName()).log(Level.SEVERE, null, ex);
           }
        
        Fichier fichier = new Fichier();
    fichier.fichier(board);
    
   // fichier.fichier(board);
    
    
    });
    
    
    
    group.getChildren().addAll(buttonAleatoire,buttonSouris,buttonFichier);

    stage.setScene(scene);                                                      //ADD SCENE TO STAGE
    stage.show();  
    
    }
            
    
  
    
    
}
