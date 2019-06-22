/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfe.reposotory;

import com.pfe.model.poucentage;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author PROGRAMEUR
 */
public interface poucentagerepo  extends JpaRepository<poucentage, Integer>{
    
}
