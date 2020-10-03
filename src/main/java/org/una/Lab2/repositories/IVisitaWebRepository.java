/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.Lab2.repositories;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.una.Lab2.entities.VisitaWeb;

/**
 *
 * @author adrian
 */

public interface IVisitaWebRepository extends JpaRepository<VisitaWeb, Long> {
    
   // @Query(value = "SELECT t FROM VisitaWeb t JOIN t.paginasWeb po JOIN po.categoriasWeb u where u.estados=:estado and t.fechaRegistro BETWEEN :startDate AND :endDate")
    //public Optional<List<VisitaWeb>> findByUsuarioIdAndFechaRegistroBetween(boolean estado, Date startDate, Date endDate);
    
}
    