/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfe.bean;

import com.pfe.model.langage;
import com.pfe.model.Client;
import com.pfe.reposotory.ClientJpa;
import com.pfe.reposotory.langagerepo;
import com.pfe.scope.ScopeName;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope(ScopeName.VIEW)
public class thebestprofile {
    private List<clientl> listcv =new ArrayList<> ();
 @Autowired
    private ClientJpa clientjpa;
    @Autowired
    private codewarsManipulation code;
     @Autowired
    private langagerepo lange;
    public class clientl{
    private langage l;
        private String langueP;
    private int Score;
    private Client client1;

        public langage getL() {
            return l;
        }

        public void setL(langage l) {
            this.l = l;
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

        public Client getClient1() {
            return client1;
        }

        public void setClient1(Client client1) {
            this.client1 = client1;
        }
    
    }
    public List<clientl> getListcv() {
        listcv.clear();
        List<langage> list1=new ArrayList<langage>();
       list1.addAll( lange.findAll());
       for(langage l:list1){
       Client c =new Client();
      
       clientl cl =new clientl();
       c=clientjpa.findOne(l.getIdclient1());
       cl.setScore(l.getScore());
       cl.setLangueP(l.getLangueP());
       cl.setClient1(c);
       listcv.add(cl);
       }
 
        return listcv;
    }

    public void setListcv(List<clientl> listcv) {
        this.listcv = listcv;
    }
    
}
