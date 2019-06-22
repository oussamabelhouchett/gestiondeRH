/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfe.bean;

import com.pfe.model.Demande;
import com.pfe.reposotory.demandJpa;
import com.pfe.scope.ScopeName;
import java.util.ArrayList;
import java.util.List;
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
@Scope(ScopeName.VIEW )
 @ManagedBean
        @SessionScoped
public class requestbean {
    @Autowired
    private demandJpa demande;
    private List<Demande>listdemande =new ArrayList<>();
    private HttpSession seprivatession=sessionlog.getSession();
List<String>liststring =new ArrayList<>();

    public List<Demande> getListdemande() {
        listdemande.clear();
        listdemande.addAll(demande.findAll());
        System.out.println(" listdemande.size()");
        return listdemande;
    }

    public void setListdemande(List<Demande> listdemande) {
        this.listdemande = listdemande;
    }

    public List<String> getListstring() {
        liststring.add("mejdi");
        liststring.add("oussama");
        
        return liststring;
    }

    public void setListstring(List<String> liststring) {
        this.liststring = liststring;
    }
    
    
}
