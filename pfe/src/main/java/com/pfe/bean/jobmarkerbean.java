/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfe.bean;

import com.pfe.model.Client;
import com.pfe.model.Demande;
import com.pfe.model.SkilParDemande;
import com.pfe.model.Skils;
import com.pfe.reposotory.ClientJpa;
import com.pfe.reposotory.SkilsdemandJpa;
import com.pfe.reposotory.demandJpa;
import com.pfe.scope.ScopeName;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author PROGRAMEUR
 */
@Component


@Scope(ScopeName.VIEW )
 @ManagedBean
        @SessionScoped
public class jobmarkerbean {
@Autowired
private ClientJpa clientjpa;
@Autowired
private SkilsdemandJpa skiljpa;
@Autowired
private demandJpa  demand;
private List<Integer> listexperience =new ArrayList();
private List<String> listeVille=new ArrayList();
private List<String> listniveau =new ArrayList();
private Vector<Client> listclient =new Vector<Client>();
private List<String> listskil=new ArrayList();
private List<String> listSkilselection =new ArrayList();
private int experience;
private String niveau;
private String ville;
private Client c;
private String all;
private String v;
private List<colortype> listcolor=new ArrayList<>();
private int pourecentage=80;
    UIComponent cheak1;

    public UIComponent getCheak1() {
        return cheak1;
    }

    public void setCheak1(UIComponent cheak1) {
        this.cheak1 = cheak1;
    }
    
    public int getPourecentage() {
        return pourecentage;
    }

    public void setPourecentage(int pourecentage) {
        this.pourecentage = pourecentage;
    }


    public List<colortype> getListcolor() {
        listclient.clear();
        listcolor.clear();
        List<Client> l1 =new ArrayList<>();
     l1.addAll(clientjpa.findAll());
        System.out.println("com.pfe.bean.jobmarkerbean.getListcolor()"+l1);
        int i=1;
        for(Client c :l1){
           colortype color=new colortype();
           color.setC(c);
            if(i==1){
                color.setType("bg-primary");
                System.err.println("1");
            }
              if(i==2){
                color.setType("bg-pink");
                    System.err.println("2");
            }  if(i==3){
                color.setType("bg-success");
                  System.err.println("3");
            }  if(i==4){
                color.setType("bg-secondary");
                 System.err.println("4");
                i=(i/4)-1;
            }
            listcolor.add(color);
        i++;
        }
        return listcolor;
    }

    public void setListcolor(List<colortype> listcolor) {
        this.listcolor = listcolor;
    }
    public String getV() {
        return v;
    }

    public void setV(String v) {
        this.v = v;
    }

public List<String> getListskil() {
 List<Demande> listd =new ArrayList();
 
listd.addAll(demand.findAll());
 listskil.clear();
 for(Demande d : listd ){
for(SkilParDemande sk :d.getListskils()){
listskil.add(sk.getSkilsdemande());
}
 }
        
        return (List<String>)listskil.stream().distinct().collect(Collectors.toList());
    }

    public String getAll() {
        return all;
    }

    public void setAll(String all) {
        this.all = all;
    }

    public void setListskil(List<String> listskil) {
        this.listskil = listskil;
    }
    public Client getC() {
        return c;
    }

    public void setC(Client c) {
        this.c = c;
    }

    public Vector<Client> getListclient() {
        return listclient;
    }

    public void setListclient(Vector<Client> listclient) {
        this.listclient = listclient;
    }

  
@PostConstruct
public void init(){
    System.out.println("hello");
  listclient.addAll(clientjpa.findAll());
        
}
   
    public ClientJpa getClientjpa() {
        return clientjpa;
    }

    public void setClientjpa(ClientJpa clientjpa) {
        this.clientjpa = clientjpa;
    }

    public List<Integer> getListexperience() {
        listexperience.clear();
        for(Client clien :listclient){
        listexperience.add(clien.getNbrExperience());
        }
        return (List<Integer>)listexperience.stream().distinct().collect(Collectors.toList());
    }

    public void setListexperience(List<Integer> listexperience) {
        this.listexperience = listexperience;
    }

    public List<String> getListeVille() {
        listeVille.clear();
         for(Client clien :listclient){
        listeVille.add(clien.getLocation());
        }
        return (List<String>) listeVille.stream().distinct().collect(Collectors.toList());
    }

    public void setListeVille(List<String> listeVille) {
        this.listeVille = listeVille;
    }

    public List<String> getListniveau() {
        listniveau.clear();
         for(Client clien :listclient){
        listniveau.add(clien.getNiveauScolaire());
        }
        return (List<String>) listniveau.stream().distinct().collect(Collectors.toList());
    }

    public void setListniveau(List<String> listniveau) {
        this.listniveau = listniveau;
    }

    public List<String> getListSkilselection() {
        return listSkilselection;
    }

    public void setListSkilselection(List<String> listSkilselection) {
        this.listSkilselection = listSkilselection;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
    
  public void cheacked(){
    List<Client> listToRemove =new ArrayList<Client>();
    if(listSkilselection.size()==0){
      for(Client clie :listclient){
          System.out.println("sisze"+clie.getListSkils().size());
          if(clie.getListSkils().size()==0){
        listToRemove.add(clie);
          }
          System.out.println("list"+listSkilselection);
   listclient.stream().filter(x->x.getNbrExperience()>=2).forEach(x->System.out.println(x.getNom()));
 /*    listclient.clear();*/

      System.out.println("liste"+listSkilselection);
  }
      listclient.removeAll(listToRemove);
      System.out.println("size of lis client"+listclient.size());
  listToRemove =new ArrayList<Client>();
          for(Client clie :listclient){
                    for(Skils s: clie.getListSkils())
                    {for(String st:listSkilselection){
                    if(!(s.getSkil().toLowerCase().equals(st.toLowerCase()))){
                             listToRemove.add(clie);
                    }
                    }
                    
                    
                    }
         
   
     
          } listclient.removeAll(listToRemove);
          
      System.out.println("size of lis client2   ");
    }
  } 
  public void experienceselection(){
  List<Client> listToRemove =new ArrayList<Client>();
      for(Client clie :listclient){
          if(clie.getNbrExperience()!=experience)
   
listToRemove.add(clie);
      System.out.println("liste"+listSkilselection);
  }
      listclient.removeAll(listToRemove);
  
  }
  private boolean  cheak;
  public void  villeselection(boolean b){
      
        String summary = cheak? "Checked" : "Unchecked";
        System.out.println("com.pfe.bean.jobmarkerbean.villeselection()"+b);
      System.out.println("ville selection"+ville);
        List<Client> listToRemove =new ArrayList<Client>();
      for(Client clie :listclient){
          if(clie.getLocation().equals(ville)){
   
listToRemove.add(clie);}
      System.out.println("liste"+listSkilselection);
  }
      listclient.removeAll(listToRemove);
  }
  public void niveauselction(){
    System.out.println("niveau selection"+niveau);
        List<Client> listToRemove =new ArrayList<Client>();
      for(Client clie :listclient){
          if(clie.getLocation().equals(niveau)){
   
listToRemove.add(clie);}
      System.out.println("liste"+listSkilselection);
  }
      listclient.removeAll(listToRemove);
  
  }
  public void all1(){
      listclient.clear();
      System.out.println("fg");
  listclient.addAll(clientjpa.findAll());
  }

    public boolean isCheak() {
        return cheak;
    }

    public void setCheak(boolean cheak) {
        this.cheak = cheak;
    }

}
