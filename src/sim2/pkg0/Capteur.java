/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sim2.pkg0;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

/**
 *
 * @author ilyes
 */
public class Capteur {
    
    int id;
     double x,y,rayon;
     int type;
     
     public Capteur(int id,double x,double y,double rayon,int type)
    {
        
    this.id = id;
    this.x = x;
    this.y = y;
    this.rayon = rayon;
    this.type = type;
    }

  
     
     //Writer fileNoeud = new FileWriter("/home/samy/NetBeansProjects/Sim2.0/Files/fileNoeud.txt");

     public  void SaveFileNoeud(ArrayList<Capteur> arrayNoeud,int i,Writer fileNoeud) throws IOException
    {
        
        //for(int j=0;j<i;i++)
      //  {
        //fileNoeud.write("TEST \n");
       
        fileNoeud.write(arrayNoeud.get(i).id+" ");
        fileNoeud.write(arrayNoeud.get(i).x+" ");
        fileNoeud.write(arrayNoeud.get(i).y+" ");
        fileNoeud.write(arrayNoeud.get(i).rayon+"\n");
        
        //System.out.println("AAAAAAAAA \n");
        
       /* System.out.println(arrayNoeud.get(i).id+" ");
        System.out.println(arrayNoeud.get(i).x+" ");
        System.out.println(arrayNoeud.get(i).y+" ");
        System.out.println(arrayNoeud.get(i).r+" ");*/
        
        
       // }
       
       
        
    }
     
     
}

