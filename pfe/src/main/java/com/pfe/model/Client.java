/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfe.model;

import java.util.Date;
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
@Table(name = "Client")
public class Client {
    	  @Id
	    @GeneratedValue
private int idclient;
	  @Column(name="login")
private String login;
	  @Column(name ="password") 
private String password;
          @Column(name="email")
private String  email;
          @Column(name="nom")
private String nom;
@Column(name="prenom")
private String prenom;
@Column(name="numtel")
private int numtel;
@Column(name="location")
private String Location;
@Column(name="NiveauScolaire")
private String NiveauScolaire;
@Column(name="nbrExperience")
private int nbrExperience;
@Column(name="cvforum")
private  String cvForum;
private String description;
private String descriptionshort;
private String type;
private Date datenaissance;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

 @OneToMany(
		        mappedBy = "client", 
		        cascade = CascadeType.ALL, 
		        orphanRemoval = true
		    )
	private Set<Formation> listFormation =new HashSet();
@OneToMany(
		        mappedBy = "client", 
		        cascade = CascadeType.ALL, 
		        orphanRemoval = true
		    )
	private Set<Coments> listcoments =new HashSet();

 @OneToMany(
		        mappedBy = "clientl", 
		        cascade = CascadeType.ALL, 
		        orphanRemoval = true
		    )
	private Set<Langue> listlangue =new HashSet();

 @OneToMany(
		        mappedBy = "clients", 
		        cascade = CascadeType.ALL, 
		        orphanRemoval = true
		    )
	private Set<Skils> listSkils =new HashSet();
@OneToMany(
		        mappedBy = "cliente", 
		        cascade = CascadeType.ALL, 
		        orphanRemoval = true
		    )
	private Set<Experience> listExperience=new HashSet();


public Client(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Client() {
    }

    public int getIdclient() {
        return idclient;
    }

    public void setIdclient(int idclient) {
        this.idclient = idclient;
    }

  
    
    

    public String getLogin() {
        return login;
    }

    public String getCvForum() {
        return cvForum;
    }

    public void setCvForum(String cvForum) {
        this.cvForum = cvForum;
    }

    public Set<Coments> getListcoments() {
        return listcoments;
    }

    public void setListcoments(Set<Coments> listcoments) {
        this.listcoments = listcoments;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getNumtel() {
        return numtel;
    }

    public void setNumtel(int numtel) {
        this.numtel = numtel;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public String getNiveauScolaire() {
        return NiveauScolaire;
    }

    public void setNiveauScolaire(String NiveauScolaire) {
        this.NiveauScolaire = NiveauScolaire;
    }

    public int getNbrExperience() {
        return nbrExperience;
    }

    public void setNbrExperience(int nbrExperience) {
        this.nbrExperience = nbrExperience;
    }

    public Set<Formation> getListFormation() {
        return listFormation;
    }

    public void setListFormation(Set<Formation> listFormation) {
        this.listFormation = listFormation;
    }

    public Set<Langue> getListlangue() {
        return listlangue;
    }

    public void setListlangue(Set<Langue> listlangue) {
        this.listlangue = listlangue;
    }

    public Set<Skils> getListSkils() {
        return listSkils;
    }

    public void setListSkils(Set<Skils> listSkils) {
        this.listSkils = listSkils;
    }

    public Set<Experience> getListExperience() {
        return listExperience;
    }

    public void setListExperience(Set<Experience> listExperience) {
        this.listExperience = listExperience;
    }

    public String getDescriptionshort() {
        
        return description.substring(0, 100);
    }

    public void setDescriptionshort(String descriptionshort) {
        this.descriptionshort = descriptionshort;
    }

    public Date getDatenaissance() {
        return datenaissance;
    }

    public void setDatenaissance(Date datenaissance) {
        this.datenaissance = datenaissance;
    }

    @Override
    public String toString() {
        return "Client{" + "idclient=" + idclient + ", login=" + login + ", password=" + password + ", email=" + email + ", nom=" + nom + ", prenom=" + prenom + ", numtel=" + numtel + ", Location=" + Location + ", NiveauScolaire=" + NiveauScolaire + ", nbrExperience=" + nbrExperience + ", cvForum=" + cvForum + ", description=" + description + ", descriptionshort=" + descriptionshort + '}';
    }
          
}
