/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfe.reposotory;

import com.pfe.model.SkilParDemande;
import java.io.Serializable;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author PROGRAMEUR
 */
@Transactional
public interface SkilsdemandJpa  extends JpaRepository<SkilParDemande, Integer>{
    
}
