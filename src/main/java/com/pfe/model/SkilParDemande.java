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
@Table(name="skilpardemande")
public class SkilParDemande {
    @Id
    @GeneratedValue
     private int idskilsdemande;
    private String skilsdemande;
     @ManyToOne(fetch = FetchType.LAZY)
	   @JoinColumn(name = "idDemande")
private Demande entreprise;

    public SkilParDemande() {
    }

    public SkilParDemande(String skilsdemande, Demande entreprise) {
        this.skilsdemande = skilsdemande;
        this.entreprise = entreprise;
    }

    public Demande getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Demande entreprise) {
        this.entreprise = entreprise;
    }

   

    public SkilParDemande(String skilsdemande) {
        this.skilsdemande = skilsdemande;
    }
    

    public int getIdskilsdemande() {
        return idskilsdemande;
    }

    public void setIdskilsdemande(int idskilsdemande) {
        this.idskilsdemande = idskilsdemande;
    }

    public String getSkilsdemande() {
        return skilsdemande;
    }

    public void setSkilsdemande(String skilsdemande) {
        this.skilsdemande = skilsdemande;
    }
    
    
}
