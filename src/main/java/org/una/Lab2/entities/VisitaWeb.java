/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.Lab2.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
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
 * @author adrian
 */

@Entity
@Table(name = "lab2_visitas_web")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class VisitaWeb implements Serializable {
        
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "fecha_consulta", updatable = false)
    @Temporal(TemporalType.TIMESTAMP) 
    @Setter(AccessLevel.NONE)
    private Date fechaConsulta;
    
    @Column(name = "fecha_salida", updatable = false)
    @Temporal(TemporalType.TIMESTAMP) 
    @Setter(AccessLevel.NONE)
    private Date fechaSalida;
    
    @ManyToOne
    @JoinColumn(name="lab2_paginas_web_id")
    private PaginaWeb paginaWeb;
    
    @ManyToOne
    @JoinColumn(name="lab2_navegador_id")
    private Navegador navegador;    
    
    private static final long serialVersionUID = 1L;

    @PrePersist
    public void prePersist() {
        
        fechaConsulta = new Date();
 
    }

    @PreUpdate
    public void preUpdate() {

    }
}
