package org.una.Lab2.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author acer
 */

@Entity
@Table(name = "lab2_categorias_web")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CategoriaWeb implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 30)
    private String nombre;

    @Column(name = "fecha_registro", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date fechaRegistro;

    @Column
    private boolean estado;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoriaWeb") 
    private List<PaginaWeb_CategoriaWeb> paginasWeb_CategoriasWeb = new ArrayList<>();

    private static final long serialVersionUID = 1L;

    @PrePersist
    public void prePersist() {
        estado=true;
        fechaRegistro = new Date();
    }

    @PreUpdate
    public void preUpdate() {

    }
}
