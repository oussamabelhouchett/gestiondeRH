/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfe.reposotory;

import com.pfe.model.Client;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author PROGRAMEUR
 */
@Transactional

public interface ClientJpa extends JpaRepository<Client, Integer> {
    @Modifying
	@Query("UPDATE Client c SET c.cvForum =?1 WHERE c.idclient=?2")
	void setcvforum(String cv, int id);
}
