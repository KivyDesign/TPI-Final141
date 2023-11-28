package org.tpi_arg_prog.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "tbTecnico")
public class Tecnico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private int tiempoResolucion;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
//    @OneToMany(mappedBy = "tecnico")
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "otherEntity")
    private List<Especialidad> especialidades = new ArrayList<>();
    private List<Incidencias> incidencias = new ArrayList<>();

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "otherEntity")
}
