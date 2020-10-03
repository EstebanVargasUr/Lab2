package org.una.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.dto.CategoriaWebDTO;
import org.una.entities.CategoriaWeb;
import org.una.repositories.ICategoriaWebRepository;
import org.una.utils.MapperUtils;

@Service
public class CategoriaServiceImplementation implements ICategoriaWebService {

    @Autowired
    private ICategoriaWebRepository categoriaWebRepository;

    private Optional<List<CategoriaWebDTO>> findList(List<CategoriaWeb> list) {
        if (list != null) {
            List<CategoriaWebDTO> CategoriaWebDTO = MapperUtils.DtoListFromEntityList(list, CategoriaWebDTO.class);
            return Optional.ofNullable(CategoriaWebDTO);
        } else {
            return null;
        }
    }

    private Optional<List<CategoriaWebDTO>> findList(Optional<List<CategoriaWeb>> list) {
        if (list.isPresent()) {
            return findList(list.get());
        } else {
            return null;
        }
    }

    private Optional<CategoriaWebDTO> oneToDto(Optional<CategoriaWeb> one) {
        if (one.isPresent()) {
            CategoriaWebDTO CategoriaWebDTO = MapperUtils.DtoFromEntity(one.get(), CategoriaWebDTO.class);
            return Optional.ofNullable(CategoriaWebDTO);
        } else {
            return null;
        }
    }
    @Override
    @Transactional(readOnly = true)
    public Optional<List<CategoriaWebDTO>> findAll() {

        return findList(categoriaWebRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CategoriaWebDTO> findById(Long id) {
        return oneToDto(categoriaWebRepository.findById(id));
    }

}
