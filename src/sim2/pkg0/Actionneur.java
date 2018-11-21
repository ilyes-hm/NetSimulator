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
public class Actionneur {
       public int id,type;
    public double x,y,rayon;

    
    
    public Actionneur(int id,double x,double y,double rayon,int type)
    {
    this.id = id;
    this.x = x;
    this.y = y;
    this.rayon=rayon;
    this.type = type;
    }

    
    
    //Writer fileActionneur = new FileWriter("/home/samy/NetBeansProjects/Sim2.0/Files/fileActionneur.txt");
    
    public   void SaveFileActionneur(ArrayList<Actionneur> arrayActionneur,int i,Writer fileActionneur) throws IOException
    {
            //System.out.println("TESTTT ");
        
       // for(int i=0;i<arrayActionneur.size();i++)
        //{
        
        //fileActionneur.write("TEST");
        
        fileActionneur.write(arrayActionneur.get(i).id+" ");
        fileActionneur.write(arrayActionneur.get(i).x+" ");
        fileActionneur.write(arrayActionneur.get(i).y+" \n");
       // }
        
    }
    
}
