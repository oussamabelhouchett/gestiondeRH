/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfe.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author PROGRAMEUR
 */
@Entity
@Table(name = "Demande")
public class Demande {
     @Id
	    @GeneratedValue
    private int idDemande;
    private String Description;
    private String post;
    private int experience;
    private int salairemax;
    private String niveau;
    private String Exigences;
    private String adress;
  @OneToMany(
		        mappedBy = "entreprise", 
		        cascade = CascadeType.ALL, 
		        orphanRemoval = true
		    )
	private Set<SkilParDemande> listskils =new HashSet();
    @ManyToOne(fetch = FetchType.LAZY)
	   @JoinColumn(name = "identreprise")
private Entreprise entreprised;
    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
    

    public Demande() {
    }

    public Demande(String Description, String post, int experience, int salairemax, String niveau, String Exigences, String adress, Entreprise entreprised) {
        this.Description = Description;
        this.post = post;
        this.experience = experience;
        this.salairemax = salairemax;
        this.niveau = niveau;
        this.Exigences = Exigences;
        this.adress = adress;
        this.entreprised = entreprised;
    }

    public Set<SkilParDemande> getListskils() {
        return listskils;
    }

    public void setListskils(Set<SkilParDemande> listskils) {
        this.listskils = listskils;
    }
    

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public String getExigences() {
        return Exigences;
    }

    public void setExigences(String Exigences) {
        this.Exigences = Exigences;
    }

    public Entreprise getEntreprised() {
        return entreprised;
    }

    public void setEntreprised(Entreprise entreprised) {
        this.entreprised = entreprised;
    }

    public Demande(String Description, String post, int experience, int salairemax, String niveau, String Exigences, Entreprise entreprised) {
        this.Description = Description;
        this.post = post;
        this.experience = experience;
        this.salairemax = salairemax;
        this.niveau = niveau;
        this.Exigences = Exigences;
        this.entreprised = entreprised;
    }


  
    

    public int getIdDemande() {
        return idDemande;
    }

    public void setIdDemande(int idDemande) {
        this.idDemande = idDemande;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getSalairemax() {
        return salairemax;
    }

    public void setSalairemax(int salairemax) {
        this.salairemax = salairemax;
    }

    @Override
    public String toString() {
        return "Demande{" + "Description=" + Description + ", post=" + post + ", experience=" + experience + ", salairemax=" + salairemax + ", niveau=" + niveau + ", Exigences=" + Exigences + ", adress=" + adress + ", entreprised=" + entreprised + '}';
    }

 
}
