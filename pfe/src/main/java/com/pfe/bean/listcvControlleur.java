/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfe.bean;

import com.pfe.model.Client;
import com.pfe.reposotory.ClientJpa;
import com.pfe.scope.ScopeName;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author PROGRAMEUR
 */
@Component
@Scope(ScopeName.VIEW)
 @ManagedBean(name ="listcvControll")
        @SessionScoped
public class listcvControlleur {
    @Autowired
   
    private ClientJpa clientjpa;
    private Client clientSelctione;
    private List<Client> listeclient=new ArrayList();
    HttpSession session =sessionlog.getSession();
    private Client client ;

    public Client getClient() {
        client=(Client) session.getAttribute("client");
        session.setAttribute("idclient", client.getIdclient());
        Integer i =(Integer)session.getAttribute("idclient");
        client=clientjpa.findOne(i);
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    

  

 

    public Client getClientSelctione() {
       clientSelctione= (Client) session.getAttribute("cv");
        return clientSelctione;
    }

    public void setClientSelctione(Client clientSelctione) {
        this.clientSelctione = clientSelctione;
    }
    
    public  List<Client> getAllClientCv(){
        listeclient.clear();
        List<Client> listeAllclient =new ArrayList();
        listeAllclient.addAll(clientjpa.findAll());
        for(Client c : listeAllclient){
        if(c.getCvForum()!=null){
        listeclient.add(c);
        }
        }
    return listeclient;
    }
public String detail(){
    System.out.println("cleint"+clientSelctione.getCvForum());
    session.setAttribute("cv", clientSelctione);
return "cvdetail";
}
    
    public List<Client> getListeclient() {
        listeclient.clear();
        listeclient=getAllClientCv();
        System.out.println("com.pfe.bean.listcvControlleur.getListeclient()"+getAllClientCv());
    return   listeclient.stream().filter(x->!(x.getCvForum().equals("aucun"))).collect(Collectors.toList());
                }

    public void setListeclient(List<Client> listeclient) {
        this.listeclient = listeclient;
    }
    
    
}
