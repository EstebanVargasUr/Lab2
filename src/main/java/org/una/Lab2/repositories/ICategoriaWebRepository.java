package org.una.Lab2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.una.Lab2.entities.CategoriaWeb;
import org.una.Lab2.entities.PaginaWeb;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ICategoriaWebRepository extends JpaRepository<CategoriaWeb, Long> {
    @Query(value = "SELECT e FROM PaginaWeb_CategoriaWeb e JOIN e.categoriaWeb c JOIN e.paginaWeb p where p.id=:paginaWebId and c.fechaRegistro BETWEEN :startDate AND :endDate")
    public Optional<List<CategoriaWeb>> findByPaginaWebIdAndFechaRegistroBetween(Long paginaWebId, Date startDate, Date endDate);
}