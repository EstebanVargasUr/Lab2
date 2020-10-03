package org.una.Lab2.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author Esteban Vargas
 */
@Data
@AllArgsConstructor
@NoArgsConstructor 
@ToString
public class PaginaWebDTO {
    
    private Long id; 
    private String url;
    private String nombre;
    private String descripcion;
    private Date fechaRegistro; 
    private Date fechaModificacion;
    private float valoracion;
    private boolean estado; 
}
