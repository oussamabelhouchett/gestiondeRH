/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfe.bean;

import com.pfe.scope.ScopeName;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
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
public class Curentpage {
    private String home;
    private String profile;
    private String Request;
    private String forum;
private String employement;
private String homeEntreprise;
private String jobmarket;

    public String getEmployement() {
           currentpage();
        return employement;
    }

    public void setEmployement(String employement) {
        this.employement = employement;
    }

    public String getHomeEntreprise() {
        currentpage();
        return homeEntreprise;
    }

    public void setHomeEntreprise(String homeEntreprise) {
        this.homeEntreprise = homeEntreprise;
    }

    public String getJobmarket() {
           currentpage();
        return jobmarket;
    }

    public void setJobmarket(String jobmarket) {
        this.jobmarket = jobmarket;
    }

    public String getHome() {
        currentpage();
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getProfile() {
        currentpage();
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getRequest() {
          currentpage();
        return Request;
    }

    public void setRequest(String Request) {
        this.Request = Request;
    }

    public String getForum() {
          currentpage();
        return forum;
    }

    public void setForum(String forum) {
        this.forum = forum;
    }
    
    public void currentpage(){
    ExternalContext ctx = FacesContext.getCurrentInstance().getExternalContext();

String uri = ((HttpServletRequest) ctx.getRequest()).getRequestURI();
if(uri.indexOf("Client")>0){
    home="active";
    profile="";
    Request="";
    forum="";
    
    employement="";
    jobmarket="";
    homeEntreprise="";
}

if(uri.indexOf("profile")>0){
    home="";
    profile="active";
    Request="";
    forum="";
    employement="";
    jobmarket="";
    homeEntreprise="";
}
if(uri.indexOf("Requests")>0){
    home="";
    profile="";
    Request="active";
    forum="";
    
    employement="";
    jobmarket="";
    homeEntreprise="";
}
if(uri.indexOf("Forum")>0){
    home="";
    profile="";
    Request="";
    forum="active";
    employement="";
    jobmarket="";
    homeEntreprise="";
}
if(uri.indexOf("EntreprisePage")>0)
{
  home="";
    profile="";
    Request="";
    forum="";
    
    employement="";
    jobmarket="";
    homeEntreprise="active";}
if(uri.indexOf("employment")>0)
{
  home="";
    profile="";
    Request="";
    forum="";
    
    employement="active";
    jobmarket="";
    homeEntreprise="";}
if(uri.indexOf("jobmarket")>0)
{
  home="";
    profile="";
    Request="";
    forum="";
    
    employement="";
    jobmarket="active";
    homeEntreprise="";
}
        System.out.println("path"+uri);
}
public void initialize(){
 home="";
    profile="";
    Request="";
    forum="";
    
    employement="";
    jobmarket="";
    homeEntreprise="";
    System.out.println("hello");

}}
