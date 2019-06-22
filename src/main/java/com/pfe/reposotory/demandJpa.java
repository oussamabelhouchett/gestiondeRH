
package com.pfe.reposotory;

import com.pfe.model.Demande;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface demandJpa extends JpaRepository<Demande, Integer>  {
    
}
