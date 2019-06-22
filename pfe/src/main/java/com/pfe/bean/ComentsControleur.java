/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfe.bean;

import com.pfe.model.Client;
import com.pfe.model.Coments;
import com.pfe.reposotory.comentsJpa;
import com.pfe.scope.ScopeName;
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
 @ManagedBean
        @SessionScoped
public class ComentsControleur {
    private String message;
    
    @Autowired
    private comentsJpa commentsjpa;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public void addcomments(){
        System.out.println("com.pfe.bean.ComentsControleur.addcomments()");
        HttpSession session =sessionlog.getSession();
        
      Client clientSelctione= (Client) session.getAttribute("cv");
     Coments c =new Coments (message,clientSelctione);
      commentsjpa.save(c);
    }
}
