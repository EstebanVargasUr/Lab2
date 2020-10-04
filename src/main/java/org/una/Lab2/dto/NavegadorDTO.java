package org.una.Lab2.dto;

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
public class NavegadorDTO {
    
    private Long id; 
    private String nombre;
    private boolean modoIncognito; 
}
