/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfe.reposotory;

import com.pfe.model.Client;
import com.pfe.model.Entreprise;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author PROGRAMEUR
 */
@Transactional
public interface EntrepirseJpa extends JpaRepository<Entreprise, Integer> {
    
}
