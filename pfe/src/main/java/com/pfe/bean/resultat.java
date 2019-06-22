/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfe.bean;

/**
 *
 * @author PROGRAMEUR
 */
public class resultat {
    private int comentnegative;
    private int commentPositive;

    public resultat() {
    }

    public resultat(int comentnegative, int commentPositive) {
        this.comentnegative = comentnegative;
        this.commentPositive = commentPositive;
    }

    public int getComentnegative() {
        return comentnegative;
    }

    public void setComentnegative(int comentnegative) {
        this.comentnegative = comentnegative;
    }

    public int getCommentPositive() {
        return commentPositive;
    }

    public void setCommentPositive(int commentPositive) {
        this.commentPositive = commentPositive;
    }
    
    
}
