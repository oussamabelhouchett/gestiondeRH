package com.pfe.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.pfe.model.Client;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="langeclient")
public class langage  implements Serializable {
    @Id
    @GeneratedValue
   private int id;
   
    private String langueP;
    private int Score;

 private int  idclient1;
    public langage() {
    }

    @Override
    public String toString() {
        return "langage{"  + ", langueP=" + langueP + ", Score=" + Score + '}';
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdclient1() {
        return idclient1;
    }

    public void setIdclient1(int idclient1) {
        this.idclient1 = idclient1;
    }

    

  

    public langage(String langueP, int Score) {
        this.langueP = langueP;
        this.Score = Score;
      
    }

    public String getLangueP() {
        return langueP;
    }

    public void setLangueP(String langueP) {
        this.langueP = langueP;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int Score) {
        this.Score = Score;
    }

    
    
}
