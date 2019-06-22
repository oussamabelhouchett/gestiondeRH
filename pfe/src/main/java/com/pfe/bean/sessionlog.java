/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfe.bean;

import com.pfe.model.Entreprise;
import com.pfe.reposotory.EntrepirseJpa;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author oussama
 */
public class sessionlog {
    

public static HttpSession getSession(){
    return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
}
public static HttpServletRequest getRequest(){


return  (HttpServletRequest)  FacesContext.getCurrentInstance().getExternalContext().getRequest();

}

    
}
