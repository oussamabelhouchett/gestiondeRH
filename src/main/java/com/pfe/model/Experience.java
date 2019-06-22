/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfe.model;

import java.io.Serializable;
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
@Table(name="Experience")
public class Experience implements Serializable{
   @Id
   @GeneratedValue
   private int idexperience;
   private String datedebut;
   private String datefin;
   private String Description;
   private String Location;
   private String nomentreprise;

  @ManyToOne(fetch = FetchType.LAZY)
	   @JoinColumn(name = "idclient")
private Client cliente ;
   
    public Experience() {
    }

    public Experience(String datedebut, String datefin, String Description, String Location) {
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.Description = Description;
        this.Location = Location;
    }
   

    public int getIdexperience() {
        return idexperience;
    }

    public void setIdexperience(int idexperience) {
        this.idexperience = idexperience;
    }

    public String getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(String datedebut) {
        this.datedebut = datedebut;
    }

    public String getDatefin() {
        return datefin;
    }

    public void setDatefin(String datefin) {
        this.datefin = datefin;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public String getNomentreprise() {
        return nomentreprise;
    }

    public void setNomentreprise(String nomentreprise) {
        this.nomentreprise = nomentreprise;
    }
   
}
