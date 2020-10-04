package org.una.Lab2.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name = "lab2_navegadores")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Navegador {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nombre", length = 30)
    private String nombre;
    
    @Column
    private boolean modoIncognito;
   
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "navegador")
    private List<VisitaWeb> visitasWeb = new ArrayList<>();
     
    private static final long serialVersionUID = 1L;

}
