package org.una.Lab2.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.Lab2.dto.PaginaWeb_CategoriaWebDTO;
import org.una.Lab2.entities.PaginaWeb_CategoriaWeb;
import org.una.Lab2.repositories.IPaginaWeb_CategoriaWebRepository;
import org.una.Lab2.utils.MapperUtils;

/**
 *
 * @author Esteban Vargas
 */
@Service
public class PaginaWeb_CategoriaWebServiceImplementation implements IPaginaWeb_CategoriaWebService{

    @Autowired
    private IPaginaWeb_CategoriaWebRepository paginaWeb_CategoriaWebRepository;
    
    private Optional<List<PaginaWeb_CategoriaWebDTO>> findList(List<PaginaWeb_CategoriaWeb> list) {
        if (list != null) {
            List<PaginaWeb_CategoriaWebDTO> paginaWebDTO = MapperUtils.DtoListFromEntityList(list, PaginaWeb_CategoriaWebDTO.class);
            return Optional.ofNullable(paginaWebDTO);
        } else {
            return null;
        }
    }
    private Optional<List<PaginaWeb_CategoriaWebDTO>> findList(Optional<List<PaginaWeb_CategoriaWeb>> list) {
        if (list.isPresent()) {
            return findList(list.get());
        } else {
            return null;
        }
    }
    private Optional<PaginaWeb_CategoriaWebDTO> oneToDto(Optional<PaginaWeb_CategoriaWeb> one) {
        if (one.isPresent()) {
            PaginaWeb_CategoriaWebDTO paginaWebDTO = MapperUtils.DtoFromEntity(one.get(), PaginaWeb_CategoriaWebDTO.class);
            return Optional.ofNullable(paginaWebDTO);
        } else {
            return null;
        }
    }
    @Override
    @Transactional(readOnly = true)
    public Optional<List<PaginaWeb_CategoriaWebDTO>> findAll() {
        return findList(paginaWeb_CategoriaWebRepository.findAll());
    }
    
    @Override
    @Transactional(readOnly = true)
    public Optional<PaginaWeb_CategoriaWebDTO> findById(Long id) {
        return oneToDto(paginaWeb_CategoriaWebRepository.findById(id));
    }
    
}
