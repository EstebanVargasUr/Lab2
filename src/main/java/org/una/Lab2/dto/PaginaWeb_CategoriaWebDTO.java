package org.una.Lab2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.una.Lab2.entities.CategoriaWeb;
import org.una.Lab2.entities.PaginaWeb;

/**
 *
 * @author Esteban Vargas
 */
@Data
@AllArgsConstructor
@NoArgsConstructor 
@ToString
public class PaginaWeb_CategoriaWebDTO {
    
    private Long id; 
    private PaginaWeb paginaWeb;
    private CategoriaWeb categoriaWeb;
}
