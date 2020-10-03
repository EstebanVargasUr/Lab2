package org.una.Lab2.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Esteban Vargas
 */
@Entity
@Table(name = "lab2_paginas_web")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PaginaWeb implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "url", length = 600)
    private String url;
    
    @Column(name = "nombre", length = 30)
    private String nombre;
    
    @Column(name = "descripcion", length = 100)
    private String descripcion;
   
    @Column
    private float valoracion;
    
    @Column
    private boolean estado;
    
    @Column(name = "fecha_registro", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @Setter(AccessLevel.NONE)
    private Date fechaRegistro;
   
   
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "lab2_paginasWeb_categoriasWeb",
            joinColumns = @JoinColumn(name = "lab2_categorias_web_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "lab2_paginas_web_id",
                    referencedColumnName = "id"))
    
    private List<CategoriaWeb> categoriaWeb;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paginaWeb")
    private List<VisitaWeb> visitasWeb = new ArrayList<>();
     
    private static final long serialVersionUID = 1L;

    @PrePersist
    public void prePersist() {
        estado=true;
        fechaRegistro = new Date();

    }
}
