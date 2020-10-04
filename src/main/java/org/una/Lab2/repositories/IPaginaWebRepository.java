package org.una.Lab2.repositories;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.una.Lab2.entities.PaginaWeb;

/**
 *
 * @author Esteban Vargas
 */
public interface IPaginaWebRepository extends JpaRepository<PaginaWeb, Long> {
    
   @Query(value = "SELECT e FROM PaginaWeb_CategoriaWeb e JOIN e.categoriaWeb c JOIN e.paginaWeb p where c.id=:categoriaWebId and p.estado=:estado")
   public Optional<List<PaginaWeb>> findByCategoriasWebIdAndEstado(Long categoriaWebId, boolean estado);
}
