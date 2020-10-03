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
import org.una.Lab2.dto.VisitaWebDTO;
import org.una.Lab2.services.IVisitaWebService;


@RestController
@RequestMapping("/visitasWeb") 
@Api(tags = {"Visitas Web"})
public class VisitaWebController {

    @Autowired
    private IVisitaWebService visitaWebService;
    
    final String MENSAJE_VERIFICAR_INFORMACION = "Debe verifiar el formato y la información de su solicitud con el formato esperado";

    @GetMapping("/")
    @ApiOperation(value = "Obtiene una lista de todas las visitas web", response = VisitaWebDTO.class, responseContainer = "List", tags = "Visitas Web")
    public ResponseEntity<?> findAll() {
        try {
            return new ResponseEntity(visitaWebService.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getClass(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtiene un visita web por su Id", response = VisitaWebDTO.class, tags = "Visitas Web")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        try {
            return new ResponseEntity(visitaWebService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/find/{idPagina}/{idNavegador}")
    @ApiOperation(value = "Obtiene una visita web a partir del id de una pagina y del id de un navegador", response = VisitaWebDTO.class, tags = "Visitas Web")
    public ResponseEntity<?> findByPaginaWebIdAndNavegadorId(@PathVariable(value = "idPagina") Long id1, @PathVariable(value = "idNavegador") Long id2) {
        try {
            return new ResponseEntity(visitaWebService.findByPaginaWebIdAndNavegadorId(id1, id2), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
   }
}