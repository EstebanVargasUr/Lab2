package org.una.Lab2.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
   
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paginaWeb") 
    private List<VisitaWeb> visitasWeb = new ArrayList<>();
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paginaWeb") 
    private List<PaginaWeb_CategoriaWeb> paginasWeb_CategoriasWeb = new ArrayList<>();
    
    private static final long serialVersionUID = 1L;

    @PrePersist
    public void prePersist() {
        estado=true;
        fechaRegistro = new Date();

    }
}
