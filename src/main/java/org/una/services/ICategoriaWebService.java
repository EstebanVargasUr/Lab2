package org.una.services;

import org.una.dto.CategoriaWebDTO;
import java.util.List;
import java.util.Optional;

public interface ICategoriaWebService {
    public Optional<List<CategoriaWebDTO>> findAll();

    public Optional<CategoriaWebDTO> findById(Long id);
}
