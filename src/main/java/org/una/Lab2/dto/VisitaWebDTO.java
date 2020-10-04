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

    private Navegador navegador;
    private PaginaWeb paginaWeb;
}
