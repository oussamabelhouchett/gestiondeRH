/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfe.Service;

import com.pfe.model.Client;
import com.pfe.model.Entreprise;
import com.pfe.reposotory.ClientJpa;
import com.pfe.reposotory.EntrepirseJpa;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PROGRAMEUR
 */
@Service
public class LoginService {
@Autowired
private ClientJpa clientjpa;
@Autowired
private EntrepirseJpa entrprisejpa;
public  List<Client> findclient(){
   return clientjpa.findAll();
}
public  List<Entreprise> findEntreprise(){
   return entrprisejpa.findAll();
}
public void update(String cv,int id){
clientjpa.setcvforum(cv, id);
}
}