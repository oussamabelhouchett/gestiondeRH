/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfe.bean;

import com.pfe.model.Client;
import com.pfe.scope.ScopeName;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;
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
public class ProfileBean {
    private Client client;
    HttpSession session =sessionlog.getSession();

    public Client getClient() {
        client=(Client)session.getAttribute("client");
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    
    
    
}
