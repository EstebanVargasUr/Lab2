package org.una.Lab2.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.Lab2.dto.NavegadorDTO;
import org.una.Lab2.entities.Navegador;
import org.una.Lab2.repositories.INavegadorRepository;
import org.una.Lab2.utils.MapperUtils;

/**
 *
 * @author Esteban Vargas
 */
@Service
public class NavegadorServiceImplementation implements INavegadorService{

    @Autowired
    private INavegadorRepository navegadorRepository;
    
    private Optional<List<NavegadorDTO>> findList(List<Navegador> list) {
        if (list != null) {
            List<NavegadorDTO> navegadorDTO = MapperUtils.DtoListFromEntityList(list, NavegadorDTO.class);
            return Optional.ofNullable(navegadorDTO);
        } else {
            return null;
        }
    }
    private Optional<List<NavegadorDTO>> findList(Optional<List<Navegador>> list) {
        if (list.isPresent()) {
            return findList(list.get());
        } else {
            return null;
        }
    }
    private Optional<NavegadorDTO> oneToDto(Optional<Navegador> one) {
        if (one.isPresent()) {
            NavegadorDTO navegadorDTO = MapperUtils.DtoFromEntity(one.get(), NavegadorDTO.class);
            return Optional.ofNullable(navegadorDTO);
        } else {
            return null;
        }
    }
    @Override
    @Transactional(readOnly = true)
    public Optional<List<NavegadorDTO>> findAll() {
        return findList(navegadorRepository.findAll());
    }
    
    @Override
    @Transactional(readOnly = true)
    public Optional<NavegadorDTO> findById(Long id) {
        return oneToDto(navegadorRepository.findById(id));
    }
    
}
