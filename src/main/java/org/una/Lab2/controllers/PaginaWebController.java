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
import org.una.Lab2.dto.PaginaWebDTO;
import org.una.Lab2.services.IPaginaWebService;

/**
 *
 * @author Esteban Vargas
 */
@RestController
@RequestMapping("/paginasWeb") 
@Api(tags = {"Paginas Web"})
public class PaginaWebController {
    
    @Autowired
    private IPaginaWebService paginaWebService;
    
    final String MENSAJE_VERIFICAR_INFORMACION = "Debe verifiar el formato y la información de su solicitud con el formato esperado";

    @GetMapping("/")
    @ApiOperation(value = "Obtiene una lista de todos las Paginas Web", response = PaginaWebDTO.class, responseContainer = "List", tags = "Paginas Web")
    public ResponseEntity<?> findAll() {
        try {
            return new ResponseEntity(paginaWebService.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getClass(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtiene un Pagina Web por su Id", response = PaginaWebDTO.class, tags = "Paginas Web")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        try {
            return new ResponseEntity(paginaWebService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
