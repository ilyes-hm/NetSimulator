/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sim2.pkg0;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.HostServices;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import static sim2.pkg0.Barre.tuto;

/**
 *
 * @author ilyes
 */
public class Simulateur extends Application {
    
    public static Choix choix = new Choix();
    public static Fenetre board = new Fenetre();
    public static Barre bars = new Barre();
    public static Outils outils = new Outils();
    
    @Override
    public void start(Stage primaryStage) {
        
       tuto.setText("Guide d'utilisation");
     //  File parentDir = new File("/home/samy/NetBeansProjects/Redaction Finale/SIMUL.F/Sim2.0/src/sim2/pkg0");
       File parentDir = new File("./");
       File pdf=new File(parentDir,"Tuto.pdf");
       HostServices hostServices = getHostServices();
    
        tuto.setOnAction(new EventHandler<ActionEvent>() {
            
            public void handle(ActionEvent event) {
                hostServices.showDocument(pdf.getAbsolutePath());
            }});
        
        
        
        
       board.board();
       
       bars.bars(board,choix);
     /*   try {
            outils.outils(board,choix);
            
            //choix.choix();
        } catch (IOException ex) {
            Logger.getLogger(Sim20.class.getName()).log(Level.SEVERE, null, ex);
        }*/
     
   //  Rootage rt = new Rootage();
    //   rt.root();
     
       
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
