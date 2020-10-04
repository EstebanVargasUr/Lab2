package org.una.Lab2.services;

import java.util.List;
import java.util.Optional;
import org.una.Lab2.dto.NavegadorDTO;

/**
 *
 * @author Esteban Vargas
 */
public interface INavegadorService {
    
    public Optional<List<NavegadorDTO>> findAll();
    
    public Optional<NavegadorDTO> findById(Long id);
}
