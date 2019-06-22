/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfe.bean;

import com.pfe.model.Client;
import com.pfe.model.Demande;
import com.pfe.model.Entreprise;
import com.pfe.model.SkilParDemande;
import com.pfe.model.Skils;
import com.pfe.reposotory.SkilsdemandJpa;
import com.pfe.scope.ScopeName;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.pfe.reposotory.*;
import java.util.Comparator;
import java.util.stream.Collectors;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import static org.primefaces.component.contextmenu.ContextMenu.PropertyKeys.event;
import org.primefaces.context.RequestContext;

/**
 *
 * @author PROGRAMEUR
 */
@Component


@Scope(ScopeName.VIEW )
 @ManagedBean(name="gf")
        @SessionScoped
public class demandBean {
    @Autowired
    private SkilsdemandJpa skiljpa;
    @Autowired
    private demandJpa  demandjpa;
       private String teerea;
       private Demande demande=new Demande();
       private String nomentreprise;
       private Demande demand ;
private  List<String> listskils ;
private List<Clientscore> listfitre ;
private HttpSession session =sessionlog.getSession();

    public List<Clientscore> getListfitre() {
        if(demand==null){
         demand=new Demande();
        }else{
              listfitre=new ArrayList<>();
        listfitre.addAll(filter());}
        return listfitre;
    }

    public void setListfitre(List<Clientscore> listfitre) {
        this.listfitre = listfitre;
    }

    public HttpSession getSession() {
        return session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

private List<Demande>listedemande=new ArrayList<Demande>();
@PostConstruct
public void init(){
listskils=new ArrayList<String>();
}
public void saveelement(){
    System.out.println("add");
 listskils.add(teerea);
  teerea="";

}

    public  List<String> getListskils() {
      
        return listskils;
    }

    public  void setListskils(List<String> listskils) {
        listskils = listskils;
    }
 @Autowired
        EntrepirseJpa entjpa;
    public void save(){
        int n1=0;
        int n2=0;
        n1=(int) demandjpa.count();
        n2=(int) skiljpa.count();
        System.out.println("nbre de skils"+n2+"nbre de demande"+n1);
          Integer e=  (Integer) session.getAttribute("entreprise");
           Entreprise entrepris=new Entreprise();
           entrepris=entjpa.findOne(e);
        System.out.println("Entreprise Id :"+entrepris.getLogin());
            Demande d =new Demande(demande.getDescription(), demande.getPost(), demande.getExperience(), demande.getSalairemax(), demande.getNiveau(), "", demande.getAdress(), entrepris);
            
             demandjpa.save(d);
             demandjpa.flush();
        System.out.println("com.pfe.bean.demandBean.save()"+d.getIdDemande());
          for(String s:listskils){
                SkilParDemande sk =new SkilParDemande(s,d);
            skiljpa.save(sk);
          
 
            }
              int n3=0;
            int n4=0;
           n3=(int) demandjpa.count();
        n4=(int) skiljpa.count();
            if((n3>n1)&&(n4>n2)){
                System.out.println("com.pfe.bean.demandBean.save()tre");
          FacesMessage message = new FacesMessage("Succesful"," is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, message);
        demande=new Demande();


            }
    }
    public Demande getDemande() {
        return demande;
    }
    private void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    public void setDemande(Demande demande) {
        this.demande = demande;
    }
   

    public String getTeerea() {
        System.out.println("text"+teerea);
        return teerea;
    }

    public void setTeerea(String teerea) {
        this.teerea = teerea;
    } 
  

    public List<Demande> getListedemande() {
        listedemande.clear();  Integer i = (Integer)session.getAttribute("entreprise");
  Entreprise  e =new Entreprise();
  e=entjpa.findOne(i);
     listedemande.addAll(e.getListdemand());
        return listedemande;
    }

    public void setListedemande(List<Demande> listedemande) {
        this.listedemande = listedemande;
    }
    public void test(){
        System.out.println("hello");
    }
    public String cheak(){
  Integer i = (Integer)session.getAttribute("entreprise");

   String ch="";
    if(i==null){
    ch="LoginForEntreprise";
    
    }
    return ch;
    }

    public String getNomentreprise() {
        
    Entreprise e = (Entreprise)session.getAttribute("entreprise");
    
        return e.getNomentreprise();
    }

    public void setNomentreprise(String nomentreprise) {
        this.nomentreprise = nomentreprise;
    }

    public Demande getDemand() {
       
    System.out.println("com.pfe.bean.demandBean.getDemand()");
        return    demand;
    }
public void trye( Demande d) {
       
}
    public void setDemand(Demande demand) {
        this.demand = demand;
    }
    @Autowired
    private ClientJpa cleintjpa;
    public List<Client> remplir(){
  
              List<Client> listclient=new ArrayList();
       listclient.addAll(cleintjpa.findAll());
    return   listclient.stream().filter(x->x.getNbrExperience()>=2).collect(Collectors.toList());
    
    }
    public int nbrecompatible(Client c,Demande demand){
        int nbr=0;
  List<Skils> lists=new ArrayList<Skils>();
  lists.addAll(c.getListSkils());
  for(Skils s: lists){
  for(SkilParDemande sk:demand.getListskils()){
  if(s.getSkil().toLowerCase().equals(sk.getSkilsdemande().toLowerCase())){
  nbr+=1;
  }
  }
  }
        return nbr;
    }
    public int scoreofoneskils(){
        if(demand.getListskils().size()==0)
            return 0;
    
    return 20/demand.getListskils().size();}
    public int calculScore(Client c){
        int scoreglobale=0;
        int scoreNiveau=0;
        int scoreexperience=0;
        int scoreskils=0;
         if(c.getNbrExperience()==demand.getExperience()){
         scoreexperience+=20;
         }  if(c.getNbrExperience()>demand.getExperience()){
         scoreexperience+=35;
         }
         int nbrec=0;
         nbrec=nbrecompatible(c,demand);
         scoreskils=scoreskils+(nbrec*scoreofoneskils());
         if(c.getNiveauScolaire().toLowerCase().equals(demand.getNiveau().toLowerCase())){
         scoreNiveau=20;
         }
         System.out.println("score"+scoreNiveau+scoreexperience+scoreskils);
    return scoreNiveau+scoreexperience+scoreskils;
    }
    public List<Clientscore> filter(){
       
    List<Client>listr=new ArrayList<>();
    listr.addAll(remplir());

        System.out.println("ff"+listr);
       List<Clientscore>listscore=new ArrayList<>();
    for(Client c :listr){
   Clientscore c1=new Clientscore();
   c1.setClient(c);
   c1.setScore(calculScore(c));
   listscore.add(c1);
   
    }listscore.stream().forEach(x->System.out.println(x.getClient().getNom()+""+x.getScore()));
       System.out.println(listscore);
  return (List<Clientscore>)listscore.stream().sorted(Comparator.comparing(Clientscore::getScore).reversed()).collect(Collectors.toList());
    }
}
