/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfe.bean;

import com.pfe.model.Entreprise;
import com.pfe.reposotory.EntrepirseJpa;
import com.pfe.scope.ScopeName;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ScopeName.VIEW)
@ManagedBean
@ViewScoped
public class HomeentrepriseBean {
    private HttpSession session=sessionlog.getSession();
    Entreprise entreprise=new Entreprise();
@Autowired
private EntrepirseJpa enteprisejpa;
    public Entreprise getEntreprise() {
        int id =(int) session.getAttribute("entreprise");
    entreprise=enteprisejpa.findOne(id);
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }
    
    
    
    
    
}
