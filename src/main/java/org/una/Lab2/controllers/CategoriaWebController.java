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
import org.una.Lab2.dto.CategoriaWebDTO;
import org.una.Lab2.services.ICategoriaWebService;

@RestController
@RequestMapping("/lab2_categorias_web")
@Api(tags = {"Categorias Web"})
public class CategoriaWebController {
    @Autowired
    private ICategoriaWebService categoriaWebService;
    final String MENSAJE_VERIFICAR_INFORMACION = "Debe verifiar el formato y la información de su solicitud con el formato esperado";

    @GetMapping("/")
    @ApiOperation(value = "Obtiene una lista de todas las categorias web", response = CategoriaWebDTO.class, responseContainer = "List", tags = "Categorias Web")
    ResponseEntity<?> findAll() {
        try {
            return new ResponseEntity(categoriaWebService.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getClass(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/{id}")
    @ApiOperation(value = "Obtiene la categoria web por medio del Id", response = CategoriaWebDTO.class, tags = "Categorias Web")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        try {
            return new ResponseEntity(categoriaWebService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
