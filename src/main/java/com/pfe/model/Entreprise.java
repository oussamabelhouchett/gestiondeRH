/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfe.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author PROGRAMEUR
 */
@Entity
@Table(name = "Entreprise")
public class Entreprise {
    @Id
	    @GeneratedValue
private int identreprise;
    private String nomentreprise;
	  @Column(name="login")
private String login;
	  @Column(name ="password")
          
private String password;
private String logo;
          private String description;
          private String email;
          private String numtel;
          private String website;
          private String adress;
          
	  
 @OneToMany(
		        mappedBy = "entreprised", 
		        cascade = CascadeType.ALL, 
		        orphanRemoval = true
		    )
	private Set<Demande> listdemand =new HashSet();

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
        

    public Entreprise(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public Entreprise() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumtel() {
        return numtel;
    }

    public void setNumtel(String numtel) {
        this.numtel = numtel;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

 

    public int getIdentreprise() {
        return identreprise;
    }

    public void setIdentreprise(int identreprise) {
        this.identreprise = identreprise;
    }

    public Set<Demande> getListdemand() {
        return listdemand;
    }

    public void setListdemand(Set<Demande> listdemand) {
        this.listdemand = listdemand;
    }

   

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

    public String getNomentreprise() {
        return nomentreprise;
    }

    public void setNomentreprise(String nomentreprise) {
        this.nomentreprise = nomentreprise;
    }

    
}
