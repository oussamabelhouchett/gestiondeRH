/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfe.bean;

import com.pfe.model.Client;

/**
 *
 * @author PROGRAMEUR
 */
public class Clientscore {
    private Client client;
    private int score;

    public Clientscore() {
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Clientscore{" + "client=" + client + ", score=" + score + '}';
    }
    
    
    
}
