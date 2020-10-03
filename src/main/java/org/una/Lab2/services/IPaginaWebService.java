package org.una.Lab2.services;

import java.util.List;
import java.util.Optional;
import org.una.Lab2.dto.PaginaWebDTO;

/**
 *
 * @author Esteban Vargas
 */
public interface IPaginaWebService {
    
    public Optional<List<PaginaWebDTO>> findAll();
    
    public Optional<PaginaWebDTO> findById(Long id);
    
    public Optional<List<PaginaWebDTO>> findByCategoriasWebIdAndEstado(Long categoriaWebId, boolean estado);
    
}
