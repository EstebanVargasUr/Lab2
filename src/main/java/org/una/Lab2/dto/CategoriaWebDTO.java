package org.una.Lab2.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CategoriaWebDTO {

    private Long id;
    private String nombre;
    private Date fechaRegistro;
    private boolean estado;

}
