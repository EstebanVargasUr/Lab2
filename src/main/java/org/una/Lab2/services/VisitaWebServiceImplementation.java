package org.una.Lab2.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.Lab2.dto.VisitaWebDTO;
import org.una.Lab2.entities.VisitaWeb;
import org.una.Lab2.repositories.IVisitaWebRepository;
import org.una.Lab2.utils.MapperUtils;

@Service
public class VisitaWebServiceImplementation implements IVisitaWebService {

    @Autowired
    private IVisitaWebRepository visitaWebRepository;

    private Optional<List<VisitaWebDTO>> findList(List<VisitaWeb> list) {
        if (list != null) {
            List<VisitaWebDTO> visitaWebDTO = MapperUtils.DtoListFromEntityList(list, VisitaWebDTO.class);
            return Optional.ofNullable(visitaWebDTO);
        } else {
            return null;
        }
    }
    private Optional<List<VisitaWebDTO>> findList(Optional<List<VisitaWeb>> list) {
        if (list.isPresent()) {
            return findList(list.get());
        } else {
            return null;
        }
    }
    private Optional<VisitaWebDTO> oneToDto(Optional<VisitaWeb> one) {
        if (one.isPresent()) {
            VisitaWebDTO visitaWebDTO = MapperUtils.DtoFromEntity(one.get(), VisitaWebDTO.class);
            return Optional.ofNullable(visitaWebDTO);
        } else {
            return null;
        }
    }
    @Override
    @Transactional(readOnly = true)
    public Optional<List<VisitaWebDTO>> findAll() {
        return findList(visitaWebRepository.findAll());
    }
    
    @Override
    @Transactional(readOnly = true)
    public Optional<VisitaWebDTO> findById(Long id) {
        return oneToDto(visitaWebRepository.findById(id));
    }

    @Override
     @Transactional(readOnly = true)
    public Optional<List<VisitaWebDTO>> findByPaginaWebIdAndNavegadorId(Long id1, Long id2) {
        return findList(visitaWebRepository.findByPaginaWebIdAndNavegadorId(id1, id2));
    }
    
}
