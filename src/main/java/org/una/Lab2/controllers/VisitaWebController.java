package org.una.Lab2.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.Lab2.dto.VisitaWebDTO;
import org.una.Lab2.services.IVisitaWebService;

@RestController
@RequestMapping("/lab2_visitas_web") 
@Api(tags = {"Visitas web"})
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
    @ApiOperation(value = "Obtiene una visita web por su id", response = VisitaWebDTO.class, tags = "Visitas Web")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        try {
            return new ResponseEntity(visitaWebService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
   }
}