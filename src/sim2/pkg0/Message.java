/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sim2.pkg0;

import java.io.IOException;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import java.util.ArrayList;
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
public class Message {
    
    boolean connexe=false;
    
    
    
    public void envoyer_act(ArrayList<Capteur> arrayNoeud,ArrayList<Actionneur> arrayActionneur,ArrayList<Station> arrayStation,int i,Capteur node,Actionneur act_dest) 
    {
       
       // System.out.println("ENVOYERRRRRRRRR -------------------------------------");
        
       // arrayNoeudChemin.add(node);
        
    int size=arrayNoeud.size();
    int j;    
    
    double x1,x2,y1,y2,D;
    
    
    double ray;
    
    D=0;
    
    for(j=0;j<size;j++)
    {
       // System.out.println("NUM FOR !!!!!!!!!!!!!!");
    ray=node.rayon;
        
    x1=(node.x);
    y1=(node.y);
    x2=(arrayNoeud.get(j).x);
    y2=(arrayNoeud.get(j).y);  
        
    D=sqrt((pow(x2-x1,2))+(pow(y1-y2,2)));
    //System.out.println("D = "+D);
        if(D<=ray && D!=0 )
        {
            
            
            
            
            
          arrayNoeudValide.add(arrayNoeud.get(j));
        //  System.out.println("VOISIN trouvé");
                    
                        //System.out.println(arrayNoeud.get(j).id);
                  //      System.out.println(arrayNoeud.get(j).x);
                    //    System.out.println(arrayNoeud.get(j).y);
                       
                       /* System.out.println(arrayNoeudValide.get(0).id);
                        System.out.println(arrayNoeudValide.get(0).x);
                        System.out.println(arrayNoeudValide.get(0).y);*/
                       
          
          
        }
    }
    
    
    //JE DOIS CHERCHER SI IL EXISTE LE MEILLEUR ACTIONNEUR 
    
   // System.out.println("JE DOIS CHERCHER SI IL EXISTE LE MEILLEUR ACTIONNEUR ");
    int size_a=arrayActionneur.size();
    double D_a;
    int w;
    
    Capteur noeud_act = new Capteur(0,0.0,0.0,0.0,1);
    
    for(w=0;w<size_a;w++)
    {
       // System.out.println("NUM FOR !!!!!!!!!!!!!!");
    ray=node.rayon;
        
    x1=(node.x);
    y1=(node.y);
    x2=(arrayActionneur.get(w).x);
    y2=(arrayActionneur.get(w).y);  
        
    D_a=sqrt((pow(x2-x1,2))+(pow(y1-y2,2)));
    //System.out.println("D = "+D);
        if(D_a<=ray )
        {
            noeud_act.id=arrayActionneur.get(w).id;
            noeud_act.x=arrayActionneur.get(w).x;
            noeud_act.y=arrayActionneur.get(w).y;
            noeud_act.type=arrayActionneur.get(w).type;
            noeud_act.rayon=arrayActionneur.get(w).rayon;
            
            
          arrayNoeudValide.add(noeud_act);
        //  System.out.println("VOISIN trouvé est un Actionneur !!!!");
                    
                  
                       
          
          
        }
    }
    
    
    
    
    //A LA RECHERCHE DU MEILLEUR ACTIONNEUR***********
  /*  int size_act=arrayActionneur.size();
    int n;
    double x_act,y_act;
    
        x_act=arrayActionneur.get(0).x;
        y_act=arrayActionneur.get(0).y;
        
        
    
    
    for(n=0;n<size_act;n++)
    {
        x_act=arrayActionneur.get(n).x;
        y_act=arrayActionneur.get(n).y;
        
    }
    
    */
    //***********************************************
    
    int k;
    int size2=arrayNoeudValide.size();
    
    //min=arrayNoeudValide.get(0).
    
    
    double x_st,y_st;
    double x_valide,y_valide;
    double D_valide;
    double min;
    
    
   // x_st=arrayStation.get(0).x;
   // y_st=arrayStation.get(0).y;
    
    
    
    Capteur nextHop = new Capteur(0,0.0,0.0,0.0,1);
    
    
    
    min=sqrt((pow(arrayNoeudValide.get(0).x-act_dest.x,2))+(pow(act_dest.y-arrayNoeudValide.get(0).y,2)));
    
    nextHop=arrayNoeudValide.get(0);
    
   /* System.out.println("NEXT HOP NRMLM :");
     System.out.println(arrayNoeudValide.get(0).id);
                        System.out.println(arrayNoeudValide.get(0).x);
                        System.out.println(arrayNoeudValide.get(0).y);*/
    
    
    for(k=0;k<size2;k++)
    {
       // System.out.println("VOISIN test");
        x_valide=arrayNoeudValide.get(k).x;
        y_valide=arrayNoeudValide.get(k).y;
        
        D_valide=sqrt((pow(x_valide-act_dest.x,2))+(pow(act_dest.y-y_valide,2)));
        
        if(D_valide<=min)
        {
        min=D_valide;
        
        nextHop=arrayNoeudValide.get(k);
       /* System.out.println("BEST Next Hop = "+nextHop.id);
        System.out.println("BEST Next Hop = "+nextHop.x);
        System.out.println("BEST Next Hop = "+nextHop.y);*/
        
        }
    
    }
    
    //arrayNoeudChemin.add(nextHop);
    
    //System.out.println("BEST !! = "+nextHop.id);
    
     arrayNoeudChemin.add(node);
    
    int D_final;
        D_final=(int)sqrt((pow(nextHop.x-act_dest.x,2))+(pow(act_dest.y-nextHop.y,2)));
    
        //System.out.println(D_final);
        
    
    
         if(D_final>nextHop.rayon)
         {  
                                            i=nextHop.id; 
                                            //System.out.println("BEST Voisin = "+nextHop.id);
                                            envoyer_act(arrayNoeud,arrayActionneur,arrayStation,i,nextHop,act_dest);
         }
                                            
         if(D_final<=nextHop.rayon)
         {arrayNoeudChemin.add(nextHop);
         /*System.out.println("BEST Final = "+nextHop.id);*/
         }
        
        // System.out.println("BEST  33 !!");
    
     
    
    
    
    
  // connexe=true;
  
       
        
    }
    
    
    public void envoyer_base(ArrayList<Capteur> arrayNoeud,ArrayList<Station> station, Actionneur action)
    {
        
        
        
        int j;
        int size=arrayNoeud.size();
    double x1,y1,x2,y2;
    double ray;
    double D;
    double x_state=arrayStation.get(0).x;
    double y_state=arrayStation.get(0).y;
        
    //System.out.println("size arrayNoeud = "+size);
    double dd;
   
   dd=sqrt((pow(action.x-x_state,2))+(pow(y_state-action.y,2)));
   
   if(dd<=action.rayon)
   {
       System.out.println("DANS LE IFFFFFF");
       Capteur action_node = new Capteur(0,0.0,0.0,0.0,1);
       action_node.x=action.x;
       action_node.y=action.y;
       action_node.id=action.id;
       action_node.type=action.type;
       action_node.rayon=action.rayon;
       
       
  // arrayNoeudValide_act.add(action_node);
   }
    
    
else
 {
     System.out.println("DANS LE ELSE");
    
    for(j=0;j<size;j++)
    {
        //System.out.println("NUM FOR !!!!!!!!!!!!!!");
    ray=action.rayon;
        
    x1=(action.x);
    y1=(action.y);
    x2=(arrayNoeud.get(j).x);
    y2=(arrayNoeud.get(j).y);  
        
    D=sqrt((pow(x2-x1,2))+(pow(y1-y2,2)));
    //System.out.println("D = "+D);
        if(D<=ray )
        {
          arrayNoeudValide_act.add(arrayNoeud.get(j));
          System.out.println("VOISIN trouvééé");
                    
                        System.out.println(arrayNoeud.get(j).id);
                      //  System.out.println(arrayNoeud.get(j).x);
                      //  System.out.println(arrayNoeud.get(j).y);
                       
                      //  System.out.println(arrayNoeudValide_act.get(j).id);
                     //   System.out.println(arrayNoeudValide_act.get(j).x);
                      //  System.out.println(arrayNoeudValide_act.get(j).y);
                       
          
          
        }
    }
        
    int size2=arrayNoeudValide_act.size();
   // System.out.println("size 2 = "+arrayNoeudValide_act.size());
   // double x_state,y_state;
    double min_act,d_act;
    
    
    
    Capteur nextHop2 = new Capteur(0,0.0,0.0,0.0,1);
    
    
    
    min_act=sqrt((pow(arrayNoeudValide_act.get(0).x-x_state,2))+(pow(y_state-arrayNoeudValide_act.get(0).y,2)));
    
    nextHop2=arrayNoeudValide_act.get(0);
    
    for(int m=0;m<size2;m++)
    {
    d_act=sqrt((pow(arrayNoeudValide_act.get(m).x-x_state,2))+(pow(y_state-arrayNoeudValide_act.get(m).y,2)));
    
    if(d_act<=min_act)
            {
            min_act=d_act;
            nextHop2=arrayNoeudValide_act.get(m);
            
           //  System.out.println("VOISIN meilleur");
                    
                      //  System.out.println(nextHop2.id);
                      //  System.out.println(arrayNoeud.get(j).x);
                      //  System.out.println(arrayNoeud.get(j).y);
            
            
            }
   
    }
    
    envoyer(nextHop2);
    
 }//fin else
    
    
  //  System.out.println("THE NEXTHOP 2 :"+nextHop2.id);
  //  System.out.println(nextHop2.id);
  //  System.out.println(nextHop2.x);
   // System.out.println(nextHop2.y);
   
  /* double dd;
   
   dd=sqrt((pow(action.x-x_state,2))+(pow(y_state-action.y,2)));
   
   if(dd<=action.rayon)
   {
       Noeud action_node = new Noeud(0,0.0,0.0,0.0,1);
       action_node.x=action.x;
       action_node.y=action.y;
       action_node.id=action.id;
       action_node.type=action.type;
       action_node.rayon=action.rayon;
       
       
   arrayNoeudValide_act.add(action_node);
   }
   else
   {
            for(int m=0;m<size2;m++)
    {
    d_act=sqrt((pow(arrayNoeudValide_act.get(m).x-x_state,2))+(pow(y_state-arrayNoeudValide_act.get(m).y,2)));
    
    if(d_act<=min_act)
            {
            min_act=d_act;
            nextHop2=arrayNoeudValide_act.get(m);
            
            }
   
    }
       
       
   }*/
   
   
   
    
   // envoyer(nextHop2);
    
    
   
   
   
    }
    
   
    public void envoyer(Capteur nextHop2)
    {
    int size5=arrayNoeud.size();
    int p;
    double ray;
    double x1,y1,x2,y2;
    double Dis,Diss;
    
    
    //**********/*//*/*/*/****
    
    
    
    Diss=sqrt((pow(arrayStation.get(0).x-nextHop2.x,2))+(pow(nextHop2.y-arrayStation.get(0).y,2)));
    
    if(Diss<=nextHop2.rayon)
    {
        arrayNoeudChemin_act.add(nextHop2);
    
    }
    else
    {
        for(p=0;p<size5;p++)
    {
       // System.out.println("NUM FOR !!!!!!!!!!!!!!");
    ray=nextHop2.rayon;
        
    x1=(nextHop2.x);
    y1=(nextHop2.y);
    x2=(arrayNoeud.get(p).x);
    y2=(arrayNoeud.get(p).y);  
        
    Dis=sqrt((pow(x2-x1,2))+(pow(y1-y2,2)));
    //System.out.println("D = "+D);
        if(Dis<=ray && Dis!=0)
        {
          arrayNoeudValide_nextHop2.add(arrayNoeud.get(p));
        //  System.out.println("VOISIN de NextHop 2 trouvé : "+arrayNoeud.get(p).id);
                    
                    //    System.out.println(arrayNoeud.get(p).id);
                  //      System.out.println(arrayNoeud.get(j).x);
                    //    System.out.println(arrayNoeud.get(j).y);
                       
                      //  System.out.println(arrayNoeudValide.get(0).id);
                      //  System.out.println(arrayNoeudValide.get(0).x);
                      //  System.out.println(arrayNoeudValide.get(0).y);
                       
          
          
        }
    }
        
        
        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        
         int size_a=arrayActionneur.size();
    double D_a;
    int w;
    
    Capteur noeud_act = new Capteur(0,0.0,0.0,0.0,1);
    
    for(w=0;w<size_a;w++)
    {
       // System.out.println("NUM FOR !!!!!!!!!!!!!!");
    ray=nextHop2.rayon;
        
    x1=(nextHop2.x);
    y1=(nextHop2.y);
    x2=(arrayActionneur.get(w).x);
    y2=(arrayActionneur.get(w).y);  
        
    D_a=sqrt((pow(x2-x1,2))+(pow(y1-y2,2)));
    //System.out.println("D = "+D);
        if(D_a<=ray )
        {
            noeud_act.id=arrayActionneur.get(w).id;
            noeud_act.x=arrayActionneur.get(w).x;
            noeud_act.y=arrayActionneur.get(w).y;
            noeud_act.type=arrayActionneur.get(w).type;
            noeud_act.rayon=arrayActionneur.get(w).rayon;
            
            
          arrayNoeudValide_nextHop2.add(noeud_act);
        //  System.out.println("VOISIN trouvé est un Actionneur !!!!");
                    
                  
                       
          
          
        }
    }
    
        
        
        
        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        
                
        
        
        
        
        
        //le meilleur des arrayNoeudValide_NextHop2
        
        double mini;
        double base_x,base_y;
        int q;
        int size6=arrayNoeudValide_nextHop2.size();
        
        base_x=arrayStation.get(0).x;
        base_y=arrayStation.get(0).y;
        
        Capteur nextHop3 = new Capteur(0,0.0,0.0,0.0,1);
    
    
    
    mini=sqrt((pow(arrayNoeudValide_nextHop2.get(0).x-base_x,2))+(pow(base_y-arrayNoeudValide_nextHop2.get(0).y,2)));
    
    nextHop3=arrayNoeudValide_nextHop2.get(0);
    
   /* System.out.println("NEXT HOP NRMLM :");
     System.out.println(arrayNoeudValide.get(0).id);
                        System.out.println(arrayNoeudValide.get(0).x);
                        System.out.println(arrayNoeudValide.get(0).y);*/
    double x_v,y_v;
    double D_v;
    //System.out.println("size6 = : "+size6);
    
    for(q=0;q<size6;q++)
    {
      //  System.out.println("VOISIN test");
        x_v=arrayNoeudValide_nextHop2.get(q).x;
        y_v=arrayNoeudValide_nextHop2.get(q).y;
        
        D_v=sqrt((pow(x_v-base_x,2))+(pow(base_y-y_v,2)));
        
        if(D_v<=mini)
        {
        mini=D_v;
        
        nextHop3=arrayNoeudValide_nextHop2.get(q);
       /* System.out.println("BEST Next Hop = "+nextHop.id);
        System.out.println("BEST Next Hop = "+nextHop.x);
        System.out.println("BEST Next Hop = "+nextHop.y);*/
        
        }
    
    }
    
    
   // System.out.println("BEST voisin de NextHop2 = "+nextHop3.id);
    
     arrayNoeudChemin_act.add(nextHop2);
     
     int D_fin;
        D_fin=(int)sqrt((pow(nextHop3.x-base_x,2))+(pow(base_y-nextHop3.y,2)));
        
         if(D_fin>nextHop3.rayon)
         {  
                                            int i=nextHop3.id; 
                                          //  System.out.println("BEST Voisin = "+nextHop3.id);
                                           // envoyer_act(arrayNoeud,arrayActionneur,arrayStation,i,nextHop,act_dest);
                                           envoyer(nextHop3);
         }
                                            
         if(D_fin<=nextHop3.rayon)
         {arrayNoeudChemin_act.add(nextHop3);
       //  System.out.println("BEST Final = "+nextHop3.id);
         }
        
    }//fin else  
    }
    
   
    
}
