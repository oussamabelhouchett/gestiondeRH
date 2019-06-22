/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfe.bean;

import com.pfe.Service.LoginService;
import com.pfe.model.Client;
import com.pfe.model.Entreprise;
import com.pfe.scope.ScopeName;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

/**
 *
 * @author PROGRAMEUR
 */
@Component
@Scope(ScopeName.VIEW)
 @ManagedBean
        @SessionScoped
public class LoginBean {
   @Autowired
    private LoginService clientservice;
   
    HttpSession session = sessionlog.getSession();
    private String login;
    private String password;

    public String getLogin() {
        return login;
    }
  
    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String  loginClient() throws IOException{
       String url="";
      if(clientservice.findclient().size()==0){}else {
            List<Client> liste =new ArrayList();
            liste.addAll(clientservice.findclient());
            for(Client c : liste){
            if((c.getLogin().equals(login))&&(c.getPassword().equals(password))){
                System.out.println("oussama");
                session.setAttribute("client", c);
                    session.setAttribute("idclient", c.getIdclient());
                url="Client";
            }}}
        return url;
    }
    public String loginEntreprise() throws IOException{
       String url="";
      if(clientservice.findEntreprise().size()==0){}else {
            List<Entreprise> liste =new ArrayList();
            liste.addAll(clientservice.findEntreprise());
            for(Entreprise c : liste){
            if((c.getLogin().equals(login))&&(c.getPassword().equals(password))){
                System.out.println("oussama");
                     session.setAttribute("entreprise", c.getIdentreprise());
                url="EntreprisePage";
            }}}
        return url;
    }
  
   
}
