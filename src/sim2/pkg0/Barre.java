/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sim2.pkg0;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import static sim2.pkg0.Aleatoire.arrayActionneur;
import static sim2.pkg0.Aleatoire.arrayNoeud;
import static sim2.pkg0.Aleatoire.arrayStation;

/**
 *
 * @author ilyes
 */
public class Barre {
 
   // public static Board board = new Board();
    public static MenuItem tuto=new MenuItem();
    Fenetre z = new Fenetre();
   
    
     Choix x = new Choix();
    
    public void bars(Fenetre z,Choix x)
    {
        
    MenuBar menuBar = new MenuBar();
    
    menuBar.prefWidthProperty().bind( z.stage2.widthProperty());
    Menu fichierMenu = new Menu("Fichier");                                     //FICHIER
        MenuItem nouveauMenuItem = new MenuItem("Nouveau");                     //NOUVEAU
        fichierMenu.getItems().add(nouveauMenuItem);
        nouveauMenuItem.setOnAction(actionEvent -> nouveau(x) );
        
        MenuItem ouvrirMenuItem = new MenuItem("Ouvrir");                       //OUVRIR
        fichierMenu.getItems().add(ouvrirMenuItem);
        ouvrirMenuItem.setOnAction(actionEvent -> ouvrir() );

        MenuItem enregistrerMenuItem = new MenuItem("Enregistrer");             //ENREGISTRER
        fichierMenu.getItems().add(enregistrerMenuItem);
        enregistrerMenuItem.setOnAction(actionEvent -> {
        try {
            sauvgarder();
        } catch (IOException ex) {
            Logger.getLogger(Barre.class.getName()).log(Level.SEVERE, null, ex);
        }
    } );
        
        MenuItem quitterMenuItem = new MenuItem("Quitter");                     //QUITTER
        fichierMenu.getItems().add(quitterMenuItem);
        quitterMenuItem.setOnAction(actionEvent -> quitter() );
                
                                         //EDITION
    Menu aideMenu = new Menu("Aide");                                           //AIDE
    //tuto.setText("Guide d'utilisation");
    MenuItem propos=new MenuItem("À propos");
    propos.setOnAction(actionEvent ->{
        Stage Pr =new Stage();
        Pr.setTitle("À propos");
        Group gp=new Group();
        Label l1=new Label("Simulateur de réseaux des objets coopérants");
            l1.setLayoutX(75);
            l1.setLayoutY(50);
            Label l2=new Label("                      Version 1.0");
            l2.setLayoutX(85);
            l2.setLayoutY(100);
            Label l3=new Label("                   Développé par:");
            l3.setLayoutX(80);
            l3.setLayoutY(150);
            Label l4=new Label("                 Malik Louail et Ilyes Hamitouche");
            l4.setLayoutX(30);
            l4.setLayoutY(170);
            Label l5=new Label("                     Encadré par:");
            l5.setLayoutX(80);
            l5.setLayoutY(250); 
            Label l6=new Label("                          Dr. A.Benaouda ");
            l6.setLayoutX(50);
            l6.setLayoutY(270);
            Label l8=new Label("     Université de Sétif 1, Faculté des sciences");
            l8.setLayoutX(50);
            l8.setLayoutY(300);
            Label l7=new Label("                 © 2015-2016");
            l7.setLayoutX(85);
            l7.setLayoutY(330);
            gp.getChildren().addAll(l1,l2,l3,l4,l5,l6,l7,l8);
            Scene sp=new Scene(gp,400,350);
            Pr.setScene(sp);
            Pr.show();
    });
    aideMenu.getItems().addAll(tuto,propos);
    menuBar.getMenus().addAll(fichierMenu,aideMenu);
    
    
    
    z.group2.getChildren().addAll(menuBar);
    //bp.group2.getChildren().addAll(menuBar);
    
    
    
    
    }
    
    public void nouveau(Choix x)                                                       //FONCTION NOUVEAU
    {
    //z.group2.getChildren().clear();
    
    
    
   x.choix(z.group2);
    
    
    }
    
    public void ouvrir()                                                        //FONCTION OUVRIR
    {
        Fichier f=new Fichier();
        f.fichier(z);
    }
    
    
    public void sauvgarder() throws IOException
    {
        //FileWriter fileWriter=null;
     //   Writer fileNoeudWriter = new FileWriter("/home/samy/NetBeansProjects/Sim2.0/Files/fileNoeud.txt");
     //   Writer fileActionneurWriter = new FileWriter("/home/samy/NetBeansProjects/Sim2.0/Files/fileActionneur.txt");
              
                String S="0";
     
                   
             FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Enregistrer");
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.Txt)", "*.Txt");
                fileChooser.getExtensionFilters().add(extFilter);
                File file = fileChooser.showSaveDialog(z.stage2);
                
                 Writer fileNoeudWriter = new FileWriter(file);
                
                
                if(file!=null){
                   
                     
                
                
             
                    for(int i=0;i<arrayNoeud.size();i++){
                    //String S=arrayNoeud.get(i).concat(arrayNoeud.get(i++));
                    
                         S=String.valueOf("n "+arrayNoeud.get(i).id+" "+arrayNoeud.get(i).x+" "+arrayNoeud.get(i).y+" "+arrayNoeud.get(i).type+" "+arrayNoeud.get(i).rayon+"\n");
                        //SaveFile(S,file,fileWriter);
                        
                        fileNoeudWriter.write(S);
                        
                  //  System.out.println("Num for");
                    }
                //    fileNoeudWriter.close();
                    
                    
                    for(int i=0;i<arrayActionneur.size();i++){
                    //String S=arrayNoeud.get(i).concat(arrayNoeud.get(i++));
                    
                         S=String.valueOf("a "+arrayActionneur.get(i).id+" "+arrayActionneur.get(i).x+" "+arrayActionneur.get(i).y+" "+arrayActionneur.get(i).type+" "+arrayActionneur.get(i).rayon+"\n");
                        //SaveFile(S,file,fileWriter);
                        
                        fileNoeudWriter.write(S);
                        
                //    System.out.println("Num for");
                    }
                    
                    S=String.valueOf("b "+arrayStation.get(0).id+" "+arrayStation.get(0).x+" "+arrayStation.get(0).y+"\n");
                    fileNoeudWriter.write(S);
                    
                    fileNoeudWriter.close();
    
                }//fin de file!=null
    }
   
    
    
    
    
    
    public void quitter()                                                       //FONCTION QUITTER
    { 
    z.stage2.close();
    }
    
    
}
