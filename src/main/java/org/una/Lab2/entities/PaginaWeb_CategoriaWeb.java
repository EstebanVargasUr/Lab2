package org.una.Lab2.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author Esteban Vargas
 */
@Entity
@Table(name = "lab2_paginas_web_categorias_web")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PaginaWeb_CategoriaWeb {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     
    @ManyToOne
    @JoinColumn(name="lab2_paginasWeb_id")
    private PaginaWeb paginaWeb;
    
    @ManyToOne
    @JoinColumn(name="lab2_categoriasWeb_id")
    private CategoriaWeb categoriaWeb;
    
    private static final long serialVersionUID = 1L;
}
