package org.una.Lab2.services;

import java.util.List;
import java.util.Optional;
import org.una.Lab2.dto.VisitaWebDTO;

public interface IVisitaWebService {

    public Optional<List<VisitaWebDTO>> findAll();
    
    public Optional<VisitaWebDTO> findById(Long id);
    
    public Optional<List<VisitaWebDTO>> findByPaginaWebIdAndNavegadorId(Long id1,Long id2);
}

