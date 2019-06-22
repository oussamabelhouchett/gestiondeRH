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
@Table(name="langue")
public class Langue {
    @Id
    @GeneratedValue
   private int idlangue;
   private String langue;
  @ManyToOne(fetch = FetchType.LAZY)
	   @JoinColumn(name = "idclient")
private Client clientl;
    public Langue() {
    }

    public int getIdlangue() {
        return idlangue;
    }

    public void setIdlangue(int idlangue) {
        this.idlangue = idlangue;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public Langue(String langue) {
        this.langue = langue;
    }

    public Client getClientl() {
        return clientl;
    }

    public void setClientl(Client clientl) {
        this.clientl = clientl;
    }
    
    
}
