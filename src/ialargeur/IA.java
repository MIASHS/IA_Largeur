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

public ArrayList<IA> successeurs(IA e) throws CloneNotSupportedException{
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



Tchemin SSALGO Cruche(e:Tetat)
chemin,sol : Tchemin
l: Tliste
ens: Tens
Fin : Booleen
DEBUT
    chemin<-CREER()
    sol<-CREER()
    l<-CREER()
    ens<-CREER()
    SI But?(e)
        ALORS
sol<-chemin 
RETOURNER sol
    SINON
        ens<-Successeur(e)
        TANT QUE NON VIDE(ens)
            s<-CHOISIR(ens)
            ens<-SUPPRIMER(ens,s)
            l<-ADJ(l,s)
        FTQ
        Fin<-faux
        TANT QUE NON VIDE(l) ET NON Fin FAIRE
            chemin<-ADJ(TETE(l),chemin)
            SI But?(QUEUE(chemin))
                Fin<-VRAI
                sol<-chemin
            SINON 
                chemin<-Cruche(TETE(l),chemin)
            FSI
            l<-RESTE(l)
        FTQ
        RETOURNER sol
    FSI
FSP
}
