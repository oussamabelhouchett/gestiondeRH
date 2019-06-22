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
@Table(name="Coments")
public class Coments {
    @Id
    @GeneratedValue
    private int idcoment;
    private String message;
    @ManyToOne(fetch = FetchType.LAZY)
	   @JoinColumn(name = "idclient")
    private Client client;

    public Coments() {
    }

    public Coments(String message, Client client) {
        this.message = message;
        this.client = client;
    }

    public int getIdcoment() {
        return idcoment;
    }

    public void setIdcoment(int idcoment) {
        this.idcoment = idcoment;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    
}
