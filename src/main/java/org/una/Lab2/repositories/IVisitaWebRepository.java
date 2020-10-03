package org.una.Lab2.repositories;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.una.Lab2.entities.VisitaWeb;


public interface IVisitaWebRepository extends JpaRepository<VisitaWeb, Long> {
    
    @Query(value = "SELECT vw FROM VisitaWeb vw JOIN vw.paginaWeb pw JOIN vw.navegador nw where pw.id=:id1 and nw.id=:id2")
    public Optional<List<VisitaWeb>> findByPaginaWebIdAndNavegadorId(Long id1,Long id2);
    
}
    