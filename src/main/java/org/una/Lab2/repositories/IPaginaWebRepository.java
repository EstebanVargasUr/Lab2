package org.una.Lab2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.una.Lab2.entities.PaginaWeb;

/**
 *
 * @author Esteban Vargas
 */
public interface IPaginaWebRepository extends JpaRepository<PaginaWeb, Long> {
    
}
