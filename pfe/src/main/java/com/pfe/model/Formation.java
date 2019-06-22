/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfe.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author PROGRAMEUR
 */
@Entity
@Table(name="Formation")
public class Formation {
    @Id
   @GeneratedValue
   private int idFormation;
   private String datedebutformation;
   private String datefinformation;
   private String Descriptionformation;
   private String Locationformation;
   private String institue;
    @ManyToOne(fetch = FetchType.LAZY)
	   @JoinColumn(name = "idclient")
private Client client;
    
    public Formation() {
    }

    public Formation(String datedebutformation, String datefinformation, String Descriptionformation, String Locationformation, String institue) {
        this.datedebutformation = datedebutformation;
        this.datefinformation = datefinformation;
        this.Descriptionformation = Descriptionformation;
        this.Locationformation = Locationformation;
        this.institue = institue;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int getIdFormation() {
        return idFormation;
    }

    public void setIdFormation(int idFormation) {
        this.idFormation = idFormation;
    }

    public String getDatedebutformation() {
        return datedebutformation;
    }

    public void setDatedebutformation(String datedebutformation) {
        this.datedebutformation = datedebutformation;
    }

    public String getDatefinformation() {
        return datefinformation;
    }

    public void setDatefinformation(String datefinformation) {
        this.datefinformation = datefinformation;
    }

    public String getDescriptionformation() {
        return Descriptionformation;
    }

    public void setDescriptionformation(String Descriptionformation) {
        this.Descriptionformation = Descriptionformation;
    }

    public String getLocationformation() {
        return Locationformation;
    }

    public void setLocationformation(String Locationformation) {
        this.Locationformation = Locationformation;
    }

    public String getInstitue() {
        return institue;
    }

    public void setInstitue(String institue) {
        this.institue = institue;
    }
    
   
   
 
}
