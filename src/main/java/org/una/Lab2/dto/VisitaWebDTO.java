/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.Lab2.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.una.Lab2.entities.Navegador;
import org.una.Lab2.entities.PaginaWeb;

/**
 *
 * @author adrian
 */



@Data
@AllArgsConstructor
@NoArgsConstructor 
@ToString
public class VisitaWebDTO {
 
    private Long id; 
    private Date fechaConsulta;
    private Date fechaSalida;
    private PaginaWeb paginaWeb;
    private Navegador navegador;
}
