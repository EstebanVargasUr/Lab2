package org.una.Lab2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.una.Lab2.entities.Navegador;

/**
 *
 * @author Esteban Vargas
 */
public interface INavegadorRepository extends JpaRepository<Navegador, Long>{
    
}
