package org.una.Lab2.services;

import org.una.Lab2.dto.CategoriaWebDTO;
import org.una.Lab2.dto.PaginaWebDTO;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ICategoriaWebService {
    public Optional<List<CategoriaWebDTO>> findAll();

    public Optional<CategoriaWebDTO> findById(Long id);

    public Optional<List<CategoriaWebDTO>>findByPaginaWebIdAndFechaRegistroBetween(Long paginaWebId, Date startDate, Date endDate);

}
