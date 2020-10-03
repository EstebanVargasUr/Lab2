package org.una.Lab2.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.Lab2.dto.PaginaWebDTO;
import org.una.Lab2.entities.PaginaWeb;
import org.una.Lab2.repositories.IPaginaWebRepository;
import org.una.Lab2.utils.MapperUtils;

/**
 *
 * @author Esteban Vargas
 */
@Service
public class PaginaWebServiceImplementation implements IPaginaWebService{

    @Autowired
    private IPaginaWebRepository paginaWebRepository;
    
    private Optional<List<PaginaWebDTO>> findList(List<PaginaWeb> list) {
        if (list != null) {
            List<PaginaWebDTO> paginaWebDTO = MapperUtils.DtoListFromEntityList(list, PaginaWebDTO.class);
            return Optional.ofNullable(paginaWebDTO);
        } else {
            return null;
        }
    }
    private Optional<List<PaginaWebDTO>> findList(Optional<List<PaginaWeb>> list) {
        if (list.isPresent()) {
            return findList(list.get());
        } else {
            return null;
        }
    }
    private Optional<PaginaWebDTO> oneToDto(Optional<PaginaWeb> one) {
        if (one.isPresent()) {
            PaginaWebDTO paginaWebDTO = MapperUtils.DtoFromEntity(one.get(), PaginaWebDTO.class);
            return Optional.ofNullable(paginaWebDTO);
        } else {
            return null;
        }
    }
    @Override
    @Transactional(readOnly = true)
    public Optional<List<PaginaWebDTO>> findAll() {
        return findList(paginaWebRepository.findAll());
    }
    
    @Override
    @Transactional(readOnly = true)
    public Optional<PaginaWebDTO> findById(Long id) {
        return oneToDto(paginaWebRepository.findById(id));
    }
    
}
