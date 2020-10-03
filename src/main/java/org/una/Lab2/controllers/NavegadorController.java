package org.una.Lab2.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.una.Lab2.dto.NavegadorDTO;
import org.una.Lab2.services.INavegadorService;

/**
 *
 * @author Esteban Vargas
 */
@RestController
@RequestMapping("/navegadores") 
@Api(tags = {"Navegadores"})
public class NavegadorController {
    
    @Autowired
    private INavegadorService navegadorService;
    
    final String MENSAJE_VERIFICAR_INFORMACION = "Debe verifiar el formato y la información de su solicitud con el formato esperado";

    @GetMapping("/")
    @ApiOperation(value = "Obtiene una lista de todos los Navegadores", response = NavegadorDTO.class, responseContainer = "List", tags = "Navegadores")
    public ResponseEntity<?> findAll() {
        try {
            return new ResponseEntity(navegadorService.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getClass(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtiene un Navegador por su Id", response = NavegadorDTO.class, tags = "Navegadores")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        try {
            return new ResponseEntity(navegadorService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
