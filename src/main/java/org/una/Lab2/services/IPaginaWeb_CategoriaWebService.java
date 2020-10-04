package org.una.Lab2.services;

import java.util.List;
import java.util.Optional;
import org.una.Lab2.dto.PaginaWeb_CategoriaWebDTO;

/**
 *
 * @author Esteban Vargas
 */
public interface IPaginaWeb_CategoriaWebService {
    
    public Optional<List<PaginaWeb_CategoriaWebDTO>> findAll();
    
    public Optional<PaginaWeb_CategoriaWebDTO> findById(Long id);
}
