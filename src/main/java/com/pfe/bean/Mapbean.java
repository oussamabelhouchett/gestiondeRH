/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfe.bean;

import com.pfe.model.Client;
import com.pfe.model.langage;
import com.pfe.reposotory.ClientJpa;
import com.pfe.reposotory.langagerepo;
import com.pfe.scope.ScopeName;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ScopeName.VIEW)
 @ManagedBean
        @SessionScoped
public class Mapbean {
    @Autowired
    private langagerepo lang;
    public class langagemax{
          private String langage;
    private int max; 
     public String getLangage() {
            return langage;
        }

        public void setLangage(String langage) {
            this.langage = langage;
        }

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }
    
    }


       
    
    private String namemap;
    private int nbrdecv;
    private double  poucentage;

    public double getPoucentage() {
        poucentage=poucentage();
        return poucentage;
    }

    public void setPoucentage(double poucentage) {
        this.poucentage = poucentage;
    }
    
  
private langagemax g;

    public langagemax getG() {
        g=chercher();
        return g;
    }

    public void setG(langagemax g) {
        this.g = g;
    }

   
   
    @Autowired
    private ClientJpa clientjpa;

    public int getNbrdecv() {
        nbrdecv=nbredeclienparville();
        return nbrdecv;
    }

    public void setNbrdecv(int nbrdecv) {
        this.nbrdecv = nbrdecv;
    }

    public String getNamemap() {
        
        return namemap;
    }

    public void setNamemap(String namemap) {
        
        this.namemap = namemap;
    }
    
    public  void affiche(){
         System.out.println("name ;"+namemap);
   }
    public int nbredeouccerance( List<langage> l,int pos,String lang){
    int nbre=0;
    for(int j=pos;j<l.size();j++){
    if(l.get(j).getLangueP().equalsIgnoreCase(lang)){
    nbre++;}
    }
    return nbre;}
    
    public double poucentage(){
   int nbr=0;
   List<Client>listclient =new ArrayList<>();
    listclient.addAll(clientjpa.findAll());
     for(Client c: listclient){
   if(c.getLocation().equalsIgnoreCase(namemap)){
  nbr++;
   }

    }
        
        return (nbr*100)/listclient.size();
    
    }
    public int nbredeclienparville(){
   int nbr=0;
   List<Client>listclient =new ArrayList<>();
    listclient.addAll(clientjpa.findAll());
     for(Client c: listclient){
   if(c.getLocation().equalsIgnoreCase(namemap)){
  nbr++;
   }

    }
        
        return nbr;
    
    }
    public langagemax chercher(){
    langagemax lm=new langagemax();
    List<langage> listl =new ArrayList<>();
   listl.addAll(lang.findAll());
   int j=0;
   int max=0;
   for(langage l: listl){
       Client c =new Client();
       c=clientjpa.findOne(l.getIdclient1());
       if(c!=null){
           
   if(c.getLocation().equalsIgnoreCase(namemap)){
      int n=0;
      n=nbredeouccerance(listl, j, l.getLangueP());
  if(n>max){
  max=n;
  lm.setLangage(l.getLangueP());
  lm.setMax(max);
  }
   }
   }
   j++;
   }
      
      return lm; 
}
}