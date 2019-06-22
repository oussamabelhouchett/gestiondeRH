/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfe.bean;

import com.pfe.Service.LoginService;
import com.pfe.model.Client;
import com.pfe.model.Demande;
import com.pfe.model.SkilParDemande;
import com.pfe.reposotory.ClientJpa;
import com.pfe.reposotory.demandJpa;
import com.pfe.scope.ScopeName;
import java.io.IOException;
import static java.lang.System.in;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

/**
 *
 * @author PROGRAMEUR
 */
@Controller
@Scope(ScopeName.VIEW)
 
public class ClientBean {
   
    private String ch;

    public String getCh() {
        return ch;
    }

    public void setCh(String ch) {
        this.ch = ch;
    }
    
     private String   testcvifnull;
 
   @Autowired
           private LoginService loginservice;
   @Autowired 
            private demandJpa demnad;
   @Autowired
           private ClientJpa clientjpa;
   HttpSession session = sessionlog.getSession();
   private Client client;
   
   
   public void getparamter(){
       this.setCh("oussama");
   /* ExternalContext ctx = FacesContext.getCurrentInstance().getExternalContext();

String uri = ((HttpServletRequest) ctx.getRequest()).getRequestURI();*/
        System.out.println("ID :"+ch);
   }
   
   
  public String getTestcvifnull() {
        Client  client1=(Client) session.getAttribute("client");
        session.setAttribute("idclient", client1.getIdclient());
        Integer i =(Integer)session.getAttribute("idclient");
        client1=clientjpa.findOne(i);
        if(client1.getCvForum().equals("aucun"))
        {testcvifnull="true"; 
        
         System.out.println("com.pfe.bean.ClientBeaff"+client1.getCvForum());
      }else{  System.out.println("com.pfe.bean.ClientBean.getTestcvifnull()"+client1.getCvForum());
            testcvifnull="false";
            session.setAttribute("client",client);
        }
        return testcvifnull;
    }

    public void setTestcvifnull(String testcvifnull) {
        this.testcvifnull = testcvifnull;
    }
    public Client getClient() {
        client=(Client) session.getAttribute("client");
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
  
    public String logout() throws IOException{
        session.invalidate();
        System.out.println("com.pfe.bean.ClientBean.logout()");
return "Home";
    }
}
