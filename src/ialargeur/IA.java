/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ialargeur;

import java.util.ArrayList;

/**
 *
 * @author oneiroi
 */
public class IA {
    int cruche4L=0;
    int cruche3L=0;
    
ArrayList<IA> tchemin= new ArrayList<>();
//sinit 

public boolean but(IA e){
    if((e.cruche4L==2)||(e.cruche3L==2)){
        return true;
    }else{
            return false;
            }
}

public ArrayList<IA> successeurs(IA e){
IA e1=new IA();
ArrayList<IA> ens= new ArrayList<>();
e1=e;
e1.cruche4L+=4;   
if(this.valide(e1)){
    ens.add(e1);
}
e1=e;
e1.cruche3L+=3;   
if(this.valide(e1)){
    ens.add(e1);
}
e1=e;
e1.cruche3L-=3;   
if(this.valide(e1)){
    ens.add(e1);
}
e1=e;
e1.cruche4L-=4;   
if(this.valide(e1)){
    ens.add(e1);
}
e1=e;
e1.cruche3L+= e1.cruche4L;
e1.cruche4L-=4;
if(this.valide(e1)){
    ens.add(e1);
}

e1=e;
e1.cruche4L+= e1.cruche3L;
e1.cruche3L-=3;
if(this.valide(e1)){
    ens.add(e1);
}
return ens;
}

public boolean valide(IA e){
    if((e.cruche4L<=4||e.cruche4L>=0)&&(e.cruche3L<=3||e.cruche3L >=0)){
        return true;
    }else{
        if(e.cruche4L>4){
            e.cruche4L=4;
        }else if(e.cruche4L<0){
            e.cruche4L=0;
            }else if(e.cruche3L>3){
                e.cruche3L=3;
                }else if(e.cruche3L<0){
                    e.cruche3L=0;
                    }else{
                        return false;
                    }
        return true;
    }
}

public ArrayList<IA> cruche(IA e, ArrayList<IA> chemin){
    ArrayList<IA> sol = new ArrayList<>();
    ArrayList<IA> ens = new ArrayList<IA>();
    boolean fin=false;
    if(e.but(e)){
        sol.addAll(chemin);
        return sol;            
    }else{
        ens.addAll(e.successeurs(e));
        while(!ens.isEmpty()&&!fin){
            chemin.add(-1,ens.get(0));
            if(e.but(chemin.get(-1))){
                fin=true;
                sol.addAll(chemin);
            }else{
                chemin.addAll(cruche(ens.get(0),chemin));
            }
            ens.remove(0);
        }
        return sol;
    }
} 
}
